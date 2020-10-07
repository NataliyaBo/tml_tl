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


-- Messages

create table message
(
  id   bigint identity not null,
  user_name varchar(100) not null,
  subj varchar(100),
  body clob not null,
  dtm timestamp default current_timestamp not null,
  primary key (id)
);

insert into message(id, user_name, subj, body, dtm)
values (1, 'Иван', 'Тема 1',
'Причиной стало отсутствие разрешения на работы. Согласно постановлению регулятора, эти компании обязаны в течение месяца разорвать договоры на финансирование строительства газопровода. Сам «Газпром» также оштрафован на $7,6 млрд.',
parsedatetime('2012-09-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (2, 'Иван', 'Тема 2',
'В свою очередь пресс-секретарь правительства Польши Петр Мюллер предложил ФРГ польский газопровод Baltic Pipe, как альтернативу «Северного потока – 2» в случае остановки реализации проекта. Мюллер добавил, что СП-2 якобы противоречит идее европейской солидарности и энергетической безопасности. Он подчеркнул, что Польша выступает за однозначную солидарность европейских стран в этом вопросе.',
parsedatetime('2012-10-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (3, 'Иван', 'Тема 3',
'Алиев отметил, что хотел бы видеть гарантами мира в Карабахе ведущие страны мира, которым доверяют и Азербайджан, и Армения. Он допустил, что это могут быть не только государства, входящие в минскую группу ОБСЕ.',
parsedatetime('2012-11-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (4, 'Иван', 'Тема 4',
'Армения неоднократно заявляла, что на стороне Азербайджана в боях участвует Турция. Анкара и Баку эту информацию опровергают, при этом турецкие власти выражали готовность оказать Азербайджану любую помощь при запросе.',
parsedatetime('2012-12-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (5, 'Иван', 'Тема 5',
'Премьер-министр Франции Жан Кастекс также поздравил ученую. «Искренние и теплые поздравления Эммануэль Шарпантье», — написал он в своем Twitter.',
parsedatetime('2013-01-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (6, 'Иван', 'Тема 6',
'Шарпантье и Дудне регулярно назывались в числе основных кандидатов на Нобелевскую премию в течение последних десяти лет.',
parsedatetime('2013-02-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (7, 'Иван', 'Тема 7',
'При этом, по ее словам, до конца недели местами могут пройти небольшие кратковременные дожди как днем, так и ночью.',
parsedatetime('2013-03-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (8, 'Иван', 'Тема 8',
'Ранее, 1 октября, метеоролог сообщила, что в Москве временный снежный покров может образоваться уже в последних числах месяца.',
parsedatetime('2013-04-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (9, 'Иван', 'Тема 9',
'В результате начальник пограничного управления ФСБ России по восточному арктическому району принял решение направить для эвакуации пострадавшего вертолет с пограничным нарядом, который проводил облет Новосибирского архипелага.',
parsedatetime('2013-05-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (10, 'Иван', 'Тема 10',
'Вертолет авиации ФСБ России Ми-8 эвакуировал в районную больницу поселка Тикси в Якутии оленевода, который пострадал от нападения белого медведя. Об этом сообщила пресс-служба пограничного управления ФСБ по восточному арктическому району в среду, 7 октября.',
parsedatetime('2013-06-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (11, 'Иван', 'Тема 11',
'Он также отметил, что уже обсуждал этот вопрос с гендиректором производителя «Ангары» — Центра им. М.В. Хруничева Алексеем Варочко.',
parsedatetime('2013-07-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (12, 'Иван', 'Тема 12',
'«Ангара» — семейство экологически чистых ракет-носителей различных классов. В него входят легкие носители «Ангара-1.2», средние — «Ангара-А3», тяжелые — «Ангара-А5» и повышенной грузоподъемности — «Ангара-А5В».',
parsedatetime('2013-08-17 18:47:52.69', 'yyyy-MM-dd hh:mm:ss.SS') );

insert into message(id, user_name, subj, body, dtm)
values (13, 'John', 'Subject 13',
'Message text',
parsedatetime('2020-09-17 07:05:01.69', 'yyyy-MM-dd hh:mm:ss.SS'));