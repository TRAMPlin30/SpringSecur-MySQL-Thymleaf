USE auth_jwt;

CREATE TABLE roles (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50),
  primary key (id)
);

insert into roles (name) values ('ROLE_USER'), ('ROLE_ADMIN');