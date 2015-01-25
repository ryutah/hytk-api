# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table blog_data (
  id                        bigint not null,
  blog_title                varchar(80),
  blog_content              LONGTEXT,
  status                    integer default 1 not null,
  publish_date              timestamp,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_blog_data primary key (id))
;

create table blog_tag_data (
  id                        bigint not null,
  blog_id                   bigint,
  tag_id                    bigint,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_blog_tag_data primary key (id))
;

create table category_blog_data (
  id                        bigint not null,
  category_id               bigint,
  blog_id                   bigint,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_category_blog_data primary key (id))
;

create table category_data (
  id                        bigint not null,
  category                  varchar(20) not null,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_category_data primary key (id))
;

create table comment_data (
  id                        bigint not null,
  blog_id                   bigint,
  comment_name              varchar(50),
  comment_title             varchar(50),
  comment_content           TEXT not null,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_comment_data primary key (id))
;

create table tag_data (
  id                        bigint not null,
  tag                       varchar(25) not null,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_tag_data primary key (id))
;

create table test_model (
  id                        bigint not null,
  name                      varchar(255),
  publish                   varchar(255),
  parent_id                 bigint,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_test_model primary key (id))
;

create table test_parent (
  id                        bigint not null,
  parent_name               varchar(255) not null,
  constraint pk_test_parent primary key (id))
;

create sequence blog_data_seq;

create sequence blog_tag_data_seq;

create sequence category_blog_data_seq;

create sequence category_data_seq;

create sequence comment_data_seq;

create sequence tag_data_seq;

create sequence test_model_seq;

create sequence test_parent_seq;

alter table blog_tag_data add constraint fk_blog_tag_data_blogData_1 foreign key (blog_id) references blog_data (id) on delete restrict on update restrict;
create index ix_blog_tag_data_blogData_1 on blog_tag_data (blog_id);
alter table blog_tag_data add constraint fk_blog_tag_data_tagData_2 foreign key (tag_id) references tag_data (id) on delete restrict on update restrict;
create index ix_blog_tag_data_tagData_2 on blog_tag_data (tag_id);
alter table category_blog_data add constraint fk_category_blog_data_category_3 foreign key (category_id) references category_data (id) on delete restrict on update restrict;
create index ix_category_blog_data_category_3 on category_blog_data (category_id);
alter table category_blog_data add constraint fk_category_blog_data_blogData_4 foreign key (blog_id) references blog_data (id) on delete restrict on update restrict;
create index ix_category_blog_data_blogData_4 on category_blog_data (blog_id);
alter table comment_data add constraint fk_comment_data_blogData_5 foreign key (blog_id) references blog_data (id) on delete restrict on update restrict;
create index ix_comment_data_blogData_5 on comment_data (blog_id);
alter table test_model add constraint fk_test_model_parentId_6 foreign key (parent_id) references test_parent (id) on delete restrict on update restrict;
create index ix_test_model_parentId_6 on test_model (parent_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists blog_data;

drop table if exists blog_tag_data;

drop table if exists category_blog_data;

drop table if exists category_data;

drop table if exists comment_data;

drop table if exists tag_data;

drop table if exists test_model;

drop table if exists test_parent;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists blog_data_seq;

drop sequence if exists blog_tag_data_seq;

drop sequence if exists category_blog_data_seq;

drop sequence if exists category_data_seq;

drop sequence if exists comment_data_seq;

drop sequence if exists tag_data_seq;

drop sequence if exists test_model_seq;

drop sequence if exists test_parent_seq;

