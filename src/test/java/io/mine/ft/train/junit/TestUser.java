package io.mine.ft.train.junit;

import org.junit.Test;

import io.mine.ft.train.dao.impl.UserDaoImpl;
import io.mine.ft.train.entity.User;
import io.mine.ft.train.service.UserService;
import io.mine.ft.train.service.impl.UserServiceImpl;

public class TestUser {
@Test
public void TestDao(){
	UserDaoImpl udi = new UserDaoImpl();
	User user=null;
	user=udi.selectUser("霁月", "100001");
	System.out.println(user);
}
@Test
public void TestService(){
	UserService usi=new UserServiceImpl();
	User user=usi.queryOneUserByNameAndPass("霁月", "100001");
	System.out.println(user);
}

}
