package sky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sky.dao.UserMapper;
import sky.exception.UsernnameExistException;
import sky.pojo.User;
import sky.service.inter.UserLoginAndRegist;
import sky.util.CookieUtils;
import sky.util.EncryptionUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/22 0022
 * Time: 22:26
 * To change this template use FileMode | Settings | FileMode Templates.
 */

@Service
public class UserLoginAndRegistImpl implements UserLoginAndRegist {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) throws UsernnameExistException {
        User u = userMapper.selectByPrimaryKey(user.getUsername());
        if (u != null) {
            throw new UsernnameExistException("用户名重复");
        }
        user.setPassword(EncryptionUtils.parseMD5(user.getPassword()));
        userMapper.insertSelective(user);
    }

    public boolean userLogin(User user, Boolean remember, HttpServletResponse response) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return false;
        }
        String passMD5 = EncryptionUtils.parseMD5(user.getPassword());
        user.setPassword(passMD5);
        User result = userMapper.login(user);
        if (result == null) {
            return false;
        }
        String uuid = UUID.randomUUID().toString();
        String cookieValue = EncryptionUtils.parseMD5(uuid);
        if (remember) {
            Long currentTime = new Date().getTime() + 60 * 60 * 24 * 7;
            String toKen = cookieValue + ":" + currentTime + ":" + result.getPassword();
            System.out.println(toKen.length());
            result.setToken(toKen);
            userMapper.updateByPrimaryKeySelective(result);
        }
        CookieUtils.setCookie(response, "remember", cookieValue + ":" + result.getUsername());
        return true;
    }

}
