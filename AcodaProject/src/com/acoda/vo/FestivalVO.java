package com.acoda.vo;

public class FestivalVO {
	
	private MemberVO membervo;
	
	private int f_number;
	private String f_name;
	private String season;
	private String f_start_date;
	private String f_end_date;
	private String f_local;
	private String f_contents;
	private int user_number;
	
	
	
	public FestivalVO() {
		super();
	}

	public FestivalVO(int f_number, String f_name, String season, String f_start_date, String f_end_date,
			String f_local, String f_contents, int user_number) {
		super();
		this.f_number = f_number;
		this.f_name = f_name;
		this.season = season;
		this.f_start_date = f_start_date;
		this.f_end_date = f_end_date;
		this.f_local = f_local;
		this.f_contents = f_contents;
		this.user_number = user_number;
	}
	
	public FestivalVO(String f_name, String season, String f_start_date, String f_end_date,
			String f_local, String f_contents, int user_number,int f_number) {
		super();
		this.f_number = f_number;
		this.f_name = f_name;
		this.season = season;
		this.f_start_date = f_start_date;
		this.f_end_date = f_end_date;
		this.f_local = f_local;
		this.f_contents = f_contents;
		this.user_number = user_number;
	}

	
	//click
	public FestivalVO(int f_number, String f_name, String season, String f_start_date, String f_end_date,
			String f_local, String f_contents) {
		super();
		this.f_number = f_number;
		this.f_name = f_name;
		this.season = season;
		this.f_start_date = f_start_date;
		this.f_end_date = f_end_date;
		this.f_local = f_local;
		this.f_contents = f_contents;
	}

	public int getF_number() {
		return f_number;
	}



	public void setF_number(int f_number) {
		this.f_number = f_number;
	}



	public String getF_name() {
		return f_name;
	}



	public void setF_name(String f_name) {
		this.f_name = f_name;
	}



	public String getSeason() {
		return season;
	}



	public void setSeason(String season) {
		this.season = season;
	}



	public String getF_start_date() {
		return f_start_date;
	}



	public void setF_start_date(String f_start_date) {
		this.f_start_date = f_start_date;
	}



	public String getF_end_date() {
		return f_end_date;
	}



	public void setF_end_date(String f_end_date) {
		this.f_end_date = f_end_date;
	}



	public String getF_local() {
		return f_local;
	}



	public void setF_local(String f_local) {
		this.f_local = f_local;
	}



	public String getF_contents() {
		return f_contents;
	}



	public void setF_contents(String f_contents) {
		this.f_contents = f_contents;
	}



	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}



	

	

}
