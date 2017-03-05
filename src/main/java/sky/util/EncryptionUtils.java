package sky.util;

import org.apache.commons.codec.digest.DigestUtils;
import sky.pojo.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密解密
 * User: krny
 * Date: 2017/2/27 0027
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 */
public class EncryptionUtils {

    public static User parseUser(User user) {
        String pass = user.getPassword();
        user.setPassword(sha256Hex(pass));
        return user;
    }

    public static User parseUser(User user, String password) {
        user.setPassword(sha256Hex(password));
        return user;
    }

    public static User parseUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(sha256Hex(password));
        return user;
    }
    public static String sha256Hex(String data) {
        return DigestUtils.sha256Hex(data + "$%`");
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
