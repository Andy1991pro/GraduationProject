create table role
(
    id   bigint auto_increment
        primary key,
    name varchar(500) null
);

create table product
(
    id   bigint auto_increment
        primary key,
    name     varchar(255) null,
    in_stock bit          null,
    quantity int          null,
    price   double       null
);




