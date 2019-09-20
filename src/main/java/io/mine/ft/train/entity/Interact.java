package io.mine.ft.train.entity;

import java.util.Date;

/**
 * 
 * 类的作用: 作者: 马超 创建时间: 2015-1-31下午12:08:26 email : zhangmj@zparkhr.com.cn
 * version: 1.0
 */
public class Interact {
	private Integer interactId;
	private String interactName;
	private String interactDetail;
	private String department;
	private String studentName;
	private String teacherName;
	private String flagAnswer;
	private String answerContent;
	private String flagEstimate;
	private String estimateContent;
	private Integer tuid;
	private Integer sid;
	private Double score;
	private java.util.Date createDate;
	private java.util.Date answerTime;
	private java.util.Date estimateTime;
	private String teacherDepartment;
	private String flagTeacherAccusation;
	private String flagStudentAccusation;
	private String studentAccusationContent;
	public String getStudentAccusationContent() {
		return studentAccusationContent;
	}
	public Long getDate(){
		Long date=((new Date().getTime()-createDate.getTime()))/1000/60/60/24;
		return date;
	}
	public void setStudentAccusationContent(String studentAccusationContent) {
		this.studentAccusationContent = studentAccusationContent;
	}

	@Override
	public String toString() {
		return "Interact [interactId=" + interactId + ", interactName="
				+ interactName + ", interactDetail=" + interactDetail
				+ ", department=" + department + ", studentName=" + studentName
				+ ", teacherName=" + teacherName + ", flagAnswer=" + flagAnswer
				+ ", answerContent=" + answerContent + ", flagEstimate="
				+ flagEstimate + ", estimateContent=" + estimateContent
				+ ", tuid=" + tuid + ", sid=" + sid + ", score=" + score
				+ ", createDate=" + createDate + ", answerTime=" + answerTime
				+ ", estimateTime=" + estimateTime + ", teacherDepartment="
				+ teacherDepartment + ", flagTeacherAccusation="
				+ flagTeacherAccusation + ", flagStudentAccusation="
				+ flagStudentAccusation + "]";
	}
	public Interact(){}
	public Interact(Integer interactId, String interactName,
			String interactDetail, String department, String studentName,
			String teacherName, String flagAnswer, String answerContent,
			String flagEstimate, String estimateContent, Integer tuid,
			Integer sid, Double score, Date createDate, Date answerTime,
			Date estimateTime, String teacherDepartment,
			String flagTeacherAccusation, String flagStudentAccusation) {
		super();
		this.interactId = interactId;
		this.interactName = interactName;
		this.interactDetail = interactDetail;
		this.department = department;
		this.studentName = studentName;
		this.teacherName = teacherName;
		this.flagAnswer = flagAnswer;
		this.answerContent = answerContent;
		this.flagEstimate = flagEstimate;
		this.estimateContent = estimateContent;
		this.tuid = tuid;
		this.sid = sid;
		this.score = score;
		this.createDate = createDate;
		this.answerTime = answerTime;
		this.estimateTime = estimateTime;
		this.teacherDepartment = teacherDepartment;
		this.flagTeacherAccusation = flagTeacherAccusation;
		this.flagStudentAccusation = flagStudentAccusation;
	}

	public Integer getInteractId() {
		return interactId;
	}

	public void setInteractId(Integer interactId) {
		this.interactId = interactId;
	}

	public String getInteractName() {
		return interactName;
	}

	public void setInteractName(String interactName) {
		this.interactName = interactName;
	}

	public String getInteractDetail() {
		return interactDetail;
	}

	public void setInteractDetail(String interactDetail) {
		this.interactDetail = interactDetail;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getFlagAnswer() {
		return flagAnswer;
	}

	public void setFlagAnswer(String flagAnswer) {
		this.flagAnswer = flagAnswer;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getFlagEstimate() {
		return flagEstimate;
	}

	public void setFlagEstimate(String flagEstimate) {
		this.flagEstimate = flagEstimate;
	}

	public String getEstimateContent() {
		return estimateContent;
	}

	public void setEstimateContent(String estimateContent) {
		this.estimateContent = estimateContent;
	}

	public Integer getTuid() {
		return tuid;
	}

	public void setTuid(Integer tuid) {
		this.tuid = tuid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.util.Date getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(java.util.Date answerTime) {
		this.answerTime = answerTime;
	}

	public java.util.Date getEstimateTime() {
		return estimateTime;
	}

	public void setEstimateTime(java.util.Date estimateTime) {
		this.estimateTime = estimateTime;
	}

	public String getTeacherDepartment() {
		return teacherDepartment;
	}

	public void setTeacherDepartment(String teacherDepartment) {
		this.teacherDepartment = teacherDepartment;
	}

	public String getFlagTeacherAccusation() {
		return flagTeacherAccusation;
	}

	public void setFlagTeacherAccusation(String flagTeacherAccusation) {
		this.flagTeacherAccusation = flagTeacherAccusation;
	}

	public String getFlagStudentAccusation() {
		return flagStudentAccusation;
	}

	public void setFlagStudentAccusation(String flagStudentAccusation) {
		this.flagStudentAccusation = flagStudentAccusation;
	}

}
