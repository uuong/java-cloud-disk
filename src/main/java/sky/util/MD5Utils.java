package sky.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/22 0022
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public class MD5Utils {
    public static String encoder(String message) {
        try {
            message += "8*u@a";
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = md.digest(message.getBytes());
            return new BASE64Encoder().encode(b);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(encoder("3333"));
    }
}
