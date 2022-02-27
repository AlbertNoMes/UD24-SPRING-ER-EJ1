DROP table IF EXISTS articulos;
DROP table IF EXISTS fabricantes;

CREATE TABLE fabricantes(
codigo int auto_increment,
nombre nvarchar(100),
primary key (codigo)
);

insert into fabricantes (nombre)values('APPLE');

CREATE TABLE articulos(
codigo int auto_increment,
nombre nvarchar(100),
precio int,
fabricante int,
primary key (codigo),
foreign key (fabricante) references fabricantes (codigo)
);

insert into articulos (nombre, precio, fabricante)values('IPHONE', 500, 1);