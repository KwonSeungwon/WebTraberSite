package com.acoda.dao;

public interface IProduct {

      //리스트 페이징 처리완료
   String select_product = "select (select count(*)  from product where  rownum<=100) total,item_number,product_name,id,price,head_count,sell_date,schedule,trip_date,note,pic "
         + "from product p,member m where p.user_number=m.user_number order by item_number desc";

   String insert_product = "insert into product(item_number,product_name,user_number,price,head_count,sell_date,schedule,trip_date,note,pic)"
         + "values(product_seq.nextval,?,?,?,?,?,?,?,?,?)";

   String update_product = "update product set PRODUCT_NAME = ?, PRICE = ?, HEAD_COUNT = ?, SCHEDULE = ?, TRIP_DATE = ?, NOTE = ?, PIC = ? "
         + "where item_number = ? ";
   
   String productupdateinfo = "select * from product where item_number=?";
   String delete_product = "delete from product where item_number=?  ";

   String click_product = "select * from product where item_number=?";

   String select_detail = "select item_number,product_name,price,head_count,sell_date,schedule,trip_date,note,pic,id from product p, member m where p.user_number=m.user_number and item_number = ?";

   String search_product = "select(select count(*)  from product where  rownum<=100 and product_name  like '%'||?||'%') total, item_number,product_name,id,price,head_count,sell_date,trip_date"
         + " from product p,member m where  p.user_number=m.user_number and product_name  like '%'||?||'%' ";

}