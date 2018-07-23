package com.acoda.vo;

public class PictureVO {

	private Post_BoardVO post_boardvo;
	private MemberVO membervo;
	
	private String path;
	private int post_number;
	private int user_number;
	
	
	
	public PictureVO() {
		super();
	}



	public PictureVO(String path, int post_number, int user_number) {
		super();
		this.path = path;
		this.post_number = post_number;
		this.user_number = user_number;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public int getPost_number() {
		return post_number;
	}



	public void setPost_number(int post_number) {
		this.post_number = post_boardvo.getPost_number();
	}



	public int getUser_number() {
		return user_number;
	}



	public void setUser_number(int user_number) {
		this.user_number = membervo.getUser_number();
	}
	
	
	
}
