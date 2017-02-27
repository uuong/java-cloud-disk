package sky.service.inter;

import sky.exception.UsernnameExistException;
import sky.pojo.User;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/22 0022
 * Time: 22:19
 * To change this template use FileMode | Settings | FileMode Templates.
 */
public interface UserLoginAndRegist {
    void addUser(User user) throws UsernnameExistException;

    boolean userLogin(User user, Boolean rememberme, HttpServletResponse response);
}
