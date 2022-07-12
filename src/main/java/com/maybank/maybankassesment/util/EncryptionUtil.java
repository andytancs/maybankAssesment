package com.maybank.maybankassesment.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;

@Component
public class EncryptionUtil {

    public String sha256(String plaintext){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plaintext.getBytes());
            byte byteData[] = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
