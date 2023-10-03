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


INSERT INTO restaurante
(id, nombre, direccion, max_comensales, fecha_fundacion)
VALUES(1, 'Casa Manolo', 'Calla Calatrava 7', 120, '2023-10-03 16:12:35.788');


INSERT INTO producto
(id, nombre, descripcion, precio, id_restaurante)
VALUES(2, 'Solomillo al whisky', 'Plato de solomillo con salsa al whisky acompañado de patatas fritas', 5.6, 1);
INSERT INTO producto
(id, nombre, descripcion, precio, id_restaurante)
VALUES(3, 'Serranito de Pollo', 'Especialidad de la casa, acompañado con pimiento asado ,jamón , tomate y cebolla.', 4.0, 1);
