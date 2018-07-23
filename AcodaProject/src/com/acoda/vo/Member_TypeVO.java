package com.acoda.vo;

public class Member_TypeVO {

	private int rating; //등급코드
	private String ration_name; //등급명
	
	
	
	
	public Member_TypeVO() {
		super();
	}
	
	public Member_TypeVO(int rating, String ration_name) {
		super();
		this.rating = rating;
		this.ration_name = ration_name;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getRation_name() {
		return ration_name;
	}
	public void setRation_name(String ration_name) {
		this.ration_name = ration_name;
	}
	
	
}
