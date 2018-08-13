create table festival(
f_number number NOT NULL unique,
f_name varchar2(1000) not null,
season varchar2(200) not null,
f_start_date varchar2(100) not null,
f_end_date varchar2(100) not null,
f_local varchar2(150) not null,
f_contents varchar2(4000) not null,
user_number number,
constraint festival_usernumber_fk foreign key(user_number) references member ON DELETE CASCADE
);
create sequence festival_seq
increment by 1 start with 1;

drop sequence festival_seq;

update member set rating = 3 where user_number=25;
commit