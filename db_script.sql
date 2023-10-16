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


create table persona (
                         id serial4,
                         nombre varchar(150) not null,
                         apellidos varchar(150) not null,
                         dni char(9) not null,
                         fecha_nacimiento date,
                         primary key(id)
);

create table pedido (
                        id serial4,
                        codigo varchar(15) not null,
                        fecha timestamp(6) not null,
                        id_cliente int4 not null,
                        id_repartidor int4 not null,
                        primary key (id),
                        constraint fk_pedido_cliente foreign key (id_cliente) references persona(id),
                        constraint fk_pedido_repartidor foreign key (id_repartidor) references persona(id)
);


create table linea_pedido (
                              id serial4,
                              id_producto int4 not null,
                              id_pedido int4 not null, cantidad int4 not null,

                              primary key(id),
                              constraint fk_linea_pedido_producto foreign key (id_producto) references producto(id),
                              constraint fk_linea_pedido_pedido foreign key (id_pedido) references pedido(id)
);


create table usuario (
                         id serial4,
                         username varchar(150),
                         "password" varchar(500),
                         rol smallint,
                         id_persona int4 null,
                         primary key(id),
                         constraint fk_usuario_persona foreign key (id_persona) references persona(id)
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
