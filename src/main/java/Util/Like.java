package Util;

import java.sql.Timestamp;

public class Like {
	private String id;
	private String post_id;
	private String profile_email;
	private Timestamp created_time;
	
	public Like(String id_, String post_id_, String profile_email_, Timestamp created_time_) {
		id = id_;
		post_id = post_id_;
		profile_email = profile_email_;
		created_time = created_time_;
	}
	
	public Like() {}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id_) {
		id = id_;
	}
	
	public String getPostID() {
		return post_id;
	}
	
	public void setPostID(String pi) {
		post_id = pi;
	}
	
	public String getProfileEmail() {
		return profile_email;
	}
	
	public void setProfileEmail(String pe) {
		profile_email = pe;
	}
	
	public Timestamp getCreatedTime() {
		return created_time;
	}
	
	public void setCreatedTime(Timestamp ct) {
		created_time = ct;
	}
}
