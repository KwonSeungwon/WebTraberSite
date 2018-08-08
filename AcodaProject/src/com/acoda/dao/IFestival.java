package com.acoda.dao;

public interface IFestival {

    String insert_festival ="insert into festival(f_number,f_name,season,f_start_date,f_end_date,f_local,f_contents,user_number)  values(festival_seq.nextval,?,?,?,?,?,?,?)";
    
    String delete_festival="delete from festival  where f_number=?";
    
    String find_festival="select * from festival  where f_number=?";
   
    String update_festival="update festival set f_name=?,season=?, f_start_date=?, f_end_date=?,"
          + " f_local =?, f_contents=? "
          + " where f_number=?";
    String select_festival="select f_number,f_name,season,f_start_date,f_end_date,f_local,f_contents from festival where rownum<=100 order by f_number desc" ; 
    
    String search_festival="select f_number,f_name,season,f_start_date,f_end_date,f_local"
    		+ " from festival where f_name like  '%'||?||'%' ";
    
    
	String click_festival="select f_number,f_name,season,f_start_date,f_end_date,f_local,f_contents  from festival "
			+ "where f_number=?";
	
	/*String click_post="select post_number,post_title,post_contents,registration_date,views,path,id from post_board post_board,member member "
			+ "where post_board.user_number=member.user_number and post_board.post_number=?";*/
	}
