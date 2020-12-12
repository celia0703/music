-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: music
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(20) NOT NULL,
  `adminpwd` varchar(20) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'hyl','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `albumId` int(11) NOT NULL AUTO_INCREMENT,
  `albumname` varchar(20) NOT NULL,
  `albumimg` varchar(255) DEFAULT NULL,
  `albumtime` date DEFAULT NULL,
  `singer_singername` varchar(20) NOT NULL,
  PRIMARY KEY (`albumId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (2,'lover','/music/album/lover.jpg','2019-11-08','taylor-swift'),(3,'1989','/music/album/wildest.jpg','2019-11-08','taylor-swift'),(4,'shape of you','/music/album/shape of you.jpg','2019-11-08','Ed Sheeran'),(6,'True Colors','/music/album/beautiful now.jpg','2019-11-08','ZEDD');
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(20) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `users_username` varchar(20) NOT NULL,
  `music_musicname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,NULL,NULL,'zhangsan','lover'),(2,NULL,NULL,'zhangsan','lover'),(3,NULL,NULL,'zhangsan','lover'),(4,NULL,NULL,'zhangsan','lover'),(5,NULL,NULL,'苏汉伟','lover'),(6,NULL,NULL,'黄大大','lover'),(7,NULL,NULL,'苏汉伟','lover'),(8,NULL,NULL,'苏汉伟','lover');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collections`
--

DROP TABLE IF EXISTS `collections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collections` (
  `collectionId` int(11) NOT NULL AUTO_INCREMENT,
  `music_musicname` varchar(20) NOT NULL,
  `users_username` varchar(20) NOT NULL,
  PRIMARY KEY (`collectionId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collections`
--

LOCK TABLES `collections` WRITE;
/*!40000 ALTER TABLE `collections` DISABLE KEYS */;
INSERT INTO `collections` VALUES (23,'Safe','苏汉伟'),(28,'lover','苏汉伟');
/*!40000 ALTER TABLE `collections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `users_username` varchar(20) NOT NULL,
  `music_musicname` varchar(20) NOT NULL,
  `text` varchar(255) NOT NULL,
  `time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (2,'苏汉伟','lover','非常非常的好听，值得下载收藏QVQ','2019-12-6 21:23:9'),(4,'苏汉伟','Safe&Sound','测试','2019-12-6 21:37:56'),(9,'黄大大','Wildest','灰常的好听哦QVQ','2019-12-8 19:34:26'),(17,'zhangsan','恋爱循环','fgsdf','2019-12-16 14:2:19');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `memberId` int(11) NOT NULL AUTO_INCREMENT,
  `users_username` varchar(20) NOT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`memberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music`
--

DROP TABLE IF EXISTS `music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `music` (
  `musicId` int(11) NOT NULL AUTO_INCREMENT,
  `musicname` varchar(20) NOT NULL,
  `musicurl` varchar(255) NOT NULL,
  `musicimg` varchar(255) DEFAULT NULL,
  `lrc` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `singer_singername` varchar(20) NOT NULL,
  `category_categoryname` varchar(20) DEFAULT NULL,
  `album_albumname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`musicId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music`
--

LOCK TABLES `music` WRITE;
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` VALUES (1,'lover','/music/songbook/Taylor Swift-Lover.mp3','/music/imgbook/lover.jpg','/music/lrcbook','欧美、流行、L','taylor-swift',NULL,'lover'),(2,'Wildest','/music/songbook/wildest.mp3','/music/imgbook/wildest.jpg',NULL,'欧美、流行、W','taylor-swift',NULL,'1989'),(3,'Safe&Sound','/music/songbook/SafeSound.mp3','/music/imgbook/Safe&Sound.jpg',NULL,'欧美、流行','taylor-swift',NULL,'lover'),(4,'绿色','/music/songbook/陈雪凝 - 绿色.mp3','/music/imgbook/绿色.jpg','/music/lrcbook','中国、L、流行乐','陈雪凝',NULL,NULL),(5,'深海少女','/music/songbook/初音ミク - 深海少女.mp3','/music/imgbook/深海少女.jpg','/music/lrcbook','日本、可爱、S','初音',NULL,NULL),(6,'可能否','/music/songbook/可能否.mp3','/music/imgbook/可能否.jpg','/music/lrcbook','网络流行、K','网络歌手',NULL,NULL),(7,'这一生关于你的风景','/music/songbook/枯木逢春 - 这一生关于你的风景.mp3','/music/imgbook/这一生关于你的风景.jpg','/music/lrcbook','流行','枯木逢春',NULL,NULL),(9,'飘向北方','/music/songbook/飘向北方.mp3','/music/imgbook/飘向北方.jpg','/music/lrcbook','流行乐、Rap、P','那吾克热、尤长靖',NULL,NULL),(10,'你的酒馆对我打了烊','/music/songbook/陈雪凝 - 你的酒馆对我打了烊.mp3','/music/imgbook/你的酒馆对我打了样.jpg','/music/lrcbook','流行乐、中国','陈雪凝',NULL,NULL),(11,'I knew you trouble','/music/songbook/Taylor Swift - I Knew You Were Trouble. [mqms2](1).mp3','/music/imgbook/i knew you were trouble.jpg','/music/lrcbook','欧美、流行、I','taylor-swift',NULL,'lover'),(12,'差不多的姑娘','/music/songbook/G.E.M. 邓紫棋 - 差不多姑娘.mp3','/music/imgbook/差不多姑娘.jpg','/music/lrcbook','港澳、流行乐、C','邓紫棋',NULL,NULL),(13,'恋爱循环','/music/songbook/花澤香菜 - 恋愛サーキュレーション (恋爱循环).mp3','/music/imgbook/国王与乞丐.jpg','/music/lrcbook','日本、可爱、L','dfd',NULL,NULL);
/*!40000 ALTER TABLE `music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend`
--

DROP TABLE IF EXISTS `recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommend` (
  `recommendId` int(11) NOT NULL AUTO_INCREMENT,
  `recname` varchar(20) DEFAULT NULL,
  `recimg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`recommendId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend`
--

LOCK TABLES `recommend` WRITE;
/*!40000 ALTER TABLE `recommend` DISABLE KEYS */;
INSERT INTO `recommend` VALUES (1,'第一张','/music/imgindex/mc_img5.jpeg'),(2,'第二张','/music/imgindex/mc_img1.jpg'),(3,'第三张','/music/imgindex/mc_img2.jpeg'),(4,'第四张','/music/imgindex/mc_img3.jpeg');
/*!40000 ALTER TABLE `recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `singers`
--

DROP TABLE IF EXISTS `singers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `singers` (
  `singerId` int(11) NOT NULL AUTO_INCREMENT,
  `singername` varchar(20) NOT NULL,
  `gender` char(2) DEFAULT NULL,
  `singerimg` varchar(255) DEFAULT NULL,
  `catename` varchar(255) DEFAULT NULL,
  `initial` char(2) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`singerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `singers`
--

LOCK TABLES `singers` WRITE;
/*!40000 ALTER TABLE `singers` DISABLE KEYS */;
/*!40000 ALTER TABLE `singers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `userpwd` varchar(20) NOT NULL,
  `gender` char(2) NOT NULL,
  `age` int(11) NOT NULL,
  `number` varchar(11) NOT NULL,
  `regtime` date NOT NULL,
  `userimg` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'苏汉伟','123','男',19,'1666666666','2019-10-31','/music/touxiang/f275066763b54ec88e500481e599c340!400x400.jpeg','非会员'),(2,'zhangsan','123','男',19,'111111111','2019-10-31','/music/touxiang/001f41eb0ff94528902a6d64215fa528!400x400.jpeg','会员'),(3,'黄大大','123','女',20,'13696256366','2019-10-31','/music/touxiang/94b2e734619a400e91db8b7802ad490b!400x400.jpeg','非会员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-16 14:09:24
