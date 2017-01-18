--sql
create table TBL_PERSONA
(
ID int NOT NULL IDENTITY (1,1) PRIMARY KEY,
NOMBRE varchar(100),
CORREO varchar(100)
)

--postgres
create table TBL_PERSONA
(
ID serial PRIMARY KEY,,
NOMBRE varchar(100),
CORREO varchar(100)
)