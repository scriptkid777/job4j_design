CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE zachety (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE student_zachety (
    id SERIAL PRIMARY KEY,
     student_id INT REFERENCES students (id),
     zachety_id INT REFERENCES zachety (id)
);