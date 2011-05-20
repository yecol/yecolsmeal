-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 20, 2011 at 01:46 ����
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
  `branchLocation` varchar(150) NOT NULL DEFAULT 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA',
  `branchDeliveryArea` varchar(1024) NOT NULL,
  `areaType` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bid`),
  KEY `branch_merchant` (`mid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`bid`, `mid`, `branchName`, `branchAddress`, `branchPhone`, `branchLocation`, `branchDeliveryArea`, `areaType`) VALUES
(1, 1, '学院路店', '学院路32号', '010-21051111', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/VQwblzVEBdGWqLjxTb', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAAdwQAAAAK\r\neA==', 0),
(2, 1, '学知桥店', '学之桥323号', '010-20111111', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/VQwblzVEBdGWqLjxTb', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAAdwQAAAAK\r\neA==', 0),
(3, 1, '北航店', '北航22号', '021-06325152', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHBAQ/VQwblzVEBdGWqLjxTb', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAAdwQAAAAK\r\neA==', 0),
(4, 1, '朝阳店', '朝阳区CBD12号', '123456', 'rO0ABXNyACdjb20ucXEuY3N0YXIuc3BlZWR5bWVhbC5lbnRpdHkuTG9jYXRpb27ax9u7lpO6BAIA\r\nAkQACGxhdGl0dWRlRAAJbG9uZ2l0dWRleHAAAAAAAAAAAAAAAAAAAAAA', 'rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAAK\r\nc3IAJ2NvbS5xcS5jc3Rhci5zcGVlZHltZWFsLmVudGl0eS5Mb2NhdGlvbtrH27uWk7oEAgACRAAI\r\nbGF0aXR1ZGVEAAlsb25naXR1ZGV4cAAAAAAAAAAAAAAAAAAAAAB4', 0);

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
  `md_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`meid`),
  KEY `menu_merchant` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `menu`
--


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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `merchant`
--

INSERT INTO `merchant` (`mid`, `username`, `pwd`, `email`, `phone`, `address`, `companyName`, `status`, `credits`, `cr_timestamp`) VALUES
(1, 'kfc', 'e10adc3949ba59abbe56e057f20f883e', 'kfc@gmail.com', '15098716541', '北京市海淀区万寿路7号', '北京肯德基有限责任公司', 0, 0, '2011-05-15 13:54:53'),
(2, 'pizzahut', 'e10adc3949ba59abbe56e057f20f883e', 'pizzahut@gmail.com', '021-21519652', '北京市海淀区中关村大厦', '必胜客食品有限公司', 0, 0, '2011-05-15 15:29:28'),
(3, 'wpj', 'e10adc3949ba59abbe56e057f20f883e', 'waipojia@gmail.com', '15968847561', NULL, '杭州市外婆家餐饮有限公司', 0, 0, '2011-05-20 11:08:43'),
(4, 'wpj', 'e10adc3949ba59abbe56e057f20f883e', 'waipojia@gmail.com', '15968847561', NULL, '杭州市外婆家餐饮有限公司', 0, 0, '2011-05-20 11:09:25');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `mid` int(10) NOT NULL,
  `status` int(5) NOT NULL,
  `orderTime` datetime NOT NULL,
  `orderItems` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `order_merchant` (`mid`),
  KEY `order_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `order`
--


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
  `location` varchar(100) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `cr_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `username`, `pwd`, `email`, `phone`, `credit`, `status`, `location`, `address`, `cr_timestamp`) VALUES
(3, 'ddolphin', 'e10adc3949ba59abbe56e057f20f883e', 'xujb1987@gmail.com', '18967095126', 0, 0, 'rO0ABXA=', '学院路37号北京航空航天大学新主楼', '0000-00-00 00:00:00'),
(4, 'zhouyi', 'e10adc3949ba59abbe56e057f20f883e', 'zhouyi@qq.com', '15011211654', 0, 0, 'rO0ABXA=', '北京市海淀区花园路12号', '2011-05-15 13:50:58'),
(5, 'yecol', 'e10adc3949ba59abbe56e057f20f883e', 'yecol@live.cn', '15848295126', 0, 0, 'rO0ABXA=', '北京市海淀区学知桥', '2011-05-15 13:51:51');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `branch`
--
ALTER TABLE `branch`
  ADD CONSTRAINT `branch_merchant` FOREIGN KEY (`mid`) REFERENCES `merchant` (`mid`) ON DELETE CASCADE;

--
-- Constraints for table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_merchant` FOREIGN KEY (`mid`) REFERENCES `merchant` (`mid`) ON DELETE CASCADE;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_merchant` FOREIGN KEY (`mid`) REFERENCES `merchant` (`mid`),
  ADD CONSTRAINT `order_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
