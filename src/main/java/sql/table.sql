CREATE table IF NOT EXISTS user2(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    userName VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS category(
    id SERIAL primary key,
    name VARCHAR(50) UNIQUE NOT NULL,
    description TEXT NOT NULL
);