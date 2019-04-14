package com.llg.bean;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String num;
	private String name;
	private Student leader;
	private Class c;
	private List<Student> member;
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public List<Student> getMember() {
		return member;
	}
	public void setMember(List<Student> member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", num=" + num + ", name=" + name + ", leader=" + leader + ", c=" + c + ", member="
				+ member + "]";
	}

	
}
