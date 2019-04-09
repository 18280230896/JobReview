package com.llg.bean;

import java.io.Serializable;

public class GroupStudent implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Student student;
	private Group group;
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
	@Override
	public String toString() {
		return "GroupStudent [id=" + id + ", student=" + student + ", group=" + group + "]";
	}
	
}
