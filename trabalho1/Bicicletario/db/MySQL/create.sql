drop database if exists bicicletario;

create database bicicletario;

use bicicletario;


create table Usuario
(
	codigo 	varchar(20) not null,
	nome   	varchar(256) not null,
    email  	varchar(256) not null unique,
    senha  	varchar(256) not null,
    papel  	varchar(10)	not null,
    primary key (codigo)
);


create table Cliente
(
    cpf        varchar(20)  not null,
    telefone   varchar(256),
    sexo       varchar(256),
    nascimento varchar(10),
    foreign key (cpf) references Usuario (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);


create table Locadora
(
    cnpj      	varchar(14)  not null,
    cidade 		varchar(256),
    foreign key (cnpj) references Usuario (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

create table Bicicleta
(
    id        varchar(20) not null,
    modelo    varchar(20) not null,
    ano       varchar(20) not null,
    descricao varchar(20) not null,
    valor     varchar(20) not null,
    primary key (id)
);

create table Locacao
( 
    id      varchar(20) not null, 
    status  varchar(20) not null,
    data    varchar(20) not null, 
    val     varchar(20) not null, 
    cnpj    varchar(14)  not null,
    cpf     varchar(20)  not null,
    bike_id varchar(20) not null,
    primary key (id), 
    foreign key (cnpj) references Locadora(cnpj), 
    foreign key (cpf) references Cliente(cpf), 
    foreign key (bike_id) references Bicicleta(id)
);



insert into Usuario(codigo, nome, email, senha, papel) values ('12345','admin', 'admin@hotmail.com', 'admin', 'ADMIN');

insert into Usuario values ('6789', 'usuario','user@hotmail.com', '123', 'CLIENTE');
insert into Cliente values ('6789', 'nao tem', 'feminino', '21/03/2000');


insert into Usuario values ('6782','usuario', 'user2@hotmail.com', '1234', 'CLIENTE');
insert into Cliente values ('6782', 'nao tem', 'feminino', '21/03/2000');

insert into Usuario values ('0000','locadora', 'locadora@hotmail.com', '111', 'LOCADORA');
insert into Locadora values ('0000','são carlos');

insert into Usuario values ('6781','usuario','user1@hotmail.com', '1234',  'LOCADORA');
insert into Locadora values ('6781','são carlos');

insert into Bicicleta(id, modelo, ano, descricao, valor) values ('0000', 'modelo', '2013', 'bike', '2000');
insert into Locacao values ('1111', 'em uso', '21/03/2000', '21.88', '0000', '6789', '0000');