package io.mine.ft.train.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.mine.ft.train.dao.InteractDao;
import io.mine.ft.train.entity.Accusation;
import io.mine.ft.train.entity.Course;
import io.mine.ft.train.entity.Interact;
import io.mine.ft.train.entity.User;
import io.mine.ft.train.util.JdbcUtil;

public class InteractDaoImpl implements InteractDao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	Interact it = null;

	public List<Interact> selectAllInteract(Integer sId) {
		// TODO Auto-generated method stub
		List<Interact> list = new ArrayList<Interact>();
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("select * from t_interact where sid=?");
			pstm.setInt(1, sId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Interact it = new Interact(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getDouble(13), rs.getDate(14),
						rs.getDate(15), rs.getDate(16), rs.getString(17),
						rs.getString(18), rs.getString(19));
				list.add(it);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, rs);
		}
		return list;
	}

	/*
	 * 模糊查询
	 */
	public List<Interact> selectAllInteract(String flagAnswer, String choice,
			String name, Integer sId) {
		// TODO Auto-generated method stub
		List<Interact> list = new ArrayList<Interact>();
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("select * from t_interact where sid=? and flag_answer=? and "
							+ choice + " like '%" + name + "%'");
			pstm.setInt(1, sId);
			pstm.setString(2, flagAnswer);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Interact it = new Interact(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getDouble(13), rs.getDate(14),
						rs.getDate(15), rs.getDate(16), rs.getString(17),
						rs.getString(18), rs.getString(19));
				list.add(it);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, rs);
		}
		return list;
	}

	public void deleteSqlDao(Integer interactId) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("delete from t_interact where interact_id=?");
			pstm.setInt(1, interactId);
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, null);
		}

	}

	public void insertSqlDao(Interact it) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("insert into t_interact values(?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?)");
			pstm.setInt(1, it.getInteractId());
			pstm.setString(2, it.getInteractName());
			pstm.setString(3, it.getInteractDetail());
			pstm.setString(4, it.getDepartment());
			pstm.setString(5, it.getStudentName());
			pstm.setString(6, it.getTeacherName());
			pstm.setString(7, it.getFlagAnswer());
			pstm.setString(8, it.getAnswerContent());
			pstm.setString(9, it.getFlagEstimate());
			pstm.setString(10, it.getEstimateContent());
			pstm.setInt(11, it.getTuid());
			pstm.setInt(12, it.getSid());
			pstm.setDouble(13, it.getScore());

			pstm.setDate(14, (Date) it.getAnswerTime());
			pstm.setDate(15, (Date) it.getEstimateTime());
			pstm.setString(16, it.getTeacherDepartment());
			pstm.setString(17, it.getFlagTeacherAccusation());
			pstm.setString(18, it.getFlagStudentAccusation());
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, null);
		}

	}

	public List<User> selectAllTeacher() {
		// TODO Auto-generated method stub
		List<User> list = null;
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("select * from t_user where role='teacher'");
			rs = pstm.executeQuery();
			list = new ArrayList<User>();
			while (rs.next()) {
				User user = null;
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, rs);
		}
		return list;
	}

	public List<Course> selectAllCourseByTeacherId(Integer tid) {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<Course>();
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("select * from t_course t1 left join course_user t2 "
							+ "on t1.course_id=t2.c_id where t2.u_id=?");
			pstm.setInt(1, tid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Course course = new Course(rs.getInt(1), rs.getString(2));
				courses.add(course);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, rs);
		}
		return courses;
	}

	public Interact selectDetailById(Integer interactId) {
		// TODO Auto-generated method stub
		Interact it = null;
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("select * from t_interact t1 left join t_accusation t2 "
							+ "on t1.interact_id=t2.i_id where t1.interact_id=?");
			pstm.setInt(1, interactId);
			rs = pstm.executeQuery();
			if (rs.next()) {
				it = new Interact(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getDouble(13), rs.getDate(14),
						rs.getDate(15), rs.getDate(16), rs.getString(17),
						rs.getString(18), rs.getString(19));
				it.setStudentAccusationContent(rs.getString(25));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, rs);
		}
		return it;
	}

	public void insertAccusation(Accusation acc) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("insert into t_accusation values(?,?,?,?,?,?)");
			pstm.setInt(1, acc.getAccusationId());
			pstm.setString(2, acc.getTeacherAccusationContent());
			pstm.setDate(3, (Date) acc.getStudentAccusationTime());
			pstm.setDate(4, (Date) acc.getTeacherAccusationTime());
			pstm.setInt(5, acc.getiId());
			pstm.setString(6, acc.getStudentAccusationContent());
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, null);
		}
	}

	public void updateInteract(Interact it) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			pstm = conn
					.prepareStatement("update t_interact set estimate_time=?,estimate_content=?,flag_estimate=?,"
							+ "flag_student_accusation=?,interact_detail=? where interact_id=?");
			
			java.util.Date date1=it.getEstimateTime();
			if(date1==null) pstm.setDate(1,null);
			else{
				java.sql.Date sqldate=new java.sql.Date(date1.getTime());
				pstm.setDate(1,sqldate);
			}
			pstm.setString(2, it.getEstimateContent());
			pstm.setString(3, it.getFlagEstimate());
			pstm.setString(4, it.getFlagStudentAccusation());
			pstm.setString(5, it.getInteractDetail());
			pstm.setInt(6, it.getInteractId());
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.release(null, pstm, null);
		}
	}
}
