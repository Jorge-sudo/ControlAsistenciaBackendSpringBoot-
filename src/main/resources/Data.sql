CREATE TABLE persona (
  ci INTEGER NOT NULL PRIMARY KEY,
  nombre VARCHAR(25) NOT NULL,
  apellido VARCHAR(25) NOT NULL,
  profesion VARCHAR(40) NOT NULL,
  genero VARCHAR(5) NOT NULL
);
-- INSERTAR DATOS PERSONA
INSERT INTO persona(ci, nombre, apellido, profesion, genero)
VALUES (11077821, 'Jorge Luis', 'Arone Delgado',
        'Ingeniero en Sistemas', 'M');
INSERT INTO persona(ci, nombre, apellido, profesion, genero)
VALUES (11902134, 'Jose', 'Tarqui',
        'Contador', 'M');

CREATE TABLE docente (
   ci INTEGER NOT NULL PRIMARY KEY,
   cod_rfid VARCHAR(20) NOT NULL,
   FOREIGN KEY(ci) REFERENCES persona(ci)
);
-- INSERTAR DATOS DOCENTE
INSERT INTO docente(ci, cod_rfid)
VALUES (11077821, 'a4frg43fd');

CREATE TABLE supervisor (
   ci INTEGER NOT NULL PRIMARY KEY,
   turno VARCHAR(15) NOT NULL,
   FOREIGN KEY(ci) REFERENCES persona(ci)
);

-- INSERTAR DATOS USUARIO SUPERVISOR
INSERT INTO supervisor(ci, turno)
VALUES (11902134, 'mañana');

CREATE TABLE usuario (
  id_usuario INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  usuario VARCHAR(20) NOT NULL,
  contrasenia VARCHAR(200) NOT NULL,
  ci INTEGER NOT NULL,
  FOREIGN KEY(ci) REFERENCES supervisor(ci)
);

-- INSERTAR DATOS USUARIO SUPERVISOR
INSERT INTO usuario( usuario, contrasenia, ci)
VALUES ( 'joseUser', 'jos123', 11902134);

CREATE TABLE rol (
  id_rol INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  nombre VARCHAR(15) NOT NULL
);
-- INSERTAR DATOS ROL
INSERT INTO rol( nombre)
VALUES ('USER');
INSERT INTO rol( nombre)
VALUES ('ADMIN');

CREATE TABLE usuario_rol (
  id_userol INTEGER  AUTO_INCREMENT NOT NULL PRIMARY KEY,
  id_usuario INTEGER NOT NULL ,
  id_rol INTEGER NOT NULL ,
  FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
  FOREIGN KEY(id_rol) REFERENCES rol(id_rol)
);

-- INSERTAR DATOS USUARIO_ROL
INSERT INTO usuario_rol(id_usuario, id_rol)
VALUES (1, 1);

CREATE TABLE turno(
  id_turno INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  nombre VARCHAR(25) NOT NULL
);

INSERT INTO turno(nombre) VALUES ('mañana');
INSERT INTO turno(nombre) VALUES ('tarde');
INSERT INTO turno(nombre) VALUES ('noche');

CREATE TABLE carrera (
  id_carrera INTEGER  AUTO_INCREMENT NOT NULL PRIMARY KEY,
  nombre VARCHAR(25) NOT NULL,
  bloque VARCHAR(5) NOT NULL,
  id_turno INTEGER NOT NULL,
  FOREIGN KEY(id_turno) REFERENCES turno(id_turno)
);

-- INSERTAR DATOS CARRERA
INSERT INTO carrera(nombre,  bloque, id_turno)
VALUES ('Ingieneria en Sistemas', 'A',1 );
INSERT INTO carrera(nombre,  bloque, id_turno)
VALUES ('Contabilidad', 'A',1 );

CREATE TABLE materia (
  sigla VARCHAR(10) NOT NULL PRIMARY KEY,
  nombre VARCHAR(25) NOT NULL,
  aula VARCHAR(15) NOT NULL,
  piso INTEGER NOT NULL,
  semestre INTEGER NOT NULL,
  ci_docente INTEGER NOT NULL,
  FOREIGN KEY(ci_docente) REFERENCES docente(ci)
);
-- INSERTAR DATOS MATERIA
INSERT INTO materia(sigla, nombre, aula, piso, semestre, ci_docente)
VALUES ('SIS-12', 'Programacion III', 'SIS-111', 3, 4 ,11077821);

CREATE TABLE horario (
  id_horario INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  hora_inicio TIME NOT NULL,
  hora_final TIME NOT NULL,
  id_turno INTEGER NOT NULL,
  FOREIGN KEY(id_turno) REFERENCES turno(id_turno)
);
-- INSERTAR DATOS HORARIO
INSERT INTO horario ( hora_inicio, hora_final, id_turno)
VALUES ( '7:30:00', '9:00:00', 1);
INSERT INTO horario ( hora_inicio, hora_final, id_turno)
VALUES ( '9:15:00', '10:45:00', 1);

CREATE TABLE materia_horario (
  id_materia_Horario INTEGER  AUTO_INCREMENT NULL PRIMARY KEY,
  sigla VARCHAR(10) NOT NULL,
  id_horario INTEGER NOT NULL,
  FOREIGN KEY(sigla) REFERENCES materia(sigla),
  FOREIGN KEY(id_horario) REFERENCES horario(id_horario)
);
-- INSERTAR DATOS PASA_EN
INSERT INTO materia_horario( sigla, id_horario)
VALUES ( 'SIS-12', 1);

CREATE TABLE materia_asignado (
   id_materia_Asignado INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
   sigla VARCHAR(10) NOT NULL,
   id_carrera INTEGER NOT NULL,
   FOREIGN KEY(sigla) REFERENCES materia(sigla),
   FOREIGN KEY(id_carrera) REFERENCES carrera(id_carrera)
);
INSERT INTO materia_asignado( sigla, id_carrera)
VALUES ('SIS-12', 1);

CREATE TABLE asistencia (
  id_asistencia INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  fecha DATE NOT NULL,
  hora_entrada TIME NOT NULL,
  hora_salida TIME ,
  cant_estudiantes INTEGER NOT NULL,
  id_usuario INTEGER NOT NULL,
  ci  INTEGER NOT NULL,
  FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
  FOREIGN KEY(ci) REFERENCES docente(ci)
);
-- INSERTAR DATOS ASISTENCIA
INSERT INTO asistencia( fecha, hora_entrada, hora_salida, cant_estudiantes, id_usuario, ci)
VALUES ('2022-03-23', '7:30:00', '9:00:00', 19, 2, 11077821);

