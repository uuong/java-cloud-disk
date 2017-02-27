package sky.dao;

import sky.pojo.User;

import java.util.List;

public interface UserMapper {

    int insertSelective(User user);

    User selectByPrimaryKey(String username);

    User login(User user);

    void updateByPrimaryKeySelective(User user);
    List<User> queryAll();
}