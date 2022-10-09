CREATE TABLE feign2 (
    id SERIAL PRIMARY KEY ,
    full_name varchar,
    age integer,
    group_name varchar,
    deleted boolean DEFAULT false,
    id_student bigint
);




