drop
database if exists bicicletario;

create
database bicicletario;

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
    modelo    varchar(20),
    ano       integer,
    descricao text,
    valor     float,
    primary key (id),
    foreign key (cnpj) references Locadora (cnpj) ON DELETE CASCADE ON UPDATE CASCADE
);

create table Locacao
(
    id       bigint      not null auto_increment,
    status   int         not null,
    data     date        not null,
    val      float,
    cnpj     varchar(20) not null,
    cpf     varchar(20) not null,
    bike_id bigint      not null,
    primary key (id),
    foreign key (cpf) references Cliente (cpf) ON DELETE CASCADE ON UPDATE CASCADE ,
    foreign key (bike_id) references Bicicleta (id) ON DELETE CASCADE ON UPDATE CASCADE ,
    foreign key (cnpj) references Locadora (cnpj) ON DELETE CASCADE ON UPDATE CASCADE
);