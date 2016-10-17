-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 17, 2016 at 08:35 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbldelivery`
--

CREATE TABLE `tbldelivery` (
  `did` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  `cname` text NOT NULL,
  `address` text NOT NULL,
  `city` text NOT NULL,
  `state` text NOT NULL,
  `zip` text NOT NULL,
  `phone` text NOT NULL,
  `status` text NOT NULL,
  `longtitude` text,
  `latitude` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldelivery`
--

INSERT INTO `tbldelivery` (`did`, `oid`, `cname`, `address`, `city`, `state`, `zip`, `phone`, `status`, `longtitude`, `latitude`) VALUES
(1, 32, 'dafd', 'dafd', 'adfasd', 'fasdfa', 'dfadsfa', 'adsfadsf', 'New', 'asdfadsf', 'asdfasdf'),
(2, 32, '', '', '', '', '', '', 'New', '', ''),
(3, 32, '', '', '', '', '', '', 'New', '', ''),
(4, 32, 'dadf', 'aadf', 'adfad', 'adf', 'adf', 'adf', 'New', 'adf', 'dadf'),
(5, 32, '', '', '', '', '', '', 'New', '', ''),
(6, 32, 'dafd', 'adfasd', 'fasdfas', 'dfasdf', 'adfsdf', 'asdfdsf', 'New', '', ''),
(7, 55, ' ', '', '', '', '', '', 'New', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tblitems`
--

CREATE TABLE `tblitems` (
  `iid` int(11) NOT NULL,
  `item_name` text NOT NULL,
  `identifier` text NOT NULL,
  `description` text NOT NULL,
  `price` double NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblitems`
--

INSERT INTO `tblitems` (`iid`, `item_name`, `identifier`, `description`, `price`, `image`) VALUES
(1, 'Momo', 'Nepali', 'Tasty food', 200, 'momo.jpg'),
(2, 'Kokko', 'Cambodia', 'Yummy', 300, 'food.jpg'),
(3, 'McChicken', 'American', 'Chicken Burger', 1.27, 'mcchicken.jpg'),
(4, 'afasdfasdf', 'American', 'adfdfasdf', 1234124, '^DF5790B90E2EFBB2CD7DC279DF804BACF5BE10B6D73F53AB6B^pimgpsh_fullsize_distr.jpg'),
(5, 'adfadsf', 'American', 'dafdfsd11111', 1111, 'konoha-logo-naruto-real-time_71385.jpg'),
(6, 'adfadsf', 'American', 'adsfasdf', 11111, 'konoha-logo-naruto-real-time_71385.jpg'),
(7, 'adasdf', 'American', 'dafdsf', 223, 'konoha-logo-naruto-real-time_71385.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tblorder`
--

CREATE TABLE `tblorder` (
  `oid` int(11) NOT NULL,
  `order_status` text NOT NULL,
  `delivery_time` text,
  `delivery_location` text,
  `qty` int(11) NOT NULL,
  `price` double NOT NULL,
  `sid` int(11) NOT NULL,
  `iid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblorder`
--

INSERT INTO `tblorder` (`oid`, `order_status`, `delivery_time`, `delivery_location`, `qty`, `price`, `sid`, `iid`) VALUES
(1, 'New', '', '', 2, 12, 9, 3),
(2, 'New', '', '', 3, 50, 9, 2),
(3, 'New', NULL, NULL, 1, 300, 8, 2),
(4, 'New', NULL, NULL, 1, 300, 0, 2),
(5, 'New', NULL, NULL, 1, 300, 1, 2),
(6, 'New', NULL, NULL, 1, 300, 2, 2),
(7, 'New', NULL, NULL, 1, 300, 4, 2),
(8, 'New', NULL, NULL, 1, 300, 5, 2),
(9, 'New', NULL, NULL, 1, 300, 6, 2),
(10, 'New', NULL, NULL, 1, 300, 7, 2),
(11, 'New', NULL, NULL, 1, 300, 8, 2),
(12, 'New', NULL, NULL, 1, 300, 9, 2),
(13, 'New', NULL, NULL, 1, 300, 9, 2),
(14, 'New', NULL, NULL, 3, 300, 9, 2),
(15, 'New', NULL, NULL, 3, 200, 9, 1),
(16, 'New', NULL, NULL, 3, 1.27, 9, 3),
(17, 'New', NULL, NULL, 3, 300, 1, 2),
(18, 'New', NULL, NULL, 3, 300, 2, 2),
(19, 'New', NULL, NULL, 3, 300, 4, 2),
(20, 'New', NULL, NULL, 3, 300, 5, 2),
(21, 'New', NULL, NULL, 3, 300, 6, 2),
(22, 'New', NULL, NULL, 3, 300, 7, 2),
(23, 'New', NULL, NULL, 3, 300, 8, 2),
(24, 'New', NULL, NULL, 3, 300, 9, 2),
(25, 'New', NULL, NULL, 5, 200, 1, 1),
(26, 'New', NULL, NULL, 5, 200, 2, 1),
(27, 'New', NULL, NULL, 5, 200, 4, 1),
(28, 'New', NULL, NULL, 5, 200, 5, 1),
(29, 'New', NULL, NULL, 5, 200, 6, 1),
(30, 'New', NULL, NULL, 5, 200, 7, 1),
(31, 'New', NULL, NULL, 5, 200, 8, 1),
(32, 'New', NULL, NULL, 5, 200, 9, 1),
(33, 'New', NULL, NULL, 4, 1.27, 1, 3),
(34, 'New', NULL, NULL, 4, 1.27, 2, 3),
(35, 'New', NULL, NULL, 4, 1.27, 4, 3),
(36, 'New', NULL, NULL, 4, 1.27, 5, 3),
(37, 'New', NULL, NULL, 4, 1.27, 6, 3),
(38, 'New', NULL, NULL, 4, 1.27, 7, 3),
(39, 'New', NULL, NULL, 4, 1.27, 8, 3),
(40, 'New', NULL, NULL, 4, 1.27, 9, 3),
(41, 'New', NULL, NULL, 3, 300, 1, 2),
(42, 'New', NULL, NULL, 3, 300, 2, 2),
(43, 'New', NULL, NULL, 3, 300, 4, 2),
(44, 'New', NULL, NULL, 3, 300, 5, 2),
(45, 'New', NULL, NULL, 3, 300, 6, 2),
(46, 'New', NULL, NULL, 3, 300, 7, 2),
(47, 'New', NULL, NULL, 3, 300, 8, 2),
(48, 'New', NULL, NULL, 3, 300, 9, 2),
(49, 'New', NULL, NULL, 1, 200, 1, 1),
(50, 'New', NULL, NULL, 1, 200, 2, 1),
(51, 'New', NULL, NULL, 1, 200, 4, 1),
(52, 'New', NULL, NULL, 1, 200, 5, 1),
(53, 'New', NULL, NULL, 1, 200, 6, 1),
(54, 'New', NULL, NULL, 1, 200, 7, 1),
(55, 'New', NULL, NULL, 1, 200, 8, 1),
(56, 'New', NULL, NULL, 1, 200, 9, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblperson`
--

CREATE TABLE `tblperson` (
  `cid` int(11) NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `gender` text NOT NULL,
  `address` text NOT NULL,
  `contact_number` text NOT NULL,
  `access_level` text NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblperson`
--

INSERT INTO `tblperson` (`cid`, `firstname`, `lastname`, `email`, `password`, `gender`, `address`, `contact_number`, `access_level`, `status`) VALUES
(1, 'adsfsaf', 'adfsaf', 'asfasdfa', 'sdfasdfasdf', 'Male', 'asdfsadf', 'asdfasf', 'Admin', 1),
(2, 'Sanzeev', 'Khatri', 'sanzeev@gmail.com', '123456', 'Male', '1000 N 4th St', '123412342134', 'Admin', 1),
(4, 'adfasf', 'adfasdf', 'adsfasdf', 'asdfasdf', 'Male', 'adfasdf', 'adsfsadf', '1', 2),
(5, '', '', '', '', 'Male', '', '', '1', 1),
(6, '', '', '', '', 'Male', '', '', '1', 1),
(7, '', '', '', '', '-Select-', '', '', '1', 1),
(8, '', '', '', '', '-Select-', '', '', '1', 1),
(9, 'Sovichea', 'Cheth', 'vichea@gmail.com', '123456', 'Male', '1000 N 4th St', '5153055842', '1', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbldelivery`
--
ALTER TABLE `tbldelivery`
  ADD PRIMARY KEY (`did`);

--
-- Indexes for table `tblitems`
--
ALTER TABLE `tblitems`
  ADD PRIMARY KEY (`iid`);

--
-- Indexes for table `tblorder`
--
ALTER TABLE `tblorder`
  ADD PRIMARY KEY (`oid`);

--
-- Indexes for table `tblperson`
--
ALTER TABLE `tblperson`
  ADD PRIMARY KEY (`cid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbldelivery`
--
ALTER TABLE `tbldelivery`
  MODIFY `did` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tblitems`
--
ALTER TABLE `tblitems`
  MODIFY `iid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tblorder`
--
ALTER TABLE `tblorder`
  MODIFY `oid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT for table `tblperson`
--
ALTER TABLE `tblperson`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
