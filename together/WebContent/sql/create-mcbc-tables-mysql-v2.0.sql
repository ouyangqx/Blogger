DROP DATABASE MCBC;
CREATE DATABASE MCBC;

DROP TABLE bible_book;
CREATE TABLE bible_book (
  id INT AUTO_INCREMENT PRIMARY KEY,
  sequence SMALLINT NOT NULL,
  number SMALLINT NOT NULL,
  testament BOOLEAN,
  code VARCHAR(20) NOT NULL,
  name VARCHAR(50),
  name_cn VARCHAR(50),
  name_tw VARCHAR(50),
  FULLTEXT INDEX idx_bb_ft_1 (name),
  FULLTEXT INDEX idx_bb_ft_2 (name_cn),
  FULLTEXT INDEX idx_bb_ft_3 (name_tw),
  UNIQUE INDEX idx_bb_1 (sequence),
  UNIQUE INDEX idx_bb_2 (code)
) ENGINE = MyISAM;

DROP TABLE bible_line;
CREATE TABLE bible_line (
  id INT AUTO_INCREMENT PRIMARY KEY,
  sequence SMALLINT NOT NULL,
  code VARCHAR(20) NOT NULL,
  chapter SMALLINT NOT NULL,
  section SMALLINT NOT NULL,
  content TEXT, 
  content_cn TEXT, 
  content_tw TEXT, 
  FULLTEXT INDEX idx_bl_ft_1 (content),
  FULLTEXT INDEX idx_bl_ft_2 (content_cn),
  FULLTEXT INDEX idx_bl_ft_3 (content_tw),
  --FOREIGN KEY (sequence) REFERENCES bible_book (sequence) 
  UNIQUE INDEX idx_bl_1 (sequence, chapter, section)
) ENGINE = MyISAM;

DROP TABLE blog_user;
CREATE TABLE blog_user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_type_id INT,
  login_name VARCHAR(20) NOT NULL,
  login_password VARCHAR(20),
  email VARCHAR(100) NOT NULL,
  firstname VARCHAR(100),
  lastname VARCHAR(100),
  nickname VARCHAR(100),
  phone_home VARCHAR(20),
  phone_cell VARCHAR(20),
  unit VARCHAR(20),
  street VARCHAR(250),
  city VARCHAR(100),
  province VARCHAR(100),
  country VARCHAR(100),
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  access_time TIMESTAMP,
  status BOOLEAN,
  UNIQUE INDEX idx_bu_1 (login_name),
  UNIQUE INDEX idx_bu_2 (email),
  INDEX idx_bu_3 (phone_home)
);

DROP TABLE blog_user_type;
CREATE TABLE blog_user_type (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  name_cn VARCHAR(200),
  status BOOLEAN
);

INSERT INTO blog_user_type VALUES (1,"Admin","管理员",true);
INSERT INTO blog_user_type VALUES (2,"Leader","经理",true);
INSERT INTO blog_user_type VALUES (3,"User","用户",true);
INSERT INTO blog_user_type VALUES (4,"Guest","访客",true);

INSERT INTO blog_user (id,user_type_id,login_name,login_password,email) VALUE (1,1,'admin','admin','clw.clw@rogers.com');
UPDATE blog_user SET access_time = now() WHERE id =1;
UPDATE blog_user SET create_time = now() WHERE id =1;
UPDATE blog_user SET update_time = now() WHERE id =1;
UPDATE blog_user SET status = true WHERE id =1;


DROP TABLE blog_group;
CREATE TABLE blog_group (
  id INT AUTO_INCREMENT PRIMARY KEY,
  security_type_id INT,
  language_type_id INT,
  group_type_id INT,
  group_name VARCHAR(50),
  description VARCHAR(250),
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  status BOOLEAN,
  FULLTEXT INDEX idx_bg_ft_1 (group_name, description)
) ENGINE = MyISAM; 

DROP TABLE blog_user_group;
CREATE TABLE blog_user_group (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  group_id INT NOT NULL,
  group_owner BOOLEAN,
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  status BOOLEAN,
  UNIQUE INDEX idx_bug_1 (user_id, group_id)
);

