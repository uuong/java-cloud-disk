package sky.util;

import sky._const.UserConst;
import sky.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * 权限验证
 * User: krny
 * Date: 2017/3/2 0002
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
public class AccessUtils {
    public static boolean isAccess(HttpSession session, String username) {
        User user = (User) session.getAttribute(UserConst.USER_SESSION);
        return (user != null && username.equals(user.getUsername()));
    }

    public static boolean isAccess(HttpSession session) {
        User user = (User) session.getAttribute(UserConst.USER_SESSION);
        return user != null;
    }
}
