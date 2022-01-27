import CryptoJS from 'crypto-js/crypto-js'

// 默认的 KEY 与 iv ，统一的给16位字符串即可
const KEY = CryptoJS.enc.Utf8.parse("byouthinvincible");
const IV = CryptoJS.enc.Utf8.parse('byouthinvincible');

// AES加密
export function Encrypt(word, keyStr, ivStr) {
  let key = KEY
  let iv = IV
  if (keyStr) {
    key = CryptoJS.enc.Utf8.parse(keyStr);
    iv = CryptoJS.enc.Utf8.parse(ivStr);
  }
  let srcs = CryptoJS.enc.Utf8.parse(word);
  var encrypted = CryptoJS.AES.encrypt(srcs, key, {
    iv: iv,
    mode: CryptoJS.mode.CBC,
    padding: CryptoJS.pad.ZeroPadding
  });
  return CryptoJS.enc.Base64.stringify(encrypted.ciphertext);
}

// AES 解密
export function Decrypt(word, keyStr, ivStr) {
  let key  = KEY
  let iv = IV
  if (keyStr) {
    key = CryptoJS.enc.Utf8.parse(keyStr);
    iv = CryptoJS.enc.Utf8.parse(ivStr);
  }
  let base64 = CryptoJS.enc.Base64.parse(word);
  let src = CryptoJS.enc.Base64.stringify(base64);
  var decrypt = CryptoJS.AES.decrypt(src, key, {
    iv: iv,
    mode: CryptoJS.mode.CBC,
    padding: CryptoJS.pad.ZeroPadding
  });
  var decryptedStr = decrypt.toString(CryptoJS.enc.Utf8);
  return decryptedStr.toString();
}
