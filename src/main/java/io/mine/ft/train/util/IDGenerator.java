package io.mine.ft.train.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IDGenerator {
		static Connection conn=null;
		static PreparedStatement pstm=null;
		static ResultSet rs=null;
		static Integer id=null;
	public static Integer getInteractID(){
	try {
		 conn = JdbcUtil.getConnection();
		 pstm = conn.prepareStatement("select interact_seq.nextval from dual");
		 rs=pstm.executeQuery();
		if(rs.next()){
			id=rs.getInt(1);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JdbcUtil.release(conn, pstm, rs);
		throw new RuntimeException(e);
	}
	return id;
	}
	
	public static Integer getAccusationID(){
		try {
			 conn=JdbcUtil.getConnection();
			 pstm = conn.prepareStatement("select interact_seq.nextval from dual");
			 rs=pstm.executeQuery();
			if(rs.next()){
				id=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JdbcUtil.release(conn, pstm, rs);
			throw new RuntimeException(e);
		}
		return id;
		}
}	
	