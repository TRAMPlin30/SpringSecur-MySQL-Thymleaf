USE auth_jwt;

CREATE TABLE users_roles (
  user_id int NOT NULL,
  role_id int NOT NULL,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

insert into users_roles (user_id, role_id) values (1,2);
