-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 05, 2011 at 07:55 ����
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `speedymealdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
CREATE TABLE IF NOT EXISTS `branch` (
  `bid` int(10) NOT NULL AUTO_INCREMENT,
  `mid` int(10) NOT NULL,
  `branchName` varchar(100) NOT NULL,
  `branchAddress` varchar(200) NOT NULL,
  `branchPhone` varchar(20) NOT NULL,
  `branchLocation` varchar(1024) NOT NULL DEFAULT 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA',
  `branchDeliveryArea` varchar(2048) NOT NULL,
  `areaType` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bid`),
  KEY `branch_merchant` (`mid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`bid`, `mid`, `branchName`, `branchAddress`, `branchPhone`, `branchLocation`, `branchDeliveryArea`, `areaType`) VALUES
(27, 7, '大运村店', '海淀区知春路29号大运村学生公寓底层东侧商铺', '010-82357298', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/0OmcmUuEBdFgUPHwH1', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAHdwQAAAAK\r\nc3IAJ2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5Mb2NhdGlvbtrH27uWk7oEAgACRAAI\r\nbGF0aXR1ZGVEAAlsb25naXR1ZGV4cEBD/QxesxO+QF0XZ3cHnlpzcQB+AAJAQ/5jH4oJA0BdF17x\r\n/d6+c3EAfgACQEP+NedCmdlAXRTujRD1G3NxAH4AAkBD/ZIQOFxoQF0U9EkSmIlzcQB+AAJAQ/2S\r\nEDhcaEBdFVmJ3xFzc3EAfgACQEP75SFXaJ1AXRVglWwNb3NxAH4AAkBD++lj3EhrQF0XYbsF+ux4\r\n', 0),
(28, 7, '学院南路店', '北京市西城区西直门北大街32号枫蓝国际购物中心B座1楼', '010-62275657', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/nY9kE2qEBdFrc1S7MA', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAOdwQAAAAQ\r\nc3IAJ2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5Mb2NhdGlvbtrH27uWk7oEAgACRAAI\r\nbGF0aXR1ZGVEAAlsb25naXR1ZGV4cEBD+94/u9eyQF0WsunMt9RzcQB+AAJAQ/vgiu+yq0BdF7AL\r\ny+Ydc3EAfgACQEP6nR9gF5hAXRe801qFiHNxAH4AAkBD+qfvnbItQF0YR+z+m3xzcQB+AAJAQ/nQ\r\nUpNKy0BdGEPUaybAc3EAfgACQEP5axHG0eFAXRgmLLpzLnNxAH4AAkBD+W0JF9a2QF0XysCDEm9z\r\ncQB+AAJAQ/hwuM+/xkBdF9YOlO45c3EAfgACQEP4UpNKyv9AXRaGBWgezXNxAH4AAkBD+M+/xlQN\r\nQF0WfDDTBqNzcQB+AAJAQ/lM7EHdGkBdFcxj8UEgc3EAfgACQEP54bCJoCdAXRV6zE74jHNxAH4A\r\nAkBD+pJPIn0DQF0VcnE2pAFzcQB+AAJAQ/vcSGrS3UBdFWAXl8w6eA==', 0),
(29, 7, '前门店', '北京市西城区前门西大街', '010-63034430', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/M7pvDMLEBdGXiKS8Mg', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAMdwQAAAAQ\r\nc3IAJ2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5Mb2NhdGlvbtrH27uWk7oEAgACRAAI\r\nbGF0aXR1ZGVEAAlsb25naXR1ZGV4cEBD81jiGWUsQF0axcE/0NBzcQB+AAJAQ/JRbbDdg0BdGst9\r\nQXQ/c3EAfgACQEPyQlruYyBAXRnPqs2ehHNxAH4AAkBD8e4kNWluQF0ZGkvboKVzcQB+AAJAQ/HW\r\njGkvb0BdF/ReC04Sc3EAfgACQEPzKV6eGwlAXRf0XgtOEnNxAH4AAkBD9CWu5jH5QF0X7sv7FbVz\r\ncQB+AAJAQ/Qn+hoM8kBdGQ79ycTbc3EAfgACQEPzRTjvNNdAXRkXgtOEd3NxAH4AAkBD81aW5Yoz\r\nQF0aCAc1fmdzcQB+AAJAQ/Q3DNyHVUBdGgPEsJ6Zc3EAfgACQEP0SGrS3LFAXRrF6zE74ng=', 0),
(30, 7, '左家庄店', '中国北京市朝阳区左家庄', '010-64686606', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/tHovQxBEBdHJ4fZ7NF', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAAK\r\nc3IAJ2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5Mb2NhdGlvbtrH27uWk7oEAgACRAAI\r\nbGF0aXR1ZGVEAAlsb25naXR1ZGV4cEBD+NZNfw7UQF0eNedCmdl4', 0),
(35, 9, '知春路店', '海淀区知春路29号大运村公寓7号楼底', '010-81828000', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/07PJClgEBdFd2OjEdh', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAAK\r\nc3IAJ2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5Mb2NhdGlvbtrH27uWk7oEAgACRAAI\r\nbGF0aXR1ZGVEAAlsb25naXR1ZGV4cEBD/K0D2alUQF0Wws5GSZB4', 0),
(36, 7, '魏公村店', '北京市海淀区魏公村路5号', '010-68428619', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/qWqaOoPEBdFJxu/NU5', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAAK\r\nc3IAJ2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5Mb2NhdGlvbtrH27uWk7oEAgACRAAI\r\nbGF0aXR1ZGVEAAlsb25naXR1ZGV4cEBD+Ktga3qiQF0V/GVAzHl4', 0),
(37, 7, '学院南路店', '海淀区学院南路50号', '010-62276698', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/qfyPseWEBdFmtmppBP', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAIdwQAAAAK\r\nc3IAJ2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5Mb2NhdGlvbtrH27uWk7oEAgACRAAI\r\nbGF0aXR1ZGVEAAlsb25naXR1ZGV4cEBD+9QXQ+lkQF0Wy6cy31BzcQB+AAJAQ/vhMrVe8kBdF64U\r\neuFIc3EAfgACQEP6ogmqo61AXRe9pRGc4HNxAH4AAkBD+XrMTviMQF0XvvSc9W9zcQB+AAJAQ/h1\r\noxpL3EBdFsYVIqb0c3EAfgACQEP5kmQbMotAXRWBMBZIQXNxAH4AAkBD+8lHBk7PQF0VVEuxrzpz\r\ncQB+AAJAQ/vUF0PpZEBdFr26ClJpeA==', 0),
(38, 11, '学院路店', '海淀区学院路甲38号长城电脑大厦', '010-82968118', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/2tCaE2sEBdFsN5XgBD', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAAK\r\nc3IAJ2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5Mb2NhdGlvbtrH27uWk7oEAgACRAAI\r\nbGF0aXR1ZGVEAAlsb25naXR1ZGV4cEBD/KODJ2dNQF0XsAvL5h14', 0);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `mid` int(10) NOT NULL,
  `bid` int(10) NOT NULL,
  `status` int(5) DEFAULT '0',
  `orderTime` datetime DEFAULT NULL,
  `orderItems` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `order_merchant` (`mid`),
  KEY `order_user` (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`oid`, `uid`, `mid`, `bid`, `status`, `orderTime`, `orderItems`) VALUES
(7, 13, 7, 27, 0, '2011-06-05 07:52:27', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAAK\r\nc3IAKGNvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5PcmRlckl0ZW3e0pbxz/rA1AIAAkkA\r\nBnBpZWNlc0wABG1lbnV0ACVMY29tL3FxL2NzdGFyL3NwZWVkeW1lYWwvZW50aXR5L01lbnU7eHAA\r\nAAABc3IAI2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5NZW51lSdoPkrDZ+cCAAVJAARt\r\nZWlkRAANbWVudUl0ZW1QcmljZUkAA21pZEwADG1lbnVJdGVtTmFtZXQAEkxqYXZhL2xhbmcvU3Ry\r\naW5nO0wAB21lbnVQaWNxAH4ABnhwAAAAD0AqAAAAAAAAAAAAB3QAD+WKsuiEhum4oeiFv+WgoXB4\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `meid` int(10) NOT NULL AUTO_INCREMENT,
  `mid` int(10) NOT NULL,
  `menuItemName` varchar(100) NOT NULL,
  `menuItemPrice` double(6,2) NOT NULL,
  `menuPic` varchar(100) DEFAULT NULL,
  `md_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`meid`),
  KEY `menu_merchant` (`mid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=32 ;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`meid`, `mid`, `menuItemName`, `menuItemPrice`, `menuPic`, `md_timestamp`) VALUES
(14, 7, '香辣鸡腿堡', 13.00, NULL, '2011-05-29 06:26:42'),
(15, 7, '劲脆鸡腿堡', 13.00, NULL, '2011-05-29 06:26:56'),
(16, 7, '奥尔良烤鸡腿堡', 14.00, NULL, '2011-05-29 11:49:49'),
(17, 7, '田园脆鸡堡', 8.50, NULL, '2011-05-29 06:28:30'),
(18, 7, '至珍全虾堡', 15.00, NULL, '2011-05-29 06:28:50'),
(19, 7, '川辣嫩牛五方', 14.50, NULL, '2011-05-29 06:29:00'),
(20, 9, '牛腩米粉套餐', 16.00, NULL, '2011-05-29 08:01:47'),
(21, 9, '卤菜米粉套餐', 16.00, NULL, '2011-05-29 08:02:39'),
(22, 9, '叉烧米粉套餐', 16.00, NULL, '2011-05-29 08:02:36'),
(24, 9, '锅烧米粉套餐', 16.00, NULL, '2011-05-29 08:02:46'),
(29, 11, '招牌牛肉饭/标', 17.50, NULL, '2011-06-01 13:46:02'),
(30, 11, '润烧东坡饭/标', 17.50, NULL, '2011-06-01 13:46:05'),
(31, 11, '山贼烧鸡饭/标', 18.50, NULL, '2011-06-01 13:46:11');

-- --------------------------------------------------------

--
-- Table structure for table `merchant`
--

DROP TABLE IF EXISTS `merchant`;
CREATE TABLE IF NOT EXISTS `merchant` (
  `mid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `pwd` varchar(130) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `companyName` varchar(100) NOT NULL,
  `status` int(10) DEFAULT NULL,
  `credits` int(10) DEFAULT NULL,
  `cr_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `merchant`
--

INSERT INTO `merchant` (`mid`, `username`, `pwd`, `email`, `phone`, `address`, `companyName`, `status`, `credits`, `cr_timestamp`) VALUES
(7, 'kfc', 'e10adc3949ba59abbe56e057f20f883e', 'kfc@gmail.com', '4008823823', '北京市', '肯德基（KFC）', 0, 0, '2011-05-29 10:55:35'),
(9, 'sgg', 'e10adc3949ba59abbe56e057f20f883e', 'admin@51guigui.com', '010-81828000', '海淀区知春路29号大运村公寓7号楼底', '爽！桂桂', 0, 0, '2011-05-29 10:55:48'),
(10, 'bsk', 'e10adc3949ba59abbe56e057f20f883e', 'bsk@gmail.com', '010-12345678', NULL, '必胜客', 0, 0, '2011-05-29 13:32:21'),
(11, 'jiyejia', 'e10adc3949ba59abbe56e057f20f883e', 'jiyejia@jyj.com', '010-670285388', NULL, '吉野家Yoshinoya', 0, 0, '2011-06-05 03:32:03');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `pwd` varchar(130) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `credit` int(11) unsigned DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `location` varchar(1024) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `cr_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `username`, `pwd`, `email`, `phone`, `credit`, `status`, `location`, `address`, `cr_timestamp`) VALUES
(13, 'yecol', 'e10adc3949ba59abbe56e057f20f883e', 'xujb1987@gmail.com', '15011019321', 0, 0, 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/3ScU7uqEBdFlHZ2VQX', '北京市海淀区学院路37号航空航天大学', '2011-05-29 08:37:03'),
(14, 'xujb', 'hello', '', NULL, 0, 0, NULL, NULL, '2011-06-05 07:36:44');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `branch`
--
ALTER TABLE `branch`
  ADD CONSTRAINT `branch_merchant` FOREIGN KEY (`mid`) REFERENCES `merchant` (`mid`) ON DELETE CASCADE;

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `order_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order_merchant` FOREIGN KEY (`mid`) REFERENCES `merchant` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_merchant` FOREIGN KEY (`mid`) REFERENCES `merchant` (`mid`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
