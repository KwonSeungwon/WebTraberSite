package com.acoda.dao;

public interface IFestival {

    String insert_festival ="insert into festival  values(?,?,?,?,?,?,?,?)";
    String delete_festival="delete from festival  where f_number=?";
    String find_festival="select * from festival  where f_number=?";
    String update_festival="update festival set season=?,f_name=?, f_start_date=?, f_end_date=?,"
          + " f_local =?, f_contents=?, usernumber=? "
          + " where f_number=?";
    String select_festival="select f_number,f_name,season,f_start_date,f_end_date,f_local,f_contents from festival order by f_number asc" ; 
    

}
