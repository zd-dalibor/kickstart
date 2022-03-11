
    create table Account (
       accountNum bigint not null auto_increment,
        active char,
        primary key (accountNum)
    ) engine=InnoDB;

    create table Customer (
       customerId bigint not null auto_increment,
        customerName varchar(255),
        primary key (customerId)
    ) engine=InnoDB;

    create table Account (
       accountNum bigint not null auto_increment,
        active char,
        primary key (accountNum)
    ) engine=InnoDB;

    create table Customer (
       customerId bigint not null auto_increment,
        customerName varchar(255),
        primary key (customerId)
    ) engine=InnoDB;
