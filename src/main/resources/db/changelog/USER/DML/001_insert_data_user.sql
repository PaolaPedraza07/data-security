--liquibase formatted sql
--changeset paoChanges:inset-employee-01

INSERT INTO demo.usuario (email, nombre, prioridad) VALUES ('pao@gmail.com', 'yy', 1);