--liquibase formatted sql
--changeset myname:mychangeset002
--comment mycomment 002

alter table item 
    add column description text

--rollback alter table item drop column description
