-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 28 déc. 2020 à 10:31
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gralllitondb`
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
  `password` varchar(50) NOT NULL,
  `mailAddress` varchar(254) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `mailAddress`) VALUES
(4, 'f3nrir', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', 'florian.miller.jeux@gmail.com');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `difficulty`
--

INSERT INTO `difficulty` (`id`, `name`) VALUES
(1, 'Très facile'),
(2, 'Facile'),
(3, 'Normale'),
(4, 'Difficile'),
(5, 'Très difficile');

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
  `ingredienttype_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ingredienttype_id` (`ingredienttype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id`, `name`, `ingredienttype_id`) VALUES
(1, 'Riz', 8),
(2, 'Oignon', 6),
(3, 'Parmesan', 9),
(4, 'Sel', 6),
(5, 'Poivre', 6),
(6, 'Bouillon de volaille', 10);

-- --------------------------------------------------------

--
-- Structure de la table `ingredienttype`
--

DROP TABLE IF EXISTS `ingredienttype`;
CREATE TABLE IF NOT EXISTS `ingredienttype` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ingredienttype`
--

INSERT INTO `ingredienttype` (`id`, `name`) VALUES
(1, 'Fruit'),
(2, 'Légume'),
(3, 'Viande rouge'),
(4, 'Viande blanche'),
(5, 'Vin'),
(6, 'Épice'),
(7, 'Condiment'),
(8, 'Céréale'),
(9, 'Fromage'),
(10, 'Divers');

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
-- Structure de la table `picture`
--

DROP TABLE IF EXISTS `picture`;
CREATE TABLE IF NOT EXISTS `picture` (
  `id` int(20) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL,
  `content` blob NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `recipe`
--

INSERT INTO `recipe` (`id`, `name`, `preparationTime`, `cookingTime`, `likeNumber`, `quantity`, `account_id`, `difficulty_id`, `recipeType_id`) VALUES
(1, 'Risotto aux cèpes', 20, 40, NULL, 2, 4, 3, 1);

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

--
-- Déchargement des données de la table `recipeingredient`
--

INSERT INTO `recipeingredient` (`quantity`, `ingredient_id`, `recipe_id`) VALUES
(100, 1, 1),
(50, 3, 1),
(10, 4, 1);

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

--
-- Déchargement des données de la table `recipestep`
--

INSERT INTO `recipestep` (`stepOrder`, `recipe_id`, `step_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3);

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

--
-- Déchargement des données de la table `recipetag`
--

INSERT INTO `recipetag` (`recipe_id`, `tag_id`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `recipetype`
--

DROP TABLE IF EXISTS `recipetype`;
CREATE TABLE IF NOT EXISTS `recipetype` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `recipetype`
--

INSERT INTO `recipetype` (`id`, `name`) VALUES
(1, 'Plat principal'),
(2, 'Entrée'),
(3, 'Dessert'),
(4, 'Amuse-bouche');

-- --------------------------------------------------------

--
-- Structure de la table `recipeustensil`
--

DROP TABLE IF EXISTS `recipeustensil`;
CREATE TABLE IF NOT EXISTS `recipeustensil` (
  `quantity` int(10) UNSIGNED NOT NULL DEFAULT 1,
  `recipe_id` int(20) UNSIGNED NOT NULL,
  `ustensil_id` int(20) UNSIGNED NOT NULL,
  KEY `recipe_id` (`recipe_id`),
  KEY `ustensil_id` (`ustensil_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `recipeustensil`
--

INSERT INTO `recipeustensil` (`quantity`, `recipe_id`, `ustensil_id`) VALUES
(2, 1, 7),
(1, 1, 3),
(1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `step`
--

DROP TABLE IF EXISTS `step`;
CREATE TABLE IF NOT EXISTS `step` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `step`
--

INSERT INTO `step` (`id`, `content`) VALUES
(1, 'e1'),
(2, 'e2'),
(3, 'e3');

-- --------------------------------------------------------

--
-- Structure de la table `stockingredient`
--

DROP TABLE IF EXISTS `stockingredient`;
CREATE TABLE IF NOT EXISTS `stockingredient` (
  `quantity` int(10) UNSIGNED NOT NULL DEFAULT 1,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tag`
--

INSERT INTO `tag` (`id`, `tagName`) VALUES
(1, 'plat d\'hiver'),
(2, 'petite folie');

-- --------------------------------------------------------

--
-- Structure de la table `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE IF NOT EXISTS `unit` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `ConversionRateSI` float NOT NULL DEFAULT 1 COMMENT 'Taux de conversion à appliquer pour avoir la conversion dans le système international.',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ustensil`
--

DROP TABLE IF EXISTS `ustensil`;
CREATE TABLE IF NOT EXISTS `ustensil` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ustensil`
--

INSERT INTO `ustensil` (`id`, `name`) VALUES
(1, 'Bol'),
(2, 'Poèle'),
(3, 'Cuillère en bois'),
(4, 'Couteau'),
(5, 'Fouet'),
(6, 'Rouleau à pâtisserie'),
(7, 'Casserole'),
(8, 'Écumoir');

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
-- Contraintes pour la table `ingredient`
--
ALTER TABLE `ingredient`
  ADD CONSTRAINT `ingredient_ibfk_1` FOREIGN KEY (`ingredienttype_id`) REFERENCES `ingredienttype` (`id`);

--
-- Contraintes pour la table `ingredientunit`
--
ALTER TABLE `ingredientunit`
  ADD CONSTRAINT `ingredientunit_ibfk_1` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`),
  ADD CONSTRAINT `ingredientunit_ibfk_2` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`);

--
-- Contraintes pour la table `picture`
--
ALTER TABLE `picture`
  ADD CONSTRAINT `picture_ibfk_1` FOREIGN KEY (`id`) REFERENCES `recipe` (`id`);

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
