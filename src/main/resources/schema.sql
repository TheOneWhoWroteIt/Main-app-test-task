
create table if not exists employee(
employee_id bigserial primary key,
first_name varchar(200) not null,
last_name varchar(200) not null,
department_id bigint default (1),
job_title varchar(255) not null,
gender varchar(50) not null,
date_of_birth date not null
);

insert into employee(first_name, last_name, job_title, gender, date_of_birth)
values ('petr', 'petrov', 'developer', 'MALE', '1985-05-10');

insert into employee(first_name, last_name, job_title, gender, date_of_birth)
values ('dima', 'dmitriev', 'hr', 'MALE', '1990-11-01');

insert into employee(first_name, last_name, job_title, gender, date_of_birth)
values ('ivan', 'ivanov', 'seo', 'MALE', '1975-03-20');

insert into employee(first_name, last_name, job_title, gender, date_of_birth)
values ('ola', 'sidorova', 'hr', 'FEMALE', '1994-06-18');

insert into employee(first_name, last_name, job_title, gender, date_of_birth)
values ('lena', 'popova', 'QA engineer', 'FEMALE', '1993-02-09');