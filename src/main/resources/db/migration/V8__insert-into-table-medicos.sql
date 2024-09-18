DELETE FROM `railway`.`medicos`;

INSERT INTO `railway`.`medicos` (`id`, `nombre`, `email`, `documento`, `especialidad`, `calle`, `distrito`, `complemento`, `numero`, `ciudad`, `telefono`, `activo`)
VALUES
('1', 'Dr. Martín Alvarez', 'martin.alvarez@example.com', '12345678', 'GENERAL', 'Calle A', 'Buenos Aires', '', '1234', 'Buenos Aires', '01123456789', '1'),
('2', 'Dra. Paula Gómez', 'paula.gomez@example.com', '23456789', 'CARDIOLOGIA', 'Calle B', 'CABA', '', '2345', 'CABA', '01123456790', '1'),
('3', 'Dr. Santiago Fernández', 'santiago.fernandez@example.com', '34567890', 'GINECOLOGIA', 'Calle C', 'La Plata', '', '3456', 'La Plata', '01123456791', '1'),
('4', 'Dra. Lucía Martínez', 'lucia.martinez@example.com', '45678901', 'NEUROLOGIA', 'Calle D', 'Mendoza', '', '4567', 'Mendoza', '01123456792', '1'),
('5', 'Dr. Nicolás Pérez', 'nicolas.perez@example.com', '56789012', 'NUTRICION', 'Calle E', 'Rosario', '', '5678', 'Rosario', '01123456793', '1'),
('6', 'Dra. Carolina Torres', 'carolina.torres@example.com', '67890123', 'ORTOPEDIA', 'Calle F', 'Salta', '', '6789', 'Salta', '01123456794', '1'),
('7', 'Dr. Felipe Ruiz', 'felipe.ruiz@example.com', '78901234', 'PEDIATRIA', 'Calle G', 'Córdoba', '', '7890', 'Córdoba', '01123456795', '1'),
('8', 'Dra. Sofia Castro', 'sofia.castro@example.com', '89012345', 'UROLOGIA', 'Calle H', 'San Juan', '', '8901', 'San Juan', '01123456796', '1'),
('9', 'Dr. Andrés López', 'andres.lopez@example.com', '90123456', 'GENERAL', 'Calle I', 'Tucumán', '', '9012', 'Tucumán', '01123456797', '1'),
('10', 'Dra. Valentina Silva', 'valentina.silva@example.com', '01234567', 'CARDIOLOGIA', 'Calle J', 'Misiones', '', '0123', 'Misiones', '01123456798', '1'),
('11', 'Dr. Tomás Vega', 'tomas.vega@example.com', '12345679', 'GINECOLOGIA', 'Calle K', 'Catamarca', '', '2344', 'Catamarca', '01123456799', '1'),
('12', 'Dra. Julia Reyes', 'julia.reyes@example.com', '23456780', 'NEUROLOGIA', 'Calle L', 'Neuquén', '', '4565', 'Neuquén', '01123456800', '1'),
('13', 'Dr. Emiliano Herrera', 'emiliano.herrera@example.com', '34567891', 'NUTRICION', 'Calle M', 'Río Negro', '', '6786', 'Río Negro', '01123456801', '1'),
('14', 'Dra. Gabriela Moreno', 'gabriela.moreno@example.com', '45678902', 'ORTOPEDIA', 'Calle N', 'Chaco', '', '8907', 'Chaco', '01123456802', '1'),
('15', 'Dr. Juan Pérez', 'juan.perez@example.com', '56789013', 'PEDIATRIA', 'Calle O', 'Formosa', '', '0128', 'Formosa', '01123456803', '1'),
('16', 'Dra. María Torres', 'maria.torres@example.com', '67890124', 'UROLOGIA', 'Calle P', 'Corrientes', '', '2349', 'Corrientes', '01123456804', '1'),
('17', 'Dr. Lucas González', 'lucas.gonzalez@example.com', '78901235', 'GENERAL', 'Calle Q', 'Jujuy', '', '4560', 'Jujuy', '01123456805', '1'),
('18', 'Dra. Natalia Ramos', 'natalia.ramos@example.com', '89012346', 'CARDIOLOGIA', 'Calle R', 'Chubut', '', '6781', 'Chubut', '01123456806', '1'),
('19', 'Dr. Franco López', 'franco.lopez@example.com', '90123457', 'GINECOLOGIA', 'Calle S', 'Santa Cruz', '', '8902', 'Santa Cruz', '01123456807', '1'),
('20', 'Dra. Camila Díaz', 'camila.diaz@example.com', '01234568', 'NEUROLOGIA', 'Calle T', 'Tierra del Fuego', '', '0123', 'Tierra del Fuego', '01123456808', '1'),
('21', 'Dr. Agustín Castillo', 'agustin.castillo@example.com', '12345680', 'NUTRICION', 'Calle U', 'Formosa', '', '1235', 'Formosa', '01123456809', '1'),
('22', 'Dra. Verónica Torres', 'veronica.torres@example.com', '23456781', 'ORTOPEDIA', 'Calle V', 'Santa Fe', '', '2346', 'Santa Fe', '01123456810', '1'),
('23', 'Dr. Leonardo Ortiz', 'leonardo.ortiz@example.com', '34567892', 'PEDIATRIA', 'Calle W', 'Mendoza', '', '3457', 'Mendoza', '01123456811', '1'),
('24', 'Dra. Inés Salgado', 'ines.salgado@example.com', '45678903', 'UROLOGIA', 'Calle X', 'Río Negro', '', '4568', 'Río Negro', '01123456812', '1');
