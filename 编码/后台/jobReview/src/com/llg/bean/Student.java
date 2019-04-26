package com.llg.bean;

import java.io.Serializable;

public class Student extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String num;
	private Class c;
	private Group group;

	
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
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
