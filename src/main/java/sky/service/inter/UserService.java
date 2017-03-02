package sky.service.inter;

import sky.pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/22.js 0022
 * Time: 22.js:20
 * To change this template use FileMode | Settings | FileMode Templates.
 */
public interface UserService {
    List<User> query();

    User select(String username);

    boolean change(User user, String newpass);
}
