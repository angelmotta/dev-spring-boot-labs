DROP TABLE IF EXISTS `student`;

CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    first_name varchar(45),
    last_name varchar(45),
    email varchar(45)
)