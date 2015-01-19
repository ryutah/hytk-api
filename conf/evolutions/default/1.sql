# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table blog_data (
  id                        bigint auto_increment not null,
  blog_title                varchar(80),
  blog_content              LONGTEXT,
  status                    integer default 1 not null,
  publish_date              datetime,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_blog_data primary key (id))
;

create table blog_tag_data (
  id                        bigint auto_increment not null,
  blog_id                   bigint,
  tag_id                    bigint,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_blog_tag_data primary key (id))
;

create table category_blog_data (
  id                        bigint auto_increment not null,
  category_id               bigint,
  blog_id                   bigint,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_category_blog_data primary key (id))
;

create table category_data (
  id                        bigint auto_increment not null,
  category                  varchar(20) not null,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_category_data primary key (id))
;

create table comment_data (
  id                        bigint auto_increment not null,
  blog_id                   bigint,
  comment_name              varchar(50),
  comment_title             varchar(50),
  comment_content           TEXT not null,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_comment_data primary key (id))
;

create table tag_data (
  id                        bigint auto_increment not null,
  tag                       varchar(25) not null,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_tag_data primary key (id))
;

create table test_model (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  publish                   varchar(255),
  parent_id                 bigint,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_test_model primary key (id))
;

create table test_parent (
  id                        bigint auto_increment not null,
  parent_name               varchar(255) not null,
  constraint pk_test_parent primary key (id))
;

alter table blog_tag_data add constraint fk_blog_tag_data_blogData_1 foreign key (blog_id) references blog_data (id) on delete restrict on update restrict;
create index ix_blog_tag_data_blogData_1 on blog_tag_data (blog_id);
alter table blog_tag_data add constraint fk_blog_tag_data_tagData_2 foreign key (tag_id) references tag_data (id) on delete restrict on update restrict;
create index ix_blog_tag_data_tagData_2 on blog_tag_data (tag_id);
alter table category_blog_data add constraint fk_category_blog_data_categoryData_3 foreign key (category_id) references category_data (id) on delete restrict on update restrict;
create index ix_category_blog_data_categoryData_3 on category_blog_data (category_id);
alter table category_blog_data add constraint fk_category_blog_data_blogData_4 foreign key (blog_id) references blog_data (id) on delete restrict on update restrict;
create index ix_category_blog_data_blogData_4 on category_blog_data (blog_id);
alter table comment_data add constraint fk_comment_data_blogData_5 foreign key (blog_id) references blog_data (id) on delete restrict on update restrict;
create index ix_comment_data_blogData_5 on comment_data (blog_id);
alter table test_model add constraint fk_test_model_parentId_6 foreign key (parent_id) references test_parent (id) on delete restrict on update restrict;
create index ix_test_model_parentId_6 on test_model (parent_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table blog_data;

drop table blog_tag_data;

drop table category_blog_data;

drop table category_data;

drop table comment_data;

drop table tag_data;

drop table test_model;

drop table test_parent;

SET FOREIGN_KEY_CHECKS=1;

