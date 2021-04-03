-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hotelBookingDb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotelBookingDb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotelBookingDb` DEFAULT CHARACTER SET utf8 ;
USE `hotelBookingDb` ;

-- -----------------------------------------------------
-- Table `hotelBookingDb`.`Hotels`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelBookingDb`.`Hotels` (
                                                         `hotelId` INT NOT NULL AUTO_INCREMENT,
                                                         `hotelName` VARCHAR(100) NOT NULL,
    `phoneNumber` VARCHAR(45) NOT NULL,
    `hotelEmail` VARCHAR(45) NOT NULL,
    `country` VARCHAR(45) NOT NULL,
    `city` VARCHAR(45) NOT NULL,
    `address` VARCHAR(60) NOT NULL,
    `rating` INT (1) NOT NULL,
    PRIMARY KEY (`hotelId`),
    UNIQUE INDEX `phone_number_UNIQUE` (`phoneNumber` ASC) VISIBLE,
    UNIQUE INDEX `hotelEmail_UNIQUE` (`hotelEmail` ASC) VISIBLE)
    ENGINE = InnoDB;
INSERT INTO `Hotels` VALUES (1, 'Mission to Mars', '+55 (514) 535-9359', 'rcuthbertson0@github.com', 'Brazil', 'Palmeira', '23596 Riverside Avenue',5);
INSERT INTO `Hotels` VALUES (2, 'Alexandra Project', '+962 (418) 469-9318', 'ssaunders1@microsoft.com', 'Jordan', 'Safi', '32 Kingsford Circle',5);
INSERT INTO `Hotels` VALUES (3, 'Only When I Laugh', '+62 (531) 250-4318', 'kdyte2@is.gd', 'Indonesia', 'Pesagen', '46562 Division Lane',5);
INSERT INTO `Hotels` VALUES (4, 'Des gens qui s''embrassent', '+39 (831) 660-2057', 'llangfield3@upenn.edu', 'Italy', 'Venezia', '709 Clemons Place',5);
INSERT INTO `Hotels` VALUES (5, 'Crossing the Bridge', '+33 (335) 227-7336', 'glilliman4@domainmarket.com', 'France', 'Frontignan', '5 Hintze Hill',5);
INSERT INTO `Hotels` VALUES (6, 'Amada Collossos', '+86 (547) 453-1773', 'gmaffucci5@rakuten.co.jp', 'China', 'Gaobu', '2 Mayfield Junction',5);
INSERT INTO `Hotels` VALUES (7, 'Charley Varrick', '+63 (494) 272-5186', 'hpenney6@miibeian.gov.cn', 'Philippines', 'Libertad', '7 Jay Street',5);
INSERT INTO `Hotels` VALUES (8, 'Prince of Foxes', '+375 (295) 421-9093', 'tfarlane7@eventbrite.com', 'Belarus', 'Dashkawka', '44 Forest Run Street',5);
INSERT INTO `Hotels` VALUES (9, 'Lasa y Zabala', '+27 (686) 294-4785', 'bsmithend8@pen.io', 'South Africa', 'Victoria West', '518 Eggendart Alley',5);
INSERT INTO `Hotels` VALUES (10, 'WNUF Special', '+86 (695) 626-3598', 'aberard9@samsung.com', 'China', 'Xinming', '41698 Miller Alley',5);
INSERT INTO `Hotels` VALUES (11, 'Closing Camp', '+7 (407) 676-6551', 'alittlejohna@apple.com', 'Russia', 'Dzerzhinskiy', '2216 Hansons Plaza',5);
INSERT INTO `Hotels` VALUES (12, 'Young People', '+62 (612) 736-4452', 'dyepiskovb@reverbnation.com', 'Indonesia', 'Parakanhonje Wetan', '486 Bonner Parkway',5);
INSERT INTO `Hotels` VALUES (13, 'House of Yes', '+977 (670) 861-8833', 'rblowfieldc@acquirethisname.com', 'Nepal', 'Hitura', '82 Michigan Junction',5);
INSERT INTO `Hotels` VALUES (14, 'Glorious 39', '+62 (248) 800-2494', 'cconord@myspace.com', 'Indonesia', 'Krajan', '90 Forest Parkway',4);
INSERT INTO `Hotels` VALUES (15, 'Fort Washington', '+996 (865) 307-6428', 'hannettse@xing.com', 'Kyrgyzstan', 'Kara Suu', '748 Hollow Ridge Drive',4);
INSERT INTO `Hotels` VALUES (16, 'The Greatest', '+351 (177) 223-8711', 'rdruhanf@microsoft.com', 'Portugal', 'Torre', '2779 Oak Valley Junction',4);
INSERT INTO `Hotels` VALUES (17, 'Firefly', '+86 (305) 885-8641', 'marcaseg@naver.com', 'China', 'Jianfeng', '1 Bluejay Trail',4);
INSERT INTO `Hotels` VALUES (18, 'Next Three Days', '+86 (429) 290-6747', 'skelnerh@accuweather.com', 'China', 'Dalu', '7072 Darwin Hill',4);
INSERT INTO `Hotels` VALUES (19, 'Bunny and the Bull', '+351 (307) 502-9866', 'cmarciskewskii@angelfire.com', 'Portugal', 'Aveleda', '71249 Center Trail',4);
INSERT INTO `Hotels` VALUES (20, 'Season12', '+7 (786) 532-8854', 'ocastiblancoj@homestead.com', 'Russia', 'Magadan', '74482 La Follette Pass',4);
INSERT INTO `Hotels` VALUES (21, 'Magnum Force', '+86 (928) 251-0369', 'nlogesk@phoca.cz', 'China', 'Hecheng', '7314 Reindahl Parkway',4);
INSERT INTO `Hotels` VALUES (22, 'Zatoichi Swordsman', '+504 (283) 510-2290', 'imatasl@cdc.gov', 'Honduras', 'Valle de Ángeles', '68840 Atwood Alley',3);
INSERT INTO `Hotels` VALUES (23, 'The Prophecy', '+66 (955) 523-4012', 'arapellim@oracle.com', 'Thailand', 'Khueang Nai', '83 Sloan Lane',3);
INSERT INTO `Hotels` VALUES (24, 'Menschen am Sonntag', '+351 (700) 106-0365', 'abonhomen@nyu.edu', 'Portugal', 'Arcos de Valdevez', '68 Bay Point',3);
INSERT INTO `Hotels` VALUES (25, 'Superheroes', '+62 (352) 169-1777', 'dmowlingo@patch.com', 'Indonesia', 'Medalem', '48687 Hayes Avenue',3);
INSERT INTO `Hotels` VALUES (26, 'Island Earth', '+976 (900) 670-2472', 'lmackimmp@pcworld.com', 'Mongolia', 'Mandal', '056 Crest Line Court',3);
INSERT INTO `Hotels` VALUES (27, 'Riffraff', '+420 (521) 989-9375', 'aluardq@oracle.com', 'Czech Republic', 'Tuchoměřice', '9044 Petterle Center',3);
INSERT INTO `Hotels` VALUES (28, 'Paris', '+7 (388) 277-6608', 'dcarruthersr@upenn.edu', 'Russia', 'Unecha', '45 Hollow Ridge Hill',3);
INSERT INTO `Hotels` VALUES (29, 'Blood Moon', '+86 (869) 840-6746', 'jmcconnals@ow.ly', 'China', 'Chaoyang', '3209 Onsgard Center',2);
INSERT INTO `Hotels` VALUES (30, 'Grand Onder', '+7 (618) 530-7332', 'egibbiet@dagondesign.com', 'Russia', 'Urazovka', '866 Blaine Plaza',1);


