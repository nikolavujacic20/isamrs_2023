insert into authority (role) values ('ROLE_ADMIN');
insert into authority (role) values ('ROLE_REGISTERED_USER');
insert into authority (role) values ('ROLE_INSTRUCTOR');

insert into users (type, email, password, is_active) values ('admin','admin@gmail.com','$2a$10$RVzuprKddsjdq6P8QWmqF.sCj2uYPIUlbFVB.b7tJ9RdFNOOBNoXO' ,true);
insert into users (type, email, password, is_active) values ('registered_user','user@gmail.com','$2a$10$RVzuprKddsjdq6P8QWmqF.sCj2uYPIUlbFVB.b7tJ9RdFNOOBNoXO' ,true);
insert into users (type, email, password, is_active) values ('taxidriver','driver@gmail.com','$2a$10$RVzuprKddsjdq6P8QWmqF.sCj2uYPIUlbFVB.b7tJ9RdFNOOBNoXO' ,true);
insert into users_authority (user_id, authority_id) values (1, 1);
insert into users_authority (user_id, authority_id) values (2, 2);

insert into vehicle_type (name, price_per_km) values ('kombi', 300);

insert into working_hours (start_time, end_time) values ('08:00:00', '09:00:00');