package com.acoda.vo;

public class Post_BoardVO {

	private Post_TypeVO post_typevo;
	private MemberVO membervo;
	
	private int p_type; //게시판타입번호(F)
	private String title; //게시판이름
	private int title_number; //게시판번호
	private int user_number; //회원고유번호(F)
	private int post_number; //게시글번호(P)
	private String post_title; //게시글제목
	private String post_contents; //게시글내용
	private String registration_date; //등록일자
	private int view; //조회수
	
	
	public Post_BoardVO() {
		super();
	}


	public Post_BoardVO(int p_type, String title, int title_number, int user_number, int post_number, String post_title,
			String post_contents, String registration_date, int view) {
		super();
		this.p_type = p_type;
		this.title = title;
		this.title_number = title_number;
		this.user_number = user_number;
		this.post_number = post_number;
		this.post_title = post_title;
		this.post_contents = post_contents;
		this.registration_date = registration_date;
		this.view = view;
	}


	public int getP_type() {
		return p_type;
	}


	public void setP_type(int p_type) {
		this.p_type = post_typevo.getP_type();
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getTitle_number() {
		return title_number;
	}


	public void setTitle_number(int title_number) {
		this.title_number = title_number;
	}


	public int getUser_number() {
		return user_number;
	}


	public void setUser_number(int user_number) {
		this.user_number = membervo.getUser_number();
	}


	public int getPost_number() {
		return post_number;
	}


	public void setPost_number(int post_number) {
		this.post_number = post_number;
	}


	public String getPost_title() {
		return post_title;
	}


	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}


	public String getPost_contents() {
		return post_contents;
	}


	public void setPost_contents(String post_contents) {
		this.post_contents = post_contents;
	}


	public String getRegistration_date() {
		return registration_date;
	}


	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}


	public int getView() {
		return view;
	}


	public void setView(int view) {
		this.view = view;
	}


	
	
	
	
	
}
