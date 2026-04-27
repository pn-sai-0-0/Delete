CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE appointment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    doctor_name VARCHAR(100),
    date VARCHAR(20),
    time VARCHAR(20)
);