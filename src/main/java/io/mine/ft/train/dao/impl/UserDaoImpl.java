package io.mine.ft.train.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.mine.ft.train.dao.UserDao;
import io.mine.ft.train.entity.User;
import io.mine.ft.train.util.JdbcUtil;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public User selectUser(String username, String password) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("select * from t_user where username=? and password=?");
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			user = null;
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, rs);
		}
		return user;
	}
}
