package io.mine.ft.train.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import io.mine.ft.train.dao.InteractDao;
import io.mine.ft.train.dao.impl.InteractDaoImpl;
import io.mine.ft.train.entity.Accusation;
import io.mine.ft.train.entity.Course;
import io.mine.ft.train.entity.Interact;
import io.mine.ft.train.entity.User;
import io.mine.ft.train.service.InteractService;
import io.mine.ft.train.util.JdbcUtil;

public class InteractServiceImpl implements InteractService {
	Connection conn = null;

	public List<Interact> QueryAllInteract(Integer sId) {
		// TODO Auto-generated method stub
		List<Interact> list = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			InteractDao idi = new InteractDaoImpl();
			list = idi.selectAllInteract(sId);
			conn.commit();
		} catch (Exception e) {
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
		return list;
	}

	/*
	 * (non-Javadoc)模糊查询
	 * 
	 * @see
	 * com.zpark.bb.service.InteractService#QueryAllInteract(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.Integer)
	 */
	public List<Interact> QueryAllInteract(String flagAnswer,
			String information, String name, Integer sId) {
		// TODO Auto-generated method stub
		List<Interact> list = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			InteractDao idi = new InteractDaoImpl();
			if (information.equals("department")) {
				String choice = "teacher_department";
				list = idi.selectAllInteract(flagAnswer, choice, name, sId);
			}
			if (information.equals("teacher")) {
				String choice = "teacher_name";
				list = idi.selectAllInteract(flagAnswer, choice, name, sId);
			}
			conn.commit();
		} catch (Exception e) {
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
		return list;
	}

	public void deleteInteractService(Integer interactId) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			InteractDao idi = new InteractDaoImpl();
			idi.deleteSqlDao(interactId);
			conn.commit();
		} catch (Exception e) {
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
	}

	public void addInteractService(Interact it) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			InteractDao idi = new InteractDaoImpl();
			idi.insertSqlDao(it);
			conn.commit();
		} catch (Exception e) {
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
	}

	/**
	 * 查询所有老师
	 */

	public List<User> QueryAllTeacherService() {
		// TODO Auto-generated method stub
		List<User> list = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			List<Course> courses = null;
			InteractDao idi = new InteractDaoImpl();
			list = idi.selectAllTeacher();
			for (User user : list) {
				courses = idi.selectAllCourseByTeacherId(user.getUserId());
				user.setCourses(courses);
			}
			conn.commit();
		} catch (Exception e) {
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
		return list;
	}

	public Interact QueryDetailById(Integer interactId) {
		// TODO Auto-generated method stub
		Interact it = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			InteractDao idi = new InteractDaoImpl();
			it = idi.selectDetailById(interactId);
			conn.commit();
		} catch (Exception e) {
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
		return it;
	}

	public void updateInteractService(Interact it) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			InteractDao idi = new InteractDaoImpl();
			idi.updateInteract(it);
			conn.commit();
		} catch (Exception e) {
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
	}

	public void AddAccusationService(Accusation acc) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			InteractDao idi = new InteractDaoImpl();
			idi.insertAccusation(acc);
			conn.commit();
		} catch (Exception e) {
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
	}
}
