package com.acoda.vo;

public class BuyVO {

	private MemberVO membervo;
	private ProductVO productvo;

	private int item_number;
	private int user_number;
	private int order_number;
	private String order_day;
	private String nationality;
	private int fellow_traveler;
	private String language;
	private String unusual;
	private String id;
	
	
	public BuyVO() {
		super();
	}

	//»ý¼ºÀÚ
	public BuyVO(int item_number, int user_number, int order_number, String order_day, String nationality,
			int fellow_traveler, String language, String unusual, String id) {
		super();
		this.item_number = item_number;
		this.user_number = user_number;
		this.order_number = order_number;
		this.order_day = order_day;
		this.nationality = nationality;
		this.fellow_traveler = fellow_traveler;
		this.language = language;
		this.unusual = unusual;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getItem_number() {
		return item_number;
	}

	public void setItem_number(int item_number) {
		this.item_number = item_number;
	}

	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public String getOrder_day() {
		return order_day;
	}

	public void setOrder_day(String order_day) {
		this.order_day = order_day;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getFellow_traveler() {
		return fellow_traveler;
	}

	public void setFellow_traveler(int fellow_traveler) {
		this.fellow_traveler = fellow_traveler;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getUnusual() {
		return unusual;
	}

	public void setUnusual(String unusual) {
		this.unusual = unusual;
	}

}
