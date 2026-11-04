CREATE TABLE reunion (
	id BIGSERIAL PRIMARY KEY,
	asunto VARCHAR(128) NOT NULL,
	fecha TIMESTAMP NOT NULL
);

CREATE TABLE persona (
	id BIGSERIAL PRIMARY KEY,
	nombre VARCHAR(32) NOT NULL,
	apellido VARCHAR(32) NOT NULL, 
	correo VARCHAR(32) NOT NULL, 
	telefono VARCHAR(32) NOT NULL
);

CREATE TABLE asistente (
	reunion_id BIGSERIAL,
	persona_id BIGSERIAL,
	PRIMARY KEY (reunion_id, persona_id),
	FOREIGN KEY (reunion_id) REFERENCES reunion(id),
	FOREIGN KEY (persona_id) REFERENCES persona(id)
)
