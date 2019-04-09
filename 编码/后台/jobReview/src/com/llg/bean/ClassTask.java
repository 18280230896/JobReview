package com.llg.bean;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

public class ClassTask implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private int type;
	private Timestamp startTime;
	private Time endTime;
	private Task task;
	private Class c;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Class getC() {
		return c;
	}
	public void setC(Class c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "ClassTask [id=" + id + ", type=" + type + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", task=" + task + ", c=" + c + "]";
	}
	
	
}
