drop database if exists bicicletario;

create database bicicletario;

use bicicletario;


create table Usuario
(
	codigo 	varchar(18) not null,
	nome   	varchar(256) not null,
    email  	varchar(256) not null unique,
    senha  	varchar(256) not null,
    papel  	varchar(10)	not null,
    primary key (codigo)
);


create table Cliente
(
    cpf        varchar(14)  not null,
    telefone   varchar(256),
    sexo       varchar(256),
    nascimento varchar(10),
    foreign key (cpf) references Usuario (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);


create table Locadora
(
    cnpj      	varchar(19)  not null,
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
    cnpj    varchar(18)  not null,
    cpf     varchar(14)  not null,
    bike_id varchar(20) not null,
    primary key (id), 
    foreign key (cnpj) references Locadora(cnpj), 
    foreign key (cpf) references Cliente(cpf), 
    foreign key (bike_id) references Bicicleta(id)
);



insert into Usuario(codigo, nome, email, senha, papel) values ('12345','admin', 'admin@hotmail.com', 'admin', 'ADMIN');

-- Clientes
insert into Usuario values ('468.325.873-40', 'Maria','maria@hotmail.com', 'cliente1', 'CLIENTE');
insert into Cliente values ('468.325.873-40', '(16)99423-5549', 'Feminino', '21/03/2000');

insert into Usuario values ('123.456.789-01', 'João', 'joao@hotmail.com', 'cliente2', 'CLIENTE');
insert into Cliente values ('123.456.789-01', '(16)91234-5678', 'Masculino', '15/07/1995');

insert into Usuario values ('987.654.321-09', 'Ana', 'ana@hotmail.com', 'cliente3', 'CLIENTE');
insert into Cliente values ('987.654.321-09', '(16)92345-6789', 'Feminino', '02/11/1988');

insert into Usuario values ('567.890.123-45', 'Pedro', 'pedro@hotmail.com', 'cliente4', 'CLIENTE');
insert into Cliente values ('567.890.123-45', '(16)93456-7890', 'Masculino', '10/05/1993');

-- Locadoras
insert into Usuario values ('12.345.678/0001-90','Locadora 1', 'locadora1@hotmail.com', 'locadora1', 'LOCADORA');
insert into Locadora values ('12.345.678/0001-90','São Carlos');

insert into Usuario values ('98.765.432/0001-21', 'Locadora 2', 'locadora2@hotmail.com', 'locadora2', 'LOCADORA');
insert into Locadora values ('98.765.432/0001-21', 'Campinas');

insert into Usuario values ('45.678.901/0001-34', 'Locadora 3', 'locadora3@hotmail.com', 'locadora3', 'LOCADORA');
insert into Locadora values ('45.678.901/0001-34', 'Ribeirão Preto');

insert into Usuario values ('23.456.789/0001-45', 'Locadora 4', 'locadora4@hotmail.com', 'locadora4', 'LOCADORA');
insert into Locadora values ('23.456.789/0001-45', 'Araraquara');

-- Locaçoes
insert into Bicicleta(id, modelo, ano, descricao, valor) values ('0000', 'modelo', '2013', 'bike', '2000');
insert into Locacao values ('1111', 'uso finalizado', '21/03/2000', '21.88', '12.345.678/0001-90', '468.325.873-40', '0000');

insert into Bicicleta(id, modelo, ano, descricao, valor) values ('1111', 'model', '2012', 'bicicleta rosa', '1030');
insert into Locacao values ('2222', 'em uso', '18/07/2003', '42.47', '12.345.678/0001-90', '468.325.873-40', '0000');