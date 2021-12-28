insert into tb_usuario (admin_Status,email,nome,senha) values (true,'admin@administradores.com','admin','$2a$10$varkAaJBgAai7gUz9yXdA.b4v96d.CskybyK3KFZEX6k2WHWpSb4.');

insert into tb_estudante(nome, data_nascimento, nota1)
values('diego frazao', TO_DATE('01/01/2000', 'DD/MM/YYYY'), 100);

insert into tb_estudante(nome, data_nascimento, nota2)
values('joão fernandes', TO_DATE('01/01/1990', 'DD/MM/YYYY'), 100);

insert into tb_estudante(nome, data_nascimento, nota3)
values('maria de lurdes', TO_DATE('01/01/1980', 'DD/MM/YYYY'), 100);
