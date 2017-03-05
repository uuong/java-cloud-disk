package sky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sky.dao.UserMapper;
import sky.exception.UserNameExistException;
import sky.pojo.User;
import sky.service.inter.LoginAndRegist;
import sky.util.CookieUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 *  todo 改进 复用一个User对象 避免重复new；
 * User: krny
 * Date: 2017/2/22.js 0022
 * Time: 22.js:26
 * To change this template use FileMode | Settings | FileMode Templates.
 */

@Service
public class LoginAndRegistImpl implements LoginAndRegist {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) throws UserNameExistException {
        User u = userMapper.selectByPrimaryKey(user.getUsername());
        if (u != null) {
            throw new UserNameExistException("用户名重复");
        }

        //user = EncryptionUtils.parseUser(user, user.getPassword());
        userMapper.insertSelective(user);
    }

    public boolean userLogin(User user, Boolean remember, HttpServletResponse response) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return false;
        }

        //user = EncryptionUtils.parseUser(user, user.getPassword());
        User result = userMapper.login(user);
        if (result == null) {
            return false;
        }
        String cookieValue = UUID.randomUUID().toString();
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

    public void logout(User user) {
        User u = new User();
        u.setToken("no");
        u.setUsername(user.getUsername());
        userMapper.updateByPrimaryKeySelective(u);
    }

}
