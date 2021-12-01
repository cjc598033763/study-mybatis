package com.qfedu.dao;

import com.qfedu.pojo.User;

public interface UserDAO {
    public  int insertUser(User user);
    public User queryUser(String username);

}
