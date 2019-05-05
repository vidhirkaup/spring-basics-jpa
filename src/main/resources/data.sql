insert into course(id, name, created_date, last_updated_date) values (10001, 'Spring Boot JPA with Hibernate', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values (10002, 'Java 8 In Action', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values (10003, 'ReactJS In Action', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values (10004, 'Master SQL', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values (10005, 'jBPM Quick Recipes', sysdate(), sysdate());

insert into passport(id, number, created_date, last_updated_date) values (40001, 'A11111', sysdate(), sysdate());
insert into passport(id, number, created_date, last_updated_date) values (40002, 'B22222', sysdate(), sysdate());
insert into passport(id, number, created_date, last_updated_date) values (40003, 'C33333', sysdate(), sysdate());

insert into student(id, name, passport_id, created_date, last_updated_date) values (20001, 'Alice', 40001, sysdate(), sysdate());
insert into student(id, name, passport_id, created_date, last_updated_date) values (20002, 'Bob', 40002, sysdate(), sysdate());
insert into student(id, name, passport_id, created_date, last_updated_date) values (20003, 'Cathy', 40003, sysdate(), sysdate());

insert into review(id, rating, description, created_date, last_updated_date) values (50001, 1, 'Good Course', sysdate(), sysdate());
insert into review(id, rating, description, created_date, last_updated_date) values (50002, 2, 'Better Course', sysdate(), sysdate());
insert into review(id, rating, description, created_date, last_updated_date) values (50003, 3, 'Best Course', sysdate(), sysdate());
insert into review(id, rating, description, created_date, last_updated_date) values (50004, 4, 'Awesome Course', sysdate(), sysdate());
insert into review(id, rating, description, created_date, last_updated_date) values (50005, 5, 'Superb Course', sysdate(), sysdate());