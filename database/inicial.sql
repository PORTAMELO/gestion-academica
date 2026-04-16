
-- Alumnos
INSERT INTO alumnos (nombre, apellido, email, fecha_nacimiento) VALUES
                                                                    ('Carlos',    'Ramírez',  'carlos.ramirez@email.com',  '2000-03-15'),
                                                                    ('Ana',       'Gómez',    'ana.gomez@email.com',        '1999-07-22'),
                                                                    ('Luis',      'Martínez', 'luis.martinez@email.com',    '2001-11-08'),
                                                                    ('Valentina', 'Torres',   'valentina.torres@email.com', '2000-05-30'),
                                                                    ('Sebastián', 'Herrera',  'sebastian.herrera@email.com','1998-09-14');

-- Materias
INSERT INTO materias (nombre, codigo, creditos) VALUES
                                                    ('Matemáticas',          'MAT-101', 4),
                                                    ('Programación Básica',  'PRG-101', 3),
                                                    ('Base de Datos',        'BDD-201', 3),
                                                    ('Inglés Técnico',       'ING-101', 2);

-- Notas
INSERT INTO notas (valor, fecha_registro, alumno_id, materia_id) VALUES
                                                                     (4.5, '2024-03-10', 1, 1),
                                                                     (3.8, '2024-03-10', 1, 2),
                                                                     (4.2, '2024-03-11', 2, 1),
                                                                     (5.0, '2024-03-11', 2, 3),
                                                                     (2.9, '2024-03-12', 3, 2),
                                                                     (3.5, '2024-03-12', 3, 4),
                                                                     (4.8, '2024-03-13', 4, 1),
                                                                     (4.0, '2024-03-13', 4, 3),
                                                                     (3.2, '2024-03-14', 5, 2),
                                                                     (4.6, '2024-03-14', 5, 4);