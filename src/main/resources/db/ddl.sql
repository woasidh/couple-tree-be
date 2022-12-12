# User Table
create table user
(
    id       bigint auto_increment
        primary key,
    userId   varchar(255) not null,
    password varchar(255) not null,
    name     varchar(255) not null
);

insert into User (userId, password, name) values ('mwchoi', 'Yoohoo77!!', '최민우');