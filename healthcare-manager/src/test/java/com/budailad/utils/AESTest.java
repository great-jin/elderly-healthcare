package com.budailad.utils;

import org.junit.jupiter.api.Test;
import static com.budailad.utils.AESUtil.encrypt;
import static com.budailad.utils.AESUtil.desEncrypt;

class AESTest {

    private static String IV = "byouthinvincible";
    private static String KEY = "byouthinvincible";

    @Test
    void Encrypt() {
        String data = "123";
        try {
            String str = new String(data.getBytes(),"UTF-8");

            String enStr = encrypt(str, KEY, IV);
            System.out.println("数据：" + data);
            System.out.println("加密：" + enStr);

            String deStr = desEncrypt(enStr, KEY, IV).trim();
            System.out.println("解密：" + deStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void EncryptTest() {
        try {
            String frontEnPwd = "QVOPN3Ca3Xq9uFpS8iB0pw==";
            String frontDePwd = desEncrypt(frontEnPwd, KEY, IV).trim();
            System.out.println("解密：" + frontDePwd);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
