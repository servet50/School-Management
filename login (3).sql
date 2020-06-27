-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 26, 2020 at 10:31 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login`
--

-- --------------------------------------------------------

--
-- Table structure for table `addinglesson`
--

DROP TABLE IF EXISTS `addinglesson`;
CREATE TABLE IF NOT EXISTS `addinglesson` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `First_Lesson` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Second_Lesson` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Third_Lesson` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Fourth_Lesson` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Fifth_Lesson` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Sixth_Lesson` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Seventh_Lesson` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64646546 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Dumping data for table `addinglesson`
--

INSERT INTO `addinglesson` (`student_id`, `First_Lesson`, `Second_Lesson`, `Third_Lesson`, `Fourth_Lesson`, `Fifth_Lesson`, `Sixth_Lesson`, `Seventh_Lesson`) VALUES
(33, 'Software Development', '0', '0', '0', '0', '0', '0'),
(54, '0', '0', '0', '0', '0', '0', '0'),
(75, '0', '0', '0', '0', '0', '0', '0'),
(99, '0', '0', '0', '0', '0', '0', '0'),
(148, 'Computer Networks', 'Software Development', 'Java Programming', 'Operating System', 'Virtualization Technologies', 'Biometric System', 'Intership'),
(155, 'Computer Networks', 'Software Development', 'Java Programming', 'Operating System', 'Virtualization Technologies', 'Biometric System', 'CSS and Bootstrap Web Design'),
(165, '0', '0', '0', '0', '0', '0', '0'),
(2373, 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks'),
(2525, 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks'),
(2828, 'Computer Networks', 'Software Development', 'Java Programming', 'Operating System', 'Virtualization Technologies', 'Biometric System', 'Intership'),
(3434, 'Computer Networks', 'CSS and Bootstrap Web Design', 'Operating System', 'Virtualization Technologies', 'Biometric System', 'Java Programming', 'Virtualization Technologies'),
(3435, 'Operating System', 'Computer Networks', 'Virtualization Technologies', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'CSS and Bootstrap Web Design'),
(4523, 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks'),
(5896, '1', '0', '0', '0', '0', '0', '0'),
(6363, 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks'),
(7333, 'Computer Networks', 'Software Development', 'Java Programming', 'Operating System', 'Virtualization Technologies', 'Biometric System', 'Intership'),
(7373, 'Computer Networks', 'Software Development', 'Java Programming', 'Operating System', 'Biometric System', 'Intership', 'CSS and Bootstrap Web Design'),
(8787, '3', '0', '0', '0', '0', '0', '0'),
(8989, 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks', 'Computer Networks');

-- --------------------------------------------------------

--
-- Table structure for table `dblogin`
--

DROP TABLE IF EXISTS `dblogin`;
CREATE TABLE IF NOT EXISTS `dblogin` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8mb4_turkish_ci NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_turkish_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5251516 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Dumping data for table `dblogin`
--

INSERT INTO `dblogin` (`user_id`, `name`, `password`) VALUES
(7333, 'servet', '1234'),
(3, 'maryam50', '1234'),
(4, 'maryam50', '1234'),
(5, '222', '1234'),
(6, '123123123', '1234'),
(5251515, 'sdqf', '51515'),
(6363, 'ali', '1234'),
(5896, 'servet58', '1234'),
(8787, 'servet870', '1234'),
(89, 'ozcan', '1234'),
(99, 'zelal', '1234'),
(33, 'ozan', '1234'),
(2525, 'ayca', '1234'),
(155, 'anil', '1234'),
(7373, 'servet73', '1234'),
(8989, 'elvin73', '1234'),
(4523, 'elaz?g', '1234'),
(2373, 'ahmet', '1234'),
(2828, 'servet50', '1234'),
(148, 'servet55', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
CREATE TABLE IF NOT EXISTS `lesson` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `computer` int(11) NOT NULL,
  `software` int(11) NOT NULL,
  `java` int(11) NOT NULL,
  `operating` int(11) NOT NULL,
  `virtu` int(11) NOT NULL,
  `biometric` int(11) NOT NULL,
  `intership` int(11) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8991 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Dumping data for table `lesson`
--

INSERT INTO `lesson` (`student_id`, `computer`, `software`, `java`, `operating`, `virtu`, `biometric`, `intership`) VALUES
(1, 5, 5, 5, 5, 5, 5, 5),
(2, 55, 55, 78, 77, 78, 34, 33),
(3, 98, 45, 45, 88, 77, 23, 23),
(4, 20, 1, 1, 1, 1, 12, 21),
(5, 85, 5, 88, 8, 77, 87, 87),
(6, 85, 5, 88, 8, 77, 87, 87),
(7, 54, 55, 51, 15, 515, 51, 5),
(8, 54, 4, 45, 5, 5, 4, 45),
(9, 20, 2, 2, 2, 2, 2, 2),
(10, 54, 6, 6, 6, 6, 66, 66),
(11, 54, 6, 6, 6, 6, 66, 66),
(12, 2, 2, 2, 32, 2, 23, 44),
(13, 2, 2, 2, 32, 2, 23, 44),
(14, 20, 40, 52, 25, 44, 56, 55),
(15, 98, 90, 90, 88, 78, 89, 79),
(8989, 98, 98, 98, 98, 98, 98, 98),
(8990, 9, 88, 8, 8, 8, 8, 8),
(7333, 98, 98, 98, 98, 98, 98, 98),
(155, 78, 78, 78, 78, 78, 78, 78),
(2525, 78, 7, 7, 7, 7, 7, 7),
(4523, 45, 9, 41, 40, 56, 8, 9),
(6363, 78, 78, 78, 78, 78, 78, 78),
(2828, 98, 98, 98, 98, 98, 98, 98),
(148, 85, 85, 85, 85, 85, 85, 85);

-- --------------------------------------------------------

--
-- Table structure for table `teacherlogin`
--

DROP TABLE IF EXISTS `teacherlogin`;
CREATE TABLE IF NOT EXISTS `teacherlogin` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8mb4_turkish_ci NOT NULL,
  `password` int(45) NOT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Dumping data for table `teacherlogin`
--

INSERT INTO `teacherlogin` (`teacher_id`, `username`, `password`) VALUES
(1, 'maryam25', 1234),
(2, 'maryam', 1234);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `surname` char(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `password` int(11) NOT NULL,
  `date` int(11) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `faculty` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  `department` varchar(40) COLLATE utf8mb4_turkish_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=123123124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `surname`, `password`, `date`, `phone_number`, `faculty`, `department`) VALUES
(2828, 'servet50', 'ozden', 1234, 250120, 54323152, 'mhndslk', 'computer'),
(148, 'servet55', 'ozden', 1234, 252512, 542552, 'muhendislik', 'computer'),
(2525, 'ayca', 'sahsuvar', 1234, 5896, 51515, 'asgsg', 'sdgsdg'),
(155, 'anil', 'tirak', 1234, 45464, 6565, 'sdgsdg', 'SDGSH'),
(7333, 'servet', 'ozden', 1234, 4151, 151651, 'fagfag', 'agasdg'),
(165050, 'servet', 'ozden', 1234, 252525, 626265, 'safsdg', 'sdgsg'),
(8989, 'elvin73', 'ozden', 1234, 5455, 54845, 'dfsg', 'gsgh'),
(2373, 'ahmet', 'ihsan', 1234, 4548, 324325, 'dsfsdg', 'sdgsh');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
