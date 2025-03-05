package utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * Class for encrypt/decrypt a String
 * @author apvjx
 * @author cristian.ulloa@agfa.com
 * @version 1.0
 */
public class Security {
    private static final Logger LOGGER = LogManager.getLogger("Security");
    private final String securityPhrase;
    public Security() {
        this.securityPhrase = "c666b13d8eb65a55c5aa09644b6b3804";
    }
    
    /**
     * Method encrypt a text
     * @param texto
     * @return encryptText
     */
    public String Encrypt(String texto) {
 
        String base64EncryptedString = "";
 
        try {
            LOGGER.debug("initializing security encryption");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(securityPhrase.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.getEncoder().encode(buf);
            base64EncryptedString = new String(base64Bytes);
            LOGGER.debug("ending security encryption");
 
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            LOGGER.error(ex.toString());
        }
        return base64EncryptedString;
    }
    
    /**
     * Method decrypt a text
     * @param textoEncriptado
     * @return decryptText
     * @throws Exception 
     */
    public String Decrypt(String textoEncriptado) throws Exception {

        String base64EncryptedString = "";

        try {
            LOGGER.debug("initializing security decryption");
            byte[] message = Base64.getDecoder().decode(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(securityPhrase.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");
            LOGGER.debug("ending security decryption");
            
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            LOGGER.error(ex.toString());
        }
        return base64EncryptedString;
    }
}
