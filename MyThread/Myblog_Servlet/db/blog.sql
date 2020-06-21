drop database if exists blogdemo;
create database blogdemo default charset utf8mb4;

use blogdemo;

drop table IF EXISTS user;
create table user
(
    id          int primary key auto_increment,
    name        varchar(20),
    create_time timestamp
);

drop table IF EXISTS article;
create table article
(
    id          int primary key auto_increment,
    title       varchar(50) not null,
    content     mediumtext  not null,
    user_id     int,
    create_time timestamp,
    foreign key (user_id) references user (id)
);

insert into user(name, create_time) values('abc', current_timestamp);

insert into article(title, content, user_id, create_time) values('标题1', '内容1', 1, current_timestamp);
insert into article(title, content, user_id, create_time) values('标题2', '内容2', 1, current_timestamp);
insert into article(title, content, user_id, create_time) values('标题3', '内容3', 1, current_timestamp);
insert into article(title, content, user_id, create_time) values('标题4', '内容4', 1, current_timestamp);
insert into article(title, content, user_id, create_time) values('标题5', '内容5', 1, current_timestamp);
insert into article(title, content, user_id, create_time) values('标题6', '内容6', 1, current_timestamp);