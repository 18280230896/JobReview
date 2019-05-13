package com.llg.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class JobStatus implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Student student;
	private Group group;
	private ClassTask classTask;
	private Timestamp submitTime;
	private Integer score;
	private Integer gread;
	private Integer adopt;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


	public ClassTask getClassTask() {
		return classTask;
	}


	public void setClassTask(ClassTask classTask) {
		this.classTask = classTask;
	}


	public Timestamp getSubmitTime() {
		return submitTime;
	}


	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public Integer getGread() {
		return gread;
	}


	public void setGread(Integer gread) {
		this.gread = gread;
	}


	public Integer getAdopt() {
		return adopt;
	}


	public void setAdopt(Integer adopt) {
		this.adopt = adopt;
	}


	@Override
	public String toString() {
		return "JobStatus [id=" + id + ", student=" + student + ", group=" + group + ", classTask=" + classTask
				+ ", submitTime=" + submitTime + ", score=" + score + ", gread=" + gread + ", adopt=" + adopt + "]";
	}


	
}
