create sequence hibernate_sequence start with 1 increment by 1;

create table position
(
  id   bigint identity not null,
  name varchar(100)    not null,
  primary key (id)
);

alter table position
  add constraint UK_position_name unique (name);

create table employee
(
  id          bigint identity not null,
  first_name  varchar(100)    not null,
  last_name   varchar(100)    not null,
  patronymic  varchar(100),
  position_id bigint,
  primary key (id)
);

alter table employee
  add constraint FK_employee__position_id foreign key (position_id) references position;

create table work_time
(
  id                bigint identity not null,
  employee_id       bigint          not null,
  work_date         date            not null,
  work_time_minutes bigint          not null,
  primary key (id)
);

alter table work_time
  add constraint FK_work_time__employee_id foreign key (employee_id) references employee;

insert into position(name)
values ('Директор');
insert into position(name)
values ('Бухгалтер');
insert into position(name)
values ('Эксперт');
insert into position(name)
values ('Дизайнер');

insert into employee(first_name, last_name, patronymic, position_id)
values ('Иван', 'Иванов', 'Иванович', 1);
insert into employee(first_name, last_name, patronymic, position_id)
values ('Пётр', 'Петров', 'Петрович', 2);
insert into employee(first_name, last_name, patronymic, position_id)
values ('Сидор', 'Сидоров', 'Сидорович', 4);

insert into work_time(employee_id, work_date, work_time_minutes)
values (1, '2020-01-10', 480);
insert into work_time(employee_id, work_date, work_time_minutes)
values (1, '2020-01-11', 480);
insert into work_time(employee_id, work_date, work_time_minutes)
values (2, '2020-01-10', 480);
insert into work_time(employee_id, work_date, work_time_minutes)
values (3, '2020-01-10', 420);
