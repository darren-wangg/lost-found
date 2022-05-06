package Util;

import java.sql.SQLException;

import Dao.PostDao;

public class Post {
	private String id;
	private String profile_email;
	private String written_text;
	private String created_datetime;
	private Integer likes;
	
	public Post(String id_, String profile_email_, String written_text_, String created_datetime_) {
		id = id_;
		profile_email = profile_email_;
		written_text = written_text_;
		created_datetime = created_datetime_;
	}
	
	//everytime we add a like, need to update like parameter with PostDao.getlikes() again
	
	public Post() {}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id_) {
		id = id_;
	}
	
	public String getProfileEmail() {
		return profile_email;
	}
	
	public void setProfileEmail(String pe) {
		profile_email = pe;
	}
	
	public String getWrittenText() {
		return written_text;
	}
	
	public void setWrittenText(String wt) {
		written_text = wt;
	}
	
	public String getCreatedDatetime() {
		return created_datetime;
	}
	
	public void setCreatedDatetime(String cd) {
		created_datetime = cd;
	}
	
	public Integer getLikes() {
		return likes;
	}
	
}
