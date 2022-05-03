DROP DATABASE IF EXISTS lost_n_found;
CREATE DATABASE lost_n_found;

USE lost_n_found;

DROP TABLE IF EXISTS user_profile;
CREATE TABLE user_profile (
  email VARCHAR(50) UNIQUE, 
  name_ VARCHAR(50),
  id VARCHAR(15) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50),
  password_ VARCHAR(50)
);

DROP TABLE IF EXISTS post_like;
CREATE TABLE post_like (
  id VARCHAR(15) NOT NULL PRIMARY KEY AUTO_INCREMENT, 
  post_id VARCHAR(15) REFERENCES user_post(id),
  profile_email VARCHAR(50) REFERENCES user_profile(email),
  created_time TIMESTAMP
);

DROP TABLE IF EXISTS user_post;
CREATE TABLE user_post (
    id VARCHAR(15) NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    profile_email VARCHAR(50) REFERENCES user_profile(email),
    written_text TEXT,
    created_datetime TIMESTAMP
);

DROP TABLE IF EXISTS post_comment;
CREATE TABLE post_comment (
    id VARCHAR(15) NOT NULL PRIMARY KEY, 
    post_id VARCHAR(15) REFERENCES user_post(id),
    profile_id VARCHAR(15) REFERENCES user_profile(id),
    comment_text TEXT,
    created_datetime TIMESTAMP
);

DROP TABLE IF EXISTS friendship;
CREATE TABLE friendship (
	profile_request VARCHAR(15) REFERENCES user_profile(id),
    profile_accept VARCHAR(15) REFERENCES user_profile(id)
);