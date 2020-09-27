package cn.dreambreeze.server.utils;

import cn.dreambreeze.server.constant.ResultCode;
import cn.dreambreeze.server.exception.CustomException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author dream breeze
 * @date 2020/9/18 14:56
 */
public class CryptUtil {


  public static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";
  private static final Logger LOG = LoggerFactory.getLogger(CryptUtil.class);
  private static final String CRYPT_KEY = "dreambreeze54321";

  /**
   * 加密
   *
   * @param source
   * @return
   * @throws Exception
   */
  public static String encrypt(String source) {
    try {
      Cipher cipher = Cipher.getInstance(CIPHER_MODE);
      SecretKeySpec secretKeySpec = new SecretKeySpec(CRYPT_KEY.getBytes(), "AES");
      IvParameterSpec iv = new IvParameterSpec(CRYPT_KEY.getBytes());
      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
      byte[] encrypted = cipher.doFinal(source.getBytes());

      return new Base64().encodeToString(encrypted);
    } catch (Exception e) {
      LOG.error(ResultCode.CRYPT_ENCRYPT_ERROR.getMessage() + ":{}", e);
      throw new CustomException(ResultCode.CRYPT_ENCRYPT_ERROR);
    }
  }

  /**
   * 解密
   *
   * @param source
   * @return
   * @throws Exception
   */
  public static String decrypt(String source) {
    try {
      byte[] sourceData = new Base64().decode(source);

      SecretKeySpec secretKeySpec = new SecretKeySpec(CRYPT_KEY.getBytes(), "AES");
      IvParameterSpec iv = new IvParameterSpec(CRYPT_KEY.getBytes());
      Cipher cipher = Cipher.getInstance(CIPHER_MODE);
      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);

      try {
        return new String(cipher.doFinal(sourceData));
      } catch (Exception e) {
        LOG.error(ResultCode.CRYPT_DECRYPT_ERROR.getMessage() + ":{}", e);
        throw new CustomException(ResultCode.CRYPT_DECRYPT_ERROR);
      }
    } catch (Exception ex) {
      LOG.error(ResultCode.CRYPT_DECRYPT_ERROR.getMessage() + ":{}", ex);
      throw new CustomException(ResultCode.CRYPT_DECRYPT_ERROR);
    }
  }

  public static void main(String[] args) {
    String content = "1234";
    System.out.println("加密前：" + content);
    String encryptStr = encrypt(content);
    System.out.println("加密后：" + encryptStr);
    String decrypt = decrypt("l2Tsh1t7dLYEwt/bOnRzgDY96XcrZhoj1gO4mUAa0BRei08t2qJtUX+47Mahc8w/");
    System.out.println("解密后: " + decrypt);
  }
}
