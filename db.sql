-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2020 at 01:57 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test1`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prix` float(7,2) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`id`, `nom`, `prix`, `quantite`) VALUES
(2, 'Article 2', 15.99, 10),
(3, 'article 3', 10.88, 100),
(4, 'test', 10.99, 50),
(5, 'test 2', 1.99, 16),
(6, 'test', 10.99, 99),
(7, 'article 7', 8.99, 15),
(8, 'article 3', 10.99, 10),
(9, 'Article 10', 8.00, 20);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `orders` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `orders`, `created_at`) VALUES
(1, '┌──────────────────────────────────────────────────────────────────────────────┐\r\n│Orders                                                                        │\r\n├───────────────────┬───────────────────┬───────────────────┬──────────────────┤\r\n│article            │prix d\'article     │quantite           │prix total        │\r\n├───────────────────┼───────────────────┼───────────────────┼──────────────────┤\r\n│article 3          │10.99 $            │2                  │21.98 $           │\r\n├───────────────────┴───────────────────┴───────────────────┼──────────────────┤\r\n│prix total                                                 │21.98 $           │\r\n├───────────────────────────────────────────────────────────┼──────────────────┤\r\n│cash                                                       │30.0 $            │\r\n├───────────────────────────────────────────────────────────┼──────────────────┤\r\n│a rendre                                                   │8.02 $            │\r\n└───────────────────────────────────────────────────────────┴──────────────────┘', '2020-12-11 16:00:03'),
(2, '┌──────────────────────────────────────────────────────────────────────────────┐\r\n│Orders                                                                        │\r\n├───────────────────┬───────────────────┬───────────────────┬──────────────────┤\r\n│article            │prix d\'article     │quantite           │prix total        │\r\n├───────────────────┼───────────────────┼───────────────────┼──────────────────┤\r\n│article 3          │10.88 $            │50                 │544.0 $           │\r\n├───────────────────┴───────────────────┴───────────────────┼──────────────────┤\r\n│prix total                                                 │544.0 $           │\r\n├───────────────────────────────────────────────────────────┼──────────────────┤\r\n│cash                                                       │0.0 $             │\r\n├───────────────────────────────────────────────────────────┼──────────────────┤\r\n│a rendre                                                   │0.0 $             │\r\n└───────────────────────────────────────────────────────────┴──────────────────┘', '2020-12-11 16:11:09'),
(3, '┌──────────────────────────────────────────────────────────────────────────────┐\r\n│Orders                                                                        │\r\n├───────────────────┬───────────────────┬───────────────────┬──────────────────┤\r\n│article            │prix d\'article     │quantite           │prix total        │\r\n├───────────────────┼───────────────────┼───────────────────┼──────────────────┤\r\n│article 7          │8.99 $             │10                 │89.899994 $       │\r\n├───────────────────┴───────────────────┴───────────────────┼──────────────────┤\r\n│prix total                                                 │89.899994 $       │\r\n├───────────────────────────────────────────────────────────┼──────────────────┤\r\n│cash                                                       │100.0 $           │\r\n├───────────────────────────────────────────────────────────┼──────────────────┤\r\n│a rendre                                                   │10.100006 $       │\r\n└───────────────────────────────────────────────────────────┴──────────────────┘', '2020-12-11 16:15:21');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
