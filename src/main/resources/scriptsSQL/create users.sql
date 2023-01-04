USE auth_jwt;

CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(50),
  first_name varchar(200),
  last_name varchar(200),
  password varchar(200),
  primary key (id)
);

