package com.llg.bean;

import java.io.Serializable;

public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Task task;
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
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", task=" + task + "]";
	}
	
}
