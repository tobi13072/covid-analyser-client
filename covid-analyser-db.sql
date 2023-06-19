-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 19 Cze 2023, 18:33
-- Wersja serwera: 10.4.27-MariaDB
-- Wersja PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `coviddb`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `continent`
--

CREATE TABLE `continent` (
  `continent_id` int(9) NOT NULL,
  `continent_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `continent`
--

INSERT INTO `continent` (`continent_id`, `continent_name`) VALUES
(1, 'Australia-Oceania'),
(2, 'Asia'),
(3, 'North-America'),
(4, 'South-America'),
(5, 'Europe'),
(6, 'Africa');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `continent_seq`
--

CREATE TABLE `continent_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `continent_seq`
--

INSERT INTO `continent_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `country`
--

CREATE TABLE `country` (
  `country_id` int(9) NOT NULL,
  `country_name` varchar(255) DEFAULT NULL,
  `continent_id` int(9) DEFAULT NULL,
  `who_id` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `country`
--

INSERT INTO `country` (`country_id`, `country_name`, `continent_id`, `who_id`) VALUES
(1, 'USA', 3, 1),
(2, 'Brazil', 4, 1),
(3, 'India', 2, 2),
(4, 'Russia', 5, 3),
(5, 'South Africa', 6, 4),
(6, 'Mexico', 3, 1),
(7, 'Peru', 4, 1),
(8, 'Chile', 4, 1),
(9, 'Colombia', 4, 1),
(10, 'Spain', 5, 3),
(11, 'Iran', 2, 5),
(12, 'UK', 5, 3),
(13, 'Saudi Arabia', 2, 5),
(14, 'Pakistan', 2, 5),
(15, 'Bangladesh', 2, 2),
(16, 'Italy', 5, 3),
(17, 'Turkey', 2, 3),
(18, 'Argentina', 4, 1),
(19, 'Germany', 5, 3),
(20, 'France', 5, 3),
(21, 'Iraq', 2, 5),
(22, 'Philippines', 2, 6),
(23, 'Indonesia', 2, 2),
(24, 'Canada', 3, 1),
(25, 'Qatar', 2, 5),
(26, 'Kazakhstan', 2, 3),
(27, 'Egypt', 6, 5),
(28, 'Ecuador', 4, 1),
(29, 'Bolivia', 4, 1),
(30, 'Sweden', 5, 3),
(31, 'Oman', 2, 5),
(32, 'Israel', 2, 3),
(33, 'Ukraine', 5, 3),
(34, 'Dominican Republic', 3, 1),
(35, 'Panama', 3, 1),
(36, 'Belgium', 5, 3),
(37, 'Kuwait', 2, 5),
(38, 'Belarus', 5, 3),
(39, 'UAE', 2, 5),
(40, 'Romania', 5, 3),
(41, 'Netherlands', 5, 3),
(42, 'Singapore', 2, 6),
(43, 'Guatemala', 3, 1),
(44, 'Portugal', 5, 3),
(45, 'Poland', 5, 3),
(46, 'Nigeria', 6, 4),
(47, 'Honduras', 3, 1),
(48, 'Bahrain', 2, 5),
(49, 'Japan', 2, 6),
(50, 'Armenia', 2, 3),
(51, 'Ghana', 6, 4),
(52, 'Kyrgyzstan', 2, 3),
(53, 'Afghanistan', 2, 5),
(54, 'Switzerland', 5, 3),
(55, 'Algeria', 6, 4),
(56, 'Azerbaijan', 2, 3),
(57, 'Morocco', 6, 5),
(58, 'Uzbekistan', 2, 3),
(59, 'Serbia', 5, 3),
(60, 'Moldova', 5, 3),
(61, 'Ireland', 5, 3),
(62, 'Kenya', 6, 4),
(63, 'Venezuela', 4, 1),
(64, 'Nepal', 2, 2),
(65, 'Austria', 5, 3),
(66, 'Costa Rica', 3, 1),
(67, 'Ethiopia', 6, 4),
(68, 'Australia', 1, 6),
(69, 'El Salvador', 3, 1),
(70, 'Czechia', 5, 3),
(71, 'Cameroon', 6, 4),
(72, 'Ivory Coast', 6, 4),
(73, 'S. Korea', 2, 6),
(74, 'Denmark', 5, 3),
(75, 'Palestine', 2, 5),
(76, 'Bosnia and Herzegovina', 5, 3),
(77, 'Bulgaria', 5, 3),
(78, 'Madagascar', 6, 4),
(79, 'Sudan', 6, 5),
(80, 'North Macedonia', 5, 3),
(81, 'Senegal', 6, 4),
(82, 'Norway', 5, 3),
(83, 'DRC', 6, 4),
(84, 'Malaysia', 2, 6),
(85, 'French Guiana', 4, NULL),
(86, 'Gabon', 6, 4),
(87, 'Tajikistan', 2, 3),
(88, 'Guinea', 6, 4),
(89, 'Haiti', 3, 1),
(90, 'Finland', 5, 3),
(91, 'Zambia', 6, 4),
(92, 'Luxembourg', 5, 3),
(93, 'Mauritania', 6, 4),
(94, 'Paraguay', 4, 1),
(95, 'Albania', 5, 3),
(96, 'Lebanon', 2, 5),
(97, 'Croatia', 5, 3),
(98, 'Djibouti', 6, 5),
(99, 'Greece', 5, 3),
(100, 'Libya', 6, 5),
(101, 'Equatorial Guinea', 6, 4),
(102, 'Maldives', 2, 2),
(103, 'CAR', 6, NULL),
(104, 'Hungary', 5, 3),
(105, 'Malawi', 6, 4),
(106, 'Zimbabwe', 6, 4),
(107, 'Nicaragua', 3, 1),
(108, 'Hong Kong', 2, 6),
(109, 'Congo', 6, 4),
(110, 'Montenegro', 5, 3),
(111, 'Thailand', 2, 2),
(112, 'Somalia', 6, 5),
(113, 'Mayotte', 6, NULL),
(114, 'Eswatini', 6, 4),
(115, 'Sri Lanka', 2, 2),
(116, 'Cuba', 3, 1),
(117, 'Cabo Verde', 6, 4),
(118, 'Namibia', 6, 4),
(119, 'Mali', 6, 4),
(120, 'Slovakia', 5, 3),
(121, 'South Sudan', 6, 4),
(122, 'Slovenia', 5, 3),
(123, 'Lithuania', 5, 3),
(124, 'Estonia', 5, 3),
(125, 'Mozambique', 6, 4),
(126, 'Rwanda', 6, 4),
(127, 'Suriname', 4, 1),
(128, 'Guinea-Bissau', 6, 4),
(129, 'Benin', 6, 4),
(130, 'Iceland', 5, 3),
(131, 'Sierra Leone', 6, 4),
(132, 'Yemen', 2, 5),
(133, 'Tunisia', 6, 5),
(134, 'New Zealand', 1, 6),
(135, 'Angola', 6, 4),
(136, 'Uruguay', 4, 1),
(137, 'Latvia', 5, 3),
(138, 'Jordan', 2, 5),
(139, 'Liberia', 6, 4),
(140, 'Uganda', 6, 4),
(141, 'Cyprus', 2, 3),
(142, 'Georgia', 2, 3),
(143, 'Burkina Faso', 6, 4),
(144, 'Niger', 6, 4),
(145, 'Togo', 6, 4),
(146, 'Syria', 2, 5),
(147, 'Jamaica', 3, 1),
(148, 'Malta', 5, 3),
(149, 'Andorra', 5, 3),
(150, 'Chad', 6, 4),
(151, 'Gambia', 6, 4),
(152, 'Sao Tome and Principe', 6, 4),
(153, 'Botswana', 6, 4),
(154, 'Bahamas', 3, 1),
(155, 'Vietnam', 2, 6),
(156, 'Lesotho', 6, 4),
(157, 'Diamond Princess', NULL, NULL),
(158, 'San Marino', 5, 3),
(159, 'RĂ©union', 6, NULL),
(160, 'Channel Islands', 5, NULL),
(161, 'Guyana', 4, 1),
(162, 'Tanzania', 6, 4),
(163, 'Taiwan', 2, 6),
(164, 'Comoros', 6, 4),
(165, 'Burundi', 6, 4),
(166, 'Myanmar', 2, 2),
(167, 'Mauritius', 6, 4),
(168, 'Isle of Man', 5, NULL),
(169, 'Mongolia', 2, 6),
(170, 'Eritrea', 6, 4),
(171, 'Guadeloupe', 3, NULL),
(172, 'Martinique', 3, NULL),
(173, 'Faeroe Islands', 5, NULL),
(174, 'Aruba', 3, NULL),
(175, 'Cambodia', 2, 6),
(176, 'Trinidad and Tobago', 3, 1),
(177, 'Cayman Islands', 3, NULL),
(178, 'Gibraltar', 5, NULL),
(179, 'Papua New Guinea', 1, 6),
(180, 'Sint Maarten', 3, NULL),
(181, 'Bermuda', 3, 1),
(182, 'Brunei ', 2, NULL),
(183, 'Barbados', 3, 1),
(184, 'Turks and Caicos', 3, NULL),
(185, 'Seychelles', 6, 4),
(186, 'Monaco', 5, 3),
(187, 'Bhutan', 2, 2),
(188, 'Antigua and Barbuda', 3, 1),
(189, 'Liechtenstein', 5, 3),
(190, 'Belize', 3, 1),
(191, 'French Polynesia', 1, NULL),
(192, 'St. Vincent Grenadines', 3, NULL),
(193, 'Saint Martin', 3, NULL),
(194, 'Macao', 2, NULL),
(195, 'CuraĂ§ao', 3, NULL),
(196, 'Fiji', 1, 6),
(197, 'Saint Lucia', 3, 1),
(198, 'Timor-Leste', 2, 2),
(199, 'Grenada', 3, 1),
(200, 'New Caledonia', 1, NULL),
(201, 'Laos', 2, 6),
(202, 'Dominica', 3, 1),
(203, 'Saint Kitts and Nevis', 3, 1),
(204, 'Greenland', 3, 3),
(205, 'Montserrat', 3, NULL),
(206, 'Caribbean Netherlands', 3, NULL),
(207, 'Falkland Islands', 4, NULL),
(208, 'Vatican City', 5, 3),
(209, 'Western Sahara', 6, 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `countrystat`
--

CREATE TABLE `countrystat` (
  `stat_id` int(9) NOT NULL,
  `country_id` int(9) DEFAULT NULL,
  `country_population` bigint(20) DEFAULT NULL,
  `total_cases` int(9) DEFAULT NULL,
  `total_deaths` int(9) DEFAULT NULL,
  `total_recovered` int(9) DEFAULT NULL,
  `active_cases` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `countrystat`
--

INSERT INTO `countrystat` (`stat_id`, `country_id`, `country_population`, `total_cases`, `total_deaths`, `total_recovered`, `active_cases`) VALUES
(1, 1, 331198130, 5032179, 162804, 2576668, 2292707),
(2, 2, 212710692, 2917562, 98644, 2047660, 771258),
(3, 3, 1381344997, 2025409, 41638, 1377384, 606387),
(4, 4, 145940924, 871894, 14606, 676357, 180931),
(5, 5, 59381566, 538184, 9604, 387316, 141264),
(6, 6, 129066160, 462690, 50517, 308848, 103325),
(7, 7, 33016319, 455409, 20424, 310337, 124648),
(8, 8, 19132514, 366671, 9889, 340168, 16614),
(9, 9, 50936262, 357710, 11939, 192355, 153416),
(10, 10, 187026592, 1418120, 114000, 24, 24),
(11, 11, 84097623, 320117, 17976, 277463, 24678),
(12, 12, 67922029, 308134, 46413, 0, 0),
(13, 13, 34865919, 284226, 3055, 247089, 34082),
(14, 14, 221295851, 281863, 6035, 256058, 19770),
(15, 15, 164851401, 249651, 3306, 143824, 102521),
(16, 16, 60452568, 249204, 35187, 201323, 12694),
(17, 17, 84428331, 237265, 5798, 220546, 10921),
(18, 18, 45236884, 228195, 4251, 99852, 124092),
(19, 19, 83811260, 215210, 9252, 196200, 9758),
(20, 20, 65288306, 195633, 30312, 82460, 82861),
(21, 21, 40306025, 140603, 5161, 101025, 34417),
(22, 22, 109722719, 119460, 2150, 66837, 50473),
(23, 23, 273808365, 118753, 5521, 75645, 37587),
(24, 24, 37775022, 118561, 8966, 103106, 6489),
(25, 25, 2807805, 112092, 178, 108831, 3083),
(26, 26, 18798667, 95942, 1058, 68871, 26013),
(27, 27, 102516525, 95006, 4951, 48898, 41157),
(28, 28, 17668824, 90537, 5877, 71318, 13342),
(29, 29, 11688459, 86423, 3465, 27373, 55585),
(30, 30, 10105596, 81967, 5766, 0, 0),
(31, 31, 5118446, 80713, 492, 70910, 9311),
(32, 32, 9197590, 79559, 576, 53427, 25556),
(33, 33, 43705858, 76808, 1819, 42524, 32465),
(34, 34, 10858648, 76536, 1246, 40539, 34751),
(35, 35, 4321282, 71418, 1574, 45658, 24186),
(36, 36, 11594739, 71158, 9859, 17661, 43638),
(37, 37, 4276658, 70045, 469, 61610, 7966),
(38, 38, 9449001, 68503, 580, 63756, 4167),
(39, 39, 9902079, 61845, 354, 55739, 5752),
(40, 40, 19224023, 57895, 2566, 28992, 26337),
(41, 41, 17138756, 56982, 6153, 0, 0),
(42, 42, 5854932, 54555, 27, 48031, 6497),
(43, 43, 17946899, 54339, 2119, 42070, 10150),
(44, 44, 10193593, 52061, 1743, 37840, 12478),
(45, 45, 75684604, 99030, 3548, 71284, 24204),
(46, 46, 206606300, 45244, 930, 32430, 11884),
(47, 47, 9919704, 45098, 1423, 6116, 37559),
(48, 48, 1706669, 42889, 156, 39945, 2788),
(49, 49, 126435859, 42263, 1026, 28877, 12360),
(50, 50, 2963811, 39819, 772, 31556, 7491),
(51, 51, 31133483, 39642, 199, 36384, 3059),
(52, 52, 6534479, 38659, 1447, 30099, 7113),
(53, 53, 39009447, 36896, 1298, 25840, 9758),
(54, 54, 8660952, 36108, 1985, 31600, 2523),
(55, 55, 43926079, 33626, 1273, 23238, 9115),
(56, 56, 10148243, 33247, 479, 29275, 3493),
(57, 57, 36953359, 29644, 449, 20553, 8642),
(58, 58, 33516027, 28315, 175, 19291, 8849),
(59, 59, 8733665, 27332, 621, 14047, 12664),
(60, 60, 4032983, 26628, 828, 18676, 7124),
(61, 61, 4943200, 26372, 1768, 23364, 1240),
(62, 62, 53881160, 24411, 399, 10444, 13568),
(63, 63, 28427499, 22299, 195, 12146, 9958),
(64, 64, 29186486, 21750, 65, 15389, 6296),
(65, 65, 9011577, 21696, 719, 19596, 1381),
(66, 66, 5098730, 21070, 200, 7038, 13832),
(67, 67, 115223736, 20900, 365, 9027, 11508),
(68, 68, 25528864, 19890, 255, 10941, 8694),
(69, 69, 6489514, 19126, 513, 9236, 9377),
(70, 70, 10711019, 17731, 390, 12320, 5021),
(71, 71, 26606188, 17718, 391, 15320, 2007),
(72, 72, 26437950, 16447, 103, 12484, 3860),
(73, 73, 51273732, 14519, 303, 13543, 673),
(74, 74, 5794279, 14306, 617, 12787, 902),
(75, 75, 5112340, 13398, 92, 6907, 6399),
(76, 76, 3278650, 13396, 384, 7042, 5970),
(77, 77, 6942854, 13014, 435, 7374, 5205),
(78, 78, 27755708, 12526, 134, 10148, 2244),
(79, 79, 43943536, 11780, 763, 6194, 4823),
(80, 80, 2083365, 11399, 517, 7480, 3402),
(81, 81, 16783877, 10715, 223, 7101, 3391),
(82, 82, 5425471, 9468, 256, 8857, 355),
(83, 83, 89802183, 9309, 215, 8048, 1046),
(84, 84, 32406372, 9038, 125, 8713, 200),
(85, 85, 299385, 8127, 47, 7240, 840),
(86, 86, 2230563, 7787, 51, 5609, 2127),
(87, 87, 9557468, 7665, 62, 6443, 1160),
(88, 88, 13164905, 7664, 49, 6757, 858),
(89, 89, 11416103, 7544, 171, 4832, 2541),
(90, 90, 5541604, 7532, 331, 6980, 221),
(91, 91, 18430129, 7164, 199, 5786, 1179),
(92, 92, 626952, 7073, 119, 5750, 1204),
(93, 93, 4660728, 6444, 157, 5291, 996),
(94, 94, 7141091, 6375, 66, 4974, 1335),
(95, 95, 2877470, 6016, 188, 3155, 2673),
(96, 96, 6822220, 5672, 70, 1974, 3628),
(97, 97, 4102577, 5404, 155, 4688, 561),
(98, 98, 989387, 5330, 59, 5057, 214),
(99, 99, 10417673, 5123, 210, 1374, 3539),
(100, 100, 6880353, 4879, 107, 652, 4120),
(101, 101, 1407001, 4821, 83, 2182, 2556),
(102, 102, 541448, 4680, 19, 2725, 1936),
(103, 103, 4837752, 4620, 59, 1641, 2920),
(104, 104, 9657785, 4597, 600, 3463, 534),
(105, 105, 19174839, 4491, 137, 2137, 2217),
(106, 106, 14883803, 4339, 84, 1264, 2991),
(107, 107, 6632263, 3902, 123, 2913, 866),
(108, 108, 7503041, 3850, 46, 2458, 1346),
(109, 109, 5530506, 3546, 58, 1589, 1899),
(110, 110, 628074, 3480, 60, 2178, 1242),
(111, 111, 69817894, 3330, 58, 3148, 124),
(112, 112, 15933012, 3227, 93, 1728, 1406),
(113, 113, 273419, 3042, 39, 2738, 265),
(114, 114, 1161348, 2968, 55, 1476, 1437),
(115, 115, 21422362, 2839, 11, 2541, 287),
(116, 116, 11325899, 2775, 88, 2409, 278),
(117, 117, 556581, 2734, 27, 2010, 697),
(118, 118, 2545264, 2652, 15, 563, 2074),
(119, 119, 20302901, 2552, 124, 1954, 474),
(120, 120, 5459915, 2480, 29, 1824, 627),
(121, 121, 11206572, 2450, 47, 1175, 1228),
(122, 122, 2078968, 2223, 125, 1909, 189),
(123, 123, 2718121, 2171, 81, 1656, 434),
(124, 124, 1326627, 2124, 63, 1954, 107),
(125, 125, 31333962, 2120, 15, 795, 1310),
(126, 126, 12981546, 2111, 5, 1258, 848),
(127, 127, 587154, 2096, 29, 1446, 621),
(128, 128, 1972277, 2032, 27, 944, 1061),
(129, 129, 12151976, 1936, 38, 1600, 298),
(130, 130, 341465, 1930, 10, 1825, 95),
(131, 131, 7992169, 1877, 67, 1427, 383),
(132, 132, 29886897, 1768, 508, 898, 362),
(133, 133, 11830801, 1642, 51, 1241, 350),
(134, 134, 5002100, 1569, 22, 1524, 23),
(135, 135, 32956300, 1483, 64, 520, 899),
(136, 136, 3474956, 1318, 37, 1079, 202),
(137, 137, 1883936, 1275, 32, 1070, 173),
(138, 138, 10213138, 1232, 11, 1171, 50),
(139, 139, 5068618, 1224, 78, 705, 441),
(140, 140, 45867852, 1223, 5, 1102, 116),
(141, 141, 1208238, 1208, 19, 856, 333),
(142, 142, 3988368, 1206, 17, 987, 202),
(143, 143, 20954852, 1158, 54, 961, 143),
(144, 144, 24281433, 1153, 69, 1057, 27),
(145, 145, 8296582, 1012, 22, 697, 293),
(146, 146, 17539600, 999, 48, 311, 640),
(147, 147, 2962478, 958, 12, 745, 201),
(148, 148, 441663, 946, 9, 670, 267),
(149, 149, 77278, 944, 52, 828, 64),
(150, 150, 16467965, 942, 76, 838, 28),
(151, 151, 2422754, 935, 16, 136, 783),
(152, 152, 219544, 878, 15, 797, 66),
(153, 153, 2356075, 804, 2, 63, 739),
(154, 154, 393616, 761, 14, 91, 656),
(155, 155, 97425470, 747, 10, 392, 345),
(156, 156, 2143943, 742, 23, 175, 544),
(157, 157, 0, 712, 13, 651, 48),
(158, 158, 33938, 699, 42, 657, 0),
(159, 159, 895952, 671, 5, 592, 74),
(160, 160, 174022, 597, 47, 533, 17),
(161, 161, 786936, 538, 22, 189, 327),
(162, 162, 59886383, 509, 21, 183, 305),
(163, 163, 23821199, 477, 7, 443, 27),
(164, 164, 871326, 396, 7, 340, 49),
(165, 165, 11922216, 395, 1, 304, 90),
(166, 166, 54446389, 357, 6, 308, 43),
(167, 167, 1271985, 344, 10, 334, 0),
(168, 168, 85078, 336, 24, 312, 0),
(169, 169, 3283344, 293, 0, 260, 33),
(170, 170, 3551175, 282, 0, 225, 57),
(171, 171, 400131, 279, 14, 179, 86),
(172, 172, 375235, 276, 15, 98, 163),
(173, 173, 48882, 266, 0, 192, 74),
(174, 174, 106812, 263, 3, 114, 146),
(175, 175, 16741375, 243, 0, 210, 33),
(176, 176, 1399950, 210, 8, 135, 67),
(177, 177, 65798, 203, 1, 202, 0),
(178, 178, 33690, 190, 0, 184, 6),
(179, 179, 8963009, 163, 3, 53, 107),
(180, 180, 42924, 160, 16, 64, 80),
(181, 181, 62254, 157, 9, 144, 4),
(182, 182, 437893, 141, 3, 138, 0),
(183, 183, 287411, 133, 7, 100, 26),
(184, 184, 38768, 129, 2, 39, 88),
(185, 185, 98408, 126, 0, 124, 2),
(186, 186, 39270, 125, 4, 105, 16),
(187, 187, 772443, 105, 0, 93, 12),
(188, 188, 98010, 92, 3, 76, 13),
(189, 189, 38139, 89, 1, 85, 3),
(190, 190, 398312, 86, 2, 31, 53),
(191, 191, 281072, 64, 0, 62, 2),
(192, 192, 110976, 56, 0, 46, 10),
(193, 193, 38729, 53, 3, 41, 9),
(194, 194, 650193, 46, 0, 46, 0),
(195, 195, 164161, 31, 1, 28, 2),
(196, 196, 897095, 27, 1, 18, 8),
(197, 197, 183712, 25, 0, 24, 1),
(198, 198, 1320812, 25, 0, 24, 1),
(199, 199, 112576, 24, 0, 23, 1),
(200, 200, 285769, 22, 0, 22, 0),
(201, 201, 7285750, 20, 0, 19, 1),
(202, 202, 72004, 18, 0, 18, 0),
(203, 203, 53237, 17, 0, 16, 1),
(204, 204, 56780, 14, 0, 14, 0),
(205, 205, 4992, 13, 1, 10, 2),
(206, 206, 26247, 13, 0, 7, 6),
(207, 207, 3489, 13, 0, 13, 0),
(208, 208, 801, 12, 0, 12, 0),
(209, 209, 598682, 10, 1, 8, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `countrystat_seq`
--

CREATE TABLE `countrystat_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `countrystat_seq`
--

INSERT INTO `countrystat_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `country_seq`
--

CREATE TABLE `country_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `country_seq`
--

INSERT INTO `country_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `password`, `role`, `username`) VALUES
(1, '$2a$10$SXsu77wWzDKbbNXvlRorZ.iXQhl9LirXgFKnJ7wFOiC2FzyJmRr1.', 'ADMIN', 'mario'),
(2, '$2a$10$k.3NMcaTIlwnPkM6e0Zu6OwySr4XBCVqMOrH1.Uuby2aMxd8d0Cdy', 'USER', 'john');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `whoregion`
--

CREATE TABLE `whoregion` (
  `who_id` int(9) NOT NULL,
  `who_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `whoregion`
--

INSERT INTO `whoregion` (`who_id`, `who_name`) VALUES
(1, 'Americas'),
(2, 'South-EastAsia'),
(3, 'Europe'),
(4, 'Africa'),
(5, 'EasternMediterranean'),
(6, 'WesternPacific');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `whoregion_seq`
--

CREATE TABLE `whoregion_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `whoregion_seq`
--

INSERT INTO `whoregion_seq` (`next_val`) VALUES
(1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `continent`
--
ALTER TABLE `continent`
  ADD PRIMARY KEY (`continent_id`);

--
-- Indeksy dla tabeli `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`country_id`),
  ADD KEY `continent_id` (`continent_id`),
  ADD KEY `who_id` (`who_id`);

--
-- Indeksy dla tabeli `countrystat`
--
ALTER TABLE `countrystat`
  ADD PRIMARY KEY (`stat_id`),
  ADD KEY `country_id` (`country_id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `whoregion`
--
ALTER TABLE `whoregion`
  ADD PRIMARY KEY (`who_id`);

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `country`
--
ALTER TABLE `country`
  ADD CONSTRAINT `country_ibfk_1` FOREIGN KEY (`continent_id`) REFERENCES `continent` (`continent_id`),
  ADD CONSTRAINT `country_ibfk_2` FOREIGN KEY (`who_id`) REFERENCES `whoregion` (`who_id`);

--
-- Ograniczenia dla tabeli `countrystat`
--
ALTER TABLE `countrystat`
  ADD CONSTRAINT `countrystat_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
