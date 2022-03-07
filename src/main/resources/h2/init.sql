create table CHECKINGACCOUNTS(
    id bigint auto_increment,
    name varchar(50),
    cpf varchar(12),
    account_number varchar(7),
    agency varchar(4),
    balance decimal(15, 2),
    primary key(id)
);