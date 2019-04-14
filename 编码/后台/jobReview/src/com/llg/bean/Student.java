package com.llg.bean;

import java.io.Serializable;

public class Student extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Class c;
	private Group group;

	public Class getC() {
		return c;
	}
	public void setC(Class c) {
		this.c = c;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	
	
	
}
