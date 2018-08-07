package com.acoda.dao;

public interface IReply {
	
	String select_reply="select post_number,r_number,r_comment,r_date,id from reply reply,member member where reply.user_number = member.user_number and reply.post_number=?";
	String insert_reply="insert into reply(post_number,r_number,user_number,r_date,r_comment) values(?,reply_seq.nextval,?,?,?)";
	String update_reply="update reply set r_comment=? where r_number=?";
	String delete_reply="delete from reply where r_number=?";
	String update_viewscount_minus="update post_board set views=views-1 where post_number=?";

}
