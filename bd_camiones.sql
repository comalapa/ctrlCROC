-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_camiones
--

CREATE DATABASE IF NOT EXISTS db_camiones;
USE db_camiones;

--
-- Definition of table `tb_asistencia`
--

DROP TABLE IF EXISTS `tb_asistencia`;
CREATE TABLE `tb_asistencia` (
  `id` int(11) NOT NULL auto_increment,
  `chofer_id` int(11) default NULL,
  `entrada` datetime default NULL,
  `salida` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_asistencia`
--

/*!40000 ALTER TABLE `tb_asistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_asistencia` ENABLE KEYS */;


--
-- Definition of table `tb_camion`
--

DROP TABLE IF EXISTS `tb_camion`;
CREATE TABLE `tb_camion` (
  `id` int(11) NOT NULL auto_increment,
  `marca` varchar(45) default NULL,
  `modelo` varchar(4) default NULL,
  `color` varchar(15) default NULL,
  `no_placa` varchar(9) default NULL,
  `no_serie` varchar(25) default NULL,
  `no_control` int(11) default NULL,
  `capacidad` int(11) default NULL,
  `propietario` varchar(60) default NULL,
  `estatus_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_camion`
--

/*!40000 ALTER TABLE `tb_camion` DISABLE KEYS */;
INSERT INTO `tb_camion` (`id`,`marca`,`modelo`,`color`,`no_placa`,`no_serie`,`no_control`,`capacidad`,`propietario`,`estatus_id`) VALUES 
 (1,'Craisler','1997','Blanco','dhc-99-12','1234568970123455',120,5,'Jaime Rodriguez Morales',1),
 (2,'Mitsubishi','2010','Negro','12-12-abc','9182837465682837',130,5,'Ruben Diaz Anzueto',1);
/*!40000 ALTER TABLE `tb_camion` ENABLE KEYS */;


--
-- Definition of table `tb_chofer`
--

DROP TABLE IF EXISTS `tb_chofer`;
CREATE TABLE `tb_chofer` (
  `id` int(11) NOT NULL auto_increment,
  `codigo` varchar(15) default NULL,
  `nombre` varchar(25) default NULL,
  `apellido_p` varchar(25) default NULL,
  `apellido_m` varchar(25) default NULL,
  `direccion` varchar(45) default NULL,
  `ciudad` varchar(45) default NULL,
  `estado` varchar(45) default NULL,
  `cp` varchar(45) default NULL,
  `telefono` varchar(12) default NULL,
  `no_ife` varchar(15) default NULL,
  `no_licencia` varchar(15) default NULL,
  `fecha_creacion` datetime default NULL,
  `fecha_borrado` datetime default NULL,
  `estatus_id` int(11) default NULL,
  `camion_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_chofer`
--

/*!40000 ALTER TABLE `tb_chofer` DISABLE KEYS */;
INSERT INTO `tb_chofer` (`id`,`codigo`,`nombre`,`apellido_p`,`apellido_m`,`direccion`,`ciudad`,`estado`,`cp`,`telefono`,`no_ife`,`no_licencia`,`fecha_creacion`,`fecha_borrado`,`estatus_id`,`camion_id`) VALUES 
 (1,'2020','Avidai','Alberto','Tobar','Comitan','Comitan de Dominguez','Chiapas','30000','9631212345','123453221223212','12C212332123127','2013-06-11 23:14:50',NULL,1,1);
/*!40000 ALTER TABLE `tb_chofer` ENABLE KEYS */;


--
-- Definition of table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
CREATE TABLE `tb_cliente` (
  `id` int(11) NOT NULL auto_increment,
  `codigo` varchar(12) default NULL,
  `nombre` varchar(60) default NULL,
  `contacto` varchar(45) default NULL,
  `curp` varchar(17) default NULL,
  `rfc` varchar(12) default NULL,
  `direccion` varchar(45) default NULL,
  `ciudad` varchar(40) default NULL,
  `estado` varchar(25) default NULL,
  `telefono` varchar(10) default NULL,
  `estatus_id` int(11) default NULL,
  `fecha_creacion` datetime default NULL,
  `fecha_borrado` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cliente`
--

/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;


--
-- Definition of table `tb_cola`
--

DROP TABLE IF EXISTS `tb_cola`;
CREATE TABLE `tb_cola` (
  `id` int(11) NOT NULL auto_increment,
  `chofer_id` int(11) default NULL,
  `nombre` varchar(65) default NULL,
  `camion_control` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cola`
--

/*!40000 ALTER TABLE `tb_cola` DISABLE KEYS */;
INSERT INTO `tb_cola` (`id`,`chofer_id`,`nombre`,`camion_control`) VALUES 
 (3,1,'Avidai','120');
/*!40000 ALTER TABLE `tb_cola` ENABLE KEYS */;


--
-- Definition of table `tb_destino`
--

DROP TABLE IF EXISTS `tb_destino`;
CREATE TABLE `tb_destino` (
  `id` int(11) NOT NULL auto_increment,
  `estado` varchar(50) default NULL,
  `ciudad` varchar(50) default NULL,
  `colonia` varchar(50) default NULL,
  `direccion` varchar(200) default NULL,
  `contacto` varchar(50) default NULL,
  `telefono` varchar(10) default NULL,
  `celular` varchar(10) default NULL,
  `referencia` varchar(200) default NULL,
  `pedido_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_destino`
--

/*!40000 ALTER TABLE `tb_destino` DISABLE KEYS */;
INSERT INTO `tb_destino` (`id`,`estado`,`ciudad`,`colonia`,`direccion`,`contacto`,`telefono`,`celular`,`referencia`,`pedido_id`) VALUES 
 (6,'Chiapas','Las Margaritas','Centro','Centro','Rosario Magaña','6311111','0631222222','Una casa en construccion',2),
 (5,'Chiapas','Comitan de Dominguez','Centro','1a. Avenida Oriente Sur','Juan Muñoz Vargas','6354321','9631212345','A un costado de la calle',1);
/*!40000 ALTER TABLE `tb_destino` ENABLE KEYS */;


--
-- Definition of table `tb_entradas`
--

DROP TABLE IF EXISTS `tb_entradas`;
CREATE TABLE `tb_entradas` (
  `id` int(11) NOT NULL auto_increment,
  `pedido_id` int(11) default NULL,
  `salida` datetime default NULL,
  `regreso` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_entradas`
--

/*!40000 ALTER TABLE `tb_entradas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_entradas` ENABLE KEYS */;


--
-- Definition of table `tb_estatus`
--

DROP TABLE IF EXISTS `tb_estatus`;
CREATE TABLE `tb_estatus` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(25) default NULL,
  `descripcion` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_estatus`
--

/*!40000 ALTER TABLE `tb_estatus` DISABLE KEYS */;
INSERT INTO `tb_estatus` (`id`,`nombre`,`descripcion`) VALUES 
 (1,'Activo','Para indicar que el elemento esta acrivo'),
 (2,'Eliminado','Para indicar que el elemento esta eliminado'),
 (3,'Asignado','Indica que el pedido ya fue recibido y esta p'),
 (4,'Completado','Indica que el pedido ya fue entregado'),
 (5,'En ruta','Indica que el pedido esta en camino a la entr');
/*!40000 ALTER TABLE `tb_estatus` ENABLE KEYS */;


--
-- Definition of table `tb_materiales`
--

DROP TABLE IF EXISTS `tb_materiales`;
CREATE TABLE `tb_materiales` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(25) default NULL,
  `descripcion` varchar(45) default NULL,
  `precio` double default NULL,
  `descuento` double default NULL,
  `iva` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_materiales`
--

/*!40000 ALTER TABLE `tb_materiales` DISABLE KEYS */;
INSERT INTO `tb_materiales` (`id`,`nombre`,`descripcion`,`precio`,`descuento`,`iva`) VALUES 
 (1,'Arena','Arena para construccion',680,NULL,NULL),
 (2,'Grava','Grava para construccion',700,NULL,NULL),
 (3,'Grava lavada','Grava limpia para construccion',900,NULL,NULL),
 (4,'Piedra caliza','Piedra para Contruccion',1200,NULL,NULL);
/*!40000 ALTER TABLE `tb_materiales` ENABLE KEYS */;


--
-- Definition of table `tb_pedidos`
--

DROP TABLE IF EXISTS `tb_pedidos`;
CREATE TABLE `tb_pedidos` (
  `id` int(11) NOT NULL auto_increment,
  `chofer_id` int(11) default NULL,
  `camion_id` int(11) default NULL,
  `material_id` int(11) default NULL,
  `estatus_id` int(11) default NULL,
  `fecha_creado` datetime default NULL,
  `fecha_completado` datetime default NULL,
  `fecha_borrado` datetime default NULL,
  `usuario_id` int(11) default NULL,
  `observaciones` varchar(80) default NULL,
  `entregado` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pedidos`
--

/*!40000 ALTER TABLE `tb_pedidos` DISABLE KEYS */;
INSERT INTO `tb_pedidos` (`id`,`chofer_id`,`camion_id`,`material_id`,`estatus_id`,`fecha_creado`,`fecha_completado`,`fecha_borrado`,`usuario_id`,`observaciones`,`entregado`) VALUES 
 (1,1,1,3,4,'2013-06-11 23:17:06','2013-06-11 23:22:40',NULL,NULL,NULL,NULL),
 (2,1,1,4,4,'2013-06-11 23:24:11','2013-06-11 23:24:42',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_pedidos` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
