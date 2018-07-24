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
	String insert_post="insert into post_board(p_type,title,title_number) values(?,?,?,?,postboard_seq.nextval,?,?,?,?,?)";
	String find_post="select post_number,title,id,post_title,registration_date,views from post_board post_board,member member where post_board.user_number=member.user_number and post_board.post_number=?";
	String update_post="update post_board set p_type=?,title=?,title_number=?,user_number=?,post_title=?,post_contents=?,registration_date=?,views=?,id=? where post_number=? ";
}
