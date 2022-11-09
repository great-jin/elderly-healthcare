package xyz.ibudai.utils;

import org.junit.jupiter.api.Test;

import static xyz.ibudai.utils.AESUtil.encrypt;
import static xyz.ibudai.utils.AESUtil.desEncrypt;

class AESTest {

    private static String IV = "dyouthinvincible";
    private static String KEY = "dyouthinvincible";

    @Test
    void Encrypt() {
        String data = "123456";
        try {
            String str = new String(data.getBytes(), "UTF-8");

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
