package com.acoda.dao;

public interface IBuy {
	
	String select_buy="select * from buy where user_number = ?";
	String insert_buy="insert into buy(order_number,order_day,nationality,fellow_traveler"
			+ ",language,unusual,user_number,item_number) values(buy_seq.nextval,?,?,?,?,?,?,?)";
	String find_buy="";
	String update_buy="";
	String delete_buy="delete from buy where item_number = ?";
	//신청서 확인시 목록보여주기
	String a_select_buy="select m.id,b.order_number,b.order_day,b.nationality,b.fellow_traveler,"
			+ "b.language,b.unusual" 
			+ " from buy b,member m where b.user_number= m.user_number and b.item_number=? ";
	String click_select="select m.id,b.order_day,b.nationality,b.fellow_traveler,b.language,b.unusual"
			+ "from buy b,member m where b.user_number=m.user_number ";
}
