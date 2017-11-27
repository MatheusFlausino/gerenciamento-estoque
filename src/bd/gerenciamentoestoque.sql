-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `engsoft`
--

-- --------------------------------------------------------

--
-- Table structure for table `caixa`
--

CREATE TABLE `caixa` (
  `id` int(11) NOT NULL,
  `data` varchar(30) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `caixa`
--

INSERT INTO `caixa` (`id`, `data`, `valor`) VALUES
(1, '2000-02-21', 100),
(2, '2017-02-12', 12),
(3, '2000-02-21', 100);

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `nome` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `cpf` tinytext COLLATE utf8_unicode_ci NOT NULL,
  `cep` tinytext COLLATE utf8_unicode_ci NOT NULL,
  `logradouro` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `bairro` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `telefone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `id` int(3) NOT NULL,
  `numero` int(10) NOT NULL,
  `complemento` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cidade` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `datanasc` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`nome`, `cpf`, `cep`, `logradouro`, `bairro`, `telefone`, `id`, `numero`, `complemento`, `cidade`, `estado`, `datanasc`) VALUES
('Fulano pra teste', '46200045609', '86300000', 'ABC', 'Centro', '11976548165', 1, 120, ' ', 'Cornélio Procópio', 'Paraná', '2000-02-21'),
('Fulano pra teste', '46200045609', '86300000', 'ABC', 'Centro', '11976548165', 2, 120, ' ', 'Cornélio Procópio', 'Paraná', '1995-02-12'),
('Fulano pra teste', '46200045609', '86300000', 'ABC', 'Centro', '11976548165', 10, 120, ' ', 'Cornélio Procópio', 'Paraná', '2000-02-21');

-- --------------------------------------------------------

--
-- Table structure for table `estoque`
--

CREATE TABLE `estoque` (
  `id` int(11) NOT NULL,
  `qtd` int(11) NOT NULL,
  `idFornecedor` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estoque`
--

INSERT INTO `estoque` (`id`, `qtd`, `idFornecedor`, `idProduto`) VALUES
(1, 40, 1, 2),
(3, 40, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `fornecedor`
--

CREATE TABLE `fornecedor` (
  `nome` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `cnpj` text COLLATE utf8_unicode_ci NOT NULL,
  `cep` text COLLATE utf8_unicode_ci NOT NULL,
  `logradouro` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `bairro` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `telefone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `id` int(3) NOT NULL,
  `numero` int(10) NOT NULL,
  `complemento` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cidade` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `fornecedor`
--

INSERT INTO `fornecedor` (`nome`, `cnpj`, `cep`, `logradouro`, `bairro`, `telefone`, `id`, `numero`, `complemento`, `cidade`, `estado`) VALUES
('Fulano pra teste', '72223484000149', '86300000', 'ABC', 'Centro', '11976548165', 1, 120, ' ', 'Cornélio Procópio', 'Paraná'),
('Fulano pra teste', '72223484000149', '86300000', 'ABC', 'Centro', '11976548165', 2, 120, ' ', 'Cornélio Procópio', 'Paraná'),
('Fulano pra teste', '72223484000149', '86300000', 'ABC', 'Centro', '11976548165', 3, 120, ' ', 'Cornélio Procópio', 'Paraná');

-- --------------------------------------------------------

--
-- Table structure for table `itemvenda`
--

CREATE TABLE `itemvenda` (
  `id` int(11) NOT NULL,
  `idVenda` varchar(60) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `nomeProduto` varchar(45) NOT NULL,
  `qtdProduto` int(11) NOT NULL,
  `precoProduto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemvenda`
--

INSERT INTO `itemvenda` (`id`, `idVenda`, `idProduto`, `nomeProduto`, `qtdProduto`, `precoProduto`) VALUES
(11, 'eb694f395f2d976f9f10b92a91d86a80', 1, 'Pomada', 12, 17.14),
(18, 'asld123adsf34', 1, 'Qualquer produto', 2, 17.2);

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE `produto` (
  `id` int(3) NOT NULL,
  `nome` varchar(25) DEFAULT NULL,
  `fabricante` varchar(25) DEFAULT NULL,
  `preco` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`id`, `nome`, `fabricante`, `preco`) VALUES
(1, 'Pomada', 'Um Fabricante', 17.14),
(5, 'Pomada', 'Um Fabricante', 17.14),
(11, 'Pomada', 'Um Fabricante', 17.14);

-- --------------------------------------------------------

--
-- Table structure for table `venda`
--

CREATE TABLE `venda` (
  `idVenda` varchar(60) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `dataVenda` varchar(30) NOT NULL,
  `tipoPagamento` varchar(20) NOT NULL,
  `descontoVenda` double NOT NULL,
  `totalVenda` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `venda`
--

INSERT INTO `venda` (`idVenda`, `idCliente`, `dataVenda`, `tipoPagamento`, `descontoVenda`, `totalVenda`) VALUES
('asld123adsf34', 1, '2000-02-21', 'Dinheiro', 0, 124),
('eb694f395f2d976f9f10b92a91d86a80', 11, '2017-06-04', 'Cartão Debito', 0, 205.68);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `caixa`
--
ALTER TABLE `caixa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `itemvenda`
--
ALTER TABLE `itemvenda`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idVenda`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `itemvenda`
--
ALTER TABLE `itemvenda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
