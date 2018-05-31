drop table if exists student;

create table student (
  id    int primary key auto_increment,
  name  varchar(32),
  age   int,
  birth datetime
);


select *
from student;