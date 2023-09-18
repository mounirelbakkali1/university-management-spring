insert into addresses(id,city,state,zip_code) values (1,'Casablanca','Morocco','10001');
insert into addresses(id,city,state,zip_code) values (2,'Rabat','Morocco','20002');

insert into roles (id,name) values (1, 'ROLE_USER');
insert into roles (id,name) values (2, 'ROLE_STUDENT');
insert into roles (id,name) values (3, 'ROLE_PROFESSOR');


insert into departments (id,name) values (1, 'Computer Science');
insert into departments (id,name) values (2, 'Mathematics');


insert into professors (id,first_name,last_name,role_id) values (1, 'Ahmed', 'Raissouni', 3);
insert into professors (id,first_name,last_name,role_id) values (2, 'Mohamed', 'Raissouni', 3);


insert into students (id,first_name,last_name,role_id) values (1, 'Youssef', 'Raissouni', 2);
insert into students (id,first_name,last_name,role_id) values (2, 'Yassine', 'Raissouni', 2);


insert into academic_calendar(id,star_date,end_date,registration_end_date,holidays) values (1,'2020-09-01','2021-06-30','2020-09-15',2);
insert into academic_calendar(id,star_date,end_date,registration_end_date,holidays) values (2,'2020-09-01','2021-06-30','2020-09-15',3);

/*select a1_0.role_id,a1_0.id,a1_0.clazz_,a2_0.id,a2_0.city,a2_0.state,a2_0.street,a2_0.zip_code,a1_0.first_name,a1_0.last_name from (select address_id, id, role_id, first_name, last_name, 0 as clazz_ from app_user union all select address_id, id, role_id, first_name, last_name, 1 as clazz_ from professors union all select address_id, id, role_id, first_name, last_name, 2 as clazz_ from students) a1_0 left join addresses a2_0 on a2_0.id=a1_0.address_id where a1_0.role_id=?
