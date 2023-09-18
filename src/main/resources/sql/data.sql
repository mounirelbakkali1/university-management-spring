insert into addresses(id,city,state,zip_code) values (1,'Casablanca','Morocco','10001');
insert into addresses(id,city,state,zip_code) values (2,'Rabat','Morocco','20002');

insert into roles (id,name) values (1, 'ROLE_USER');
insert into roles (id,name) values (2, 'ROLE_STUDENT');
insert into roles (id,name) values (3, 'ROLE_PROFESSOR');


insert into departements (id,name) values (1, 'Computer Science');
insert into departements (id,name) values (2, 'Mathematics');


insert into professors (id,first_name,last_name,role_id) values (1, 'Ahmed', 'Raissouni', 3);
insert into professors (id,first_name,last_name,role_id) values (2, 'Mohamed', 'Raissouni', 3);


insert into students (id,first_name,last_name,role_id) values (1, 'Youssef', 'Raissouni', 2);
insert into students (id,first_name,last_name,role_id) values (2, 'Yassine', 'Raissouni', 2);


insert into academic_calendar(id,start_date,end_date,registration_end_date,holidays) values (1,'2020-09-01','2021-06-30','2020-09-15','2020-12-25,2021-01-01,2021-01-18,2021-02-15,2021-04-02,2021-05-31');
insert into academic_calendar(id,start_date,end_date,registration_end_date,holidays) values (2,'2020-09-01','2021-06-30','2020-09-15','2020-12-25,2021-01-01,2021-01-18,2021-02-15,2021-04-02,2021-05-31');
