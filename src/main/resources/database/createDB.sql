DROP SCHEMA IF EXISTS libraryDemo;
CREATE SCHEMA libraryDemo;

USE libraryDemo;

CREATE TABLE Book (
                      title VARCHAR(45) PRIMARY KEY,
                      author VARCHAR(45)
);

CREATE USER 'userLibrary'@'localhost' IDENTIFIED BY 'userLibraryPW';
GRANT ALL PRIVILEGES ON libraryDemo . * TO 'userLibrary'@'localhost';