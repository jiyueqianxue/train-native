/**
 * 
 */
package io.mine.ft.train.entity;

import java.util.Date;

/**
 * 
 * 类的作用: 作者: 马超 创建时间: 2015-1-31下午1:52:22 email : zhangmj@zparkhr.com.cn version:
 * 1.0
 */
public class Accusation {
	private Integer accusationId;
	private String teacherAccusationContent;
	private java.util.Date studentAccusationTime;
	private java.util.Date teacherAccusationTime;
	private Integer iId;
	private String studentAccusationContent;
	
	public Accusation(){};
	public Accusation(Integer accusationId, String teacherAccusationContent,
			Date studentAccusationTime, Date teacherAccusationTime,
			Integer iId, String studentAccusationContent) {
		super();
		this.accusationId = accusationId;
		this.teacherAccusationContent = teacherAccusationContent;
		this.studentAccusationTime = studentAccusationTime;
		this.teacherAccusationTime = teacherAccusationTime;
		this.iId = iId;
		this.studentAccusationContent = studentAccusationContent;
	}

	public Integer getAccusationId() {
		return accusationId;
	}

	public void setAccusationId(Integer accusationId) {
		this.accusationId = accusationId;
	}

	public String getTeacherAccusationContent() {
		return teacherAccusationContent;
	}

	public void setTeacherAccusationContent(String teacherAccusationContent) {
		this.teacherAccusationContent = teacherAccusationContent;
	}

	public java.util.Date getStudentAccusationTime() {
		return studentAccusationTime;
	}

	public void setStudentAccusationTime(java.util.Date studentAccusationTime) {
		this.studentAccusationTime = studentAccusationTime;
	}

	public java.util.Date getTeacherAccusationTime() {
		return teacherAccusationTime;
	}

	public void setTeacherAccusationTime(java.util.Date teacherAccusationTime) {
		this.teacherAccusationTime = teacherAccusationTime;
	}

	public Integer getiId() {
		return iId;
	}

	public void setiId(Integer iId) {
		this.iId = iId;
	}

	public String getStudentAccusationContent() {
		return studentAccusationContent;
	}

	public void setStudentAccusationContent(String studentAccusationContent) {
		this.studentAccusationContent = studentAccusationContent;
	}

}
