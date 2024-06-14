CREATE DATABASE  IF NOT EXISTS `moviexd` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `moviexd`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: moviexd
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id_movie` int NOT NULL AUTO_INCREMENT,
  `overview` varchar(1024) NOT NULL,
  `popularity` float NOT NULL,
  `release_date` varchar(45) NOT NULL,
  `id_user` int NOT NULL,
  `title` varchar(256) NOT NULL,
  PRIMARY KEY (`id_movie`),
  KEY `fk_movie_user_idx` (`id_user`),
  CONSTRAINT `fk_movie_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Ambientada varias generaciones en el futuro tras el reinado de César, en la que los simios son la especie dominante que vive en armonía y los humanos se han visto reducidos a vivir en la sombra. Mientras un nuevo y tiránico líder simio construye su imperio, un joven simio emprende un angustioso viaje que le llevará a cuestionarse todo lo que sabe sobre el pasado y a tomar decisiones que definirán el futuro de simios y humanos por igual.',3721.15,'2024-05-08',1,'El reino del planeta de los simios'),(2,'El mundialmente famoso Garfield, el gato casero que odia los lunes y que adora la lasaña, está a punto de vivir una aventura ¡en el salvaje mundo exterior! Tras una inesperada reunión con su largamente perdido padre – el desaliñado gato callejero Vic – Garfield y su amigo canino Odie se ven forzados a abandonar sus perfectas y consentidas vidas al unirse a Vic en un hilarante y muy arriesgado atraco.',502.943,'2024-04-30',1,'Garfield: la película'),(3,'Tras escuchar falsas acusaciones sobre su excapitán y mentor Mike y Marcus deciden investigar el asunto incluso volverse los más buscados de ser necesarios',2585.9,'2024-06-05',1,'Bad Boys: Ride or Die'),(4,'Tras escuchar falsas acusaciones sobre su excapitán y mentor Mike y Marcus deciden investigar el asunto incluso volverse los más buscados de ser necesarios',2585.9,'2024-06-05',2,'Bad Boys: Ride or Die');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `password` varchar(256) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Gabriel Talledo','$2a$10$WNtpYupEMvsabLXJ/PFqWOsBDKPph3VbiBymgYDfEzBubUix75EJy','GabrielTM'),(2,'Paula Salazar','$2a$10$WNtpYupEMvsabLXJ/PFqWOsBDKPph3VbiBymgYDfEzBubUix75EJy','Paulita3');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'moviexd'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-13 20:51:22
