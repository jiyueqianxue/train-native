package io.mine.ft.train.dao;

import java.util.List;

import io.mine.ft.train.entity.Accusation;
import io.mine.ft.train.entity.Course;
import io.mine.ft.train.entity.Interact;
import io.mine.ft.train.entity.User;

public interface InteractDao {
	
	public List<Interact> selectAllInteract(Integer sId);

	public List<Interact> selectAllInteract(String flagAnswer, String choice, String name, Integer sId);

	public void deleteSqlDao(Integer interactId);

	public void insertSqlDao(Interact it);

	public List<User> selectAllTeacher();

	public List<Course> selectAllCourseByTeacherId(Integer tid);

	public Interact selectDetailById(Integer interactId);

	public void insertAccusation(Accusation acc);

	public void updateInteract(Interact it);
}
