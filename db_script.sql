create table restaurante
(
    id              serial       not null,
    nombre          varchar(150) not null,
    direccion       varchar(300) not null,
    max_comensales  int2,
    fecha_fundacion timestamp(6) default now(),
    primary key (id)
);

create table producto
(
    id             serial       not null,
    nombre         varchar(150) not null,
    descripcion    varchar(300) not null,
    precio         float        not null,
    id_restaurante int4         not null,
    primary key (id),
    constraint producto_restaurante_fk foreign key (id_restaurante) references restaurante (id)
);