INSERT INTO vehiculos (id, anio, kilometraje, marca, modelo, precio, tipo, imagen_url) VALUES
(1, 2003, 180000, 'BMW', 'Serie 3', 7500, 'Sedán', 'https://i.pinimg.com/736x/cc/76/01/cc76019994201d1fe3f80d5c2338f20d.jpg'),
(2, 1967, 120000, 'Ford', 'Mustang Fastback', 45000, 'Coupé', 'https://i.pinimg.com/736x/3b/f2/18/3bf21812aa108bc908df013cc763dd2a.jpg'),
(3, 2021, 20000, 'Dodge', 'Challenger HellCat SRT', 65000, 'Deportivo', 'https://i.pinimg.com/736x/c9/68/ab/c968ab0ba69d641149247786091354b1.jpg'),
(4, 1999, 90000, 'Nissan', 'Skyline R34', 90000, 'Deportivo', 'https://i.pinimg.com/736x/96/3a/7d/963a7d94bd5d6092a7de2a8b0a7f7852.jpg'),
(5, 2021, 15000, 'Mercedes-Benz', 'CLS 53 AMG', 85000, 'Sedán', 'https://i.pinimg.com/736x/e5/cf/e1/e5cfe1b6af7bc7e234d005b13058343d.jpg');


INSERT INTO usuarios (id, username, nombre, apellido, email, direccion, password, rol, telefono) VALUES
(1, 'juanperez', 'Juan', 'Rodrigez', 'juan.perez@example.com', 'Calle Principal 123', 'kjasdfKJDflka34#~', 'user', '123456789'),
(2, 'mariagomez', 'María', 'Gómez', 'maria.gomez@example.com', 'Avenida Central 456', 'password456', 'user', '987654321'),
(3, 'carloslopez', 'Carlos', 'López', 'carlos.lopez@example.com', 'Calle Secundaria 789', 'password789', 'admin', '555555555'),
(4, 'anatorres', 'Ana', 'Torres', 'ana.torres@example.com', 'Avenida Principal 012', 'password012', 'user', '111111111'),
(5, 'luisramirez', 'Luis', 'Ramírez', 'luis.ramirez@example.com', 'Calle Tercera 345', 'password345', 'user', '222222222'),
(6, 'juanperez', 'Juan', 'Pérez', 'juan.perez@example.com', 'Calle Principal 123', 'password123', 'user', '123456789'),
(7, 'mariagomez', 'María', 'Gómez', 'maria.gomez@example.com', 'Avenida Central 456', 'password456', 'user', '987654321');


INSERT INTO transacciones (id, fecha, vehiculo_id, comprador_id, vendedor_id) VALUES
(101, '2000-02-10 01:00:00.000000', 1013, 1012, 1011),
(102, '0233-03-12 01:00:00.000000', 123, 123, 123),
(103, '2025-05-07 10:30:00.000000', 1501, 1502, 1503),
(104, '2025-05-07 12:45:00.000000', 2004, 2005, 2006),
(108, '0322-02-12 01:00:00.000000', 1232123, 123223, 123);
