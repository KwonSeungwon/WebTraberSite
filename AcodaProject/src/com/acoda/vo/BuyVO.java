package com.acoda.vo;

import java.util.List;

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
	private String application;
	
	public BuyVO(int order_number, String application, String memo, List<BuyVO> listvo) {
		super();
		this.order_number = order_number;
		this.application = application;
		this.memo = memo;
		this.listvo = listvo;
	}

	public List<BuyVO> getListvo() {
		return listvo;
	}

	public void setListvo(List<BuyVO> listvo) {
		this.listvo = listvo;
	}

	private String memo;
	private List<BuyVO> listvo;
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public BuyVO() {
		super();
	}

	//»ý¼ºÀÚ 
	public BuyVO(int item_number, int user_number, int order_number, String order_day, String nationality,
			int fellow_traveler, String language, String unusual, String id, String application, String memo) {
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
		this.application = application;
		this.memo = memo;
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

	@Override
	public String toString() {
		return "BuyVO [membervo=" + membervo + ", productvo=" + productvo + ", item_number=" + item_number
				+ ", user_number=" + user_number + ", order_number=" + order_number + ", order_day=" + order_day
				+ ", nationality=" + nationality + ", fellow_traveler=" + fellow_traveler + ", language=" + language
				+ ", unusual=" + unusual + ", id=" + id + ", application=" + application + ", memo=" + memo + "]";
	}

}
