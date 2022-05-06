DROP DATABASE IF EXISTS lost_n_found;
CREATE DATABASE lost_n_found;

USE lost_n_found;

DROP TABLE IF EXISTS user_profile;
CREATE TABLE user_profile (
  email VARCHAR(50) UNIQUE, 
  name_ VARCHAR(50),
  id VARCHAR(15) NOT NULL PRIMARY KEY,
  username VARCHAR(50),
  password_ VARCHAR(50)
);

DROP TABLE IF EXISTS post_like;
CREATE TABLE post_like (
  id VARCHAR(15) NOT NULL PRIMARY KEY, 
  post_id VARCHAR(15) REFERENCES user_post(id),
  profile_email VARCHAR(50) REFERENCES user_profile(email),
  created_time TIMESTAMP
);

DROP TABLE IF EXISTS user_post;
CREATE TABLE user_post (
    id VARCHAR(15) NOT NULL PRIMARY KEY, 
    profile_email VARCHAR(50) REFERENCES user_profile(email),
    written_text TEXT,
    created_datetime TIMESTAMP
);

DROP PROCEDURE IF EXISTS GetLikes;
DELIMITER $$
CREATE PROCEDURE GetLikes(IN post_id VARCHAR(15), OUT likes INT)
BEGIN
		SELECT COUNT(*)
		INTO likes
		FROM post_like pl, user_post up
		WHERE pl.post_id = up.id;
END $$
DELIMITER ; 

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



INSERT INTO user_post (id, profile_email, written_text, created_datetime)
	VALUES	('1', 'agma@usc.edu', 'hello', '2002-5-5 18:52:59.997');
		
INSERT INTO post_like (id, post_id, profile_email, created_time)
	VALUES	('1', '1',  'agma@usc.edu', '2002-5-5 18:52:59.997');
    
call GetLikes('1', @likes);
select @likes;
select*from post_like;