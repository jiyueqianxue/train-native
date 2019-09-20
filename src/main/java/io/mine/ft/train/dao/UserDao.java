package io.mine.ft.train.dao;

import io.mine.ft.train.entity.User;
public interface UserDao {
public  User selectUser(String username,String password);

}
