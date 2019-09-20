package io.mine.ft.train.service;

import io.mine.ft.train.entity.User;

public interface UserService {
	public User queryOneUserByNameAndPass(String username,String password);
}
