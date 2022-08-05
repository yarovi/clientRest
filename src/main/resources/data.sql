create table cliente
(
	codigo integer  not null,
	nroDocumento varchar(255) not null,
	nombres varchar(255) not null,
	prestamo decimal(20,2),
	cantidad integer,
	primary key(codigo)
);