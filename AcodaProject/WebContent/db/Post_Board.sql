create table post_board(
p_type number,
title varchar2(50) not null,
title_number number not null,
user_number number ,
post_number number primary key,
post_title varchar2(50) not null,
post_contents varchar2(4000) not null,
registration_date varchar2(50) not null,
views number default 0 not null,
path varchar2(4000)
);

,
constraint postboard_usernumber_fk foreign key(user_number) references member,
constraint postboard_p_type_fk foreign key(p_type) references post_type


insert into post_board(p_type,title,title_number,user_number,post_number,post_title,post_contents,registration_date,views)
values(2,'후기게시판',1,6,postboard_seq.nextval,'여행1','후기게시판test',sysdate,1);

insert into post_board(p_type,title,title_number,user_number,post_number,post_title,post_contents,registration_date,views,path)
values(2,'유저게시판',2,5,postboard_seq.nextval,'불란서','유저게시판test',sysdate,0,'c://img..');

-------------------------
create table post_type(
p_type number,
p_title  varchar2(100) not null,
constraint post_type_p_type_pk primary key(p_type)
);


 insert into post_type values(1,'댓글게시판');
insert into post_type values(2,'사진게시판');

select * from post_type;
select * from post_board;
select * from member;

drop table post_board;

commit
