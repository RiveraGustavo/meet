INSERT INTO reunion (id, asunto, fecha) VALUES (1, 'Progreso personal', '2023-06-01');
INSERT INTO reunion (id, asunto, fecha) VALUES (2, 'Seguimiento equipo', '2023-06-02');
INSERT INTO reunion (id, asunto, fecha) VALUES (3, 'General', '2023-06-03');


INSERT INTO persona (id, nombre, apellido, correo, telefono) VALUES (1, 'Juan', 'Gómez', 'juan.gomez@example.com', '123456789'  );
INSERT INTO persona (id, nombre, apellido, correo, telefono) VALUES (2, 'Marisa', 'López', 'marisa.lopez@example.com', '987654321');
INSERT INTO persona (id, nombre, apellido, correo, telefono) VALUES (3, 'Ana', 'Pérez', 'ana.perez@example.com', '555555555');
INSERT INTO persona (id, nombre, apellido, correo, telefono) VALUES (4, 'Luz', 'García', 'luz.garcia@example.com', '444444444');
INSERT INTO persona (id, nombre, apellido, correo, telefono) VALUES (5, 'Jose', 'Ruiz', 'jose.ruiz@example.com', '333333333');

INSERT INTO asistente (reunion_id, persona_id) VALUES (1, 1);
INSERT INTO asistente (reunion_id, persona_id) VALUES (1, 2);
INSERT INTO asistente (reunion_id, persona_id) VALUES (2, 1);
INSERT INTO asistente (reunion_id, persona_id) VALUES (2, 3);
INSERT INTO asistente (reunion_id, persona_id) VALUES (2, 4);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 1);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 2);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 3);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 4);
INSERT INTO asistente (reunion_id, persona_id) VALUES (3, 5);


