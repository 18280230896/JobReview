package com.llg.bean;

import java.io.Serializable;

public class TaskScore implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Student student;
	private ClassTask classTask;
	private int score;
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
	public ClassTask getClassTask() {
		return classTask;
	}
	public void setClassTask(ClassTask classTask) {
		this.classTask = classTask;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "TaskScore [id=" + id + ", student=" + student + ", classTask=" + classTask + ", score=" + score + "]";
	}
	
	
}
