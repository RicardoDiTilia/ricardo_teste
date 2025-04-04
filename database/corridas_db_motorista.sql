-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: corridas_db
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `motorista`
--

DROP TABLE IF EXISTS `motorista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motorista` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `modelo_carro` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `status` enum('ATIVO','INATIVO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rbjk7fv6x6kadmtchy9pb5bt3` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorista`
--

LOCK TABLES `motorista` WRITE;
/*!40000 ALTER TABLE `motorista` DISABLE KEYS */;
INSERT INTO `motorista` VALUES (1,'111.323.454-12','1985-05-20','Fiat Uno','Fernando Lopes','ATIVO'),(2,'523.423.311-21','2001-02-13','Fiat Mobi','Pedro Rogério','ATIVO'),(3,'452.452.615-22','1974-02-13','Saveiro ','Rafael Dias','ATIVO'),(4,'564.697.232-43','1985-07-15','Toyota Corolla','Eduardo Santos','ATIVO'),(5,'364.683.568-01','1990-02-10','Honda Civic','Mariana Souza','ATIVO'),(6,'456.434.781-22','1982-11-25','Ford Ka','Roberto Lima','INATIVO'),(9,'564.453.231-21','2005-01-05','Hb20','Ricardo','INATIVO'),(10,'574.463.231-21','2003-03-12','Cruze','Marcos Costa','ATIVO'),(11,'543.234.328-54','1988-01-14','T-Cross','Ana Paula','INATIVO'),(12,'513.251.268-21','1988-11-25','Polo','Gabriel Bezerra','INATIVO'),(13,'238.416.543-11','1986-12-10',' VW Gol','Maria Clara','ATIVO'),(14,'524.485.961-21','2002-10-09','Onix','Julia Pereira','INATIVO'),(15,'524.896.542-21','1981-09-17','Ford Ka','Augusto Luigi','INATIVO'),(16,'566.241.254-32','2000-03-12','Argo','Bruna Ferreira','ATIVO'),(17,'563.352.451-21','1990-12-20','HR-V','Rafael Abel','ATIVO');
/*!40000 ALTER TABLE `motorista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-04 14:34:03
