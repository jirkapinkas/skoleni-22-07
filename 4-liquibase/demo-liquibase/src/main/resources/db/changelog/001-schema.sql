--liquibase formatted sql
--changeset myname:mychangeset001
--comment mycomment 001

create table item (
    id bigserial primary key,
    name text
)

--rollback drop table item
