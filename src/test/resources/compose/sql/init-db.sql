create table CONTA
(
    ID    bigint GENERATED ALWAYS AS IDENTITY,
    STATUS integer,
    TIPO   integer,
    primary key(ID)
);

create table CLIENTE
(
    ID    bigint GENERATED ALWAYS AS IDENTITY,
    CPF   varchar(255),
    EMAIL    varchar(255),
    NOME     varchar(255),
    CONTA_ID bigint,
    UNIQUE(CPF),
    primary key(ID),
    CONSTRAINT CONTA_ID FOREIGN KEY(ID) REFERENCES CONTA

);