-- -----------------------------------------------------
-- Table `hotelBookingDb`.`RoomTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelBookingDb`.`RoomTypes` (
                                                            `roomTypeId` INT NOT NULL,
                                                            `roomType` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`roomTypeId`))
    ENGINE = InnoDB;
INSERT INTO `RoomTypes`  VALUES (1, 'Single');
INSERT INTO `RoomTypes`  VALUES (2, 'Double');
INSERT INTO `RoomTypes`  VALUES (3, 'Apartment');
INSERT INTO `RoomTypes`  VALUES (4, 'Suite');
INSERT INTO `RoomTypes`  VALUES (5, 'Penthouse');

-- -----------------------------------------------------
-- Table `hotelBookingDb`.`CustomerLoyalty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelBookingDb`.`CustomerLoyalty` (
                                                                  `loyaltyId` INT NOT NULL,
                                                                  `loyaltyLevelName` VARCHAR(45) NOT NULL,
    `discountPercent` INT NOT NULL,
    PRIMARY KEY (`loyaltyId`))
    ENGINE = InnoDB;
INSERT INTO `CustomerLoyalty`  VALUES (1, 'Unranked', 0);
INSERT INTO `CustomerLoyalty`  VALUES (2, 'Bronze', 1);
INSERT INTO `CustomerLoyalty`  VALUES (3, 'Silver', 2);
INSERT INTO `CustomerLoyalty`  VALUES (4, 'Gold', 3);
INSERT INTO `CustomerLoyalty`  VALUES (5, 'Platinum', 5);


