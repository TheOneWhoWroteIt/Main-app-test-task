# Тестовое задание [Java Mastery]:

У нас есть база сотрудников (employeedb). Нам необходимо добавлять новых сотрудников, удалять уволенных, обновлять данные о сотрудниках, а также должна быть возможность просмотреть весь список сотрудников сразу и отдельно получить каждого сотрудника. Для этого требуется разработать веб-приложение (Main App), представляющее из себя REST сервис, которое должно позволять выполнять CRUD операции над сотрудниками.


Main App - самостоятельное приложение предоставляющее REST API(это обязательно должен быть REST сервис) и позволяющее выполнять CRUD операции над сотрудниками(employee). Приложение состоит из трех основных элементов(слоев): Controller - это REST контроллер, позволяющий отобразить HTTP запросы на методы обрабатывающие их (для этого используйте Spring Web); Service - это сервис выполняющий бизнес-логику, в данном задании бизнес-логики практически нет, и сервис просто делает вызов DAO (для DI используйте Spring); DAO - выполняет запрос в базу данных(БД) (используйте Spring JDBC). В рамках тестового задания Controller, Service и DAO - это практически три java-класса в вашем приложении.

В реализации Main App вам следует использовать Java 8, Maven, Spring JDBC, Spring Boot (Spring Boot может быть заменен на Spring с развертыванием приложения на Tomcat).

DB - база данных. Используя PostgreSQL, создайте БД ‘employeedb’. В базе данных создайте таблицу ‘employee’ и добавьте в нее несколько сотрудников, для этого напишите SQL скрипт. Таблицу ‘employee’ требуется создать в соответствии со схемой:

employee:
* employee_id;
* first_name;
* last_name;
* department_id;
* job_title;
* gender;
* date_of_birth.

Для проверки работы вашего приложения вам понадобится, либо Rest Client, либо разработать свой UI* - написать несколько своих страниц, которые будут вызывать REST API.

Rest Client - можно использовать Postman или любой другой REST клиент, из которого вы будете делать HTTP запросы к своему приложению.

Unit Tests* - не обязательная часть задания, но будет большим плюсом и очень полезно, если вы напишете парочку модульных тестов используя JUnit/Mockito (в первую очередь такой тест стоит написать для сервиса).

При разработке можете использовать удобную для вас IDE (IntelliJ Idea, Eclipse и т.п.).

UI** - не обязательная часть задания, за которую следует браться, если вы в полном объеме выполнили основную часть задания, написали тесты и разобрались, как это все работает. Для этого достаточно написать несколько страниц, используя HTML и JS(JQuery).

--------------------------------------------------------------

### Данные для загрузки PostgreSQL в Docker и настройки базы данных.

Основная база данных:
* docker run --name main-app-employee-postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=employeedb -p 5436:5432 -d postgres

Тестовая база данных:
* docker run --name main-app-employee-test -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=employeedbtest -p 5438:5432 -d postgres


