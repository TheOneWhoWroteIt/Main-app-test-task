create type gender as ENUM ('MALE', 'FEMALE');

create table if not exists employee(
employee_id bigserial primary key,
first_name varchar(200) not null,
last_name varchar(200) not null,
department_id bigint default (1),
job_title varchar(255) not null,
gender gender not null,
date_of_birth date not null
);

insert into employee(first_name, last_name, job_title, gender, date_of_birth)
values ('petr_test', 'petrov_test', 'developer', 'MALE', '1985-05-10');

insert into employee(first_name, last_name, job_title, gender, date_of_birth)
values ('dima_test', 'dmitriev_test', 'hr', 'MALE', '1990-11-01');

insert into employee(first_name, last_name, job_title, gender, date_of_birth)
values ('ivan_test', 'ivanov_test', 'seo', 'MALE', '1975-03-20');

insert into employee(first_name, last_name, job_title, gender, date_of_birth)
values ('ola_test', 'sidorova_test', 'hr', 'FEMALE', '1994-06-18');