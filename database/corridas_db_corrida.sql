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
-- Table structure for table `corrida`
--

DROP TABLE IF EXISTS `corrida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corrida` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_hora` datetime(6) NOT NULL,
  `status` enum('SOLICITADA','EM_ANDAMENTO','CONCLUIDA','CANCELADA') NOT NULL,
  `valor` double NOT NULL,
  `motorista_id` bigint NOT NULL,
  `passageiro_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8mn7kmqhyeebbh5ambq8e2qhm` (`motorista_id`),
  KEY `FKbyoaa5huihrqixw6f7q7phc6p` (`passageiro_id`),
  CONSTRAINT `FK8mn7kmqhyeebbh5ambq8e2qhm` FOREIGN KEY (`motorista_id`) REFERENCES `motorista` (`id`),
  CONSTRAINT `FKbyoaa5huihrqixw6f7q7phc6p` FOREIGN KEY (`passageiro_id`) REFERENCES `passageiro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corrida`
--

LOCK TABLES `corrida` WRITE;
/*!40000 ALTER TABLE `corrida` DISABLE KEYS */;
INSERT INTO `corrida` VALUES (2,'2024-03-28 14:05:30.000000','SOLICITADA',23.5,1,2),(3,'2024-03-28 14:10:45.000000','EM_ANDAMENTO',18.9,2,3),(4,'2024-03-28 14:25:10.000000','CONCLUIDA',45.3,3,1),(5,'2024-03-28 15:00:00.000000','CANCELADA',0,1,3),(6,'2024-03-28 15:30:20.000000','CONCLUIDA',29.75,2,1),(7,'2024-03-28 16:10:55.000000','EM_ANDAMENTO',34.8,3,2),(8,'2024-03-28 16:45:15.000000','CONCLUIDA',12.5,1,2);
/*!40000 ALTER TABLE `corrida` ENABLE KEYS */;
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
