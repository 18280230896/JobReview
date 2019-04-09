package com.llg.bean;

import java.io.Serializable;

public class Group implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String Num;
	private String name;
	private Student leader;
	private Class c;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		Num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class getC() {
		return c;
	}
	public void setC(Class c) {
		this.c = c;
	}
	
	
	public Student getLeader() {
		return leader;
	}
	public void setLeader(Student leader) {
		this.leader = leader;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", Num=" + Num + ", name=" + name + ", leader=" + leader + ", c=" + c + "]";
	}
	
	
	
}
