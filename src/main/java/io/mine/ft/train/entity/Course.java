package io.mine.ft.train.entity;

/**
 * 
 * 类的作用: 作者: 马超 创建时间: 2015-1-31下午1:59:10 email : zhangmj@zparkhr.com.cn version:
 * 1.0
 */
public class Course {
	private Integer courseId;
	private String courseName;

	public Course(Integer courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName
				+ "]";
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
