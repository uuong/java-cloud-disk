package sky.util;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 22:35
 * To change this template use FileMode | Settings | FileMode Templates.
 */
public class TypeUtils {
    private static String[] list = {"image/jpeg", ""};

    public static String t(String type) {
        for (String s : list) {
            if (s.equals(type)) {
                return s;
            }
        }
        return "未知";
    }
}
