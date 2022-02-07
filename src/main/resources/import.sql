insert into tb_user (email, first_name, last_name, password, role) values ("teste@teste", "Fernando", "Souza", "123", "User")
insert into tb_user (email, first_name, last_name, password, role) values ("teste@teste", "Marcelo", "Silva", "123", "User")
insert into tb_user (email, first_name, last_name, password, role) values ("teste@teste", "Junior", "Lopes", "123", "User")
insert into tb_user (email, first_name, last_name, password, role) values ("teste@teste", "Ana", "Marcal", "123", "User")

insert into tb_course(category, workload, status, has_certificate, evaluation) values ("Desenvolvimento", 44.0, "Approved", true, 9.0)
insert into tb_course(category, workload, status, has_certificate, evaluation) values ("Marketing", 50.0, "Approved", true, 9.5)

insert into tb_certificate(course_id, id_user) values (1, 1)

insert into tb_subscription(id_user, course_id, progress, status) values (1, 1, 60.0, "Approved")
insert into tb_subscription(id_user, course_id, progress, status) values (2, 1, 25.0, "Approved")
insert into tb_subscription(id_user, course_id, progress, status) values (3, 1, 30.0, "Approved")
insert into tb_subscription(id_user, course_id, progress, status) values (4, 1, 75.0, "Approved")