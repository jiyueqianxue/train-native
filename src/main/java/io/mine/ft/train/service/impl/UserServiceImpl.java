package io.mine.ft.train.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.mine.ft.train.dao.impl.UserDaoImpl;
import io.mine.ft.train.entity.User;
import io.mine.ft.train.service.UserService;
import io.mine.ft.train.util.JdbcUtil;

public class UserServiceImpl implements UserService {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public User queryOneUserByNameAndPass(String username, String password) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);

			UserDaoImpl udi = new UserDaoImpl();
			user = udi.selectUser(username, password);
			if (user == null)
				throw new RuntimeException("用户不存在，请检测用户名及密码");
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(conn, null, null);
		}
		return user;
	}
}
