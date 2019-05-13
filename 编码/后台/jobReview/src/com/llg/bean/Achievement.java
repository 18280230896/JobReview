package com.llg.bean;

public class Achievement {

	private Integer score;
	private Integer gread;
	private Integer adopt;
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getGread() {
		return gread;
	}
	public void setGread(Integer gread) {
		this.gread = gread;
	}
	public Integer getAdopt() {
		return adopt;
	}
	public void setAdopt(Integer adopt) {
		this.adopt = adopt;
	}
	@Override
	public String toString() {
		return "Achievement [score=" + score + ", gread=" + gread + ", adopt=" + adopt + "]";
	}
	
	
}
