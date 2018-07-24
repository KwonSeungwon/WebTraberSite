package com.acoda.dao;

public interface IPost_Board {
	//게시판타입번호(F),게시판이름,게시판번호,회원고유번호(F),게시글번호(P),게시글제목,게시글내용,등록일자,조회수,사진파일경로
	String select_post="select post_number,title,id,post_title,registration_date,views from post_board post_board,member member where post_board.user_number=member.user_number";
	String insert_post="insert into post_board values(?,?,?,?,postboard_seq.nextval,?,?,?,?,?)";
	String insert_find_post="select * from post_board post_board,member member where post_board.user_number=member.user_number and post_board.user_number=?";
	String find_post="select post_number,title,id,post_title,registration_date,views from post_board post_board,member member where post_board.user_number=member.user_number and post_board.post_number=?";
	String update_post="update post_board set p_type=?,title=?,title_number=?,user_number=?,post_title=?,post_contents=?,registration_date=?,views=?,id=? where post_number=? ";
}
