package com.acoda.vo;

public class Post_BoardVO {

	private Post_TypeVO post_typevo;
	private MemberVO membervo;
	
	private int p_type; //게시판타입번호(F)
	private String title; //게시판이름
	private int title_number; //게시판번호
	private int user_number; //회원고유번호(F)
	private int post_number; //게시글번호(P)
	private String post_title; //게시글제목
	private String post_contents; //게시글내용
	private String registration_date; //등록일자
	private int views; //조회수
	private String path;//사진 파일경로
	
	private String id;
	
	
	

	public Post_BoardVO() {
		super();
	}

	//select_post_user 쿼리문용 생성자
	
		public Post_BoardVO(int post_number,String title, String id, String post_title, String registration_date, int views
				) {
			super();
			this.title = title;
			this.post_number = post_number;
			this.post_title = post_title;
			this.registration_date = registration_date;
			this.views = views;
			this.id = id;
		}
		
		//find
		public Post_BoardVO(String title, String id, String post_title,String post_contents, String registration_date, int views,int post_number
				) {
			super();
			this.title = title;
			this.post_number = post_number;
			this.post_title = post_title;
			this.registration_date = registration_date;
			this.views = views;
			this.id = id;
			this.post_contents = post_contents;
			
		}
		
		//click
		public Post_BoardVO(int post_number, String post_title, String post_contents, String registration_date, int views,
				String path, String id) {
			super();
			this.post_number = post_number;
			this.post_title = post_title;
			this.post_contents = post_contents;
			this.registration_date = registration_date;
			this.views = views;
			this.path = path;
			this.id = id;
		}
		
		//search
		public Post_BoardVO(int post_number,String post_title, String title, String post_contents, String registration_date, int views,
				String path) {
			super();
			this.post_number = post_number;
			this.post_title=post_title;
			this.title = title;
			this.post_contents = post_contents;
			this.registration_date = registration_date;
			this.views = views;
			this.path = path;
		}


		public Post_BoardVO(int p_type, String title, int title_number, int user_number,
				String post_title, String post_contents, String registration_date, int views, String path,int post_number) {
			super();
			this.p_type = p_type;
			this.title = title;
			this.title_number = title_number;
			this.user_number = user_number;
			this.post_number = post_number;
			this.post_title = post_title;
			this.post_contents = post_contents;
			this.registration_date = registration_date;
			this.views = views;
			this.path = path;
		}

	public Post_BoardVO(int p_type, String title, int title_number, int user_number, int post_number, String post_title,
			String post_contents, String registration_date, int views, String path) {
		super();
		this.p_type = p_type;
		this.title = title;
		this.title_number = title_number;
		this.user_number = user_number;
		this.post_number = post_number;
		this.post_title = post_title;
		this.post_contents = post_contents;
		this.registration_date = registration_date;
		this.views = views;
		this.path = path;
	}
	
	

	public Post_BoardVO(int p_type, String title, int title_number, int user_number, int post_number, String post_title,
			String post_contents, String registration_date, int views, String path, String id) {
		super();
		this.p_type = p_type;
		this.title = title;
		this.title_number = title_number;
		this.user_number = user_number;
		this.post_number = post_number;
		this.post_title = post_title;
		this.post_contents = post_contents;
		this.registration_date = registration_date;
		this.views = views;
		this.path = path;
		this.id = id;
	}



	public int getP_type() {
		return p_type;
	}


	public void setP_type(int p_type) {
		this.p_type = p_type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getTitle_number() {
		return title_number;
	}


	public void setTitle_number(int title_number) {
		this.title_number = title_number;
	}


	public int getUser_number() {
		return user_number;
	}


	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}


	public int getPost_number() {
		return post_number;
	}


	public void setPost_number(int post_number) {
		this.post_number = post_number;
	}


	public String getPost_title() {
		return post_title;
	}


	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}


	public String getPost_contents() {
		return post_contents;
	}


	public void setPost_contents(String post_contents) {
		this.post_contents = post_contents;
	}


	public String getRegistration_date() {
		return registration_date;
	}


	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}



	public String getPath() {
		return path;
	}





	public void setPath(String path) {
		this.path = path;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	
	
	
}
