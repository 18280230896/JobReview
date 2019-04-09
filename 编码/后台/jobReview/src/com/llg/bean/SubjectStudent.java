package com.llg.bean;

import java.io.Serializable;

public class SubjectStudent implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Subject subject;
	private Student student;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "SubjectStudent [id=" + id + ", subject=" + subject + ", student=" + student + "]";
	}
	
	
}
