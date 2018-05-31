-- create database hr;

drop table if exists organization;
drop table if exists employee;

-- 组织机构表
create table organization (
  orgaId   int primary key auto_increment,
  orgaName varchar(100) comment '组织机构名称',
  parentId int comment '父级ID'
);

-- 员工表
create table employee (
  empId   int primary key auto_increment,
  empName varchar(100) comment '员工姓名',
  orgaId  int comment '组织机构主键Id',
  empCode varchar(20) comment '员工编号',
  sex     varchar(2) comment '员工性别',
  age     int comment '员工年龄',
  foreign key (orgaId) references organization(orgaId)
);

-- 初始化数据
insert into organization (orgaName, parentId) values ('纺织厂',null );
insert into organization (orgaName, parentId) values ('一工段', 1);
insert into organization (orgaName, parentId) values ('二工段', 1);
