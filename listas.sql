-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 29-09-2023 a las 15:04:48
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `listas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `cargo` varchar(30) NOT NULL,
  `documento` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `edad` int NOT NULL,
  `fecha_registro` varchar(50) NOT NULL,
  `tipo_contrato` varchar(30) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`cargo`, `documento`, `nombre`, `apellido`, `edad`, `fecha_registro`, `tipo_contrato`) VALUES
('Desarrollador', '1006460987', 'Carlos', 'Zapata', 24, 'Wed Sep 27 00:00:00 COT 2023', 'Termino indefinido'),
('Desarrollador jr', '1006460117', 'Johan Alexis', 'Accardo Medina', 23, 'Tue Aug 22 00:00:00 COT 2023', 'Aprendiz Konecta'),
('Arquitecto', '40745678', 'Sebastian', 'Valencia', 32, 'Tue Aug 15 00:00:00 COT 2023', 'Prestacion de servicios');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
