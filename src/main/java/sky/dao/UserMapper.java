package sky.dao;

import sky.pojo.User;

import java.util.List;

public interface UserMapper {

    int insertSelective(User record);

    User selectByPrimaryKey(String username);


    List<User> queryAll();
}