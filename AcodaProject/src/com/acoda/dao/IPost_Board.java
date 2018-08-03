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
	String select_post_hugi="select post_number,title,id,post_title,registration_date,views from post_board post_board,member member where post_board.user_number=member.user_number and post_board.title_number=1 order by post_board.post_number desc";
	String insert_post_hugi="insert into post_board(p_type,title,title_number,user_number,post_number,post_title,post_contents,registration_date,views,path) values(1,'후기게시판',1,?,postboard_seq.nextval,?,?,?,0,?)";
	
	String select_post_user="select post_number,title,id,post_title,registration_date,views from post_board post_board,member member where post_board.user_number=member.user_number and post_board.title_number=2 order by post_board.post_number desc";
	String insert_post_user="insert into post_board(p_type,title,title_number,user_number,post_number,post_title,post_contents,registration_date,views,path) values(2,'유저게시판',2,?,postboard_seq.nextval,?,?,?,0,?)";
	
	String find_post="select post_number,title,id,post_title,post_contents,registration_date,views from post_board post_board,member member where post_board.user_number=member.user_number and post_board.post_number=?";
	
	String update_post_hugi="update post_board set p_type=1,title='후기게시판',title_number=1,user_number=?,post_title=?,post_contents=?,registration_date=?,views=?,path=? where post_number=? ";
	String update_post_user="update post_board set p_type=2,title='유저게시판',title_number=2,user_number=?,post_title=?,post_contents=?,registration_date=?,views=?,path=? where post_number=? ";
	
	String delete_post="delete from post_board where post_number=?";
	
	String click_post="select post_number,post_title,post_contents,registration_date,views,path,id from post_board post_board,member member where post_board.user_number=member.user_number and post_board.post_number=?";
	
	String search_post_hugi="select post_number,post_title,title,post_contents,registration_date,views,path,id from post_board post_board,member member where post_board.user_number=member.user_number and post_board.title_number=1 and post_board.post_title like '%'||?||'%' order by post_board.post_number desc";
	String search_post_user="select post_number,post_title,title,post_contents,registration_date,views,path,id from post_board post_board,member member where post_board.user_number=member.user_number and post_board.title_number=2 and post_board.post_title like '%'||?||'%' order by post_board.post_number desc";
	
	String update_viewscount="update post_board set views=views+1 where post_number=?";
	
}
