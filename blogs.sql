-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 26, 2019 at 04:38 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blogs`
--

-- --------------------------------------------------------

--
-- Table structure for table `blogs`
--

CREATE TABLE `blogs` (
  `id` int(11) NOT NULL,
  `registration_id` varchar(200) NOT NULL,
  `title` text NOT NULL,
  `description` longtext NOT NULL,
  `status` tinyint(10) NOT NULL DEFAULT '1',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blogs`
--

INSERT INTO `blogs` (`id`, `registration_id`, `title`, `description`, `status`, `created_date`) VALUES
(1, '1', 'test', 'A constructor is similar to a method (but not actually a method) that is invoked automatically when an object is instantiated.', 1, '2019-06-25 08:16:53'),
(2, '1', 'testBlog', 'A constructor is similar to a method (but not actually a method) that is invoked automatically when an object is instantiated.\r\nA constructor is similar to a method (but not actually a method) that is invoked automatically when an object is instantiated.\r\n', 1, '2019-06-25 08:16:53'),
(3, '3', 'testBlog111', 'A constructor is similar to a method (but not actually a method) that is invoked automatically when an object is instantiated.\r\nA constructor is similar to a method (but not actually a method) that is invoked automatically when an object is instantiated.\r\n', 1, '2019-06-25 08:16:53');

-- --------------------------------------------------------

--
-- Table structure for table `registrations`
--

CREATE TABLE `registrations` (
  `registration_id` int(11) NOT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registrations`
--

INSERT INTO `registrations` (`registration_id`, `full_name`, `email`, `password`, `created_at`, `updated_at`) VALUES
(1, 'Sankar', 'sankar', '827ccb0eea8a706c4c34a16891f84e7b', '2019-06-25 12:49:31', '2019-06-25 13:53:02'),
(2, NULL, 'sabari', '827ccb0eea8a706c4c34a16891f84e7b', '2019-06-25 17:30:19', '2019-06-25 17:30:19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blogs`
--
ALTER TABLE `blogs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registrations`
--
ALTER TABLE `registrations`
  ADD PRIMARY KEY (`registration_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blogs`
--
ALTER TABLE `blogs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `registrations`
--
ALTER TABLE `registrations`
  MODIFY `registration_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
