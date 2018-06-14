create database if not exists utestA default charset utf8 COLLATE utf8_general_ci;

use utestA;
drop table if exists User;
create table User (
	id bigint auto_increment primary key comment 'ID',
	username varchar(30) not null comment '用户名',
	password varchar(128) not null comment '密码',
	sex int comment '性别',
	createTime timestamp default now() comment '创建时间'
);

create database if not exists utestB default charset utf8 COLLATE utf8_general_ci;

use utestB;
drop table if exists Student;
create table Student (
    id bigint auto_increment primary key comment 'ID',
    username varchar(30) not null comment '姓名',
    sex int comment '性别',
    createTime timestamp default now() comment '创建时间'
);