-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 16 déc. 2020 à 14:16
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gralllitondb`
--
CREATE DATABASE IF NOT EXISTS `gralllitondb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gralllitondb`;

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `mailAddress` varchar(254) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `account_id` int(20) UNSIGNED NOT NULL,
  `recipe_id` int(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `recipe_id` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `difficulty`
--

DROP TABLE IF EXISTS `difficulty`;
CREATE TABLE IF NOT EXISTS `difficulty` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `favoriterecipe`
--

DROP TABLE IF EXISTS `favoriterecipe`;
CREATE TABLE IF NOT EXISTS `favoriterecipe` (
  `account_id` int(20) UNSIGNED NOT NULL,
  `recipe_id` int(20) UNSIGNED NOT NULL,
  KEY `account_id` (`account_id`),
  KEY `recipe_id` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ingredienttype`
--

DROP TABLE IF EXISTS `ingredienttype`;
CREATE TABLE IF NOT EXISTS `ingredienttype` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `ingredient_id` int(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ingredient_id` (`ingredient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ingredientunit`
--

DROP TABLE IF EXISTS `ingredientunit`;
CREATE TABLE IF NOT EXISTS `ingredientunit` (
  `ingredient_id` int(20) UNSIGNED NOT NULL,
  `unit_id` int(20) UNSIGNED NOT NULL,
  KEY `ingredient_id` (`ingredient_id`),
  KEY `unit_id` (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
CREATE TABLE IF NOT EXISTS `recipe` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) NOT NULL,
  `preparationTime` int(10) UNSIGNED DEFAULT NULL,
  `cookingTime` int(10) UNSIGNED DEFAULT NULL,
  `likeNumber` int(10) UNSIGNED DEFAULT NULL,
  `quantity` int(10) UNSIGNED NOT NULL COMMENT 'Nombre de personnes pour la quantité des ingrédients données.',
  `account_id` int(20) UNSIGNED NOT NULL,
  `difficulty_id` int(20) UNSIGNED NOT NULL,
  `recipeType_id` int(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `Difficulty_id` (`difficulty_id`),
  KEY `RecipeType_id` (`recipeType_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `recipeingredient`
--

DROP TABLE IF EXISTS `recipeingredient`;
CREATE TABLE IF NOT EXISTS `recipeingredient` (
  `quantity` int(10) UNSIGNED NOT NULL,
  `ingredient_id` int(20) UNSIGNED NOT NULL,
  `recipe_id` int(20) UNSIGNED NOT NULL,
  KEY `ingredient_id` (`ingredient_id`),
  KEY `recipe_id` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `recipestep`
--

DROP TABLE IF EXISTS `recipestep`;
CREATE TABLE IF NOT EXISTS `recipestep` (
  `stepOrder` int(10) UNSIGNED NOT NULL,
  `recipe_id` int(20) UNSIGNED NOT NULL,
  `step_id` int(20) UNSIGNED NOT NULL,
  KEY `recipe_id` (`recipe_id`),
  KEY `step_id` (`step_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `recipetag`
--

DROP TABLE IF EXISTS `recipetag`;
CREATE TABLE IF NOT EXISTS `recipetag` (
  `recipe_id` int(20) UNSIGNED NOT NULL,
  `tag_id` int(20) UNSIGNED NOT NULL,
  KEY `recipe_id` (`recipe_id`),
  KEY `tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `recipetype`
--

DROP TABLE IF EXISTS `recipetype`;
CREATE TABLE IF NOT EXISTS `recipetype` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `recipeustensil`
--

DROP TABLE IF EXISTS `recipeustensil`;
CREATE TABLE IF NOT EXISTS `recipeustensil` (
  `quantity` int(10) UNSIGNED NOT NULL DEFAULT '1',
  `recipe_id` int(20) UNSIGNED NOT NULL,
  `ustensil_id` int(20) UNSIGNED NOT NULL,
  KEY `recipe_id` (`recipe_id`),
  KEY `ustensil_id` (`ustensil_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `step`
--

DROP TABLE IF EXISTS `step`;
CREATE TABLE IF NOT EXISTS `step` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `stockingredient`
--

DROP TABLE IF EXISTS `stockingredient`;
CREATE TABLE IF NOT EXISTS `stockingredient` (
  `quantity` int(10) UNSIGNED NOT NULL DEFAULT '1',
  `account_id` int(20) UNSIGNED NOT NULL,
  `ingredient_id` int(20) UNSIGNED NOT NULL,
  KEY `account_id` (`account_id`),
  KEY `ingredient_id` (`ingredient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tag`
--

DROP TABLE IF EXISTS `tag`;
CREATE TABLE IF NOT EXISTS `tag` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tagName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE IF NOT EXISTS `unit` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `ConversionRateSI` float NOT NULL DEFAULT '1' COMMENT 'Taux de conversion à appliquer pour avoir la conversion dans le système international.',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ustensil`
--

DROP TABLE IF EXISTS `ustensil`;
CREATE TABLE IF NOT EXISTS `ustensil` (
  `id` int(20) UNSIGNED NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`);

--
-- Contraintes pour la table `favoriterecipe`
--
ALTER TABLE `favoriterecipe`
  ADD CONSTRAINT `favoriterecipe_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `favoriterecipe_ibfk_2` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`);

--
-- Contraintes pour la table `ingredienttype`
--
ALTER TABLE `ingredienttype`
  ADD CONSTRAINT `ingredienttype_ibfk_1` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`);

--
-- Contraintes pour la table `ingredientunit`
--
ALTER TABLE `ingredientunit`
  ADD CONSTRAINT `ingredientunit_ibfk_1` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`),
  ADD CONSTRAINT `ingredientunit_ibfk_2` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`);

--
-- Contraintes pour la table `recipe`
--
ALTER TABLE `recipe`
  ADD CONSTRAINT `recipe_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `recipe_ibfk_2` FOREIGN KEY (`difficulty_id`) REFERENCES `difficulty` (`id`),
  ADD CONSTRAINT `recipe_ibfk_3` FOREIGN KEY (`recipeType_id`) REFERENCES `recipetype` (`id`);

--
-- Contraintes pour la table `recipeingredient`
--
ALTER TABLE `recipeingredient`
  ADD CONSTRAINT `recipeingredient_ibfk_1` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`),
  ADD CONSTRAINT `recipeingredient_ibfk_2` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`);

--
-- Contraintes pour la table `recipestep`
--
ALTER TABLE `recipestep`
  ADD CONSTRAINT `recipestep_ibfk_1` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`),
  ADD CONSTRAINT `recipestep_ibfk_2` FOREIGN KEY (`step_id`) REFERENCES `step` (`id`);

--
-- Contraintes pour la table `recipetag`
--
ALTER TABLE `recipetag`
  ADD CONSTRAINT `recipetag_ibfk_1` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`),
  ADD CONSTRAINT `recipetag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`);

--
-- Contraintes pour la table `recipeustensil`
--
ALTER TABLE `recipeustensil`
  ADD CONSTRAINT `recipeustensil_ibfk_1` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`),
  ADD CONSTRAINT `recipeustensil_ibfk_2` FOREIGN KEY (`ustensil_id`) REFERENCES `ustensil` (`id`);

--
-- Contraintes pour la table `stockingredient`
--
ALTER TABLE `stockingredient`
  ADD CONSTRAINT `stockingredient_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `stockingredient_ibfk_2` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
