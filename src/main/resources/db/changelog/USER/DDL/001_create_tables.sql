--liquibase formatted sql
--changeset paoChanges:create-tables

CREATE TABLE usuario (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(255) DEFAULT NULL,
  nombre varchar(255) DEFAULT NULL,
  prioridad int DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1;