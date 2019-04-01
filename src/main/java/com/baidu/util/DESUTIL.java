package com.baidu.util;

import com.thoughtworks.xstream.core.util.Base64Encoder;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 加密类
 */
public class DESUTIL {
    static Key key;//图纸
    static String KEYSTR="gx";//生成图纸的一种算法
    static {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");//生成图纸的生成器DES
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(KEYSTR.getBytes());//生成算法因子
            keyGenerator.init(secureRandom);//初始化这个算法
            key = keyGenerator.generateKey();//生成一个key

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    //加密算法
    public static String encode(String pwd){
        Base64Encoder base64Encoder = new Base64Encoder();
        String result = "";
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] b = cipher.doFinal(pwd.getBytes());
            result = base64Encoder.encode(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return result;
    }
    //解密算法
    public static String decode(String str){
        String result="";
        Base64Encoder base64Encoder = new Base64Encoder();
        byte[] b = base64Encoder.decode(str);
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] pwd = cipher.doFinal(b);
            result = new String(pwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(encode("123456"));
        System.out.println(encode("root"));
        System.out.println(decode("L+IiRn95Z3E="));
    }

}
