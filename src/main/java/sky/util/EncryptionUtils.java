package sky.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/27 0027
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 */
public class EncryptionUtils {
    public static String sha256Hex(String data) {
        return DigestUtils.sha256Hex(data);
    }

    public static String parseMD5(String data) {
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(data.getBytes());
            StringBuilder stringBuffer = new StringBuilder();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }
}
