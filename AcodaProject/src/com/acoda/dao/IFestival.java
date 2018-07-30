package com.acoda.dao;

public interface IFestival {

    String insert_festival ="insert into festival(f_number,f_name,season,f_start_date,f_end_date,f_local,f_contents,user_number)  values(?,?,?,?,?,?,?,?)";
    
    String delete_festival="delete from festival  where f_number=?";
    
    String find_festival="select * from festival  where f_number=?";
   
    String update_festival="update festival set f_name=?,season=?, f_start_date=?, f_end_date=?,"
          + " f_local =?, f_contents=? "
          + " where f_number=?";
    String select_festival="select f_number,f_name,season,f_start_date,f_end_date,f_local,f_contents from festival order by f_number asc" ; 
    
    String search_festival="select f_number,f_name,season,f_start_date,f_end_date,f_local"
    		+ " from festival where f_name like  '%'||?||'%' ";
}
