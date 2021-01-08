package com.ltfs.main;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class AES {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
    
    static final String privateKey = 
    		"MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAK4FKPehVOZMqCe7\n" + 
    		"kFjmkC4rb7Fb9A1sGUVdn5BaUHZvEM0+5yG98ZlJ9wc/5c7kMigBy7Oh9ETWONN2\n" + 
    		"RvLs8ZILlcNmD6gBuLgHvkZizeCo3INbG4AxhNgDy+YtHbGU6hXtlwyhkefbk/5g\n" + 
    		"B/EPMquUS8DMXD+60pphVQwBU3ZDAgMBAAECgYAElvVAJrynAFGVDrDdb2NRHGsr\n" + 
    		"OdojenzmI/R/6anincZLK4QME0bqfJVr1wcYIFOkU3vMZpKbOC0ygpWXdaFfZg3c\n" + 
    		"wt+euQBXkwU/lP4quzpSMtJixcuTqc7WDV4XB2BaBgxCLLVAIdBZ6jcumMr6Ndra\n" + 
    		"ZQe3kaB0xWFJ+0/U1QJBAOMzPuoOroBvruqvC1BkJQVh6ISNvPEUA1H0mS+bKY1M\n" + 
    		"4Ks9II0hUjdez67Wfi9EjvD1lCamKyB6KjONL3KLNQ8CQQDEFDJ5IiLO9PmCPd5l\n" + 
    		"dpW9PdGKtht+47FQiTInLjNkfmq9dYLILThmTV0c/9x6Pq5AGL9v28I0l+qcs+NI\n" + 
    		"FvONAkBUhO/WqneIGAP+Efgng9mx0uZoyUGMfWFuz4tdBl/CzOKXUToWxlqLdp3T\n" + 
    		"8L8oXly+jtz6M76/ajLg0pjgB6FJAkAYnTx0zl82QbRssB2R+R/1AKSkWBX9iNHC\n" + 
    		"fWaJWphi/ieiHvVK8bpJxV5x/ICN6/5t1214ukqX1ZZDE6Xtb8wlAkAoyO3R7cKW\n" + 
    		"U8rRBlF2m8fRnuPWS6Wgb59+PwoFLCXTa6YZSXcQPy64unqPZ1/cIT6sAMGd0iad\n" + 
    		"3RJdCJuhYMAt\n" ;
 
    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    /*public static void main(String[] args) {
		String decData = ""; 
		decData = decrypt("YO5k7QL4Vbz7lk2N6n4ryA==", privateKey) ;
		System.out.println(decData);
	
	}*/
}
