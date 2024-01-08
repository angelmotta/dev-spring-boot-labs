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