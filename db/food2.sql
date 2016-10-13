-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 13, 2016 at 05:44 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `tblorder`
--

CREATE TABLE `tblorder` (
  `oid` int(11) NOT NULL,
  `order_status` text NOT NULL,
  `delivery_time` text NOT NULL,
  `delivery_location` text NOT NULL,
  `qty` int(11) NOT NULL,
  `price` double NOT NULL,
  `sid` int(11) NOT NULL,
  `iid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(3, 'Xitiz', 'Nakarmi', 'xitiz@gmail.com', '123456', 'Male', '1000 N', '1514324214', 'Admin', 1),
(4, 'adfasf', 'adfasdf', 'adsfasdf', 'asdfasdf', 'Male', 'adfasdf', 'adsfsadf', '1', 1),
(5, '', '', '', '', 'Male', '', '', '1', 1),
(6, '', '', '', '', 'Male', '', '', '1', 1),
(7, '', '', '', '', '-Select-', '', '', '1', 1),
(8, '', '', '', '', '-Select-', '', '', '1', 1);

--
-- Indexes for dumped tables
--

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
-- AUTO_INCREMENT for table `tblitems`
--
ALTER TABLE `tblitems`
  MODIFY `iid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tblorder`
--
ALTER TABLE `tblorder`
  MODIFY `oid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tblperson`
--
ALTER TABLE `tblperson`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
