package io.mine.ft.train.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class jdbcUtilPool {
	private static ThreadLocal<Connection> tdl = new ThreadLocal<Connection>();

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = tdl.get();
			if (conn == null) {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx
						.lookup("java:comp/env/jdbc/oracle");
				conn = ds.getConnection();
				tdl.set(conn);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void Release(Connection conn,PreparedStatement pstm,ResultSet rs){
		try {
			if(conn!=null){
				tdl.remove();
				conn.close();
			}
			if(pstm!=null)pstm.close();
			if(rs!=null)rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
