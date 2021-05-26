CREATE TABLE medicalstuff
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(100),
    surname        VARCHAR(100),
    age            INTEGER (3),
    position       VARCHAR(100),
    specialization VARCHAR(100)
);
INSERT INTO medicalstuff (name, surname, age, position, specialization)
VALUES ('Gregory','House',47,'Head of department','diagnostic');
INSERT INTO medicalstuff (name, surname, age, position, specialization)
VALUES ('James','Wilson',45,'Head of department','cancer');