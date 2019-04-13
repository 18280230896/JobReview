package com.llg.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class ClassTask implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private int type;
	private int semester;
	private int status;
	private int proportion;
	private Timestamp startTime;
	private Timestamp endTime;
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
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
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
	
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getProportion() {
		return proportion;
	}
	public void setProportion(int proportion) {
		this.proportion = proportion;
	}
	@Override
	public String toString() {
		return "ClassTask [id=" + id + ", type=" + type + ", semester=" + semester + ", status=" + status
				+ ", proportion=" + proportion + ", startTime=" + startTime + ", endTime=" + endTime + ", task=" + task
				+ ", c=" + c + "]";
	}
	
	
	
	
}