-- -----------------------------------------------------
-- Table `hotelBookingDb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelBookingDb`.`Customer` (
                                                           `customerId` INT NOT NULL AUTO_INCREMENT,
                                                           `firstName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `socialId` VARCHAR(30) NOT NULL,
    `customerEmail` VARCHAR(60) NOT NULL,
    `phoneNumber` VARCHAR(45) NOT NULL,
    `birthDate` DATE NOT NULL,
    `country` VARCHAR(45) NOT NULL,
    `city` VARCHAR(45) NOT NULL,
    `address` VARCHAR(45) NOT NULL,
    `loyaltyLevel` INT NOT NULL,
    PRIMARY KEY (`customerId`),
    UNIQUE INDEX `customer_id_UNIQUE` (`customerId` ASC) VISIBLE,
    UNIQUE INDEX `social_id_UNIQUE` (`socialId` ASC) VISIBLE,
    UNIQUE INDEX `email_UNIQUE` (`customerEmail` ASC) VISIBLE,
    UNIQUE INDEX `phone_number_UNIQUE` (`phoneNumber` ASC) VISIBLE,
    INDEX `fk_Customer_CustomerLoyalty1_idx` (`loyaltyLevel` ASC) VISIBLE,
    CONSTRAINT `fk_Customer_CustomerLoyalty1`
    FOREIGN KEY (`loyaltyLevel`)
    REFERENCES `hotelBookingDb`.`CustomerLoyalty` (`loyaltyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;
INSERT INTO `Customer`  VALUES (1, 'Faun', 'Childrens', '465-78-3156', 'fchildrens0@macromedia.com', '280-327-0974', '1944/04/16', 'China', 'Zhujiaqiao', '7 Melrose Court', 2);
INSERT INTO `Customer`  VALUES (2, 'Borg', 'Le Blanc', '832-20-4097', 'ble1@boston.com', '831-723-2167', '1997/07/19', 'China', 'Wenquan', '727 Sloan Pass', 5);
INSERT INTO `Customer`  VALUES (3, 'Susy', 'Jane', '433-10-3567', 'sjane2@usda.gov', '694-982-2705', '1973/07/27', 'China', 'Dongdu', '600 Eastlawn Point', 3);
INSERT INTO `Customer`  VALUES (4, 'Rodolfo', 'Penddreth', '238-09-8769', 'rpenddreth3@so.net', '152-756-2335', '1980/09/17', 'Hungary', 'Pécs', '0 Crownhardt Park', 1);
INSERT INTO `Customer`  VALUES (5, 'Clarey', 'Eicheler', '426-22-9622', 'ceicheler4@nature.com', '853-663-4984', '1979/12/19', 'Uruguay', 'San Bautista', '7 Valley Edge Hill', 5);
INSERT INTO `Customer`  VALUES (6, 'Enrica', 'Laverty', '530-32-2364', 'elaverty5@ihg.com', '306-751-6894', '1996/07/09', 'Indonesia', 'Nggelok', '6 Bonner Point', 2);
INSERT INTO `Customer`  VALUES (7, 'Jerri', 'Fernyhough', '331-94-9689', 'jfernyhough6@cdbaby.com', '883-565-2317', '1962/03/06', 'Russia', 'Rybinsk', '0595 Leroy Street', 3);
INSERT INTO `Customer`  VALUES (8, 'Michel', 'Richly', '810-85-9128', 'mrichly7@pagesperso-orange.fr', '877-405-3952', '1941/12/29', 'Macedonia', 'Kavadarci', '79842 Oneill Street', 2);
INSERT INTO `Customer`  VALUES (9, 'Carena', 'Assaf', '603-24-9463', 'cassaf8@csmonitor.com', '539-785-1673', '1951/03/22', 'Russia', 'Konstantinovo', '7 Claremont Alley', 5);
INSERT INTO `Customer`  VALUES (10, 'Ania', 'Pickersgill', '177-87-8312', 'apickersgill9@vkontakte.ru', '164-823-1442', '1950/06/26', 'Indonesia', 'Serang', '907 Northport Plaza', 2);
INSERT INTO `Customer`  VALUES (11, 'Rene', 'Petrelli', '143-43-8143', 'rpetrellia@cbslocal.com', '645-658-7165', '1948/12/24', 'Russia', 'Issad', '069 Milwaukee Street', 3);
INSERT INTO `Customer`  VALUES (12, 'Fairlie', 'Zanassi', '400-48-9606', 'fzanassib@cocolog-nifty.com', '892-714-4046', '2000/12/20', 'Benin', 'Bétérou', '62184 Summerview Crossing', 1);
INSERT INTO `Customer`  VALUES (13, 'Billie', 'Bodsworth', '610-61-6928', 'bbodsworthc@gmpg.org', '187-220-7943', '1996/11/22', 'Philippines', 'Tigaon', '5 Twin Pines Circle', 1);
INSERT INTO `Customer`  VALUES (14, 'Carita', 'Grahlmans', '103-88-4267', 'cgrahlmansd@cnbc.com', '603-857-3974', '1949/02/03', 'China', 'Jianghu', '98 Lunder Trail', 4);
INSERT INTO `Customer`  VALUES (15, 'Francklyn', 'Mensler', '386-93-5750', 'fmenslere@google.it', '219-534-9980', '1949/02/24', 'United States', 'Gary', '89471 Hazelcrest Park', 4);
INSERT INTO `Customer`  VALUES (16, 'Cortie', 'Peverell', '811-90-2799', 'cpeverellf@yellowbook.com', '782-767-2826', '1998/10/31', 'Czech Republic', 'Lenešice', '880 Holmberg Avenue', 5);
INSERT INTO `Customer`  VALUES (17, 'Myrtie', 'Solly', '724-67-9947', 'msollyg@scientificamerican.com', '262-991-2249', '1990/07/01', 'China', 'Yayao', '0 Memorial Junction', 5);
INSERT INTO `Customer`  VALUES (18, 'Carol-jean', 'Babbage', '824-82-1042', 'cbabbageh@hao123.com', '807-636-5665', '2000/11/28', 'Cuba', 'Vertientes', '52232 Londonderry Alley', 4);
INSERT INTO `Customer`  VALUES (19, 'Fenelia', 'Wigglesworth', '731-88-4270', 'fwigglesworthi@oaic.gov.au', '938-693-6440', '1958/04/19', 'Poland', 'Polańczyk', '3055 Holmberg Place', 3);
INSERT INTO `Customer`  VALUES (20, 'Odelia', 'Brecknock', '389-07-7515', 'obrecknockj@qq.com', '368-725-7504', '1955/05/18', 'Japan', 'Fukuma', '606 Hovde Place', 2);
INSERT INTO `Customer`  VALUES (21, 'Joelynn', 'Pembridge', '896-79-7442', 'jpembridgek@about.com', '741-398-2031', '1946/10/03', 'Argentina', 'San Antonio', '976 Crescent Oaks Crossing', 3);
INSERT INTO `Customer`  VALUES (22, 'Sarine', 'Weiss', '894-85-2777', 'sweissl@oaic.gov.au', '914-311-3613', '2000/03/23', 'China', 'Ercheng', '54 5th Hill', 5);
INSERT INTO `Customer`  VALUES (23, 'Terence', 'Sweetsur', '506-98-2009', 'tsweetsurm@pbs.org', '977-624-6290', '1953/01/31', 'Cameroon', 'Bertoua', '03 Chinook Alley', 5);
INSERT INTO `Customer`  VALUES (24, 'Brunhilde', 'Birkmyre', '616-57-6863', 'bbirkmyren@ovh.net', '327-292-5340', '1935/05/21', 'Ireland', 'Kilcullen', '64 Meadow Vale Place', 5);
INSERT INTO `Customer`  VALUES (25, 'Udell', 'Sarrell', '479-49-7601', 'usarrello@scribd.com', '946-815-0822', '1989/02/28', 'France', 'Sophia Antipolis', '15047 Pepper Wood Drive', 4);
INSERT INTO `Customer`  VALUES (26, 'Gaven', 'Desforges', '462-21-8063', 'gdesforgesp@livejournal.com', '447-145-2524', '1989/01/12', 'China', 'Weiyanggong', '3 Cambridge Point', 5);
INSERT INTO `Customer`  VALUES (27, 'Andee', 'Allsupp', '753-87-5013', 'aallsuppq@miitbeian.gov.cn', '294-668-9320', '1952/11/19', 'Russia', 'Yelan’-Kolenovskiy', '10 Debra Lane', 4);
INSERT INTO `Customer`  VALUES (28, 'Krystle', 'Luppitt', '254-48-5678', 'kluppittr@seesaa.net', '468-110-2742', '1959/07/01', 'Indonesia', 'Jambu', '32 Miller Trail', 5);
INSERT INTO `Customer`  VALUES (29, 'Umeko', 'Boord', '233-42-0808', 'uboords@cnbc.com', '892-364-3173', '1940/06/10', 'China', 'Daji', '04 Scott Road', 1);
INSERT INTO `Customer`  VALUES (30, 'Vivianne', 'Posner', '358-62-6316', 'vposnert@bigcartel.com', '290-713-0455', '1957/11/25', 'China', 'Qiaonan', '59149 Mariners Cove Point', 3);
INSERT INTO `Customer`  VALUES (31, 'Mordecai', 'Balcon', '515-69-5682', 'mbalconu@topsy.com', '132-969-9056', '1940/05/28', 'China', 'Zhenzhushan', '13 Steensland Center', 3);
INSERT INTO `Customer`  VALUES (32, 'Gretta', 'Logg', '347-12-1484', 'gloggv@sun.com', '808-863-1296', '1948/05/09', 'Argentina', 'Corralito', '1956 Green Center', 3);
INSERT INTO `Customer`  VALUES (33, 'Ronnie', 'Loomis', '597-47-1582', 'rloomisw@google.fr', '794-631-9091', '1957/09/15', 'Russia', 'Promyshlennaya', '9 Transport Trail', 1);
INSERT INTO `Customer`  VALUES (34, 'Nata', 'Caldera', '587-81-2491', 'ncalderax@nature.com', '284-929-6038', '1941/11/04', 'Belarus', 'Baranovichi', '97 Towne Hill', 3);
INSERT INTO `Customer`  VALUES (35, 'Garfield', 'Bertson', '305-33-4622', 'gbertsony@imgur.com', '600-859-8200', '1982/05/30', 'Portugal', 'Carcavelos', '7 Iowa Crossing', 4);
INSERT INTO `Customer`  VALUES (36, 'Eduard', 'Kemish', '656-13-3441', 'ekemishz@mozilla.org', '770-935-1102', '1962/02/24', 'Philippines', 'Caba', '759 Meadow Valley Trail', 1);
INSERT INTO `Customer`  VALUES (37, 'Stella', 'Kervin', '754-24-5335', 'skervin10@parallels.com', '293-182-2149', '1968/03/12', 'Indonesia', 'Sadahayu', '543 Tony Trail', 1);
INSERT INTO `Customer`  VALUES (38, 'Ivan', 'Parratt', '766-68-1502', 'iparratt11@reuters.com', '345-453-0781', '1989/11/05', 'China', 'Chexi', '27455 David Hill', 1);
INSERT INTO `Customer`  VALUES (39, 'Pippo', 'Gerrard', '197-04-1021', 'pgerrard12@weebly.com', '568-668-8982', '1940/07/17', 'Vietnam', 'Ia Kha', '2772 Hooker Plaza', 3);
INSERT INTO `Customer`  VALUES (40, 'Oliver', 'Woodbridge', '143-59-7525', 'owoodbridge13@pcworld.com', '343-817-2343', '1954/03/31', 'Brazil', 'Campo Belo', '12047 Tomscot Circle', 1);
INSERT INTO `Customer`  VALUES (41, 'Alberta', 'MacAleese', '616-52-2811', 'amacaleese14@yahoo.com', '268-633-0741', '2001/07/11', 'Argentina', 'Villa Ocampo', '2 Springs Lane', 2);
INSERT INTO `Customer`  VALUES (42, 'Myrtle', 'Devoy', '644-70-9226', 'mdevoy15@bravesites.com', '313-123-5212', '1990/04/04', 'Portugal', 'Donim', '42 Manitowish Parkway', 2);
INSERT INTO `Customer`  VALUES (43, 'Elladine', 'Baynham', '789-31-2574', 'ebaynham16@loc.gov', '919-207-0476', '1934/03/26', 'Angola', 'Camabatela', '94897 Toban Center', 3);
INSERT INTO `Customer`  VALUES (44, 'Ilysa', 'Noah', '224-14-0889', 'inoah17@google.nl', '656-124-7225', '1978/06/04', 'Argentina', 'El Soberbio', '99553 Jenna Junction', 2);
INSERT INTO `Customer`  VALUES (45, 'Timmie', 'Elia', '415-26-7593', 'telia18@jiathis.com', '370-864-2660', '1969/07/05', 'China', 'Sigaozhuang', '17193 La Follette Street', 5);
INSERT INTO `Customer`  VALUES (46, 'Junia', 'O''Towey', '880-63-0051', 'jotowey19@vimeo.com', '264-443-0692', '1974/08/13', 'Latvia', 'Vangaži', '25892 Northport Parkway', 1);
INSERT INTO `Customer`  VALUES (47, 'Evaleen', 'Brimblecomb', '452-13-7579', 'ebrimblecomb1a@dagondesign.com', '672-155-0380', '1941/05/13', 'South Africa', 'Lebowakgomo', '246 Mallard Junction', 2);
INSERT INTO `Customer`  VALUES (48, 'Karry', 'Uebel', '629-30-9387', 'kuebel1b@chicagotribune.com', '171-596-0896', '1989/07/30', 'Malawi', 'Rumphi', '325 Village Place', 3);
INSERT INTO `Customer`  VALUES (49, 'Onfroi', 'Vears', '755-32-1885', 'ovears1c@hubpages.com', '191-751-8488', '1935/05/13', 'Thailand', 'Na Muen', '76083 Burning Wood Place', 4);
INSERT INTO `Customer`  VALUES (50, 'Osgood', 'O''Fielly', '558-38-1792', 'oofielly1d@aboutads.info', '660-411-8337', '1967/09/16', 'Ethiopia', 'Debre Zeyit', '8 Cardinal Avenue', 4);
INSERT INTO `Customer`  VALUES (51, 'Tiebold', 'Colliard', '766-16-2011', 'tcolliard1e@reddit.com', '221-783-2970', '1979/10/01', 'Indonesia', 'Cukangpanjang', '77141 Holmberg Pass', 2);
INSERT INTO `Customer`  VALUES (52, 'Hakim', 'Fray', '547-86-6949', 'hfray1f@prlog.org', '553-906-1505', '1933/04/07', 'Portugal', 'Erada', '9209 Upham Alley', 3);
INSERT INTO `Customer`  VALUES (53, 'Jewelle', 'Berisford', '871-84-4647', 'jberisford1g@nps.gov', '440-320-1067', '1988/01/17', 'Nigeria', 'Gandi', '12 Meadow Valley Place', 4);
INSERT INTO `Customer`  VALUES (54, 'Sonnie', 'Ashlin', '336-08-8653', 'sashlin1h@behance.net', '805-485-8931', '1994/12/16', 'Chile', 'Villa Presidente Frei, Ñuñoa, Santiago, Chile', '33816 Meadow Vale Crossing', 4);
INSERT INTO `Customer`  VALUES (55, 'Selia', 'Heinritz', '600-68-5806', 'sheinritz1i@cdc.gov', '680-696-9599', '1974/09/23', 'Philippines', 'Calauag', '179 Veith Street', 1);
INSERT INTO `Customer`  VALUES (56, 'Vikky', 'Targe', '381-84-8483', 'vtarge1j@4shared.com', '653-114-8428', '1981/04/26', 'Japan', 'Kanazawa-shi', '38196 Moose Terrace', 2);
INSERT INTO `Customer`  VALUES (57, 'Rhianon', 'Browell', '388-82-0232', 'rbrowell1k@privacy.gov.au', '269-280-6325', '1949/07/25', 'Greece', 'Níkaia', '91 Prairieview Trail', 2);
INSERT INTO `Customer`  VALUES (58, 'Raymond', 'Adame', '806-44-3532', 'radame1l@github.io', '986-365-1603', '1934/03/05', 'Dominican Republic', 'Neiba', '98 Loomis Road', 3);
INSERT INTO `Customer`  VALUES (59, 'Ronalda', 'Alanbrooke', '770-33-7402', 'ralanbrooke1m@youku.com', '836-607-3978', '2000/02/06', 'Philippines', 'New Sibonga', '2 Londonderry Road', 5);
INSERT INTO `Customer`  VALUES (60, 'Lemmie', 'Moule', '775-44-9887', 'lmoule1n@oracle.com', '846-189-4956', '1965/03/04', 'Indonesia', 'Mekon', '5 Burrows Park', 1);
INSERT INTO `Customer`  VALUES (61, 'Antin', 'Dealtry', '548-50-3120', 'adealtry1o@google.pl', '326-927-6080', '1980/03/08', 'Japan', 'Kogota', '91881 Bartillon Avenue', 4);
INSERT INTO `Customer`  VALUES (62, 'Etty', 'Dike', '414-52-4330', 'edike1p@cyberchimps.com', '342-174-9058', '2000/01/02', 'Thailand', 'Mueang Nonthaburi', '6 Sommers Park', 1);
INSERT INTO `Customer`  VALUES (63, 'Kent', 'Renon', '600-24-7871', 'krenon1q@washingtonpost.com', '318-455-9196', '1948/12/29', 'Sweden', 'Knivsta', '0 Michigan Crossing', 5);
INSERT INTO `Customer`  VALUES (64, 'Somerset', 'Royce', '503-93-5455', 'sroyce1r@sourceforge.net', '781-501-0181', '1971/09/25', 'New Caledonia', 'Canala', '91705 Eagle Crest Court', 5);
INSERT INTO `Customer`  VALUES (65, 'Seymour', 'Harry', '578-26-4095', 'sharry1s@bigcartel.com', '950-533-7632', '1967/06/23', 'China', 'Yujin', '044 8th Circle', 4);
INSERT INTO `Customer`  VALUES (66, 'Rolph', 'Malthouse', '347-17-1076', 'rmalthouse1t@joomla.org', '501-587-0437', '1931/01/26', 'United States', 'Little Rock', '4 Dottie Junction', 3);
INSERT INTO `Customer`  VALUES (67, 'Vernice', 'Happel', '307-10-8630', 'vhappel1u@prlog.org', '716-524-2430', '1999/02/11', 'Canada', 'Acton Vale', '6570 Harper Way', 5);
INSERT INTO `Customer`  VALUES (68, 'Bartholomew', 'Andriuzzi', '452-67-4925', 'bandriuzzi1v@vk.com', '487-223-2916', '1970/03/18', 'Thailand', 'That Phanom', '47 Westend Circle', 3);
INSERT INTO `Customer`  VALUES (69, 'Jarid', 'Kissell', '872-83-1832', 'jkissell1w@cdbaby.com', '667-665-5209', '1978/03/16', 'Hungary', 'Sopron', '77 Chive Plaza', 1);
INSERT INTO `Customer`  VALUES (70, 'Deanna', 'MacCumeskey', '837-49-7397', 'dmaccumeskey1x@bluehost.com', '994-778-9902', '1952/02/20', 'Tunisia', 'Dar Chabanne', '141 Village Terrace', 5);
INSERT INTO `Customer`  VALUES (71, 'Maure', 'Bentley', '640-36-3169', 'mbentley1y@trellian.com', '874-409-2736', '1952/02/26', 'China', 'Liaonan', '788 Bartillon Hill', 2);
INSERT INTO `Customer`  VALUES (72, 'Valry', 'Joust', '370-69-5418', 'vjoust1z@umn.edu', '600-211-5514', '1998/01/06', 'China', 'Sandu', '27414 Clyde Gallagher Road', 3);
INSERT INTO `Customer`  VALUES (73, 'Gene', 'Oldam', '153-93-0626', 'goldam20@lulu.com', '586-341-6830', '1964/02/16', 'China', 'Ulan Us', '35736 Kropf Pass', 3);
INSERT INTO `Customer`  VALUES (74, 'Shayne', 'MacLure', '537-43-8557', 'smaclure21@wp.com', '856-318-5473', '1987/03/04', 'China', 'Xianlin', '67 International Road', 1);
INSERT INTO `Customer`  VALUES (75, 'Blakelee', 'Surby', '753-80-3774', 'bsurby22@newsvine.com', '265-141-2969', '1958/06/11', 'Tanzania', 'Butiama', '4 Beilfuss Hill', 2);
INSERT INTO `Customer`  VALUES (76, 'Chantalle', 'Severs', '850-44-9493', 'csevers23@un.org', '563-238-5616', '1943/01/20', 'Japan', 'Nagoya-shi', '2896 Nova Center', 1);
INSERT INTO `Customer`  VALUES (77, 'Cosetta', 'Codling', '466-87-2977', 'ccodling24@webs.com', '275-165-4634', '1968/03/20', 'Sweden', 'Kristianstad', '9 Carey Place', 4);
INSERT INTO `Customer`  VALUES (78, 'Kordula', 'Kop', '167-68-9426', 'kkop25@howstuffworks.com', '920-303-3667', '1936/11/29', 'China', 'Dongshan', '69003 Victoria Place', 3);
INSERT INTO `Customer`  VALUES (79, 'Bird', 'Hullock', '881-70-9050', 'bhullock26@taobao.com', '334-831-4885', '1995/12/15', 'Thailand', 'Ban Phaeo', '20 Forest Run Road', 5);
INSERT INTO `Customer`  VALUES (80, 'Corissa', 'Kimbly', '107-73-2879', 'ckimbly27@imageshack.us', '977-222-8984', '1977/11/09', 'Macedonia', 'Debar', '4220 Lerdahl Avenue', 5);
INSERT INTO `Customer`  VALUES (81, 'Hollie', 'Yedall', '224-46-2767', 'hyedall28@hud.gov', '538-923-2963', '1932/06/02', 'Russia', 'Kushnarënkovo', '83724 Forest Run Alley', 3);
INSERT INTO `Customer`  VALUES (82, 'Aldo', 'Alwell', '767-93-6854', 'aalwell29@skyrock.com', '240-609-6007', '1930/03/27', 'Brazil', 'Baixo Guandu', '83409 Ludington Pass', 2);
INSERT INTO `Customer`  VALUES (83, 'Farlie', 'Billows', '707-31-8901', 'fbillows2a@yale.edu', '791-247-8674', '1998/02/14', 'Azerbaijan', 'Baş Göynük', '5 Delaware Trail', 1);
INSERT INTO `Customer`  VALUES (84, 'Madel', 'Mattaser', '339-04-1993', 'mmattaser2b@nih.gov', '374-359-5470', '1972/09/05', 'Afghanistan', 'Sar-e Pul', '2175 Autumn Leaf Trail', 1);
INSERT INTO `Customer`  VALUES (85, 'Alyssa', 'Dielhenn', '445-32-4833', 'adielhenn2c@geocities.jp', '895-525-3463', '1995/06/07', 'China', 'Tanzhesi', '6 Knutson Way', 3);
INSERT INTO `Customer`  VALUES (86, 'Orren', 'Kinsett', '770-20-0142', 'okinsett2d@ebay.com', '695-565-5577', '1988/06/17', 'Philippines', 'Sinisian', '14483 Hoard Court', 4);
INSERT INTO `Customer`  VALUES (87, 'Martica', 'Griffin', '197-19-5065', 'mgriffin2e@nps.gov', '181-234-5426', '1943/03/20', 'Indonesia', 'Cibunut', '308 Eagle Crest Court', 2);
INSERT INTO `Customer`  VALUES (88, 'Adria', 'Kebell', '624-38-5251', 'akebell2f@ocn.ne.jp', '775-967-7223', '2000/03/18', 'Czech Republic', 'Doubravice nad Svitavou', '9 Donald Road', 3);
INSERT INTO `Customer`  VALUES (89, 'Shaun', 'Ryman', '299-67-4470', 'sryman2g@un.org', '213-995-5331', '1961/12/17', 'Croatia', 'Šenkovec', '7 Waubesa Point', 3);
INSERT INTO `Customer`  VALUES (90, 'Oberon', 'Leaney', '336-32-8346', 'oleaney2h@icio.us', '769-959-7972', '1934/01/23', 'Zambia', 'Luangwa', '3 Caliangt Lane', 4);
INSERT INTO `Customer`  VALUES (91, 'Mitchel', 'Pillans', '421-69-3712', 'mpillans2i@upenn.edu', '497-900-1811', '1956/01/07', 'France', 'Rennes', '85633 Roxbury Place', 2);
INSERT INTO `Customer`  VALUES (92, 'Vasily', 'Simmins', '233-51-1236', 'vsimmins2j@hao123.com', '298-479-3113', '1965/03/15', 'China', 'Chunyang', '12 Canary Way', 2);
INSERT INTO `Customer`  VALUES (93, 'Clarance', 'Colthard', '625-42-5192', 'ccolthard2k@moonfruit.com', '966-726-4697', '1975/03/20', 'Afghanistan', 'Rū-ye Sang', '582 Cody Park', 1);
INSERT INTO `Customer`  VALUES (94, 'Harri', 'Allmann', '534-08-0994', 'hallmann2l@tinyurl.com', '361-832-3742', '1938/05/12', 'Thailand', 'Sakon Nakhon', '9 Kensington Drive', 1);
INSERT INTO `Customer`  VALUES (95, 'Heall', 'Emby', '206-92-9889', 'hemby2m@google.com.br', '908-831-6473', '1936/06/25', 'China', 'Shuiyang', '1552 Dakota Trail', 1);
INSERT INTO `Customer`  VALUES (96, 'Agneta', 'Tear', '356-87-6063', 'atear2n@blinklist.com', '814-395-4387', '1944/04/12', 'Nicaragua', 'Puerto Morazán', '15 Schlimgen Parkway', 4);
INSERT INTO `Customer`  VALUES (97, 'Almeria', 'Pietrzak', '600-56-4184', 'apietrzak2o@biglobe.ne.jp', '860-165-9584', '1932/09/30', 'Kazakhstan', 'Egindiköl', '31885 Emmet Road', 1);
INSERT INTO `Customer`  VALUES (98, 'Lesli', 'Moscon', '360-38-6829', 'lmoscon2p@fastcompany.com', '410-370-3821', '1938/06/19', 'Norway', 'Oslo', '17 Rieder Terrace', 4);
INSERT INTO `Customer`  VALUES (99, 'Victoir', 'Gurg', '718-63-9233', 'vgurg2q@goodreads.com', '186-652-3627', '1939/05/21', 'Indonesia', 'Sindangkopo', '0217 Express Road', 5);
INSERT INTO `Customer`  VALUES (100, 'Tomi', 'Rapi', '796-02-8949', 'trapi2r@cargocollective.com', '811-276-0298', '1974/06/11', 'Russia', 'Tomilino', '93 Old Gate Way', 5);

-- -----------------------------------------------------
-- Table `hotelBookingDb`.`ReservationStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelBookingDb`.`ReservationStatus` (
                                                                    `statusId` INT NOT NULL,
                                                                    `statusName` VARCHAR(45) NULL,
    PRIMARY KEY (`statusId`))
    ENGINE = InnoDB;
INSERT INTO `ReservationStatus`  VALUES (1, 'Requested');
INSERT INTO `ReservationStatus`  VALUES (2, 'Pending');
INSERT INTO `ReservationStatus`  VALUES (3, 'Confirmed');
INSERT INTO `ReservationStatus`  VALUES (4, 'Canceled');
INSERT INTO `ReservationStatus`  VALUES (5, 'Finalized');

-- -----------------------------------------------------
-- Table `hotelBookingDb`.`HotelsHasRooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelBookingDb`.`HotelsHasRooms` (
                                                                 `hotelId` INT NOT NULL,
                                                                 `roomType` INT NOT NULL,
                                                                 `roomQuantity` INT NOT NULL DEFAULT 0,
                                                                 `pricePerNight` DECIMAL(4,2) NOT NULL DEFAULT 0.00,
    PRIMARY KEY (`hotelId`, `roomType`),
    INDEX `fk_Hotels_has_Room_types_Room_types1_idx` (`roomType` ASC) VISIBLE,
    INDEX `fk_Hotels_has_Room_types_Hotels1_idx` (`hotelId` ASC) VISIBLE,
    CONSTRAINT `fk_Hotels_has_Room_types_Hotels1`
    FOREIGN KEY (`hotelId`)
    REFERENCES `hotelBookingDb`.`Hotels` (`hotelId`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_Hotels_has_Room_types_Room_types1`
    FOREIGN KEY (`roomType`)
    REFERENCES `hotelBookingDb`.`RoomTypes` (`roomTypeId`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
    ENGINE = InnoDB;
insert into `HotelsHasRooms` VALUES (1, 2, 34, 24.19);
insert into `HotelsHasRooms` VALUES (1, 3, 29, 16.39);
insert into `HotelsHasRooms` VALUES (1, 4, 23, 12.65);
insert into `HotelsHasRooms` VALUES (1, 5, 6, 33.99);
insert into `HotelsHasRooms` VALUES (2, 1, 38, 6.3);
insert into `HotelsHasRooms` VALUES (2, 2, 47, 12.08);
insert into `HotelsHasRooms` VALUES (2, 3, 22, 20.32);
insert into `HotelsHasRooms` VALUES (2, 4, 22, 30.86);
insert into `HotelsHasRooms` VALUES (2, 5, 44, 40.37);
insert into `HotelsHasRooms` VALUES (3, 1, 36, 14.32);
insert into `HotelsHasRooms` VALUES (3, 2, 41, 38.20);
insert into `HotelsHasRooms` VALUES (3, 3, 30, 13.69);
insert into `HotelsHasRooms` VALUES (3, 4, 18, 9.84);
insert into `HotelsHasRooms` VALUES (3, 5, 27, 33.53);
insert into `HotelsHasRooms` VALUES (4, 1, 31, 44.23);
insert into `HotelsHasRooms` VALUES (4, 2, 20, 31.32);
insert into `HotelsHasRooms` VALUES (4, 3, 45, 17.34);
insert into `HotelsHasRooms` VALUES (4, 4, 43, 48.19);
insert into `HotelsHasRooms` VALUES (4, 5, 37, 9.37);
insert into `HotelsHasRooms` VALUES (5, 1, 10, 28.55);
insert into `HotelsHasRooms` VALUES (5, 2, 21, 17.30);
insert into `HotelsHasRooms` VALUES (5, 3, 6, 32.10);
insert into `HotelsHasRooms` VALUES (5, 4, 46, 40.49);
insert into `HotelsHasRooms` VALUES (5, 5, 38, 38.05);
insert into `HotelsHasRooms` VALUES (6, 1, 23, 46.57);
insert into `HotelsHasRooms` VALUES (6, 2, 28, 37.60);
insert into `HotelsHasRooms` VALUES (6, 3, 8, 34.63);
insert into `HotelsHasRooms` VALUES (6, 4, 26, 9.66);
insert into `HotelsHasRooms` VALUES (6, 5, 28, 21.58);
insert into `HotelsHasRooms` VALUES (7, 1, 15, 32.33);
insert into `HotelsHasRooms` VALUES (7, 2, 33, 10.72);
insert into `HotelsHasRooms` VALUES (7, 3, 39, 44.56);
insert into `HotelsHasRooms` VALUES (7, 4, 6, 38.87);
insert into `HotelsHasRooms` VALUES (7, 5, 46, 17.39);
insert into `HotelsHasRooms` VALUES (8, 1, 26, 17.22);
insert into `HotelsHasRooms` VALUES (8, 2, 7, 42.99);
insert into `HotelsHasRooms` VALUES (8, 3, 20, 16.37);
insert into `HotelsHasRooms` VALUES (8, 4, 15, 49.84);
insert into `HotelsHasRooms` VALUES (8, 5, 45, 33.33);
insert into `HotelsHasRooms` VALUES (9, 1, 42, 40.95);
insert into `HotelsHasRooms` VALUES (9, 2, 48, 30.33);
insert into `HotelsHasRooms` VALUES (9, 3, 27, 18.18);
insert into `HotelsHasRooms` VALUES (9, 4, 20, 38.98);
insert into `HotelsHasRooms` VALUES (9, 5, 15, 28.76);
insert into `HotelsHasRooms` VALUES (10, 1, 12, 36.52);
insert into `HotelsHasRooms` VALUES (10, 2, 15, 29.41);
insert into `HotelsHasRooms` VALUES (10, 3, 16, 24.51);
insert into `HotelsHasRooms` VALUES (10, 4, 46, 5.43);
insert into `HotelsHasRooms` VALUES (10, 5, 21, 38.63);
insert into `HotelsHasRooms` VALUES (11, 1, 6, 42.92);
insert into `HotelsHasRooms` VALUES (11, 2, 29, 5.03);
insert into `HotelsHasRooms` VALUES (11, 3, 17, 37.95);
insert into `HotelsHasRooms` VALUES (11, 4, 47, 38.14);
insert into `HotelsHasRooms` VALUES (11, 5, 15, 7.30);
insert into `HotelsHasRooms` VALUES (12, 1, 42, 30.07);
insert into `HotelsHasRooms` VALUES (12, 2, 35, 46.90);
insert into `HotelsHasRooms` VALUES (12, 3, 38, 47.09);
insert into `HotelsHasRooms` VALUES (12, 4, 7, 32.25);
insert into `HotelsHasRooms` VALUES (12, 5, 16, 24.78);
insert into `HotelsHasRooms` VALUES (13, 1, 40, 6.41);
insert into `HotelsHasRooms` VALUES (13, 2, 29, 30.40);
insert into `HotelsHasRooms` VALUES (13, 3, 25, 28.05);
insert into `HotelsHasRooms` VALUES (13, 4, 17, 30.09);
insert into `HotelsHasRooms` VALUES (13, 5, 43, 41.30);
insert into `HotelsHasRooms` VALUES (14, 1, 44, 30.32);
insert into `HotelsHasRooms` VALUES (14, 2, 23, 27.33);
insert into `HotelsHasRooms` VALUES (14, 3, 6, 36.94);
insert into `HotelsHasRooms` VALUES (14, 4, 7, 28.56);
insert into `HotelsHasRooms` VALUES (14, 5, 31, 37.88);
insert into `HotelsHasRooms` VALUES (15, 1, 24, 46.38);
insert into `HotelsHasRooms` VALUES (15, 2, 8, 13.27);
insert into `HotelsHasRooms` VALUES (15, 3, 47, 39.80);
insert into `HotelsHasRooms` VALUES (15, 4, 20, 21.27);
insert into `HotelsHasRooms` VALUES (15, 5, 44, 15.64);
insert into `HotelsHasRooms` VALUES (16, 1, 49, 36.73);
insert into `HotelsHasRooms` VALUES (16, 2, 26, 29.14);
insert into `HotelsHasRooms` VALUES (16, 3, 50, 45.50);
insert into `HotelsHasRooms` VALUES (16, 4, 25, 17.93);
insert into `HotelsHasRooms` VALUES (16, 5, 38, 13.25);
insert into `HotelsHasRooms` VALUES (17, 1, 16, 14.92);
insert into `HotelsHasRooms` VALUES (17, 2, 43, 33.97);
insert into `HotelsHasRooms` VALUES (17, 3, 24, 11.32);
insert into `HotelsHasRooms` VALUES (17, 4, 39, 29.47);
insert into `HotelsHasRooms` VALUES (17, 5, 20, 18.85);
insert into `HotelsHasRooms` VALUES (18, 1, 45, 41.93);
insert into `HotelsHasRooms` VALUES (18, 2, 16, 19.60);
insert into `HotelsHasRooms` VALUES (18, 3, 11, 29.63);
insert into `HotelsHasRooms` VALUES (18, 4, 30, 37.50);
insert into `HotelsHasRooms` VALUES (18, 5, 34, 36.10);
insert into `HotelsHasRooms` VALUES (19, 1, 43, 46.39);
insert into `HotelsHasRooms` VALUES (19, 2, 14, 37.47);
insert into `HotelsHasRooms` VALUES (19, 3, 13, 48.04);
insert into `HotelsHasRooms` VALUES (19, 4, 26, 29.74);
insert into `HotelsHasRooms` VALUES (19, 5, 41, 6.06);
insert into `HotelsHasRooms` VALUES (20, 1, 14, 23.46);
insert into `HotelsHasRooms` VALUES (20, 2, 9, 19.00);
insert into `HotelsHasRooms` VALUES (20, 3, 23, 8.94);
insert into `HotelsHasRooms` VALUES (20, 4, 25, 18.17);
insert into `HotelsHasRooms` VALUES (20, 5, 47, 14.67);
insert into `HotelsHasRooms` VALUES (21, 1, 27, 43.14);
insert into `HotelsHasRooms` VALUES (21, 2, 40, 24.32);
insert into `HotelsHasRooms` VALUES (21, 3, 17, 40.28);
insert into `HotelsHasRooms` VALUES (21, 4, 28, 47.48);
insert into `HotelsHasRooms` VALUES (21, 5, 43, 14.76);
insert into `HotelsHasRooms` VALUES (22, 1, 19, 23.63);
insert into `HotelsHasRooms` VALUES (22, 2, 43, 25.01);
insert into `HotelsHasRooms` VALUES (22, 3, 46, 21.49);
insert into `HotelsHasRooms` VALUES (22, 4, 40, 13.55);
insert into `HotelsHasRooms` VALUES (22, 5, 48, 31.69);
insert into `HotelsHasRooms` VALUES (23, 1, 21, 46.84);
insert into `HotelsHasRooms` VALUES (23, 2, 14, 28.91);
insert into `HotelsHasRooms` VALUES (23, 3, 28, 27.06);
insert into `HotelsHasRooms` VALUES (23, 4, 41, 26.28);
insert into `HotelsHasRooms` VALUES (23, 5, 16, 10.38);
insert into `HotelsHasRooms` VALUES (24, 1, 48, 10.76);
insert into `HotelsHasRooms` VALUES (24, 2, 25, 22.73);
insert into `HotelsHasRooms` VALUES (24, 3, 25, 11.24);
insert into `HotelsHasRooms` VALUES (24, 4, 28, 30.95);
insert into `HotelsHasRooms` VALUES (24, 5, 47, 49.47);
insert into `HotelsHasRooms` VALUES (25, 1, 16, 15.89);
insert into `HotelsHasRooms` VALUES (25, 2, 15, 29.00);
insert into `HotelsHasRooms` VALUES (25, 3, 35, 42.98);
insert into `HotelsHasRooms` VALUES (25, 4, 40, 60.12);
insert into `HotelsHasRooms` VALUES (25, 5, 39, 80.56);
insert into `HotelsHasRooms` VALUES (26, 1, 25, 15.86);
insert into `HotelsHasRooms` VALUES (26, 2, 47, 48.17);
insert into `HotelsHasRooms` VALUES (26, 3, 42, 47.67);
insert into `HotelsHasRooms` VALUES (26, 4, 5, 22.28);
insert into `HotelsHasRooms` VALUES (26, 5, 7, 28.63);
insert into `HotelsHasRooms` VALUES (27, 1, 30, 14.10);
insert into `HotelsHasRooms` VALUES (27, 2, 20, 34.60);
insert into `HotelsHasRooms` VALUES (27, 3, 35, 8.64);
insert into `HotelsHasRooms` VALUES (27, 4, 33, 30.44);
insert into `HotelsHasRooms` VALUES (27, 5, 20, 41.22);
insert into `HotelsHasRooms` VALUES (28, 1, 10, 41.71);
insert into `HotelsHasRooms` VALUES (28, 2, 36, 11.20);
insert into `HotelsHasRooms` VALUES (28, 3, 44, 35.27);
insert into `HotelsHasRooms` VALUES (28, 4, 11, 31.16);
insert into `HotelsHasRooms` VALUES (28, 5, 47, 33.40);
insert into `HotelsHasRooms` VALUES (29, 1, 17, 15.91);
insert into `HotelsHasRooms` VALUES (29, 2, 45, 39.79);
insert into `HotelsHasRooms` VALUES (29, 3, 29, 17.91);
insert into `HotelsHasRooms` VALUES (29, 4, 41, 43.32);
insert into `HotelsHasRooms` VALUES (29, 5, 8, 38.60);
insert into `HotelsHasRooms` VALUES (30, 1, 19, 43.05);
insert into `HotelsHasRooms` VALUES (30, 2, 7, 38.87);
insert into `HotelsHasRooms` VALUES (30, 3, 31, 43.68);
insert into `HotelsHasRooms` VALUES (30, 4, 50, 23.45);
insert into `HotelsHasRooms` VALUES (30, 5, 43, 34.32);


-- -----------------------------------------------------
-- Table `hotelBookingDb`.`Reservations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelBookingDb`.`Reservations` (
                                                               `reservationId` INT NOT NULL AUTO_INCREMENT,
                                                               `customerId` INT NOT NULL,
                                                               `hotel` INT NOT NULL,
                                                               `roomType` INT NOT NULL,
                                                               `checkIn` DATE NOT NULL,
                                                               `checkOut` DATE NOT NULL,
                                                               `priceTotal` DECIMAL(10,2) NOT NULL,
    `discountPercent` INT NOT NULL,
    `status` INT NOT NULL,
    PRIMARY KEY (`reservationId`),
    INDEX `fk_Reservations_Customer1_idx` (`customerId` ASC) VISIBLE,
    INDEX `fk_Reservations_Reservation_status1_idx` (`status` ASC) VISIBLE,
    INDEX `fk_Reservations_Hotels_has_Room_types1_idx` (`hotel` ASC, `roomType` ASC) VISIBLE,
    CONSTRAINT `fk_Reservations_Customer1`
    FOREIGN KEY (`customerId`)
    REFERENCES `hotelBookingDb`.`Customer` (`customerId`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
    CONSTRAINT `fk_Reservations_Reservation_status1`
    FOREIGN KEY (`status`)
    REFERENCES `hotelBookingDb`.`ReservationStatus` (`statusId`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    CONSTRAINT `fk_Reservations_Hotels_has_Room_types1`
    FOREIGN KEY (`hotel` , `roomType`)
    REFERENCES `hotelBookingDb`.`HotelsHasRooms` (`hotelId` , `roomType`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
    ENGINE = InnoDB;
INSERT INTO `Reservations` VALUES (1, 35, 25, 3, '2020/08/24', '2020/08/29', 208.45, 5, 2);
INSERT INTO `Reservations` VALUES (2, 86, 19, 1, '2020/11/29', '2020/12/05', 314.98, 4, 2);
INSERT INTO `Reservations` VALUES (3, 65, 8, 3, '2019/04/13', '2019/04/20', 111.15, 4, 2);
INSERT INTO `Reservations` VALUES (4, 100, 25, 3, '2021/01/16', '2021/01/26', 408.31, 4, 4);
INSERT INTO `Reservations` VALUES (5, 4, 2, 2, '2020/10/20', '2020/10/30', 120.8, 3, 5);
INSERT INTO `Reservations` VALUES (6, 94, 1, 2, '2020/05/25', '2020/05/26', 24.49, 5, 4);
INSERT INTO `Reservations` VALUES (7, 46, 10, 5, '2019/12/18', '2019/12/25', 270.41, 1, 2);
INSERT INTO `Reservations` VALUES (8, 15, 23, 2, '2019/12/23', '2019/12/24', 28.04, 1, 3);
INSERT INTO `Reservations` VALUES (9, 79, 19, 4, '2020/02/18', '2020/02/22', 113.01, 3, 2);
INSERT INTO `Reservations` VALUES (10, 75, 20, 1, '2020/08/02', '2020/08/10', 185.80, 3, 5);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
