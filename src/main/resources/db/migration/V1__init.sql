CREATE TABLE IF NOT EXISTS persona(
  id SERIAL,
  nombre VARCHAR(30),
    edad int,
    estudiante boolean,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS celular(
  id SERIAL,
  modelo VARCHAR(30),
    marca VARCHAR(30),
    color VARCHAR(10),
    idPersona SERIAL,
    PRIMARY KEY (id),
    FOREIGN KEY (idPersona) REFERENCES persona(id)
);