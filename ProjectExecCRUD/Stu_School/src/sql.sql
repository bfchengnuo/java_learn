drop  table if exists student;
drop table if exists school;

create table school (
  id int primary key auto_increment,
  name varchar(32),
  loc varchar(32)
);

create table student(
  id int primary key auto_increment,
  name varchar(20),
  age int,
  birth datetime,
  email varchar(20),
  sid int,
  foreign key (sid) references school(id)
);


insert into school (name, loc) values ('麻省理工','美国');
insert into school (name, loc) values ('耶鲁大学','美国');
insert into school (name, loc) values ('斯坦福大学','美国硅谷');
insert into school (name, loc) values ('电子科技大学','四川');