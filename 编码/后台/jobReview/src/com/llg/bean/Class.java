package com.llg.bean;

import java.io.Serializable;

public class Class implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private int semester;
	private Teacher teacher;
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", semester=" + semester + ", teacher=" + teacher + "]";
	}
	
	
	
	
	
}
