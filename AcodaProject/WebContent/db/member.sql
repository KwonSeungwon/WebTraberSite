select * from MEMBER_TYPE;
select * from member;
insert into FESTIVAL(f_number,f_name,season,f_start_date,f_end_date,f_local,f_contents,user_number)
values(festival_seq.nextval,'루지','봄',sysdate,'2018-09-25','강화도','불타는',17);


select item_number,product_name,id,price,head_count,sell_date,schedule,trip_date,note from product p,member m
where p.user_number=m.user_number;