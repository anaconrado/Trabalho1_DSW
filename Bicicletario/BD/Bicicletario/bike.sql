drop database if exists bicicletario;

create database bicicletario;

use
bicicletario;

create table Cliente
(
    cpf        varchar(20) not null,
    nome varchar(50),
    email  varchar(256) not null unique,
    senha  varchar(256) not null,
    telefone   varchar(256),
    sexo       varchar(256),
    nascimento Date
);

create table Locadora
(
    cnpj      varchar(20) not null,
    nome varchar(50),
    email  varchar(256) not null unique,
    senha  varchar(256) not null,
    descricao varchar(256),
    cidade varchar(256)
);

create table Bicicleta
(
    id        bigint      not null auto_increment,
    marca   varchar(50),
    modelo    varchar(20),
    ano       Date,
    descricao varchar(50),
    valor     float,
    primary key (id)
);

create table Locacao
(
    id       bigint      not null auto_increment,
    status   int         not null,
    data     date        not null,
    horario float,
    val      float,
    cnpj     varchar(20) not null,
    cpf     varchar(20) not null,
    bike_id bigint      not null,
    primary key (id),
    foreign key (cpf) references Cliente (cpf) ON DELETE CASCADE ON UPDATE CASCADE ,
    foreign key (bike_id) references Bicicleta (id) ON DELETE CASCADE ON UPDATE CASCADE ,
    foreign key (cnpj) references Locadora (cnpj) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into Cliente(cpf, email, senha, nome, sexo, nascimento)
values ('000.000.000-00', 'ok@ok.com', 'ok', 'ok da Silva', 'Masculino', '1970-02-20');

insert into Cliente(cpf, email, senha, nome, sexo, nascimento)
values ('000.000.000/0001-01', 'lol@lol.com', 'lux', 'lol', 'Feminino', '2011-03-02');

insert into Cliente(cpf, email, senha, nome, sexo, nascimento)
values ('000.000.000/0001-02', 'pedro2@loja.com', 'senha', 'Pedro Bueno', 'Masculino', '2001-04-10');

insert into Locadora(cnpj, nome, email, senha, cidade, descricao) 
values ('000.000.000/0001-01', 'loja 1', 'loja1@loja1.com', 'loja1', 'Sao Carlos', 'Loja muito confiavel');

insert into Locadora(cnpj, nome, email, senha, cidade, descricao) 
values ('000.000.000/0001-02', 'loja 2', 'loja2@loja2.com', 'palmeiras', 'Sao Carlos', 'Loja oficial do Palmeiras');

insert into Locadora(cnpj, nome, email, senha, cidade, descricao)
values ('000.000.001', 'Bike Esportes', 'bike@bike.com', 'bikeLife', 'Araraquara', 'A sua loja sobre bicicletas');

insert into Bicicleta(marca, modelo, ano, descricao, valor) 
values ('Monsano','R9','2015-02-21', 'Bicicleta boa', 1080.0);

insert into Bicicleta(marca, modelo, ano, descricao, valor) 
values ('Caloi','x8','2003-05-10','Da para o gasto', 1081.1);

insert into Bicicleta(marca, modelo, ano, descricao, valor) 
values ('Generico','XYZ','2018-05-03','Feita de aço ',1082.0);

insert into Locacao(status, data, horario, val, cnpj, cpf, bike_id) 
VALUES (1, '2001-02-22', 15.00, 3.00, '000.000.000/0001-02','000.000.001',2);

insert into Locacao(status, data, horario, val,  cnpj, cpf, bike_id) 
VALUES (0, '2001-02-22', 21.00, 3.00, '000.000.000/0001-02','000.000.001',2);

insert into Locacao(status, data, horario, val, cnpj, cpf, bike_id) 
VALUES (1, '2001-02-22', 11.00, 30.00, '000.000.000/0001-02','000.000.001',3);

insert into Locacao(status, data, horario, val, cnpj, cpf, bike_id) 
VALUES (0, '2001-02-22', 13.00, 30.00, '000.000.000/0001-02','000.000.001',3);