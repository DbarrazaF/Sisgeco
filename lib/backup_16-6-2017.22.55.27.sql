-- MySQL dump 10.16  Distrib 10.1.13-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: coves_proyectos
-- ------------------------------------------------------
-- Server version	10.1.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `coves_proyectos`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `coves_proyectos` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `coves_proyectos`;

--
-- Table structure for table `coves`
--

DROP TABLE IF EXISTS `coves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coves` (
  `rut_coves` char(11) NOT NULL,
  `nombre_coves` varchar(50) NOT NULL,
  `estado_coves` varchar(10) NOT NULL,
  `cod_unidad` char(4) NOT NULL,
  `ano_coves` char(4) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `direccion_coves` varchar(50) NOT NULL,
  `telefono_coves` char(23) NOT NULL,
  PRIMARY KEY (`rut_coves`),
  KEY `fk_coves_unidad_vecinal` (`cod_unidad`),
  CONSTRAINT `fk_coves_unidad_vecinal` FOREIGN KEY (`cod_unidad`) REFERENCES `unidad_vecinal` (`cod_unidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coves`
--

LOCK TABLES `coves` WRITE;
/*!40000 ALTER TABLE `coves` DISABLE KEYS */;
INSERT INTO `coves` VALUES ('65042073-k','Benidorm','Vigente','63','2016','Benidorm','4564345645-3451341'),('65043761-6','Vecinos Unidos Santa Ines','No vigente','62','2017','Santa Ines',''),('65054438-2','Pasaje 3 C.O.I.A','Vigente','62','2017','COIA',''),('65054874-4','Unidad y Esperanza','Vigente','61','2017','Colinas de Arenal',''),('65059579-3','Colinas del Arenal','Vigente','61','2017','Colinas del Arenal',''),('65118076-7','Vistas Naves','Vigente','63','2017','Vista Naves',''),('65119745-7','Codornices','Vigente','07','2017','Las Codornices',''),('65126737-4','Maravillar 1','Vigente','07','2017','Pasaje Maravillar',''),('65851430-k','Santa Ines','Vigente','62','2000','Santa Ines','');
/*!40000 ALTER TABLE `coves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decreto`
--

DROP TABLE IF EXISTS `decreto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `decreto` (
  `nro_decreto` char(10) NOT NULL,
  `fecha_decreto` date NOT NULL,
  `fecha_retiro_cheque_decreto` date DEFAULT NULL,
  `retira_cheque_decreto` char(11) DEFAULT NULL,
  `ano_postu_proyecto` char(4) NOT NULL,
  `nro_ingreso_proyecto` char(3) NOT NULL,
  `estado` char(12) NOT NULL,
  PRIMARY KEY (`nro_decreto`),
  KEY `fk_decreto_proyecto` (`ano_postu_proyecto`,`nro_ingreso_proyecto`),
  CONSTRAINT `fk_decreto_proyecto` FOREIGN KEY (`ano_postu_proyecto`, `nro_ingreso_proyecto`) REFERENCES `proyecto` (`ano_postulacion_proyecto`, `nro_ingreso_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decreto`
--

LOCK TABLES `decreto` WRITE;
/*!40000 ALTER TABLE `decreto` DISABLE KEYS */;
/*!40000 ALTER TABLE `decreto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directiva`
--

DROP TABLE IF EXISTS `directiva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `directiva` (
  `rut_dirigente` char(11) NOT NULL,
  `rut_coves` char(11) NOT NULL,
  `cargo_dirigente` varchar(11) NOT NULL,
  PRIMARY KEY (`rut_dirigente`,`rut_coves`),
  KEY `fk_directiva_coves` (`rut_coves`),
  CONSTRAINT `fk_directiva_coves` FOREIGN KEY (`rut_coves`) REFERENCES `coves` (`rut_coves`),
  CONSTRAINT `fk_directiva_dirigente` FOREIGN KEY (`rut_dirigente`) REFERENCES `dirigente` (`rut_dirigente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directiva`
--

LOCK TABLES `directiva` WRITE;
/*!40000 ALTER TABLE `directiva` DISABLE KEYS */;
INSERT INTO `directiva` VALUES ('4156158-6','65851430-k','Presidente'),('4351493-8','65042073-k','Tesorero'),('5885846-3','65851430-k','Tesorero'),('6032981-8','65042073-k','Secretario'),('7805546-4','65042073-k','Presidente');
/*!40000 ALTER TABLE `directiva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dirigente`
--

DROP TABLE IF EXISTS `dirigente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dirigente` (
  `rut_dirigente` char(11) NOT NULL,
  `nombre_dirigente` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellido_pat_dirigente` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellido_mat_dirigente` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nro_casa_dirigente` char(6) DEFAULT NULL,
  `block_dirigente` char(3) DEFAULT NULL,
  `depar_dirigente` char(3) DEFAULT NULL,
  `poblacion_dirigente` varchar(30) DEFAULT NULL,
  `telefono_dirigente` char(23) NOT NULL,
  `email_dirigente` varchar(50) DEFAULT NULL,
  `calle_dirigente` varchar(40) NOT NULL,
  `cod_sector` char(4) NOT NULL,
  PRIMARY KEY (`rut_dirigente`),
  KEY `fk_dirigente_sector` (`cod_sector`),
  CONSTRAINT `fk_dirigente_sector` FOREIGN KEY (`cod_sector`) REFERENCES `sector` (`cod_sector`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dirigente`
--

LOCK TABLES `dirigente` WRITE;
/*!40000 ALTER TABLE `dirigente` DISABLE KEYS */;
INSERT INTO `dirigente` VALUES ('4156158-6','Alicia','Bernal','Serrano','1811','','','Santa Ines','2780910-85817952','','20 Norte 1811','07'),('4351493-8','Clara','Nuñez','Salinas','','8','11','Benidorm','2397443','','Curali','07'),('5885846-3','Luis ','Carvajal','Orellana','2240','','','Santa Ines','32240947-96564167','wqewq','Pasaje central','07'),('6032981-8','Silvia','Lopez','Delgado','','2','32','Benidorm','98802434','','Curali','07'),('6436405-7','Hilda','Caroca','Pino','2273','','','Santa Ines','95654603','aktsunamun@gamil.com','Pasaje Central','07'),('7805546-4','Arturo','Rodriguez','Urbina','','2','43','Benidorm','98403460','arodriguezurbina@gmail.com','Curali','07');
/*!40000 ALTER TABLE `dirigente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `rut_funcionario` char(11) NOT NULL,
  `nombre_funcionario` varchar(20) NOT NULL,
  `apell_pat_funcionario` varchar(20) NOT NULL,
  `apell_mat_funcionario` varchar(20) NOT NULL,
  `contra_funcionario` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `tipo_funcionario` varchar(10) NOT NULL,
  `estado_funcionario` varchar(9) NOT NULL,
  PRIMARY KEY (`rut_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('111111111-k','prueba','prueba','prueba','1111111','Usuario','Activo'),('1234','Usuario','Usuario','Usuario','root','Usuario','Activo'),('17909449-5','Daniel','Barraza','Fernandez','danielbf','Admin','Activo');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `ano_postulacion_proyecto` char(4) NOT NULL,
  `nro_ingreso_proyecto` char(3) NOT NULL,
  `objetivo_proyecto` varchar(150) NOT NULL,
  `nro_partici_proyecto` char(4) NOT NULL,
  `fecha_ingre_proyecto` date NOT NULL,
  `duracion_proyecto` char(4) NOT NULL,
  `calle_referen_proyecto` varchar(50) NOT NULL,
  `aporte_otra_organ_proyecto` char(10) DEFAULT NULL,
  `monto_solici_proyecto` char(10) NOT NULL,
  `aporte_munici_proyecto` char(10) DEFAULT NULL,
  `comentario_proyecto` varchar(500) DEFAULT NULL,
  `aporte_organ_proyecto` char(10) DEFAULT NULL,
  `monto_aprob_proyecto` char(10) NOT NULL,
  `nro_matriz_proyecto` char(6) NOT NULL,
  `nro_aproba_proyecto` char(5) NOT NULL,
  `ano_matriz_proyecto` char(4) NOT NULL,
  `ano_decreto_proyecto` char(4) NOT NULL,
  `ano_aproba_proyecto` char(4) NOT NULL,
  `nombre_proyecto` varchar(100) NOT NULL,
  `nro_tipo_proyecto` char(3) NOT NULL,
  `rut_coves` char(11) NOT NULL,
  PRIMARY KEY (`ano_postulacion_proyecto`,`nro_ingreso_proyecto`),
  KEY `fk_proyecto_tipo_proyecto` (`nro_tipo_proyecto`),
  KEY `fk_proyecto_coves` (`rut_coves`),
  CONSTRAINT `fk_proyecto_coves` FOREIGN KEY (`rut_coves`) REFERENCES `coves` (`rut_coves`),
  CONSTRAINT `fk_proyecto_tipo_proyecto` FOREIGN KEY (`nro_tipo_proyecto`) REFERENCES `tipo_proyecto` (`nro_tipo_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES ('2017','123','asdfsadf','32','2017-07-15','21','qwer','234','432','243','124243','234','41','143','23','2017','2017','2017','fdsdafsdafsad','P01','65054874-4'),('2017','32','qwer','12','2017-07-08','32','werq','234','324','234','324132','234','2','234','324','2017','2017','2017','ewqwer','P01','65042073-k');
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sector` (
  `cod_sector` char(4) NOT NULL,
  `nom_sector` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_sector`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` VALUES ('01','Nueva Aurora'),('02','Recreo'),('03','Forestal'),('04','Chorillos'),('05','Viña Oriente'),('07','Santa Ines'),('08','Plan Viña'),('09','Achupallas'),('10','Gomez Carreño'),('11','Reñaca Alto'),('12','Reñaca Bajo');
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suceso`
--

DROP TABLE IF EXISTS `suceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suceso` (
  `cod_suceso` int(5) NOT NULL,
  `fecha_suceso` date NOT NULL,
  `descripcion_suceso` varchar(500) DEFAULT NULL,
  `afiche_suceso` char(2) NOT NULL,
  `rut_coves` char(11) NOT NULL,
  `rut_funcionario` char(11) NOT NULL,
  `cod_tipo_suceso` char(3) NOT NULL,
  `nro_participantes` char(4) NOT NULL,
  PRIMARY KEY (`cod_suceso`),
  KEY `fk_sucesos_coves` (`rut_coves`),
  KEY `fk_sucesos_funcionarios` (`rut_funcionario`),
  KEY `fk_sucesos_tipo_suceso` (`cod_tipo_suceso`),
  CONSTRAINT `fk_sucesos_coves` FOREIGN KEY (`rut_coves`) REFERENCES `coves` (`rut_coves`),
  CONSTRAINT `fk_sucesos_funcionarios` FOREIGN KEY (`rut_funcionario`) REFERENCES `funcionario` (`rut_funcionario`),
  CONSTRAINT `fk_sucesos_tipo_suceso` FOREIGN KEY (`cod_tipo_suceso`) REFERENCES `tipo_suceso` (`cod_tipo_suceso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suceso`
--

LOCK TABLES `suceso` WRITE;
/*!40000 ALTER TABLE `suceso` DISABLE KEYS */;
/*!40000 ALTER TABLE `suceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_proyecto`
--

DROP TABLE IF EXISTS `tipo_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_proyecto` (
  `nro_tipo_proyecto` char(3) NOT NULL,
  `nombre_tipo_proyecto` varchar(50) NOT NULL,
  PRIMARY KEY (`nro_tipo_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_proyecto`
--

LOCK TABLES `tipo_proyecto` WRITE;
/*!40000 ALTER TABLE `tipo_proyecto` DISABLE KEYS */;
INSERT INTO `tipo_proyecto` VALUES ('P01','Alarmas Comunitarias'),('P02','Alarmas Domiciliarias'),('P03','Camaras'),('P04','Luminarias'),('P05','Recuperacion de Espacio Publico'),('P06','Pasamanos'),('P07','Escaleras'),('P08','Boton de Panico'),('P09','Prevencion Y Difision'),('P10','Prevencion Situacional del Delito');
/*!40000 ALTER TABLE `tipo_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_suceso`
--

DROP TABLE IF EXISTS `tipo_suceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_suceso` (
  `cod_tipo_suceso` char(3) NOT NULL,
  `nombre_tipo_suceso` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_tipo_suceso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_suceso`
--

LOCK TABLES `tipo_suceso` WRITE;
/*!40000 ALTER TABLE `tipo_suceso` DISABLE KEYS */;
INSERT INTO `tipo_suceso` VALUES ('S01','Charla'),('S02','Expo'),('S03','Intervencion'),('S04','Reunion'),('S05','Entrega de Invitacion'),('S06','Simulacro'),('S07','Supervision Fisc'),('S08','Verano Entretenido'),('S09','Operativo');
/*!40000 ALTER TABLE `tipo_suceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_vecinal`
--

DROP TABLE IF EXISTS `unidad_vecinal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_vecinal` (
  `cod_unidad` char(4) NOT NULL,
  `nombre_unidad` varchar(50) NOT NULL,
  `cod_sector` char(4) NOT NULL,
  PRIMARY KEY (`cod_unidad`),
  KEY `fk_unidad_vecinal_sector` (`cod_sector`),
  CONSTRAINT `fk_unidad_vecinal_sector` FOREIGN KEY (`cod_sector`) REFERENCES `sector` (`cod_sector`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_vecinal`
--

LOCK TABLES `unidad_vecinal` WRITE;
/*!40000 ALTER TABLE `unidad_vecinal` DISABLE KEYS */;
INSERT INTO `unidad_vecinal` VALUES ('01','El sauce','02'),('02','Lord Cochrane','02'),('03','Recreo Alto','02'),('04','Los Mayos','02'),('05','Villa Londres','02'),('06','La Hacienda','02'),('07','Villa Columbia','02'),('08','Villa Moderna','02'),('09','Caleta Abarca','02'),('10','Monterrey','02'),('11','Vicente Naranjo','02'),('114','Caleta Abarca Alto','02'),('12','Santa Ma','02'),('125','Villa Peru','01'),('126','Harees','01'),('127','Borninquen','01'),('128','Santiago Ferrari','01'),('154','Nuevas Lomas','01'),('19','Las Colinas','02'),('20','Las Brisas-Vista Mar','01'),('21','Viña Del Mar Alto','02'),('22','Empart Etchevers','02'),('23','Ferroviaria Asiva','02'),('24','Moreno Vial','01'),('25','San Rafael','01'),('26','Chile sur','01'),('27','Las Palmas','01'),('28','Villa Linda Sur','01'),('29','Villa Montes','01'),('30','Irene Frei','01'),('31','Viña Linda norte','01'),('61','Santiago Cabrera','07'),('62','Britanica','07'),('63','Los Lirios - El Bosque','07'),('65','Poblacion Libertad','07');
/*!40000 ALTER TABLE `unidad_vecinal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'coves_proyectos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS *