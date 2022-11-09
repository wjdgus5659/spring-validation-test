CREATE DATABASE IF NOT EXISTS matt;

CREATE TABLE IF NOT EXISTS matt.user (
    user_idx INT(11) NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY(user_idx),
    UNIQUE KEY user_UK (user_id)
);