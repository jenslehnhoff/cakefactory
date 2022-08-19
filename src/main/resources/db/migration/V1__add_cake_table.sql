CREATE TABLE cake
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(256),
    type        VARCHAR(50),
    description VARCHAR(256),
    price       NUMERIC(10,2)
);