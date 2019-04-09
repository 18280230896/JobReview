package com.llg.bean;

import java.io.Serializable;

public class Task implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private int type;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", type=" + type + ", teacher=" + teacher + "]";
	}
	
}
