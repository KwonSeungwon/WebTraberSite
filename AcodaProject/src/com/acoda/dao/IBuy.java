package com.acoda.dao;

public interface IBuy {
	
	String select_buy="select * from buy where user_number = ?";
	String insert_buy="insert into buy(order_number,order_day,nationality,fellow_traveler"
			+ ",language,unusual,user_number,item_number) values(buy_seq.nextval,?,?,?,?,?,?,?)";
	String find_buy="";
	String update_buy="";
	String delete_buy="delete from buy where item_number = ?";

}
