CREATE TABLE todo(
	id bigint NOT NULL AUTO_INCREMENT,
	title varchar(200) NOT NULL,
	description varchar(200) NOT NULL,
	created_date DATETIME,
	PRIMARY KEY (id)
);