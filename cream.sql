-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 20 Février 2017 à 09:51
-- Version du serveur :  5.6.21
-- Version de PHP :  5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `cream`
--

-- --------------------------------------------------------

--
-- Structure de la table `action`
--

CREATE TABLE IF NOT EXISTS `action` (
`id` bigint(20) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sujet` varchar(255) NOT NULL,
  `tache_id` bigint(20) DEFAULT NULL,
  `type_action` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `action`
--

INSERT INTO `action` (`id`, `date_debut`, `date_fin`, `description`, `sujet`, `tache_id`, `type_action`, `user`) VALUES
(2, '2016-01-14', '2016-01-15', 'Advenit post multos Scudilo Scutariorum tribunus Advenit post multos Scudilo Scutariorum tribunus', 'Préparer le scripte', 6, 'APPEL', 'admin'),
(3, '2016-01-14', '2016-01-15', 'Advenit post multos Scudilo Scutariorum tribunus Advenit post multos Scudilo Scutariorum tribunusAdvenit post multos Scudilo Scutariorum tribunus Advenit post multos Scudilo Scutariorum tribunus', 'Appler', 6, 'APPEL', 'admin'),
(4, '2016-01-23', '2016-01-24', 'Advenit post multos Scudilo Scutariorum tribunus Advenit post multos Scudilo Advenit post multos Scudilo Scutariorum tribunus Advenit post multos Scudilo Advenit post multos Scudilo Scutariorum tribunus Advenit post multos Scudilo', 'Me deplacer', 6, NULL, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
`id` bigint(20) NOT NULL,
  `societe` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `portable` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compagne`
--

CREATE TABLE IF NOT EXISTS `compagne` (
`id` bigint(20) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `statut_compagne_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compagne`
--

INSERT INTO `compagne` (`id`, `libelle`, `date_debut`, `date_fin`, `statut_compagne_id`) VALUES
(2, 'Auto Moto', '2016-01-01', '2016-04-01', 2),
(3, 'Femme auto', '2016-01-19', '2050-01-19', 1),
(4, 'Sante +', '2016-01-01', '2016-01-30', 2);

-- --------------------------------------------------------

--
-- Structure de la table `databasechangelog`
--

CREATE TABLE IF NOT EXISTS `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `databasechangelog`
--

INSERT INTO `databasechangelog` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`) VALUES
('20151231165028', 'jhipster', 'classpath:config/liquibase/changelog/20151231165028_added_entity_Client.xml', '2016-01-07 15:04:10', 1, 'EXECUTED', '7:fb4321436aca85654d0b2d9be1d0f3f0', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 2, 'EXECUTED', '7:d5735e40061c457d496d25dd217990b9', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 3, 'EXECUTED', '7:0c9e47cadfee71ccf324a6c7a76f3bd5', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-3', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 4, 'EXECUTED', '7:829616f096539e7b865b8d2921cc5072', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-4', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 5, 'EXECUTED', '7:a8bda81a3a7cae105b11b53a5d1f92d1', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-5', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 6, 'EXECUTED', '7:04be5d4a41340a707673d87cdca42bc9', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-6', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 7, 'EXECUTED', '7:fa2bc6aa08d6a98655f9829a27300603', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-7', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 8, 'EXECUTED', '7:ef7ab3fd1b9e46aaf544f4d7ae79fcf1', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-8', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 9, 'EXECUTED', '7:570a89ae6d9e3e0c2b0ebfe8589c91aa', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-9', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 10, 'EXECUTED', '7:793a1b54a92ec0ce289b3b9841e05afb', 'addPrimaryKey', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-10', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:45', 11, 'EXECUTED', '7:34d653b516505b4cc5315da6084c02af', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-11', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:46', 12, 'EXECUTED', '7:9647b267eaa97682fff6b2b6eb990f85', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-12', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:46', 13, 'EXECUTED', '7:254402a2e6641b125b55cf3aecf5c2fa', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-13', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:46', 14, 'EXECUTED', '7:eddd3ba543c3a1208f62d8553b916439', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-14', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:46', 15, 'EXECUTED', '7:bad37ac1a6194a5897ceebcda670708b', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-15', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:46', 16, 'EXECUTED', '7:73b52733e56df30f4cde00585b2e53ad', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-16', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:46', 17, 'EXECUTED', '7:648116dc2f2c3745cb1de84a6fcafb1a', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-17', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:47', 18, 'EXECUTED', '7:48f8619f88390914d7efdad8fda6e115', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452179073388-18', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107150428_changelog.xml', '2016-01-07 15:05:47', 19, 'EXECUTED', '7:7186231b29107d6bd84db1ef5a9ed87a', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('20151231165028', 'jhipster', 'classpath:config/liquibase/changelog/20151231165028_added_entity_Agent.xml', '2016-01-07 16:54:55', 20, 'EXECUTED', '7:d370a245696226de109b5114582113f0', 'createTable, addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452188013585-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107173328_changelog.xml', '2016-01-07 17:34:08', 21, 'EXECUTED', '7:98835daf936e01fceb89ba1a17b69b5d', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452188013585-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107173328_changelog.xml', '2016-01-07 17:34:09', 22, 'EXECUTED', '7:062c2dfaef629abbf551f6b16c03a5c8', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452188013585-3', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107173328_changelog.xml', '2016-01-07 17:34:09', 23, 'EXECUTED', '7:b71f01c4e05cf2e255cab9225a3737d8', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452188013585-4', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107173328_changelog.xml', '2016-01-07 17:34:09', 24, 'EXECUTED', '7:80597e0b5d23922c6c921434327c7015', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452188013585-5', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107173328_changelog.xml', '2016-01-07 17:34:09', 25, 'EXECUTED', '7:ae5b0612543aabe8b21d8afc8572715e', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452188013585-6', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107173328_changelog.xml', '2016-01-07 17:34:09', 26, 'EXECUTED', '7:295aa528289df1f00788cdda732a3a8e', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452188013585-7', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160107173328_changelog.xml', '2016-01-07 17:34:09', 27, 'EXECUTED', '7:de4621152274782b39a7b0ee2d191f03', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:42', 28, 'EXECUTED', '7:a2d4f2572a5d286b34a85f8ab5acfe0d', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:43', 29, 'EXECUTED', '7:2eda378fe3731e584ecce6f628c27356', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-3', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:43', 30, 'EXECUTED', '7:ad4201083ee5d26161ff84fd54d1d7a5', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-4', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:43', 31, 'EXECUTED', '7:03c4ef84fea5243e6e9617cdf7c4e898', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-5', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:44', 32, 'EXECUTED', '7:8df1d6a912aae1c1ae4853a876daf60c', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-6', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:45', 33, 'EXECUTED', '7:5383803d5f633de0a9992e6c43d8ebf4', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-7', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:45', 34, 'EXECUTED', '7:a7048848f85d1877297d82f5e72bd5c3', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-8', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:46', 35, 'EXECUTED', '7:6652ca7f01d6d009110ab60eb9df9a8e', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-9', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:46', 36, 'EXECUTED', '7:6da9790fc7129b90b6a3071b91128cc8', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-10', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:47', 37, 'EXECUTED', '7:32bd1978ba9b73277d3da63c1efb1de6', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-11', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:47', 38, 'EXECUTED', '7:25ee519595e2dea7c091ef0c5a5b0856', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-12', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:49', 39, 'EXECUTED', '7:e428a3d96edc44d1131a053bcac873b0', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-13', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:50', 40, 'EXECUTED', '7:2e53ad7c9ec0ee308ca24371e688e9aa', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-14', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:51', 41, 'EXECUTED', '7:97f45d15724afa489a8a5c5ddb813a93', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-15', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:51', 42, 'EXECUTED', '7:acc00fc8029a3bf99a6e50fb20da7c4b', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-16', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:51', 43, 'EXECUTED', '7:21a133918f27b83116031643b36027c6', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-17', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:51', 44, 'EXECUTED', '7:fa5d3b3c7d35c144b8291bc0033858fe', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-18', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:52', 45, 'EXECUTED', '7:923d77df1e96b23eae662539555b37f2', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-19', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:52', 46, 'EXECUTED', '7:ad663ca9ee89143b7bb9be48fc4129a7', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-20', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:52', 47, 'EXECUTED', '7:8d69629b5cc925caba0e077b19c1c072', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-21', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:52', 48, 'EXECUTED', '7:b6d280eba235c3235c22d2b53d5107a0', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-22', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:53', 49, 'EXECUTED', '7:51a3e9b4d9a368e56655c4c5522766da', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-23', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:53', 50, 'EXECUTED', '7:a2e3555cc25018e00062e5c683109405', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-24', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:53', 51, 'EXECUTED', '7:9f1db158142e50b9bca01183e721a0b1', 'dropUniqueConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-25', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:53', 52, 'EXECUTED', '7:fb576c4e0412ecc8d93b8f8b83a5424f', 'dropTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-26', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:53', 53, 'EXECUTED', '7:e2e16216ac53cf687097172a013fcf87', 'dropTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-27', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:53', 54, 'EXECUTED', '7:34f05374bdc3a1ec197d9b5d84f77a12', 'dropTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-28', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:54', 55, 'EXECUTED', '7:53215e652591b0ecbba2659b43c1446a', 'dropTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-29', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:54', 56, 'EXECUTED', '7:ae26aad4ae5b7bf3f060603bf24d8890', 'dropTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-30', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:54', 57, 'EXECUTED', '7:c10f99b984199f65cafbb4c8104cfa7e', 'dropTable', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-31', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:54', 58, 'EXECUTED', '7:a45f7a65b747500d810146c739850685', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-32', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:54', 59, 'EXECUTED', '7:de4cc0685d6f63fab1e3e10e274fc0fa', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-33', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:54', 60, 'EXECUTED', '7:b02265c58bb3a639a32957a391bbc079', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452677022831-34', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113092327_changelog.xml', '2016-01-13 09:56:54', 61, 'EXECUTED', '7:1636b43101ff5eed55feb9b132d19808', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:53', 62, 'EXECUTED', '7:55c3a4b8dd8a93b7f9ebdff8640b0776', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:53', 63, 'EXECUTED', '7:1288f0142a6bbc9f89307fa1c5f61182', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-3', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:53', 64, 'EXECUTED', '7:39744ce48a180bb86c4c4bb2120e11a1', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-4', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:53', 65, 'EXECUTED', '7:57e03ec7f4a2ac762058b7b04a37bb5b', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-5', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:53', 66, 'EXECUTED', '7:9163700507ae8b9a249ad525dd63581e', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-6', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:53', 67, 'EXECUTED', '7:82907454ce583d40bcd2ee7b742246ff', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-7', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:53', 68, 'EXECUTED', '7:56cf72252c7ad654ac1c6b2ca11f56f8', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-8', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:54', 69, 'EXECUTED', '7:59f5d4295b6dacd2199930ce02e4bd31', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-9', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:54', 70, 'EXECUTED', '7:3f0ec3612412bb214d8921a54f66efc1', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452686158218-10', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113115545_changelog.xml', '2016-01-13 12:05:54', 71, 'EXECUTED', '7:78967982836dbfea39fb6a175ccd48a9', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452687181134-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113121255_changelog.xml', '2016-01-13 12:21:43', 72, 'EXECUTED', '7:b142f1fa7f30a38ea1fad4cb4e87e129', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452687181134-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113121255_changelog.xml', '2016-01-13 12:21:43', 73, 'EXECUTED', '7:ee62bcf2cde161d81571b9d3c6ebb70c', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452687181134-3', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113121255_changelog.xml', '2016-01-13 12:21:43', 74, 'EXECUTED', '7:2a0b6a28c2af000ecc4248ba3ec9fa89', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452687181134-4', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113121255_changelog.xml', '2016-01-13 12:21:43', 75, 'EXECUTED', '7:e040af9748181ecffeca86b18aa40021', 'dropForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452687181134-5', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113121255_changelog.xml', '2016-01-13 12:21:44', 76, 'EXECUTED', '7:a2a8f085c17dc7047d53e0dbf337dc1e', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452687181134-6', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113121255_changelog.xml', '2016-01-13 12:21:44', 77, 'EXECUTED', '7:20f2d9307d56142b1b22683637cb7c51', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452687181134-7', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113121255_changelog.xml', '2016-01-13 12:21:44', 78, 'EXECUTED', '7:fbaec40acd9644953fe979d46b8f7468', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452687181134-8', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113121255_changelog.xml', '2016-01-13 12:21:45', 79, 'EXECUTED', '7:2500c7adf327a5ab34192ab302c6ebf9', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('20160113164631', 'jhipster', 'classpath:config/liquibase/changelog/20160113164631_added_entity_RefSituationFamiliale.xml', '2016-01-13 16:50:52', 80, 'EXECUTED', '7:d52e9192dfaf5abf4196bddf4e495e5e', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('20160113164631', 'jhipster', 'classpath:config/liquibase/changelog/20160113164631_added_entity_RefSecteurActivite.xml', '2016-01-13 16:50:52', 81, 'EXECUTED', '7:f0fb16814ebb139f924c85780da75819', 'createTable', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:47', 82, 'EXECUTED', '7:ba7eeaecd99a12049ed2c55b8a39f91a', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:47', 83, 'EXECUTED', '7:7691794e68a571e12cab8ba4897282ab', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-3', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:47', 84, 'EXECUTED', '7:230107e63fe7c133af8c40c902b00421', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-4', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:47', 85, 'EXECUTED', '7:14a142bdc606b8eeba44e105fc02d2b7', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-5', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:47', 86, 'EXECUTED', '7:6b28db7e79703b871deeecf939cccb84', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-6', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:47', 87, 'EXECUTED', '7:e3364acf354670640cf66c8ef29ae27b', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-7', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:47', 88, 'EXECUTED', '7:e88b52111d784e462680cbb4880b0ef4', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-8', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:47', 89, 'EXECUTED', '7:ffe057955b8f8bad39087b31fd86ac64', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-9', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:47', 90, 'EXECUTED', '7:fa06a6307e6563945b69ee52630eec1c', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-10', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:48', 91, 'EXECUTED', '7:06d441a8d9ec939fa61e4967b312796c', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-11', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:48', 92, 'EXECUTED', '7:c4b07734d72dd389d2d8e25a20a5a4ec', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-12', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:48', 93, 'EXECUTED', '7:d30cd13adbe51a9ad0edaa914c04f3c5', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-13', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:48', 94, 'EXECUTED', '7:acb1023f391df69bf723363581103027', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452703948820-14', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113165224_changelog.xml', '2016-01-13 16:54:48', 95, 'EXECUTED', '7:416ebd049ebe7a13a4506726793f78ae', 'addForeignKeyConstraint', '', NULL, '3.4.2', NULL, NULL),
('1452704679563-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113170433_changelog.xml', '2016-01-13 17:17:12', 96, 'EXECUTED', '7:6f024fc3ba2b4c7dbf2f781b2e036c40', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452704679563-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113170433_changelog.xml', '2016-01-13 17:17:12', 97, 'EXECUTED', '7:405b5508bc67e554a11b8566572e0c64', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452704679563-3', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113170433_changelog.xml', '2016-01-13 17:17:12', 98, 'EXECUTED', '7:59953df7466b992c4eaa8ad67a940c18', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452704679563-4', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113170433_changelog.xml', '2016-01-13 17:17:12', 99, 'EXECUTED', '7:3d40f8aa26a0f33461295dca397567ea', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452704679563-5', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113170433_changelog.xml', '2016-01-13 17:17:12', 100, 'EXECUTED', '7:5e56ff4a39f14d05a185c4616a29e2ca', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452704679563-6', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113170433_changelog.xml', '2016-01-13 17:17:12', 101, 'EXECUTED', '7:ebb6ac47b18c85a2e05b95208c718290', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452704679563-7', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113170433_changelog.xml', '2016-01-13 17:17:12', 102, 'EXECUTED', '7:16239510f506cdc2d152bf786503f313', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452704679563-8', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113170433_changelog.xml', '2016-01-13 17:17:12', 103, 'EXECUTED', '7:27d1c62cb6bd179f196e17fdceb7f8f7', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452704679563-9', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113170433_changelog.xml', '2016-01-13 17:17:13', 104, 'EXECUTED', '7:51b0234fb070c086b528f8006559836b', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452706688954-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113173804_changelog.xml', '2016-01-13 17:38:51', 105, 'EXECUTED', '7:4d6d4b5b4fa734c7dc0b114c8a401836', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452706688954-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113173804_changelog.xml', '2016-01-13 17:38:51', 106, 'EXECUTED', '7:5578ff9a1d8f3a7b45a4996504f588c2', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452706965781-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113174241_changelog.xml', '2016-01-13 17:43:49', 107, 'EXECUTED', '7:a199a6aa2397e56bdd588d52580325f9', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452706965781-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113174241_changelog.xml', '2016-01-13 17:43:49', 108, 'EXECUTED', '7:21b0f0814af880f2579c2c3090ef3385', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:13', 109, 'EXECUTED', '7:e2fbcf787fd56673429902085113477e', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:13', 110, 'EXECUTED', '7:a1f02a7e426c356f214b61e2bde8e73f', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-3', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:13', 111, 'EXECUTED', '7:035bf248290b21acbf2618b97ecab6ff', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-4', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:13', 112, 'EXECUTED', '7:b829ce7fe684baf0c680e2cee4c835a0', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-5', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:14', 113, 'EXECUTED', '7:aeb744502695317078ee7469fdbcf4ce', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-6', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:14', 114, 'EXECUTED', '7:4d93a96883a8d1d6b1af7fe9f59c1e2d', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-7', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:14', 115, 'EXECUTED', '7:d30cd13adbe51a9ad0edaa914c04f3c5', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-8', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:14', 116, 'EXECUTED', '7:abac55392abf7c903672872b3da0a7c2', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-9', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:15', 117, 'EXECUTED', '7:3e5f60f68a2a32747c97d6d247260e10', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-10', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:15', 118, 'EXECUTED', '7:7a187a2ac06ef3ae70af37762e1372a2', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-11', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:15', 119, 'EXECUTED', '7:951cce7f83cef171b9593d68477a814d', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-12', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:15', 120, 'EXECUTED', '7:b00c498a92a0d2aa4ebebd8f6d959c6c', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-13', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:16', 121, 'EXECUTED', '7:24e85c12ef86319b84dbbf3eff89233c', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-14', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:16', 122, 'EXECUTED', '7:62b060a444f46ec6ff53cfc1b001ab04', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-15', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:16', 123, 'EXECUTED', '7:79a091e8516bc674812e4d67ec79d847', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452708569046-16', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160113180923_changelog.xml', '2016-01-13 18:11:16', 124, 'EXECUTED', '7:b0071317a8e5bfe65631dfe73e479a7b', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452763570515-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160114092601_changelog.xml', '2016-01-14 09:30:24', 125, 'EXECUTED', '7:6479d36ac66229f6e5626215c40c803a', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452763570515-2', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160114092601_changelog.xml', '2016-01-14 09:30:24', 126, 'EXECUTED', '7:c4756e37cc4d2a09084aaebc840b6edb', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452763570515-3', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160114092601_changelog.xml', '2016-01-14 09:30:24', 127, 'EXECUTED', '7:8c905cfcd6ee45838abd86158e21056b', 'addColumn', '', NULL, '3.4.2', NULL, NULL),
('1452763570515-4', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160114092601_changelog.xml', '2016-01-14 09:30:24', 128, 'EXECUTED', '7:a3b211707a63ced3fca874ec62bf18be', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452763570515-5', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160114092601_changelog.xml', '2016-01-14 09:30:24', 129, 'EXECUTED', '7:078eafcf239418b7c68059facfd6a4c1', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452763570515-6', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160114092601_changelog.xml', '2016-01-14 09:30:25', 130, 'EXECUTED', '7:1424910f573b9b54ddacf9f4c538b92f', 'dropColumn', '', NULL, '3.4.2', NULL, NULL),
('1452768405273-1', 'b.zinoun (generated)', 'classpath:config/liquibase/changelog/20160114104638_changelog.xml', '2016-01-14 11:26:56', 131, 'EXECUTED', '7:25464cc738159caad99c62d500e72cdb', 'addColumn', '', NULL, '3.4.2', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `databasechangeloglock`
--

CREATE TABLE IF NOT EXISTS `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `databasechangeloglock`
--

INSERT INTO `databasechangeloglock` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `jhi_authority`
--

CREATE TABLE IF NOT EXISTS `jhi_authority` (
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_authority`
--

INSERT INTO `jhi_authority` (`name`) VALUES
('ROLE_ADMIN'),
('ROLE_AGENT'),
('ROLE_DIRECTEUR'),
('ROLE_DIRECTEUR_RESEAU'),
('ROLE_GESTIONNAIRE'),
('ROLE_MANAGER_COMMERCIAL'),
('ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_persistent_audit_event`
--

CREATE TABLE IF NOT EXISTS `jhi_persistent_audit_event` (
`event_id` bigint(20) NOT NULL,
  `principal` varchar(255) NOT NULL,
  `event_date` timestamp NULL DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_persistent_audit_event`
--

INSERT INTO `jhi_persistent_audit_event` (`event_id`, `principal`, `event_date`, `event_type`) VALUES
(1, 'user', '2015-12-31 17:01:32', 'AUTHENTICATION_SUCCESS'),
(2, 'user', '2015-12-31 17:10:47', 'AUTHENTICATION_SUCCESS'),
(3, 'user', '2016-01-04 09:48:57', 'AUTHENTICATION_SUCCESS'),
(4, 'user', '2016-01-04 16:47:24', 'AUTHENTICATION_SUCCESS'),
(5, 'admin', '2016-01-04 16:58:54', 'AUTHENTICATION_SUCCESS'),
(6, 'badr', '2016-01-04 17:00:54', 'AUTHENTICATION_FAILURE'),
(7, 'admin', '2016-01-04 17:01:02', 'AUTHENTICATION_SUCCESS'),
(8, 'badr', '2016-01-04 17:02:54', 'AUTHENTICATION_SUCCESS'),
(9, 'admin', '2016-01-05 08:28:52', 'AUTHENTICATION_SUCCESS'),
(10, 'admin', '2016-01-05 09:05:18', 'AUTHENTICATION_SUCCESS'),
(11, 'soufiane', '2016-01-05 09:06:29', 'AUTHENTICATION_SUCCESS'),
(12, 'admin', '2016-01-05 09:06:44', 'AUTHENTICATION_SUCCESS'),
(13, 'admin', '2016-01-05 09:34:21', 'AUTHENTICATION_SUCCESS'),
(14, 'user', '2016-01-05 10:09:20', 'AUTHENTICATION_SUCCESS'),
(15, 'user', '2016-01-05 15:07:18', 'AUTHENTICATION_SUCCESS'),
(16, 'user', '2016-01-05 15:30:02', 'AUTHENTICATION_SUCCESS'),
(17, 'user', '2016-01-05 15:33:43', 'AUTHENTICATION_SUCCESS'),
(18, 'user', '2016-01-05 15:34:47', 'AUTHENTICATION_SUCCESS'),
(19, 'admin', '2016-01-05 16:18:57', 'AUTHENTICATION_SUCCESS'),
(20, 'badr', '2016-01-05 16:37:31', 'AUTHENTICATION_SUCCESS'),
(21, 'user', '2016-01-06 08:55:42', 'AUTHENTICATION_SUCCESS'),
(22, 'user', '2016-01-06 10:29:25', 'AUTHENTICATION_SUCCESS'),
(23, 'user', '2016-01-06 10:31:41', 'AUTHENTICATION_SUCCESS'),
(24, 'user', '2016-01-06 10:44:19', 'AUTHENTICATION_SUCCESS'),
(25, 'admin', '2016-01-06 10:44:46', 'AUTHENTICATION_SUCCESS'),
(26, 'user', '2016-01-06 10:45:05', 'AUTHENTICATION_SUCCESS'),
(27, 'user', '2016-01-06 10:46:02', 'AUTHENTICATION_SUCCESS'),
(28, 'admin', '2016-01-06 11:18:40', 'AUTHENTICATION_SUCCESS'),
(29, 'user', '2016-01-07 15:26:54', 'AUTHENTICATION_SUCCESS'),
(30, 'admin', '2016-01-08 08:40:32', 'AUTHENTICATION_SUCCESS'),
(31, 'user', '2016-01-08 10:39:31', 'AUTHENTICATION_SUCCESS'),
(32, 'admin', '2016-01-08 11:26:57', 'AUTHENTICATION_SUCCESS'),
(33, 'admin', '2016-01-08 12:15:55', 'AUTHENTICATION_SUCCESS'),
(34, 'user', '2016-01-08 14:23:39', 'AUTHENTICATION_SUCCESS'),
(35, 'admin', '2016-01-08 14:26:46', 'AUTHENTICATION_SUCCESS'),
(36, 'user', '2016-01-08 14:27:13', 'AUTHENTICATION_SUCCESS'),
(37, 'admin', '2016-01-08 14:28:05', 'AUTHENTICATION_SUCCESS'),
(38, 'agent', '2016-01-08 15:42:32', 'AUTHENTICATION_SUCCESS'),
(39, 'directeur', '2016-01-08 15:43:49', 'AUTHENTICATION_SUCCESS'),
(40, 'agent', '2016-01-08 15:56:18', 'AUTHENTICATION_SUCCESS'),
(41, 'admin', '2016-01-08 15:57:08', 'AUTHENTICATION_SUCCESS'),
(42, 'agent', '2016-01-08 15:57:48', 'AUTHENTICATION_SUCCESS'),
(43, 'admin', '2016-01-08 16:01:19', 'AUTHENTICATION_SUCCESS'),
(44, 'admin', '2016-01-08 16:05:25', 'AUTHENTICATION_SUCCESS'),
(45, 'user', '2016-01-08 18:29:31', 'AUTHENTICATION_SUCCESS'),
(46, 'user', '2016-01-12 09:53:09', 'AUTHENTICATION_SUCCESS'),
(47, 'admin', '2016-01-12 09:57:35', 'AUTHENTICATION_SUCCESS'),
(48, 'admin', '2016-01-12 10:00:05', 'AUTHENTICATION_SUCCESS'),
(49, 'admin', '2016-01-12 10:50:35', 'AUTHENTICATION_SUCCESS'),
(50, 'user', '2016-01-12 11:09:08', 'AUTHENTICATION_FAILURE'),
(51, 'user', '2016-01-12 11:09:12', 'AUTHENTICATION_SUCCESS'),
(52, 'user', '2016-01-12 14:07:39', 'AUTHENTICATION_SUCCESS'),
(53, 'agent', '2016-01-12 14:24:54', 'AUTHENTICATION_SUCCESS'),
(54, 'gestinnaire', '2016-01-12 14:46:43', 'AUTHENTICATION_FAILURE'),
(55, 'admin', '2016-01-12 14:47:40', 'AUTHENTICATION_SUCCESS'),
(56, 'gestionnaire', '2016-01-12 14:48:27', 'AUTHENTICATION_SUCCESS'),
(57, 'user', '2016-01-12 16:18:19', 'AUTHENTICATION_SUCCESS'),
(58, 'admin', '2016-01-13 09:59:10', 'AUTHENTICATION_SUCCESS'),
(59, 'user', '2016-01-13 12:08:17', 'AUTHENTICATION_SUCCESS'),
(60, 'admin', '2016-01-13 17:39:27', 'AUTHENTICATION_SUCCESS'),
(61, 'user', '2016-01-14 11:36:27', 'AUTHENTICATION_SUCCESS'),
(62, 'admin', '2016-01-14 12:09:34', 'AUTHENTICATION_SUCCESS'),
(63, 'admin', '2016-01-14 16:23:09', 'AUTHENTICATION_SUCCESS'),
(64, 'admin', '2016-01-14 19:18:22', 'AUTHENTICATION_SUCCESS'),
(65, 'user', '2016-01-15 09:24:04', 'AUTHENTICATION_SUCCESS'),
(66, 'user', '2016-01-15 10:21:13', 'AUTHENTICATION_SUCCESS'),
(67, 'admin', '2016-01-15 11:46:59', 'AUTHENTICATION_SUCCESS'),
(68, 'admin', '2016-01-15 12:05:13', 'AUTHENTICATION_SUCCESS'),
(69, 'admin', '2016-01-15 15:04:31', 'AUTHENTICATION_SUCCESS'),
(70, 'admin', '2016-01-15 15:04:35', 'AUTHENTICATION_SUCCESS'),
(71, 'admin', '2016-01-15 15:04:39', 'AUTHENTICATION_SUCCESS'),
(72, 'admin', '2016-01-15 15:04:43', 'AUTHENTICATION_SUCCESS'),
(73, 'admin', '2016-01-15 15:10:23', 'AUTHENTICATION_SUCCESS'),
(74, 'admin', '2016-01-15 15:10:27', 'AUTHENTICATION_SUCCESS'),
(75, 'user', '2016-01-15 16:51:36', 'AUTHENTICATION_SUCCESS'),
(76, 'admin', '2016-01-15 16:52:01', 'AUTHENTICATION_SUCCESS'),
(77, 'user', '2016-01-18 15:51:25', 'AUTHENTICATION_SUCCESS'),
(78, 'user', '2016-01-18 15:51:29', 'AUTHENTICATION_SUCCESS'),
(79, 'admin', '2016-01-18 15:52:03', 'AUTHENTICATION_SUCCESS'),
(80, 'admin', '2016-01-19 09:18:07', 'AUTHENTICATION_SUCCESS'),
(81, 'admin', '2016-01-19 11:16:08', 'AUTHENTICATION_SUCCESS'),
(82, 'admin', '2016-01-19 15:46:30', 'AUTHENTICATION_SUCCESS'),
(83, 'admin', '2016-01-20 09:07:20', 'AUTHENTICATION_SUCCESS'),
(84, 'admin', '2016-01-20 10:47:53', 'AUTHENTICATION_SUCCESS');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_persistent_audit_evt_data`
--

CREATE TABLE IF NOT EXISTS `jhi_persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_persistent_audit_evt_data`
--

INSERT INTO `jhi_persistent_audit_evt_data` (`event_id`, `name`, `value`) VALUES
(1, 'remoteAddress', '127.0.0.1'),
(1, 'sessionId', '3C751A97FAFAEE609758F6F4EFD330B9'),
(2, 'remoteAddress', '127.0.0.1'),
(2, 'sessionId', '28459AADEAA48434E7090B3829C8DA2B'),
(3, 'remoteAddress', '127.0.0.1'),
(3, 'sessionId', '44D5892C6EBAFA69A0D5D5B2006BF528'),
(4, 'remoteAddress', '127.0.0.1'),
(4, 'sessionId', '3691F783BCF8A587F927BEB3A8F8A503'),
(5, 'remoteAddress', '127.0.0.1'),
(5, 'sessionId', '052546C1CC44494157A034D6D5FDE047'),
(6, 'message', 'Bad credentials'),
(6, 'type', 'org.springframework.security.authentication.BadCredentialsException'),
(7, 'remoteAddress', '127.0.0.1'),
(7, 'sessionId', 'FCF0AF649995F76437F5F223512328A7'),
(8, 'remoteAddress', '127.0.0.1'),
(8, 'sessionId', '8D06BABE6B63CA54946E83EFE2A41192'),
(9, 'remoteAddress', '127.0.0.1'),
(9, 'sessionId', 'AFF049E06FD8262D757777760BAB59EE'),
(10, 'remoteAddress', '127.0.0.1'),
(10, 'sessionId', 'DB000C315508D622B4899BC92056B2FE'),
(11, 'remoteAddress', '127.0.0.1'),
(11, 'sessionId', '270D74310D21CFBD2B39DFB87AAB605F'),
(12, 'remoteAddress', '127.0.0.1'),
(12, 'sessionId', 'B905A53DE3CAE663ACB3C3BA2C2FC4C5'),
(13, 'remoteAddress', '127.0.0.1'),
(13, 'sessionId', '3C050F206CF87C6DACA4FD984545CD7D'),
(14, 'remoteAddress', '192.168.105.12'),
(14, 'sessionId', 'EFA51DC9D879D23118316FE040054031'),
(15, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(15, 'sessionId', '256033F734732C3ADAB85A121FE8859B'),
(16, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(16, 'sessionId', 'A7FC1859F169E5D4A8C550CD61572F33'),
(17, 'remoteAddress', '192.168.112.44'),
(17, 'sessionId', '60BB584D14AB09E6D46DEF8B4C9291F8'),
(18, 'remoteAddress', '192.168.112.44'),
(18, 'sessionId', '06A7E0AD2C17E6EE7B289820435D33E2'),
(19, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(19, 'sessionId', '2654353D46A513ABFF3048B11F873ED0'),
(20, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(20, 'sessionId', '3F96E89F9DCF884BB8C3246BDA2CE8AD'),
(21, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(21, 'sessionId', '76E85B55502E299840884C1D67A36BC9'),
(22, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(22, 'sessionId', '826903C93665DF46A1D6FA7BC0635540'),
(23, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(23, 'sessionId', 'D23B8944E526C1692DCEE017A5EB9E52'),
(24, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(24, 'sessionId', '1DA3498F707059C7F5DFF0B34228C4BE'),
(25, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(25, 'sessionId', '7040BCE6646E6105EF97D535607438FC'),
(26, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(26, 'sessionId', '978C02EC79932996A2F79BC04605F648'),
(27, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(27, 'sessionId', '8A5DE5BB075836FF67EF8D3BEC7847FC'),
(28, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(28, 'sessionId', 'D154F39DC1B3CACFC7E2D8DD4314E811'),
(29, 'remoteAddress', '192.168.112.48'),
(29, 'sessionId', '12180E0285FA6C82DF7018EAA04A73D3'),
(30, 'remoteAddress', '192.168.112.48'),
(30, 'sessionId', '8D8DC95EEDFCE675CF92CB36897F68AD'),
(31, 'remoteAddress', '192.168.112.48'),
(31, 'sessionId', '4DD83404A56BBDD976BD022B31D591F3'),
(32, 'remoteAddress', '192.168.112.48'),
(32, 'sessionId', '887227958B045BCEC1358507F2DB78F2'),
(33, 'remoteAddress', '192.168.112.48'),
(33, 'sessionId', '8A4A717BA1881B12201E9C0F751542ED'),
(34, 'remoteAddress', '192.168.112.44'),
(34, 'sessionId', '5E142AF97468892FE5AB45A828662174'),
(35, 'remoteAddress', '192.168.112.44'),
(35, 'sessionId', 'AEC24F3FDEF3C27E5DDD855B5DB1F5B6'),
(36, 'remoteAddress', '192.168.112.44'),
(36, 'sessionId', '93EC27C2F22845E076D83562AFC96F8C'),
(37, 'remoteAddress', '192.168.112.44'),
(37, 'sessionId', '97FE5E650E078CC9848F67C0376E423B'),
(38, 'remoteAddress', '192.168.112.48'),
(38, 'sessionId', '64427D7F5DAD2B8CF0EF9EC5C02500D0'),
(39, 'remoteAddress', '192.168.112.48'),
(39, 'sessionId', '2C28AE9111D0A326D6AB89669F770589'),
(40, 'remoteAddress', '192.168.112.48'),
(40, 'sessionId', 'E0D7947D5ADD186ED05BBD421D83E65C'),
(41, 'remoteAddress', '192.168.112.48'),
(41, 'sessionId', 'BDE9558DC39D10C5443057C5EAE8824B'),
(42, 'remoteAddress', '192.168.112.48'),
(42, 'sessionId', 'E3C78F1D823454BCB3621B3637FEF7A3'),
(43, 'remoteAddress', '127.0.0.1'),
(43, 'sessionId', '2FC6301A4672AFADF2C324FBF2FD3EDB'),
(44, 'remoteAddress', '127.0.0.1'),
(44, 'sessionId', 'F2E2E8B3DC96B6C5F4EB891B18FF4588'),
(45, 'remoteAddress', '192.168.112.44'),
(45, 'sessionId', 'EDFF735E535586E004211F6D29179691'),
(46, 'remoteAddress', '192.168.112.27'),
(46, 'sessionId', '9721E88C4A4B4E07E91C93208F06639F'),
(47, 'remoteAddress', '192.168.112.27'),
(47, 'sessionId', '783E3C036BCB90743B50C771FD8BA9F7'),
(48, 'remoteAddress', '192.168.112.27'),
(48, 'sessionId', 'E312175513B9868F6D5228CB67944E8F'),
(49, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(49, 'sessionId', 'BAA6077C73B9D21462BA94FB96054BFE'),
(50, 'message', 'Bad credentials'),
(50, 'type', 'org.springframework.security.authentication.BadCredentialsException'),
(51, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(51, 'sessionId', '2025678EE5FD65090C1E48194FF34E0B'),
(52, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(52, 'sessionId', 'DE2A465877CF2422FE3D561D44D0FB6C'),
(53, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(53, 'sessionId', 'FC28FEFF74F7EACB0270AFF9E2DD85A6'),
(54, 'message', 'Bad credentials'),
(54, 'type', 'org.springframework.security.authentication.BadCredentialsException'),
(55, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(55, 'sessionId', '850051E351EF302601AFC975F2155AE2'),
(56, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(56, 'sessionId', 'F0BF057C4D8F53890B2643D66ED4C8C1'),
(57, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(57, 'sessionId', '03FE7676498A4035EF4B33F89CD00577'),
(58, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(58, 'sessionId', '2BDDE087EE5456889E2EA2E41BBECB83'),
(59, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(59, 'sessionId', '60511DC997DBD3B4D737771666B432D5'),
(60, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(60, 'sessionId', '791F0F9A2BD137634F527CF08A0DEA49'),
(61, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(61, 'sessionId', 'D0E187CB199972475B8BC2B3BAB532AB'),
(62, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(62, 'sessionId', 'E3C2CB6B560300A9A3FB6C0E8588F5DD'),
(63, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(63, 'sessionId', '67B2159CD374506C3F994552FADB725B'),
(64, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(64, 'sessionId', 'C0D65151D7F52424478C5C5B9BA54C87'),
(65, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(65, 'sessionId', '872706332992F80669B8C44BEDBEF1AE'),
(66, 'remoteAddress', '192.168.112.44'),
(66, 'sessionId', 'EDE0EC3E65C30112D3F3AE7E838128AF'),
(67, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(67, 'sessionId', '23FA7099D7F7EEFB33D31D8CFD9869C7'),
(68, 'remoteAddress', '192.168.112.78'),
(68, 'sessionId', '8C4739031BD93B2F8B9BAC1A3401DFB0'),
(69, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(69, 'sessionId', '8C79C40EABFFF334E05FBC391DB78220'),
(70, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(70, 'sessionId', 'E296E92F07AD73E8057679DB152B5C41'),
(71, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(71, 'sessionId', '9B93D23C65E009EEE9DEFF4C16D949BD'),
(72, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(72, 'sessionId', '74DA5B5690330EF8B1DC45455943413E'),
(73, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(73, 'sessionId', '727ECE56229E831368375D45F7D0D807'),
(74, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(74, 'sessionId', '1D199565DD8D7F235749A33CFCFEA5C0'),
(75, 'remoteAddress', '192.168.112.130'),
(75, 'sessionId', 'EB13E87F7AF2EA877651E06FB7980F15'),
(76, 'remoteAddress', '192.168.112.130'),
(76, 'sessionId', '3F039A0A53DE159BD3A3396B38AB8D8F'),
(77, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(77, 'sessionId', '7FCCB91ACFC16182E7890CE29BF627D9'),
(78, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(78, 'sessionId', '516EE8FFBA728B7A2CEBC939C4670BA4'),
(79, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(79, 'sessionId', 'EF128028C5D1FB9923F17A8362D3E33B'),
(80, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(80, 'sessionId', '832AFFAC01BB86868AE33B53D48D230B'),
(81, 'remoteAddress', '192.168.105.12'),
(81, 'sessionId', '116174342608B20A557A1ACB75D81068'),
(82, 'remoteAddress', '0:0:0:0:0:0:0:1'),
(82, 'sessionId', 'DC9388E63542F568FB568F240185F08F'),
(83, 'remoteAddress', '192.168.112.78'),
(83, 'sessionId', '8475F20DD7A2EAD4635318E3470D9031'),
(84, 'remoteAddress', '192.168.112.44'),
(84, 'sessionId', '3A1C3D83DA794B2ED43BCA0DEC6C6D63');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_persistent_token`
--

CREATE TABLE IF NOT EXISTS `jhi_persistent_token` (
  `series` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `token_value` varchar(255) NOT NULL,
  `token_date` date DEFAULT NULL,
  `ip_address` varchar(39) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_persistent_token`
--

INSERT INTO `jhi_persistent_token` (`series`, `user_id`, `token_value`, `token_date`, `ip_address`, `user_agent`) VALUES
('/2t40hxO69WZpmKsT68bQQ==', 3, 'CFuOxMsHI57eNCVo9F4OLw==', '2016-01-15', '192.168.112.130', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36'),
('07sLQMRj0S/0xdE0hV2rLA==', 4, 'qG3+uSBORR9ZYosJbc69AQ==', '2016-01-18', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('2HlMcBPa4zW903NK4+oduQ==', 3, 'GHK8RgyjE6A4VzPQu5D4NQ==', '2016-01-15', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('3xRqPqFL8Rx3DiZDYmbvTw==', 3, 'EdhpX0bpm4CNrEkD3bgJhg==', '2016-01-18', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('CKFzPQwvJa+ITO/JDF9tHQ==', 3, 'Om4nv7zfum+l6KQU2zaFJA==', '2016-01-15', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('Dwlv3WQ+TCSer2fqZntUjQ==', 11, 'emaNYDcDdOjhcBUIii93Yg==', '2016-01-12', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('fkKJw7x8zjr3XPI9qItzkA==', 3, '8PghMVYjBpkBdd83hC1ZgQ==', '2016-01-15', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('GakPXKjceGTG5qUBAv3Cwg==', 3, 'BpRxDd9OMgD3SSYQyZ4XjA==', '2016-01-20', '192.168.112.78', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36'),
('gg/Irm18GQC/tSHcO7cYXQ==', 3, 'a7WoKgyrwoCJBuPzJxgCMg==', '2016-01-15', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('jwUEc3mdEkOrzngWDwf0aA==', 3, 'M1tlK+Yw3z6jD+m/yrOhDQ==', '2016-01-15', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('N2eHy2wGwx+xWIYWftc8og==', 3, '9IuxM9mJTo9tgQ9JbuZChQ==', '2016-01-19', '192.168.105.12', 'Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36'),
('p77VFDVaDAmAYC9M2w07DA==', 4, 'VlwLVUNgkIsOXCcBQtXpqg==', '2016-01-15', '192.168.112.44', 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0'),
('PwEEVgmn+nyXP51Px5amtQ==', 3, 'iyKk3UXF+pZuqWX/5a3VlA==', '2016-01-15', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0'),
('rrChInQmNp1U/JFM2AhBoA==', 3, 'du1uh5IgNi9zJA32Qtbfpw==', '2016-01-19', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('SfgyeItDZQ6t4k/h2OF10g==', 3, '16sRalSYm7mxK3XXyvGCHQ==', '2016-01-15', '192.168.112.78', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36'),
('V+DHLYUwBngDr/bh3gHFlQ==', 3, 'BVv4iQiYgQURGlfvDVvt6Q==', '2016-01-14', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'),
('WuWuOTUE+4wlybtUl1Ex5A==', 3, 'PB01YQgygFgRHtwCN6YWzA==', '2016-01-15', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0'),
('X8YH8V2pA6lmn5NHy7JnJw==', 3, 'JMTNg3qsEDjNwBjCO8bsbw==', '2016-01-20', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_user`
--

CREATE TABLE IF NOT EXISTS `jhi_user` (
`id` bigint(20) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(5) DEFAULT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NOT NULL,
  `reset_date` timestamp NULL DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_user`
--

INSERT INTO `jhi_user` (`id`, `login`, `password_hash`, `first_name`, `last_name`, `email`, `activated`, `lang_key`, `activation_key`, `reset_key`, `created_by`, `created_date`, `reset_date`, `last_modified_by`, `last_modified_date`) VALUES
(1, 'system', '$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG', 'System', 'System', 'system@localhost', b'1', 'en', NULL, NULL, 'system', '2015-12-31 16:55:59', NULL, NULL, NULL),
(2, 'anonymousUser', '$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO', 'Anonymous', 'User', 'anonymous@localhost', b'1', 'en', NULL, NULL, 'system', '2015-12-31 16:55:59', NULL, NULL, NULL),
(3, 'admin', '$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC', 'Administrator', 'Administrator', 'admin@localhost', b'1', 'fr', NULL, NULL, 'system', '2015-12-31 16:55:59', NULL, 'admin', '2016-01-08 08:52:19'),
(4, 'user', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K', 'User', 'User', 'user@localhost', b'1', 'fr', NULL, NULL, 'system', '2015-12-31 16:55:59', NULL, 'user', '2016-01-12 14:22:41'),
(7, 'directeur', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K', 'Directeur', 'directeur', 'directeur@mail.com', b'1', 'fr', NULL, '78217796168412447530', 'admin', '2016-01-08 08:41:46', '2016-01-08 08:41:46', 'admin', '2016-01-08 08:54:02'),
(8, 'reseau', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K', 'directeur_reseau', 'directeur_reseau', 'directeur_reseau@mail.com', b'1', 'fr', NULL, '49764249894374361539', 'admin', '2016-01-08 08:54:58', '2016-01-08 08:54:58', 'admin', '2016-01-08 09:07:55'),
(9, 'commercial', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K', NULL, NULL, 'commercial@mail.com', b'1', 'fr', NULL, '93396815704637818791', 'admin', '2016-01-08 09:08:37', '2016-01-08 09:08:37', 'admin', '2016-01-08 09:08:37'),
(10, 'agent', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K', NULL, NULL, 'agent@mail.com', b'1', 'fr', NULL, '77862557812402119209', 'admin', '2016-01-08 09:09:06', '2016-01-08 09:09:06', 'admin', '2016-01-08 09:09:06'),
(11, 'gestionnaire', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K', NULL, NULL, 'gestionnaire@mail.com', b'1', 'fr', NULL, '47400122750374289544', 'admin', '2016-01-08 09:10:00', '2016-01-08 09:10:00', 'admin', '2016-01-08 11:27:35');

-- --------------------------------------------------------

--
-- Structure de la table `jhi_user_authority`
--

CREATE TABLE IF NOT EXISTS `jhi_user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jhi_user_authority`
--

INSERT INTO `jhi_user_authority` (`user_id`, `authority_name`) VALUES
(1, 'ROLE_ADMIN'),
(3, 'ROLE_ADMIN'),
(10, 'ROLE_AGENT'),
(7, 'ROLE_DIRECTEUR'),
(8, 'ROLE_DIRECTEUR_RESEAU'),
(11, 'ROLE_GESTIONNAIRE'),
(9, 'ROLE_MANAGER_COMMERCIAL'),
(1, 'ROLE_USER'),
(3, 'ROLE_USER'),
(4, 'ROLE_USER'),
(10, 'ROLE_USER'),
(11, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
`id` bigint(20) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `civilite` varchar(255) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `date_obtention_permis` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `numero_cin` varchar(255) DEFAULT NULL,
  `numero_patente` varchar(255) DEFAULT NULL,
  `numero_permis` varchar(255) DEFAULT NULL,
  `raison_sociale` varchar(255) DEFAULT NULL,
  `rc` varchar(255) DEFAULT NULL,
  `secteur_activite_id` bigint(20) DEFAULT NULL,
  `situation_familiale_id` bigint(20) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `telephone`, `titre`, `civilite`, `date_naissance`, `date_obtention_permis`, `email`, `numero_cin`, `numero_patente`, `numero_permis`, `raison_sociale`, `rc`, `secteur_activite_id`, `situation_familiale_id`, `ville`, `type`) VALUES
(3, 'Zinoun', 'Badr Eddine', '06505050', NULL, NULL, NULL, NULL, NULL, 'BE888111', NULL, NULL, NULL, NULL, NULL, NULL, 'Casablanca', NULL),
(4, 'Lahlou', 'Mehdi', NULL, NULL, NULL, '1980-01-19', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Casablanca', NULL),
(5, 'Raja', 'Soufiane', NULL, NULL, NULL, '1980-01-19', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Rabat', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `prospection`
--

CREATE TABLE IF NOT EXISTS `prospection` (
`id` bigint(20) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sujet` varchar(255) NOT NULL,
  `compagne_id` bigint(20) DEFAULT NULL,
  `personne_id` bigint(20) DEFAULT NULL,
  `statut_prospection_id` bigint(20) DEFAULT NULL,
  `annee_vignette` int(11) DEFAULT NULL,
  `code_usage` varchar(255) DEFAULT NULL,
  `energie` varchar(255) DEFAULT NULL,
  `immatriculation` varchar(255) DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `modele` varchar(255) DEFAULT NULL,
  `usage_libelle` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `prospection`
--

INSERT INTO `prospection` (`id`, `date_debut`, `date_fin`, `description`, `sujet`, `compagne_id`, `personne_id`, `statut_prospection_id`, `annee_vignette`, `code_usage`, `energie`, `immatriculation`, `marque`, `modele`, `usage_libelle`, `user`) VALUES
(2, '2016-01-01', '2016-01-30', 'Demo project for Wafa CRM', 'Reconversion', 2, 3, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'admin'),
(3, NULL, NULL, NULL, '20160114104638_', 2, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'user'),
(4, NULL, NULL, NULL, 'Vignette2016', 2, 4, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `ref_secteur_activite`
--

CREATE TABLE IF NOT EXISTS `ref_secteur_activite` (
`id` bigint(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ref_situation_familiale`
--

CREATE TABLE IF NOT EXISTS `ref_situation_familiale` (
`id` bigint(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ref_statut_compagne`
--

CREATE TABLE IF NOT EXISTS `ref_statut_compagne` (
`id` bigint(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ref_statut_compagne`
--

INSERT INTO `ref_statut_compagne` (`id`, `code`, `libelle`) VALUES
(1, 'EPHEMERE', 'Ephemere'),
(2, 'FIXE', 'Fixe');

-- --------------------------------------------------------

--
-- Structure de la table `ref_statut_prospection`
--

CREATE TABLE IF NOT EXISTS `ref_statut_prospection` (
`id` bigint(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ref_statut_prospection`
--

INSERT INTO `ref_statut_prospection` (`id`, `code`, `libelle`) VALUES
(1, 'EN_COURS', 'En cours'),
(2, 'TERMINE', 'Términé');

-- --------------------------------------------------------

--
-- Structure de la table `ref_statut_tache`
--

CREATE TABLE IF NOT EXISTS `ref_statut_tache` (
`id` bigint(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ref_statut_tache`
--

INSERT INTO `ref_statut_tache` (`id`, `code`, `libelle`) VALUES
(1, 'TRAITE', 'Traité'),
(2, 'EN_COURS', 'En cours'),
(3, 'NON_COMMENCE', 'Non commencé'),
(4, 'DECALE', 'Décalé');

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE IF NOT EXISTS `tache` (
`id` bigint(20) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `piece_jointe` longblob,
  `piece_jointe_content_type` varchar(255) DEFAULT NULL,
  `prospection_id` bigint(20) DEFAULT NULL,
  `statut_tache_id` bigint(20) DEFAULT NULL,
  `sujet` varchar(255) NOT NULL,
  `user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tache`
--

INSERT INTO `tache` (`id`, `date_debut`, `date_fin`, `description`, `type`, `piece_jointe`, `piece_jointe_content_type`, `prospection_id`, `statut_tache_id`, `sujet`, `user`) VALUES
(6, '2016-01-14', '2016-01-15', NULL, 'TYPE1', NULL, NULL, 2, 2, 'Appler Mr Zinoun', 'admin'),
(7, '2016-01-15', '2016-01-16', NULL, 'TYPE1', NULL, NULL, NULL, 3, 'Envoyer Mail de devis', 'admin');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `action`
--
ALTER TABLE `action`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_4so11k87fg84i04rumfpnf2uy` (`tache_id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `compagne`
--
ALTER TABLE `compagne`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_mi9ls4w0u25q2bbopuno3rudv` (`statut_compagne_id`);

--
-- Index pour la table `databasechangeloglock`
--
ALTER TABLE `databasechangeloglock`
 ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `jhi_authority`
--
ALTER TABLE `jhi_authority`
 ADD PRIMARY KEY (`name`);

--
-- Index pour la table `jhi_persistent_audit_event`
--
ALTER TABLE `jhi_persistent_audit_event`
 ADD PRIMARY KEY (`event_id`), ADD KEY `idx_persistent_audit_event` (`principal`,`event_date`);

--
-- Index pour la table `jhi_persistent_audit_evt_data`
--
ALTER TABLE `jhi_persistent_audit_evt_data`
 ADD PRIMARY KEY (`event_id`,`name`), ADD KEY `idx_persistent_audit_evt_data` (`event_id`);

--
-- Index pour la table `jhi_persistent_token`
--
ALTER TABLE `jhi_persistent_token`
 ADD PRIMARY KEY (`series`), ADD KEY `fk_user_persistent_token` (`user_id`);

--
-- Index pour la table `jhi_user`
--
ALTER TABLE `jhi_user`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `login` (`login`), ADD UNIQUE KEY `idx_user_login` (`login`), ADD UNIQUE KEY `email` (`email`), ADD UNIQUE KEY `idx_user_email` (`email`);

--
-- Index pour la table `jhi_user_authority`
--
ALTER TABLE `jhi_user_authority`
 ADD PRIMARY KEY (`user_id`,`authority_name`), ADD KEY `fk_authority_name` (`authority_name`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_7091a9q9aqq5l7isky80445jy` (`situation_familiale_id`), ADD KEY `FK_ekk3krqdr3ga3beeteid0utk9` (`secteur_activite_id`);

--
-- Index pour la table `prospection`
--
ALTER TABLE `prospection`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_6ab2f1l8yw185ybbhpvlh425h` (`compagne_id`), ADD KEY `FK_hjxdgijmg4qpwewqg9qsj8y0q` (`statut_prospection_id`), ADD KEY `FK_sdab0lpiqkvwib8disaj1m3c1` (`personne_id`);

--
-- Index pour la table `ref_secteur_activite`
--
ALTER TABLE `ref_secteur_activite`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ref_situation_familiale`
--
ALTER TABLE `ref_situation_familiale`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ref_statut_compagne`
--
ALTER TABLE `ref_statut_compagne`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ref_statut_prospection`
--
ALTER TABLE `ref_statut_prospection`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ref_statut_tache`
--
ALTER TABLE `ref_statut_tache`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_i8r9kkt9skth6prk1c5ychlun` (`prospection_id`), ADD KEY `FK_mplrhpyfygpnj8v7c3dpam3vw` (`statut_tache_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `action`
--
ALTER TABLE `action`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `compagne`
--
ALTER TABLE `compagne`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `jhi_persistent_audit_event`
--
ALTER TABLE `jhi_persistent_audit_event`
MODIFY `event_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=85;
--
-- AUTO_INCREMENT pour la table `jhi_user`
--
ALTER TABLE `jhi_user`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `prospection`
--
ALTER TABLE `prospection`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `ref_secteur_activite`
--
ALTER TABLE `ref_secteur_activite`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `ref_situation_familiale`
--
ALTER TABLE `ref_situation_familiale`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `ref_statut_compagne`
--
ALTER TABLE `ref_statut_compagne`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `ref_statut_prospection`
--
ALTER TABLE `ref_statut_prospection`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `ref_statut_tache`
--
ALTER TABLE `ref_statut_tache`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `action`
--
ALTER TABLE `action`
ADD CONSTRAINT `FK_4so11k87fg84i04rumfpnf2uy` FOREIGN KEY (`tache_id`) REFERENCES `tache` (`id`);

--
-- Contraintes pour la table `compagne`
--
ALTER TABLE `compagne`
ADD CONSTRAINT `FK_mi9ls4w0u25q2bbopuno3rudv` FOREIGN KEY (`statut_compagne_id`) REFERENCES `ref_statut_compagne` (`id`);

--
-- Contraintes pour la table `jhi_persistent_audit_evt_data`
--
ALTER TABLE `jhi_persistent_audit_evt_data`
ADD CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`);

--
-- Contraintes pour la table `jhi_persistent_token`
--
ALTER TABLE `jhi_persistent_token`
ADD CONSTRAINT `fk_user_persistent_token` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`);

--
-- Contraintes pour la table `jhi_user_authority`
--
ALTER TABLE `jhi_user_authority`
ADD CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`),
ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
ADD CONSTRAINT `FK_7091a9q9aqq5l7isky80445jy` FOREIGN KEY (`situation_familiale_id`) REFERENCES `ref_situation_familiale` (`id`),
ADD CONSTRAINT `FK_ekk3krqdr3ga3beeteid0utk9` FOREIGN KEY (`secteur_activite_id`) REFERENCES `ref_secteur_activite` (`id`);

--
-- Contraintes pour la table `prospection`
--
ALTER TABLE `prospection`
ADD CONSTRAINT `FK_6ab2f1l8yw185ybbhpvlh425h` FOREIGN KEY (`compagne_id`) REFERENCES `compagne` (`id`),
ADD CONSTRAINT `FK_hjxdgijmg4qpwewqg9qsj8y0q` FOREIGN KEY (`statut_prospection_id`) REFERENCES `ref_statut_prospection` (`id`),
ADD CONSTRAINT `FK_sdab0lpiqkvwib8disaj1m3c1` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
ADD CONSTRAINT `FK_i8r9kkt9skth6prk1c5ychlun` FOREIGN KEY (`prospection_id`) REFERENCES `prospection` (`id`),
ADD CONSTRAINT `FK_mplrhpyfygpnj8v7c3dpam3vw` FOREIGN KEY (`statut_tache_id`) REFERENCES `ref_statut_tache` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
