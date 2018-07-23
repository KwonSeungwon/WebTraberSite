package com.acoda.vo;

public class ReplyVO {
	
	private MemberVO membervo;
	private Post_BoardVO post_boardvo;
	
	
	private int post_number; //게시글번호(F)
	private int r_number; //댓글번호(P)
	private int user_number; //회원고유번호(F)
	private String r_date; //등록일
	private String r_comment; //댓글내용
	
	public ReplyVO() {
		super();
	}

	public ReplyVO(int post_number, int r_number, int user_number, String r_date, String r_comment) {
		super();
		this.post_number = post_number;
		this.r_number = r_number;
		this.user_number = user_number;
		this.r_date = r_date;
		this.r_comment = r_comment;
	}

	public int getPost_number() {
		return post_number;
	}

	public void setPost_number(int post_number) {
		this.post_number = post_boardvo.getPost_number();
	}

	public int getR_number() {
		return r_number;
	}

	public void setR_number(int r_number) {
		this.r_number = r_number;
	}

	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = membervo.getUser_number();
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	public String getR_comment() {
		return r_comment;
	}

	public void setR_comment(String r_comment) {
		this.r_comment = r_comment;
	}
	
	
	
	
	
	
}
