package com.llg.bean;

import java.io.Serializable;

public class TaskFile implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String path;
	private Subject subject;
	private Student student;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
		return "TaskFile [id=" + id + ", name=" + name + ", path=" + path + ", subject=" + subject + ", student="
				+ student + "]";
	}
	
	
	
}
