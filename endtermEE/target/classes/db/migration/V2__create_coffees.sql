CREATE TABLE IF NOT EXISTS coffees (
    id serial NOT NULL PRIMARY KEY,
    name varchar(200),
    description text,
    price int,
    user_id int,
    FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
    );