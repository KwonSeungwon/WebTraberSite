package com.acoda.vo;

public class Post_TypeVO {

	private int p_type; //게시판타입번호
	private String p_title; //게시판타입이름
	
	public Post_TypeVO() {
		super();
	}
	
	public Post_TypeVO(int p_type, String p_title) {
		super();
		this.p_type = p_type;
		this.p_title = p_title;
	}

	public int getP_type() {
		return p_type;
	}

	public void setP_type(int p_type) {
		this.p_type = p_type;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	
	
	
}
