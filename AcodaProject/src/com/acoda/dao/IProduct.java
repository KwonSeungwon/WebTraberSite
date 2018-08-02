package com.acoda.dao;

public interface IProduct {

	String select_product="select item_number,product_name,id,price,head_count,sell_date,schedule,trip_date,note,pic "
			+ "from product p,member m where p.user_number=m.user_number";

	String insert_product="insert into product(item_number,product_name,user_number,price,head_count,sell_date,trip_date,schedule,note,pic)"
			+ "values(product_seq.nextval,?,?,?,?,?,?,?,?,?)";



	String find_product="";
	String update_product="";
	String delete_product="delete from product where item_number=?  ";
	

	String click_product="select * from product where item_number=?";
	
	String search_product="select item_number,product_name,id,price,head_count,sell_date,trip_date"
    		+ " from product p,member m where  p.user_number=m.user_number and product_name  like '%'||?||'%' ";

	
	

	String select_detail = "select * from product where item_number = ?";



}
