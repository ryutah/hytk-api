# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table blog_content (
  id                        bigint auto_increment not null,
  title                     varchar(255) not null,
  content                   text not null,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_blog_content primary key (id))
;

create table test_model (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  parent_id                 bigint,
  constraint pk_test_model primary key (id))
;

create table test_parent (
  id                        bigint auto_increment not null,
  parent_name               varchar(255) not null,
  constraint pk_test_parent primary key (id))
;

alter table test_model add constraint fk_test_model_parentId_1 foreign key (parent_id) references test_parent (id) on delete restrict on update restrict;
create index ix_test_model_parentId_1 on test_model (parent_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table blog_content;

drop table test_model;

drop table test_parent;

SET FOREIGN_KEY_CHECKS=1;

