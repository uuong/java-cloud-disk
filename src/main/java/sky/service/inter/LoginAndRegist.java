package sky.service.inter;

import sky.exception.UserNameExistException;
import sky.pojo.User;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/22.js 0022
 * Time: 22.js:19
 * To change this template use FileMode | Settings | FileMode Templates.
 */
public interface LoginAndRegist {
    void addUser(User user) throws UserNameExistException;

    boolean userLogin(User user, Boolean rememberme, HttpServletResponse response);

    void logout(User user);
}
