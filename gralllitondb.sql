-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 20 jan. 2021 à 16:17
-- Version du serveur :  10.4.13-MariaDB
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
  `password` varchar(50) NOT NULL,
  `mailAddress` varchar(254) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `mailAddress`) VALUES
(7, 'Paulo', 'n4bQgYhMfWWaL+qgxVrQFaO/TxsrC4Is0V1sFbDwCgg=', 'paul@malagnoux.com'),
(8, 'FLOFLO', 'jZae727K08KaOmKSgOaGzww/XVqGr/PKEgIMkjrcbJI=', 'florian.miller@bbox.fr');

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

--
-- Déchargement des données de la table `favoriterecipe`
--

INSERT INTO `favoriterecipe` (`account_id`, `recipe_id`) VALUES
(7, 4),
(8, 4);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `recipe`
--

INSERT INTO `recipe` (`id`, `name`, `preparationTime`, `cookingTime`, `likeNumber`, `quantity`, `account_id`, `difficulty_id`, `recipeType_id`) VALUES
(4, 'Risotto aux champignons', 45, 30, NULL, 2, 7, 3, 1),
(5, 'Gâteau au chocolat', 10, 30, NULL, 6, 8, 1, 3);

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
(250, 17, 4),
(200, 1, 4),
(1, 38, 4),
(10, 59, 4),
(50, 6, 4),
(1, 2, 4),
(10, 3, 4),
(1, 13, 4),
(1, 9, 4),
(2, 10, 4),
(1, 4, 4),
(1, 5, 4),
(20, 16, 4),
(200, 64, 5),
(100, 59, 5),
(3, 50, 5),
(50, 53, 5),
(100, 54, 5);

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
(1, 4, 8),
(2, 4, 9),
(3, 4, 10),
(4, 4, 11),
(5, 4, 12),
(6, 4, 13),
(7, 4, 14),
(8, 4, 15),
(9, 4, 16),
(10, 4, 17),
(11, 4, 18),
(12, 4, 19),
(13, 4, 20),
(14, 4, 21),
(15, 4, 22),
(16, 4, 23),
(17, 4, 24),
(18, 4, 25),
(19, 4, 26),
(20, 4, 27),
(1, 5, 28),
(2, 5, 29),
(3, 5, 30),
(4, 5, 31),
(5, 5, 32),
(6, 5, 33);

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
(4, 3),
(4, 5),
(5, 3),
(5, 8),
(5, 16);

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
(1, 4, 4),
(1, 4, 7),
(1, 4, 3),
(1, 4, 19),
(1, 5, 5),
(1, 5, 3),
(1, 5, 15),
(1, 5, 14),
(1, 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `step`
--

DROP TABLE IF EXISTS `step`;
CREATE TABLE IF NOT EXISTS `step` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `step`
--

INSERT INTO `step` (`id`, `content`) VALUES
(8, 'Il existe sur la toile deux écoles du risotto aux champignons, à savoir celle du champignon qui cuit dans le riz, et celle des champignons poêlés ajoutés à la dernière minute. Ayant longtemps pratiqué les deux recettes, je souhaitais vous communiquer la mienne : '),
(9, 'Séparer les champignons en deux (préférer des cèpes) : une partie servira à élaborer le bouillon et cuira avec le riz. L\'autre partie sera poêlé au dernier moment pour la présentation et mettre en avant le champignon tout en conservant une texture ferme.\r\nEmincer un petit peu d\'ail, d\'échalote et de persil séparément et réserver. '),
(10, 'Nettoyer les champignons et les couper en morceaux.'),
(11, 'Faire blondir dans une casserole un demi-oignon émincé dans un mélange de beurre et d\'huile d\'olive.'),
(12, 'Ajouter et poêler les champignons. '),
(13, 'Ajouter du bouillon de légume ou de poule (assez pour nourrir le risotto). '),
(14, 'Laisser mijoter le bouillon pour qu\'il s\'imprègne bien du goût et des saveurs des champignons. '),
(15, 'Chauffer une nouvelle casserole (qui accueillera le risotto), ajouter un peu d\'huile d\'olive et de beurre que vous ferez blondir. '),
(16, 'Ajouter le riz carnaroli et remuer jusqu\'à le rendre translucide (attention à la température, le riz ne doit pas coller). '),
(17, 'Déglacer avec un verre de vin blanc sec. Continuer à remuer pour que le riz n\'adhère pas et laisser réduire l\'alcool. '),
(18, 'Verser une louche de bouillon que vous avez laissé mijoter et continuer à remuer constamment jusqu\'à l\'absorption totale du riz. '),
(19, 'Réitérer l\'étape 11 jusqu\'au point de cuisson (préférer al dente). '),
(20, 'Juste avant la fin, faire fondre du beurre et un peu d\'huile d\'olive dans une poêle tout en remuant le risotto. '),
(21, 'Faire blondir l\'échalote émincée dans la poêle puis ajouter l\'ail (attention à ne pas le brûler). '),
(22, 'Faire poêler les champignons tout en remuant le risotto, assaisonner et ajouter le persil émincé en fin de cuisson avec un tour de moulin à poivre puis réserver. '),
(23, 'Assaisonner le risotto juste avant la fin. '),
(24, 'Ciseler du persil et en parsemer au dessus. '),
(25, 'Dresser le riz dans des assiettes creuses. Placer soigneusement sur le haut les champignons poêlés. '),
(26, 'Servir avec un tour de moulin à poivre et du parmesan. '),
(27, 'Le gras du beurre va s\'opposer au salé du parmesan et à l\'amertume du cèpe en arrière plan. Les puristes privilégieront un rouge italien d\'âge moyen avec une structure légère mais à la fois ronde et consistante. Personnellement, je préfère un blanc sec minéral un peu évolué au accent de sous-bois. Un bourgogne fera parfaitement l\'affaire. Bon appétit '),
(28, 'Préchauffez votre four à 180°C (thermostat 6).\r\nDans une casserole, faites fondre le chocolat et le beurre coupé en morceaux à feu très doux.'),
(29, 'Dans un saladier, ajoutez le sucre, les oeufs, la farine. Mélangez. '),
(30, 'Ajoutez le mélange chocolat/beurre. Mélangez bien. '),
(31, 'Beurrez et farinez votre moule puis y versez la pâte à gâteau. '),
(32, 'Faites cuire au four environ 20 minutes. '),
(33, 'A la sortie du four le gâteau ne paraît pas assez cuit. C\'est normal, laissez-le refroidir puis démoulez- le. ');

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
