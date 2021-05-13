CREATE TABLE IF NOT EXISTS users (
    id serial NOT NULL  PRIMARY KEY,
    email varchar(200),
    password varchar(200),
    fullname varchar(200),
    picture text
    );