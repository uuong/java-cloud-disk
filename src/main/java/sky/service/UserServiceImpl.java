package sky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sky.dao.UserMapper;
import sky.pojo.User;
import sky.service.inter.UserService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/23 0023
 * Time: 19:12
 * To change this template use FileMode | Settings | FileMode Templates.
 */
@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    public List<User> query() {
        return userMapper.queryAll();
    }

    public User select(String username) {
        return userMapper.selectByPrimaryKey(username);
    }


    public boolean change(User user, String newpass) {
        //user = EncryptionUtils.parseUser(user);
        if (userMapper.login(user) != null) {
            User tempUser = new User(user.getUsername(), newpass, null, null);
            userMapper.updateByPrimaryKeySelective(tempUser);
            return true;
        }
        return false;
    }
}
