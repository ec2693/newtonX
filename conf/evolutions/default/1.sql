# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  id                            integer,
  first_name                    varchar(255),
  last_name                     varchar(255)
);


# --- !Downs

drop table if exists user;

