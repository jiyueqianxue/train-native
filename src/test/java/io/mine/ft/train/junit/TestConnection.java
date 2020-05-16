package io.mine.ft.train.junit;

import java.sql.Connection;

import org.junit.Test;

import io.mine.ft.train.util.JdbcUtil;

public class TestConnection {
	
@Test
public void TestJdbcUtil() throws Exception {
	Connection conn=JdbcUtil.getConnection();
	System.out.println(conn);
}
}
