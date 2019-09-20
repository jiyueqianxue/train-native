package io.mine.ft.train.junit;

import java.util.List;

import org.junit.Test;

import io.mine.ft.train.dao.InteractDao;
import io.mine.ft.train.dao.impl.InteractDaoImpl;
import io.mine.ft.train.entity.Course;
import io.mine.ft.train.entity.Interact;
import io.mine.ft.train.entity.User;
import io.mine.ft.train.service.InteractService;
import io.mine.ft.train.service.impl.InteractServiceImpl;

public class TestInteract {
	@Test
	public void TestDao() {
		InteractDao idi = new InteractDaoImpl();
		List<Interact> list = idi.selectAllInteract(1);
		for (Interact it : list) {
			System.out.println(it);
		}
	}

	@Test
	public void TestService() {
		InteractService isi = new InteractServiceImpl();
		List<Interact> list = isi.QueryAllInteract(1);
		for (Interact it : list) {
			System.out.println(it);
		}
	}

	@Test
	public void TestDao2() {
		InteractDao idi = new InteractDaoImpl();
		List<Interact> list = idi
				.selectAllInteract("n", "teacher_name", "小", 1);
		for (Interact it : list) {
			System.out.println(it);
		}
	}

	@Test
	public void TestService2() {
		InteractService isi = new InteractServiceImpl();
		List<Interact> list = isi.QueryAllInteract("n", "teacher", "小", 1);
		for (Interact it : list) {
			System.out.println(it);
		}
	}
	@Test
	public void TestDao3() {
		InteractDao idi = new InteractDaoImpl();
		idi.deleteSqlDao(5001);
	}

	@Test
	public void TestService3() {
		InteractService isi = new InteractServiceImpl();
		Interact it=new Interact(1015,"JDBC问题",null,null,"霁月","梅超风","y",null,null,null,
				2,1,2.0,null,null,null,"生物系","y",null);
		isi.addInteractService(it);
	}
	
	@Test
	public void TestDao4() {
		InteractDao idi = new InteractDaoImpl();
		List<Course> courses= idi.selectAllCourseByTeacherId(6);
		
		System.out.println(courses);
		List<User> list=idi.selectAllTeacher();
		System.out.println(list);
	}

	@Test
	public void TestService4() {
		InteractService isi = new InteractServiceImpl();
		List<User> list=isi.QueryAllTeacherService();
		for(User u:list){
			for(Course c:u.getCourses()){
				System.out.println(c);
			}
		}
	}
}