DROP TABLE blog_message;
CREATE TABLE blog_message (
  id INT AUTO_INCREMENT PRIMARY KEY,
  group_id INT NOT NULL,
  user_id INT NOT NULL,
  message TEXT,
  upload_file VARCHAR(200),
  link_url VARCHAR(200),
  message_type_id INT,
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  status BOOLEAN,
  FULLTEXT INDEX idx_bm_ft_1 (message),
  INDEX idx_bm_1 (group_id, user_id)
) ENGINE = MyISAM;

DROP TABLE blog_message_type;
CREATE TABLE blog_message_type (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  name_cn VARCHAR(200),
  status BOOLEAN
);

INSERT INTO blog_message_type VALUES (1,"Image","",true);
INSERT INTO blog_message_type VALUES (2,"Music","",true);
INSERT INTO blog_message_type VALUES (3,"Link","",true);
INSERT INTO blog_message_type VALUES (4,"Text","",true);
INSERT INTO blog_message_type VALUES (5,"Word","",true);
INSERT INTO blog_message_type VALUES (6,"HTML","",true);
INSERT INTO blog_message_type VALUES (7,"File","",true);
INSERT INTO blog_message_type VALUES (8,"Plain","",true);

DROP TABLE blog_reply_message;
CREATE TABLE blog_reply_message (
  id INT AUTO_INCREMENT PRIMARY KEY,
  message_id INT NOT NULL,
  user_id INT NOT NULL,
  message TEXT,
  upload_file VARCHAR(200),
  link_url VARCHAR(200),
  message_type_id INT,
  create_time TIMESTAMP,
  update_time TIMESTAMP,
  status BOOLEAN,
  FULLTEXT INDEX idx_rbm_ft_1 (message),
  INDEX idx_brm_1 (message_id),
  INDEX idx_brm_2 (message_id, user_id)
)  ENGINE = MyISAM;

DROP TABLE blog_security_type;
CREATE TABLE blog_security_type (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  name_cn VARCHAR(200),
  status BOOLEAN
);

INSERT INTO blog_security_type VALUES (1,"Admin","管理员",true);
INSERT INTO blog_security_type VALUES (2,"Leader","经理",true);
INSERT INTO blog_security_type VALUES (3,"User","用户",true);
INSERT INTO blog_security_type VALUES (4,"Guest","访客",true);

DROP TABLE blog_statistic;
CREATE TABLE blog_statistic (
  id INT AUTO_INCREMENT PRIMARY KEY,
  statistic_id INT NOT NULL,
  statistic_table VARCHAR(50), 	
  view_times INT NOT NULL,
  update_times INT,
  status BOOLEAN,
  INDEX idx_bs_1 (statistic_id, statistic_table)
);

DROP TABLE blog_language_type;
CREATE TABLE blog_language_type (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  name_cn VARCHAR(200),
  status BOOLEAN
);

INSERT INTO blog_language_type VALUES (1,"Cantonese","粤语",true);
INSERT INTO blog_language_type VALUES (2,"English","英文",true);
INSERT INTO blog_language_type VALUES (3,"Mandarin","国语",true);

DROP TABLE blog_group_type;
CREATE TABLE blog_group_type (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200),
  name_cn VARCHAR(200),
  status BOOLEAN
);

INSERT INTO blog_group_type VALUES (1,"Album","相册",true);
INSERT INTO blog_group_type VALUES (2,"Cell Group","生命小组",true);
INSERT INTO blog_group_type VALUES (3,"Church","教会",true);
INSERT INTO blog_group_type VALUES (4,"Fellowship","团契",true);
INSERT INTO blog_group_type VALUES (5,"Generic","普通",true);
INSERT INTO blog_group_type VALUES (6,"Worship","敬拜",true);
INSERT INTO blog_group_type VALUES (7,"New","热点",true);

DROP TABLE blog_properties;
CREATE TABLE blog_properties (
  id INT AUTO_INCREMENT PRIMARY KEY,
  prop_key VARCHAR(50),
  prop_value VARCHAR(200),
  UNIQUE INDEX idx_bp_1 (prop_key)
);

INSERT INTO blog_properties VALUES (1,"data_path","/data");
INSERT INTO blog_properties VALUES (2,"upload_path","/data/upload/mcbc");
INSERT INTO blog_properties VALUES (3,"bible_path","/data/bible");
INSERT INTO blog_properties VALUES (4,"log_path","/data/logs");
INSERT INTO blog_properties VALUES (5,"tmp_path","/tmp");