package sky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sky.dao.UserMapper;
import sky.exception.UsernnameExistException;
import sky.pojo.User;
import sky.service.inter.UserLoginAndRegist;
import sky.util.MD5Utils;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/22 0022
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */

@Service
public class UserLoginAndRegistImpl implements UserLoginAndRegist {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) throws UsernnameExistException {
        User u = userMapper.selectByPrimaryKey(user.getUsername());
        user.setPassword(MD5Utils.encoder(user.getPassword()));
        if (u != null) {
            throw new UsernnameExistException("用户名重复");
        }
        userMapper.insertSelective(user);
    }

    public boolean userLogin(User user) {
        String input = MD5Utils.encoder(user.getPassword());
        User u = userMapper.selectByPrimaryKey(user.getUsername());
        if (u != null) {
            String pass = u.getPassword();
            if (pass.equals(input)) {
                return true;
            }
        }
        return false;
    }
}
