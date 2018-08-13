package com.acoda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.acoda.vo.Post_BoardVO;




@Repository
public class Post_BoardDAO implements IPost_Board {
    
   @Autowired
   JdbcTemplate jdbcTemplate;
   //Select(전체목록출력)
   public List<Post_BoardVO> getHugiPost_Board(){
      List<Post_BoardVO> all = jdbcTemplate.query(select_post_hugi, new RowMapper<Post_BoardVO>() {
         public Post_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post_BoardVO vo = new Post_BoardVO(rs.getInt("total"),rs.getInt("post_number"),rs.getString("title"), rs.getString("id"),
                  rs.getString("post_title"), rs.getString("registration_date"), rs.getInt("views"));
            return vo;
         }
         
      });
      return all;
   }
   public List<Post_BoardVO> getUserPost_Board(){
      List<Post_BoardVO> all = jdbcTemplate.query(select_post_user, new RowMapper<Post_BoardVO>() {
         public Post_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post_BoardVO vo = new Post_BoardVO(rs.getInt("total"),rs.getInt("post_number"),rs.getString("title"), rs.getString("id"),
                  rs.getString("post_title"), rs.getString("registration_date"), rs.getInt("views"));
            return vo;
         }
      });
      return all;
      
   }
   //Insert
   public int getInsert_HugiPost_Board(Post_BoardVO vo) {
      
      int r =jdbcTemplate.update(insert_post_hugi,
            new Object[] {vo.getUser_number(),vo.getPost_title()
                  ,vo.getPost_contents(),vo.getRegistration_date(),vo.getPath()});

      if (r > 0) {
         System.out.println("Post_BarodDAO 의 getInsert_HugiPost_Board if문 r>0");
         return r;
      } else {
         System.out.println("Post_BarodDAO 의 getInsert_HugiPost_Board if문 else");
         return 0;
      }
      
   }
   public int getInsert_UserPost_Board(Post_BoardVO vo) {
      int r = jdbcTemplate.update(insert_post_user,
            new Object[] {vo.getUser_number(),vo.getPost_title()
                  ,vo.getPost_contents(),vo.getRegistration_date(),vo.getPath()});
      if (r > 0) {
         System.out.println("Post_BarodDAO 의 getInsert_UserPost_Board if문 r>0");
         return r;
      } else {
         System.out.println("Post_BarodDAO 의 getInsert_UserPost_Board if문 else");
         return 0;
      } 
   }
   //Find
   public Post_BoardVO getFindPost_Board(String find_post_number) {
      
      Post_BoardVO pbvo=jdbcTemplate.queryForObject(find_post, new Object[] {find_post_number},
            new RowMapper<Post_BoardVO>() {

               @Override
               public Post_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                  
                  Post_BoardVO vo= new Post_BoardVO(rs.getString("title"), rs.getString("id"), rs.getString("post_title"),
                        rs.getString("post_contents"),rs.getString("registration_date"), rs.getInt("views"),rs.getString("path"),rs.getInt("post_number"));
                  
                  return vo;
               }
      });
      return pbvo;
   }
   
   //Delete
   public int getDelPost_Board(String del_post_number) {
      int r = jdbcTemplate.update(delete_post,del_post_number);
      return r;
   }
   //Update
   public int getUpdateHugi_Post_Board(Post_BoardVO vo) {
      return jdbcTemplate.update(update_post_hugi,new Object[] {vo.getUser_number(),vo.getPost_title(),vo.getPost_contents(),vo.getRegistration_date(),
            vo.getViews(),vo.getPath(),vo.getPost_number()});
      }
   
   
   public int getUpdateUser_Post_Board(Post_BoardVO vo) {
	  System.out.println("포스트보드다오->getUpdateUser_Post_Board 실행");
	  System.out.println("다오 vo.getPath()"+vo.getPath());
      return jdbcTemplate.update(update_post_user,new Object[] {vo.getUser_number(),vo.getPost_title(),vo.getPost_contents(),vo.getRegistration_date(),
            vo.getViews(),vo.getPath(),vo.getPost_number()});
      
   }
   //조회수처리용
   public int getUpdateViews(String click_post_number) {
      return jdbcTemplate.update(update_viewscount,click_post_number);
   }
   
   //Click(페이지 상세보기)
   public List<Post_BoardVO> getClickPost_Board(String click_post_number) {
      this.getUpdateViews(click_post_number);
      List<Post_BoardVO> pbvo=jdbcTemplate.query(click_post, new Object[] {click_post_number},
            new RowMapper<Post_BoardVO>() {

               @Override
               public Post_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                  int views = rs.getInt("views");
                  Post_BoardVO vo= new Post_BoardVO(rs.getInt("post_number"),rs.getString("post_title"),rs.getString("post_contents")
                        ,rs.getString("registration_date"),views,rs.getString("path"),rs.getString("id"));
                  return vo;
                  
               }
      });
      return pbvo;
   }
   
   //Search(제목으로검색)
   public List<Post_BoardVO> getSearch_Post_Board_User(String s){
      System.out.println("Post_BoardDAO->getSearch_Post_Board_User호출");
            RowMapper<Post_BoardVO> mapper=new RowMapper<Post_BoardVO>() {
         @Override
         public Post_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            System.out.println("Post_BoardDAO->getSearch_Post_Board_User->mapRow실행");
            Post_BoardVO vo=new Post_BoardVO();
            vo.setPost_title(rs.getString("post_title"));
            vo.setTotal(rs.getInt("total"));
            vo.setPost_number(rs.getInt("post_number"));
            vo.setTitle(rs.getString("title"));
            vo.setPost_contents(rs.getString("post_contents"));
            vo.setRegistration_date(rs.getString("registration_date"));
            vo.setViews(rs.getInt("views"));
            vo.setPath(rs.getString("path"));
            vo.setId(rs.getString("id"));
            System.out.println("mapRow의 vo.toString() = "+vo.toString());
            return vo;   
         }
      };
      return jdbcTemplate.query(search_post_user, mapper, new Object[] {s,s});
      
   }
   public List<Post_BoardVO> getSearch_Post_Board_Hugi(String s){
      RowMapper<Post_BoardVO> mapper=new RowMapper<Post_BoardVO>() {
         @Override
         public Post_BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            System.out.println("Post_BoardDAO->getSearch_Post_Board_Hugi->mapRow실행");
            Post_BoardVO vo=new Post_BoardVO();
            vo.setPost_title(rs.getString("post_title"));
            vo.setTotal(rs.getInt("total"));
            vo.setPost_number(rs.getInt("post_number"));
            vo.setTitle(rs.getString("title"));
            vo.setPost_contents(rs.getString("post_contents"));
            vo.setRegistration_date(rs.getString("registration_date"));
            vo.setViews(rs.getInt("views"));
            vo.setPath(rs.getString("path"));
            vo.setId(rs.getString("id"));
            return vo;   
         }
      };
      return jdbcTemplate.query(search_post_hugi, mapper, new Object[] {s,s});

   }

   
   
   
   
   

}