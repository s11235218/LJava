drop database if exists stu_exam;
create database stu_exam default charset utf8mb4;

use stu_exam;

create table stu (
    id int primary key auto_increment,
    name varchar(20)
);

create table course(
    id int primary key auto_increment,
    name varchar(20)
);

create table record(
    id int primary key auto_increment,
    -- 150分以下，一位小数（总长度，小数长度）
    score decimal(4, 1),
    stu_id int,
    course_id int,
    foreign key (stu_id) references stu(id),
    foreign key (course_id) references course(id)
);