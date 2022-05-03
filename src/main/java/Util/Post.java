package Util;

public class Post {
	private String id;
	private String profile_id;
	private String written_text;
	private String created_datetime;
	
	public Post(String id_, String profile_id_, String written_text_, String created_datetime_) {
		id = id_;
		profile_id = profile_id_;
		written_text = written_text_;
		created_datetime = created_datetime_;
	}
	
	public Post() {
		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id_) {
		id = id_;
	}
	
	public String getProfileID() {
		return profile_id;
	}
	
	public void setProfileID(String profID) {
		profile_id = profID;
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
}