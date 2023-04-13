-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Ápr 12. 14:14
-- Kiszolgáló verziója: 10.4.27-MariaDB
-- PHP verzió: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `vizsga`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `cart`
--

CREATE TABLE `cart` (
  `id` varchar(36) NOT NULL,
  `total` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `menuItemFoodId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `menu`
--

CREATE TABLE `menu` (
  `food_id` int(11) NOT NULL,
  `food_name` varchar(255) NOT NULL,
  `food_description` varchar(255) NOT NULL,
  `food_category` varchar(255) NOT NULL,
  `food_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `menu`
--

INSERT INTO `menu` (`food_id`, `food_name`, `food_description`, `food_category`, `food_price`) VALUES
(5, 'getto', 'Geco', '', 0),
(6, 'Kaja', 'finom', '', 0),
(7, 'kaja', 'fasza', '', 0),
(20, 'dsfds', 'dfdsf', 'fsdf', 35),
(21, 'eqwewq', 'qwewq', 'wqewqe', 421412);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `token`
--

CREATE TABLE `token` (
  `token` varchar(255) NOT NULL,
  `userId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user_address`
--

CREATE TABLE `user_address` (
  `id` int(11) NOT NULL,
  `adress` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `postalCode` varchar(255) NOT NULL,
  `mobileNumber` varchar(255) NOT NULL,
  `userId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_756f53ab9466eb52a52619ee019` (`userId`),
  ADD KEY `FK_42b69f0e42fdc2d980e57511360` (`menuItemFoodId`);

--
-- A tábla indexei `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`food_id`);

--
-- A tábla indexei `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`token`),
  ADD KEY `FK_94f168faad896c0786646fa3d4a` (`userId`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `user_address`
--
ALTER TABLE `user_address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_1abd8badc4a127b0f357d9ecbc2` (`userId`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `menu`
--
ALTER TABLE `menu`
  MODIFY `food_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `user_address`
--
ALTER TABLE `user_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `FK_42b69f0e42fdc2d980e57511360` FOREIGN KEY (`menuItemFoodId`) REFERENCES `menu` (`food_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_756f53ab9466eb52a52619ee019` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Megkötések a táblához `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `FK_94f168faad896c0786646fa3d4a` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Megkötések a táblához `user_address`
--
ALTER TABLE `user_address`
  ADD CONSTRAINT `FK_1abd8badc4a127b0f357d9ecbc2` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
