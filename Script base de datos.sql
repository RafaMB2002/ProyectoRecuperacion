create table direccion_java(
    cod_direccion number,
    nombre_via varchar2(25),
    num_via number,
    cod_postal number,
    CONSTRAINT PK_direccion_java PRIMARY KEY (cod_direccion)
);

create table oficina_java2(
    codigo number,
    nombre varchar2(25),
    direccion number,
    CONSTRAINT PK_oficina_java2 PRIMARY KEY (codigo),
    FOREIGN KEY (direccion) REFERENCES direccion_java(cod_direccion)
);

create table persona_java(
    dni varchar2(9) not null,
    nombre varchar2(25),
    ap1 varchar2(25),
    ap2 varchar(25),
    fecha_nac date,
    direccion number,
    CONSTRAINT PK_Persona PRIMARY KEY (dni),
    FOREIGN KEY (direccion) REFERENCES direccion_java(cod_direccion)
);

create table empleado_java2(
    dni varchar2(9) not null,
    fecha_alta date,
    oficina number,
    CONSTRAINT PK_empleado PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES persona_java(dni),
    FOREIGN KEY (oficina) REFERENCES oficina_java2(codigo)
);

create table programador_java(
    dni varchar2(9) not null,
    tecnologias varchar2(300),
    CONSTRAINT PK_programador_java PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES empleado_java(dni)
);

create table vendedor_java(
    dni varchar2(9) not null,
    zonas varchar2(25),
    CONSTRAINT PK_vendedor_java PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES empleado_java(dni)
);