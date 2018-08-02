package com.acoda.dao;

public interface IBuy {
	
	String select_buy="select * from buy where user_number = ?";
	String insert_buy="";
	String find_buy="";
	String update_buy="";
	String delete_buy="delete from buy where item_number = ?";

}
