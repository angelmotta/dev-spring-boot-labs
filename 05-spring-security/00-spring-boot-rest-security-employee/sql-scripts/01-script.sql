-- SPRING SECURITY --
-- protected resource --
drop table if exists employee;
CREATE table employee (
                          id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          first_name varchar(45),
                          last_name varchar(45),
                          email varchar(45)
);

insert into employee (first_name, last_name, email)
values
    ('Leslie','Andrews','leslie@luv2code.com'),
    ('Emma','Baumgarten','emma@luv2code.com'),
    ('Avani','Gupta','avani@luv2code.com'),
    ('Yuri','Petrov','yuri@luv2code.com'),
    ('Juan','Vega','juan@luv2code.com');

select * from employee order by id;

delete from employee;

--- DEFAULT Schema for Spring
drop table if exists authorities;
drop table if exists users;

create table users (
                       username varchar(50) primary key,
                       password varchar(68) not null,
                       enabled smallint not null
);

-- sample: users plain text pass
insert into users (username, password, enabled)
values
    ('john', '{noop}test123', 1),
    ('mary', '{noop}test123', 1),
    ('susan', '{noop}test123', 1);
-- sample: user bcrypt pass (test123)
insert into users (username, password, enabled)
values
    ('john', '{bcrypt}$2a$12$3JjOodVGkklzwOObffXo6uujrfmCRG.LHbpeUnjRGy/toO3vAujqe', 1),
    ('mary', '{bcrypt}$2a$12$3JjOodVGkklzwOObffXo6uujrfmCRG.LHbpeUnjRGy/toO3vAujqe', 1),
    ('susan', '{bcrypt}$2a$12$3JjOodVGkklzwOObffXo6uujrfmCRG.LHbpeUnjRGy/toO3vAujqe', 1);


create table authorities (
                             username varchar(50) not null references users (username),
                             authority varchar(50) not null,
                             primary key(username, authority)
);

insert into authorities values
                            ('john', 'ROLE_EMPLOYEE'),
                            ('mary', 'ROLE_EMPLOYEE'),
                            ('mary', 'ROLE_MANAGER'),
                            ('susan', 'ROLE_EMPLOYEE'),
                            ('susan', 'ROLE_MANAGER'),
                            ('susan', 'ROLE_ADMIN');

select * from users;
select * from authorities;


--- CUSTOM Schema for Spring
drop table if exists roles;
drop table if exists members;

create table members (
                         user_id varchar(50) primary key,
                         user_pass varchar(68) not null,
                         active smallint not null
);

-- sample: user bcrypt pass (test123)
insert into members (user_id, user_pass, active)
values
    ('john', '{bcrypt}$2a$12$3JjOodVGkklzwOObffXo6uujrfmCRG.LHbpeUnjRGy/toO3vAujqe', 1),
    ('mary', '{bcrypt}$2a$12$3JjOodVGkklzwOObffXo6uujrfmCRG.LHbpeUnjRGy/toO3vAujqe', 1),
    ('susan', '{bcrypt}$2a$12$3JjOodVGkklzwOObffXo6uujrfmCRG.LHbpeUnjRGy/toO3vAujqe', 1);


create table roles (
                       user_id varchar(50) not null references members (user_id),
                       role varchar(50) not null,
                       primary key(user_id, role)
);

insert into roles values
                      ('john', 'ROLE_EMPLOYEE'),
                      ('mary', 'ROLE_EMPLOYEE'),
                      ('mary', 'ROLE_MANAGER'),
                      ('susan', 'ROLE_EMPLOYEE'),
                      ('susan', 'ROLE_MANAGER'),
                      ('susan', 'ROLE_ADMIN');
