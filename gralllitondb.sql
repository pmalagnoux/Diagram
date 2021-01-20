-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 20 jan. 2021 à 08:35
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id`, `name`, `ingredienttype_id`) VALUES
(1, 'Riz', 8),
(2, 'Oignon', 6),
(3, 'Parmesan', 9),
(4, 'Sel', 6),
(5, 'Poivre', 6),
(6, 'Bouillon de volaille', 10),
(7, 'Courgette', 2),
(8, 'Carotte', 2),
(9, 'Échalotte', 6),
(10, 'Persil', 13),
(11, 'Thym', 13),
(12, 'Menthe', 13),
(13, 'Gousse d\'ail', 6),
(14, 'Chipolata', 17),
(15, 'Merguez', 17),
(16, 'Bolet', 11),
(17, 'Cèpe', 11),
(18, 'Pleurote', 11),
(19, 'Crevettes', 16),
(20, 'Cabillaud', 12),
(21, 'Saumon', 12),
(22, 'Moule', 16),
(23, 'Filet de poulet', 4),
(24, 'Échine de porc', 4),
(25, 'Calamar', 16),
(35, 'Safran', 6),
(36, 'Piment', 6),
(37, 'Aneth', 13),
(38, 'Huile d\'olive', 14),
(39, 'Huile de colza', 14),
(40, 'Huile de noisette', 14),
(41, 'Pain de campagne', 18),
(42, 'Baguette', 18),
(43, 'Ciboulette ', 13),
(44, 'Orange', 1),
(45, 'Fraise', 1),
(46, 'Pomme', 1),
(47, 'Poire', 2),
(48, 'Noix de Saint-Jacques', 16),
(49, 'Paprika', 6),
(50, 'Oeuf', 10),
(51, 'Béchamel', 15),
(52, 'Gélatine', 10),
(53, 'Farine', 10),
(54, 'Sucre', 10),
(55, 'Lieu noir', 12),
(56, ' Estragon', 13),
(57, 'Coriandre', 13),
(58, ' Chapelure', 10),
(59, 'Beurre', 10),
(60, 'Lait', 10),
(61, 'Chanterelle', 11),
(62, 'Langouste', 16),
(63, 'Homard', 16),
(64, 'Chocolat noir', 10),
(65, 'Chocolat au lait', 10),
(66, 'Rhum', 19),
(67, 'Kirsch', 19),
(68, 'Mozzarella', 9),
(69, 'Levure', 10),
(70, 'Miel', 10),
(71, 'Yaourt', 10),
(72, 'Bière', 19),
(73, 'Jambon', 17),
(74, 'Gruyère ', 9),
(75, 'Pomme de terre', 2),
(76, 'Boeuf haché', 3),
(77, 'Bavette', 3),
(78, 'Pavé de rumsteak', 4),
(79, 'Baron d\'agneau', 5),
(80, 'Filet de boeuf', 3),
(81, 'Faux-filet de boeuf', 3),
(82, 'Côte de porc', 4),
(83, 'Moutarde', 7),
(84, 'Blé', 8),
(85, 'Avoine', 8),
(86, 'Panais', 2),
(87, 'Topinambour', 2),
(90, 'Petits pois', 2);

-- --------------------------------------------------------

--
-- Structure de la table `ingredienttype`
--

DROP TABLE IF EXISTS `ingredienttype`;
CREATE TABLE IF NOT EXISTS `ingredienttype` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

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
(10, 'Divers'),
(11, 'Champignon'),
(12, 'Poisson'),
(13, 'Aromate'),
(14, 'Huile'),
(15, 'Sauce'),
(16, 'Fruit de mer'),
(17, 'Charcuterie'),
(18, 'Pain'),
(19, 'Alcool');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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

-- --------------------------------------------------------

--
-- Structure de la table `step`
--

DROP TABLE IF EXISTS `step`;
CREATE TABLE IF NOT EXISTS `step` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tag`
--

INSERT INTO `tag` (`id`, `tagName`) VALUES
(1, 'Plat d\'hiver'),
(2, 'Petite folie'),
(3, 'Végétarien'),
(4, 'Sans gluten'),
(5, 'Pâtes, riz, semoule'),
(6, 'Les classiques'),
(7, 'Rapide'),
(8, 'Gâteau'),
(9, 'Petits gâteaux'),
(10, 'Sud-Ouest'),
(11, 'Soupe'),
(12, 'Entrée chaude'),
(13, 'Plat unique'),
(14, 'Entrée froide'),
(15, 'Flan salé'),
(16, 'Recette minceur');

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

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
(8, 'Écumoir'),
(9, 'Pinceau'),
(10, 'Shaker'),
(11, 'Saladier'),
(12, 'Louche'),
(13, 'Mixeur'),
(14, 'Four'),
(15, 'Moule'),
(16, 'Fait-tout'),
(17, 'Chaudron'),
(18, 'Marmite'),
(19, 'Râpe'),
(20, 'Plat à gratin'),
(21, 'Écumoire');

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
