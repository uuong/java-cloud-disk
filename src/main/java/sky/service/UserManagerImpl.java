package sky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sky.dao.UserMapper;
import sky.pojo.User;
import sky.service.inter.UserManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/23 0023
 * Time: 19:12
 * To change this template use FileMode | Settings | FileMode Templates.
 */
@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserMapper userMapper;

    public List<User> query() {
        return userMapper.queryAll();
    }

    public User select(String username) {
        return null;
    }
}
