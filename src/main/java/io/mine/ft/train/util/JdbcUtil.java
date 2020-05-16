package io.mine.ft.train.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	private static ThreadLocal<Connection> tdl=new ThreadLocal<Connection>();
	private static Properties prop=new Properties(); 
	static {
		try {
			InputStream is=JdbcUtil.class.getResourceAsStream("/conf/db.properties");
			prop.load(is);
			String driverClassName=prop.getProperty("driverClassName");
			Class.forName(driverClassName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static Connection getConnection() throws Exception {
	Connection conn=null;
	conn=tdl.get();
	if(conn==null){
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		conn=DriverManager.getConnection(url, username, password);
		tdl.set(conn);
	}
	
	return conn;
}
public static void release(Connection conn,PreparedStatement pstm,ResultSet rs){
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
