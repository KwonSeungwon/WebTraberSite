package com.acoda.dao;

public interface IPost_Board {
	/*int p_type; //게시판타입번호(F)
	String title; //게시판이름
	int title_number; //게시판번호
	int user_number; //회원고유번호(F)
	int post_number; //게시글번호(P)
	String post_title; //게시글제목
	String post_contents; //게시글내용
	String registration_date; //등록일자
	int views; //조회수
	String path;//사진 파일경로
	String id*/
	
	String select_post="select post_number,title,id,post_title,registration_date,views from post_board post_board,member member where post_board.user_number=member.user_number";
	String click_post="select title,id,post_title,registration_date,views from post_board post_board,member member where post_board.user_number=member.user_number and post_board.post_numer=?";
	String insert_post_user="insert into post_board(p_type,title,title_number,user_number,post_number,post_title,post_contents,registration_date,views,path) values(1,'유저게시판',1,?,?,?,?,?,?,?)";
	String insert_post_hugi="insert into post_board(p_type,title,title_number,user_number,post_number,post_title,post_contents,registration_date,views,path) values(2,'후기게시판',2,?,?,?,?,?,?,?)";
	String find_post="select post_number,title,id,post_title,registration_date,views from post_board post_board,member member where post_board.user_number=member.user_number and post_board.post_number=?";
	String update_post="update post_board set p_type=?,title=?,title_number=?,user_number=?,post_title=?,post_contents=?,registration_date=?,views=?,id=? where post_number=? ";
	String delete_post="";
}
