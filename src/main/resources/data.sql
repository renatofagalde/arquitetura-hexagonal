
drop table if exists pessoa;
create table pessoa (id bigint not null auto_increment, email varchar(253), nome varchar(255),
                    sexo varchar(1), primary key (id)) engine=InnoDB;

insert into pessoa (id, nome, email,sexo) value (1, 'Ronaldo Fenomeno', 'r9@ronaldo.com','M');
insert into pessoa (id, nome, email,sexo) value (2, 'Zico', 'zico@ronaldo.com','M');
insert into pessoa (id, nome, email,sexo) value (3, 'Roberto Carlos', 'roberto@ronaldo.com','M');
insert into pessoa (id, nome, email,sexo) value (4, 'Ricardo KK, sempre sorringo ', 'kk@ronaldo.com','M');
insert into pessoa (id, nome, email,sexo) value (5, 'Martha Kent', 'martha@dc.com','F');
insert into pessoa (id, nome, email,sexo) value (6, 'Scarlett Johansson', 'scarlett_johansson@marvel.com','F');
insert into pessoa (id, nome, email,sexo) value (7, 'Paloma Bernardi', 'paloma_bernardi@globo.com','F');
