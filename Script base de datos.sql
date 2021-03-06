drop table vendedor_java;
drop table programador_java;
drop table empleado_java2;
drop table persona_java;
drop table oficina_java2;
drop table direccion_java;


create table direccion_java(
    cod_direccion number,
    nombre_via varchar2(25),
    num_via number,
    cod_postal number,
    CONSTRAINT PK_direccion_java PRIMARY KEY (cod_direccion)
);

Insert into direccion_java values(12, 'consolacion', 8, 23746);
Insert into direccion_java values(13, 'arjona', 8, 23746);

select *
from direccion_java;

create table oficina_java2(
    codigo number,
    nombre varchar2(25),
    direccion number,
    CONSTRAINT PK_oficina_java2 PRIMARY KEY (codigo),
    FOREIGN KEY (direccion) REFERENCES direccion_java(cod_direccion)
);

Insert into oficina_java2 values(001, 'Oficina1', 13);
Insert into oficina_java2 values(002, 'Oficina2', 12);

select *
from oficina_java2;

create table persona_java(
    dni varchar2(9) not null,
    nombre varchar2(25),
    ap1 varchar2(25),
    ap2 varchar(25),
    fecha_nac date,
    direccion number,
    tipo_persona varchar2(50), --Empleado o cliente
    CONSTRAINT PK_Persona PRIMARY KEY (dni),
    FOREIGN KEY (direccion) REFERENCES direccion_java(cod_direccion)
);

select *
from persona_java;

create table empleado_java2(
    dni varchar2(9) not null,
    fecha_alta date,
    oficina number,
    tipo_empleado varchar2(50), --venderdeor o programador
    CONSTRAINT PK_empleado PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES persona_java(dni),
    FOREIGN KEY (oficina) REFERENCES oficina_java2(codigo)
);

select *
from empleado_java2;

create table programador_java(
    dni varchar2(9) not null,
    tecnologias varchar2(300),
    CONSTRAINT PK_programador_java PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES empleado_java2(dni)
);

select *
from programador_java;

select p.*, e.*, pro.*
from persona_java p join empleado_java2 e on p.dni = e.dni join programador_java pro on e.dni = pro.dni
where p.dni = '54593460Q';

select p.*, e.*, pro.*
from persona_java p join empleado_java2 e on p.dni = e.dni join programador_java pro on e.dni = pro.dni;

create table vendedor_java(
    dni varchar2(9) not null,
    zonas varchar2(25),
    CONSTRAINT PK_vendedor_java PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES empleado_java2(dni)
);

select p.*, e.*, ven.*
from persona_java p join empleado_java2 e on p.dni = e.dni join vendedor_java ven on e.dni = ven.dni
where p.dni = '54593460Q';

select p.*, e.*, ven.*
from persona_java p join empleado_java2 e on p.dni = e.dni join vendedor_java ven on e.dni = ven.dni;

delete from persona_java;
delete from empleado_java2;

ALTER SYSTEM SET OPEN_CURSORS=1337 SID='*' SCOPE=BOTH;

commit;