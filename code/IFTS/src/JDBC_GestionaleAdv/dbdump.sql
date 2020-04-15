CREATE DATABASE  IF NOT EXISTS `ecommerce`;
USE `ecommerce`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acc`
--

DROP TABLE IF EXISTS `acc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `acc` (
  `codProd` varchar(10) NOT NULL,
  PRIMARY KEY (`codProd`),
  CONSTRAINT `f3` FOREIGN KEY (`codProd`) REFERENCES `prodotto` (`idprodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acc`
--

LOCK TABLES `acc` WRITE;
/*!40000 ALTER TABLE `acc` DISABLE KEYS */;
INSERT INTO `acc` VALUES ('p4'),('p5'),('p6');
/*!40000 ALTER TABLE `acc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `associazione`
--

DROP TABLE IF EXISTS `associazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `associazione` (
  `codProd` varchar(10) NOT NULL,
  `codAcc` varchar(10) NOT NULL,
  PRIMARY KEY (`codProd`,`codAcc`),
  KEY `f5_idx` (`codAcc`),
  CONSTRAINT `f4` FOREIGN KEY (`codProd`) REFERENCES `standalone` (`codProd`),
  CONSTRAINT `f5` FOREIGN KEY (`codAcc`) REFERENCES `acc` (`codProd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `associazione`
--

LOCK TABLES `associazione` WRITE;
/*!40000 ALTER TABLE `associazione` DISABLE KEYS */;
INSERT INTO `associazione` VALUES ('p3','p4'),('p2','p5'),('p1','p6');
/*!40000 ALTER TABLE `associazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contiene`
--

DROP TABLE IF EXISTS `contiene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contiene` (
  `codFoto` int(11) NOT NULL,
  `codProd` varchar(45) NOT NULL,
  PRIMARY KEY (`codFoto`,`codProd`),
  KEY `f6_idx` (`codProd`),
  CONSTRAINT `f6` FOREIGN KEY (`codProd`) REFERENCES `prodotto` (`idprodotto`),
  CONSTRAINT `f7` FOREIGN KEY (`codFoto`) REFERENCES `foto` (`codFoto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contiene`
--

LOCK TABLES `contiene` WRITE;
/*!40000 ALTER TABLE `contiene` DISABLE KEYS */;
INSERT INTO `contiene` VALUES (1,'p1'),(2,'p2'),(3,'p3'),(4,'p4');
/*!40000 ALTER TABLE `contiene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `di`
--

DROP TABLE IF EXISTS `di`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `di` (
  `codProd` varchar(10) NOT NULL,
  `num` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `qta` int(11) DEFAULT NULL,
  PRIMARY KEY (`codProd`,`num`,`username`),
  KEY `f11_idx` (`num`,`username`),
  CONSTRAINT `f10` FOREIGN KEY (`codProd`) REFERENCES `prodotto` (`idprodotto`),
  CONSTRAINT `f11` FOREIGN KEY (`num`, `username`) REFERENCES `scelta` (`num`, `username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `di`
--

LOCK TABLES `di` WRITE;
/*!40000 ALTER TABLE `di` DISABLE KEYS */;
INSERT INTO `di` VALUES ('p1',9,'michaelm1',3),('p2',9,'michaelm1',5),('p2',11,'giuliag1',4),('p2',13,'michaelm1',6),('p4',12,'jacopoj1',8),('p5',9,'michaelm1',2);
/*!40000 ALTER TABLE `di` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `foto` (
  `codFoto` int(11) NOT NULL,
  `descr` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codFoto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
INSERT INTO `foto` VALUES (1,'descr',NULL),(2,'descr3',NULL),(3,'descr4',NULL),(4,'descr56',NULL),(5,'efekekfhj',NULL),(6,'2erjnwiueh',NULL),(7,'dfejgke kjghk',NULL),(8,'dfgd',NULL);
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indirizzi`
--

DROP TABLE IF EXISTS `indirizzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `indirizzi` (
  `codInd` varchar(10) NOT NULL,
  `via` varchar(45) DEFAULT NULL,
  `cap` int(11) DEFAULT NULL,
  `citta` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codInd`),
  KEY `f13_idx` (`username`),
  CONSTRAINT `f13` FOREIGN KEY (`username`) REFERENCES `utente` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indirizzi`
--

LOCK TABLES `indirizzi` WRITE;
/*!40000 ALTER TABLE `indirizzi` DISABLE KEYS */;
INSERT INTO `indirizzi` VALUES ('ind1','ferrara',61122,'pesaro','michaelm1'),('ind2','cento',44045,'cento','jacopoj1'),('ind3','nuova',44045,'ferrara','giuliag1'),('ind4','vecchia',44100,'modena','michaelm1');
/*!40000 ALTER TABLE `indirizzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pagamento` (
  `codPag` varchar(10) NOT NULL,
  `descr` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codPag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES ('pag1','descr1'),('pag2','descr2'),('pag3','descr3');
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prodotto` (
  `idprodotto` varchar(10) NOT NULL,
  `disponibilita` int(11) DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `prezzo` varchar(10) DEFAULT NULL,
  `codTipo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idprodotto`),
  KEY `f1_idx` (`codTipo`),
  CONSTRAINT `f1` FOREIGN KEY (`codTipo`) REFERENCES `tipologia` (`codTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES ('p1',30,'descr1','23','t1'),('p2',23,'descr2','54','t1'),('p3',45,'descr3','23','t2'),('p4',12,'descr4','56','t3'),('p5',3,'descr5','123','t2'),('p6',45,'descr6','48','t1'),('p7',10,'descr7','68','t3');
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scelta`
--

DROP TABLE IF EXISTS `scelta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `scelta` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `data` varchar(10) DEFAULT NULL,
  `codPag` varchar(10) DEFAULT NULL,
  `num_ord` int(11) DEFAULT NULL,
  `data_pag` varchar(10) DEFAULT NULL,
  `data_consegna` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`num`,`username`),
  KEY `f8_idx` (`username`),
  KEY `f9_idx` (`codPag`),
  CONSTRAINT `f8` FOREIGN KEY (`username`) REFERENCES `utente` (`username`),
  CONSTRAINT `f9` FOREIGN KEY (`codPag`) REFERENCES `pagamento` (`codPag`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scelta`
--

LOCK TABLES `scelta` WRITE;
/*!40000 ALTER TABLE `scelta` DISABLE KEYS */;
INSERT INTO `scelta` VALUES (9,'michaelm1','10/9/19','pag1',1,'9/9/19','12/9/19'),(10,'michaelm1','10/9/19','pag2',2,'8/9/19','11/9/19'),(11,'giuliag1','9/9/19','pag3',3,'10/9/19','10/9/19'),(12,'jacopoj1','11/9/19','pag1',4,'12/9/19','15/9/19'),(13,'michaelm1','12/9/19',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `scelta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standalone`
--

DROP TABLE IF EXISTS `standalone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `standalone` (
  `codProd` varchar(10) NOT NULL,
  PRIMARY KEY (`codProd`),
  CONSTRAINT `f2` FOREIGN KEY (`codProd`) REFERENCES `prodotto` (`idprodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standalone`
--

LOCK TABLES `standalone` WRITE;
/*!40000 ALTER TABLE `standalone` DISABLE KEYS */;
INSERT INTO `standalone` VALUES ('p1'),('p2'),('p3');
/*!40000 ALTER TABLE `standalone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipologia`
--

DROP TABLE IF EXISTS `tipologia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipologia` (
  `codTipo` varchar(10) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologia`
--

LOCK TABLES `tipologia` WRITE;
/*!40000 ALTER TABLE `tipologia` DISABLE KEYS */;
INSERT INTO `tipologia` VALUES ('t1','descr1'),('t2','descr2'),('t3','descr3');
/*!40000 ALTER TABLE `tipologia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente` (
  `username` varchar(45) NOT NULL,
  `codfisc` varchar(16) NOT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `codfisc_UNIQUE` (`codfisc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('giuliag1','g1','qwerty','giulia'),('jacopoj1','j1','qwerty','jacopo'),('michaelm1','m1','qwerty','michael');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-17 11:42:12
