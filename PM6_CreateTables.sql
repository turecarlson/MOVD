-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema MOVD
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `MOVD` ;

-- -----------------------------------------------------
-- Schema MOVD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MOVD` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `MOVD` ;


-- -----------------------------------------------------
-- Table `State`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `State` ;

CREATE TABLE IF NOT EXISTS `State` (
  `StateName` VARCHAR(45) NOT NULL,
  `Slug` VARCHAR(40) NULL DEFAULT NULL,
  `Code` VARCHAR(45) NULL DEFAULT NULL,
  `Nickname` VARCHAR(70) NULL DEFAULT NULL,
  `Website` VARCHAR(40) NULL DEFAULT NULL,
  `AdmissionDate` VARCHAR(40) NULL DEFAULT NULL,
  `AdmissionNumber` VARCHAR(40) NULL DEFAULT NULL,
  `CapitalCity` VARCHAR(40) NULL DEFAULT NULL,
  `CapitalUrl` VARCHAR(100) NULL DEFAULT NULL,
  `Population` VARCHAR(40) NULL DEFAULT NULL,
  `PopulationRank` VARCHAR(40) NULL DEFAULT NULL,
  `ConstitutionUrl` VARCHAR(150) NULL DEFAULT NULL,
  `StateFlagUrl` VARCHAR(100) NULL DEFAULT NULL,
  `StateSealUrl` VARCHAR(100) NULL DEFAULT NULL,
  `MapImageUrl` VARCHAR(100) NULL DEFAULT NULL,
  `LandscapeBackgroundUrl` VARCHAR(100) NULL DEFAULT NULL,
  `SkylineBackgroundUrl` VARCHAR(100) NULL DEFAULT NULL,
  `TwitterUrl` VARCHAR(100) NULL DEFAULT NULL,
  `FacebookUrl` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`StateName`),
  UNIQUE INDEX `Code_UNIQUE` (`Code` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



-- -----------------------------------------------------
-- Table `JHCountyStat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JHCountyStat` ;

CREATE TABLE IF NOT EXISTS `JHCountyStat` (
  `FipsCode` VARCHAR(45) NOT NULL,
  `LastUpdate` VARCHAR(45) NOT NULL,
  `State` VARCHAR(45) NOT NULL,
  `CountyName` VARCHAR(45) NOT NULL,
  `CountyNameLong` VARCHAR(100) NOT NULL,
  `Latitude` VARCHAR(45) NULL DEFAULT NULL,
  `Longitude` VARCHAR(45) NULL DEFAULT NULL,
  `NCHSUrbanization` VARCHAR(45) NULL DEFAULT NULL,
  `TotalPopulation` VARCHAR(45) NULL DEFAULT NULL,
  INDEX `CntyName_index` (`CountyName` ASC) VISIBLE,
  PRIMARY KEY (`FipsCode`),
  CONSTRAINT `fk_StateName`
    FOREIGN KEY (`State`)
    REFERENCES `State` (`StateName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `JHCountyStat_Staging`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `JHCountyStat_Staging`;

CREATE TABLE IF NOT EXISTS `JHCountyStat_Staging` (
  `LastUpdate` VARCHAR(45) NOT NULL,
  `State` VARCHAR(45) NULL,
  `CountyName` VARCHAR(45) NULL,
  `CountyNameLong` VARCHAR(100) NOT NULL,
  `FipsCode` VARCHAR(45) NOT NULL,
  `Latitude` VARCHAR(45) NULL DEFAULT NULL,
  `Longitude` VARCHAR(45) NULL DEFAULT NULL,
  `NCHSUrbanization` VARCHAR(45) NULL DEFAULT NULL,
  `TotalPopulation` VARCHAR(45) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `GoogleMobilityData`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GoogleMobilityData` ;

CREATE TABLE IF NOT EXISTS `GoogleMobilityData` (
  `Synthetic_Mobility_PK` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NULL DEFAULT NULL,
  `Country` VARCHAR(45) NOT NULL,
  `Rec` INT NULL DEFAULT NULL,
  `Grocery` INT NULL DEFAULT NULL,
  `Parks` INT NULL DEFAULT NULL,
  `Transit_Station` INT NULL DEFAULT NULL,
  `Work` INT NULL DEFAULT NULL,
  `Residential` INT NULL DEFAULT NULL,
  `JHCountyStat_FipsCode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Synthetic_Mobility_PK`),
  UNIQUE INDEX `Synthetic_Mobility_PK_UNIQUE` (`Synthetic_Mobility_PK` ASC) VISIBLE,
  INDEX `fk_Google Mobility Data_JHCountyStat1_idx` (`JHCountyStat_FipsCode` ASC) VISIBLE,
  CONSTRAINT `fk_Google Mobility Data_JHCountyStat1`
    FOREIGN KEY (`JHCountyStat_FipsCode`)
    REFERENCES `JHCountyStat` (`FipsCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 369141
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Google Mobility Staging`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Google Mobility Staging` ;

CREATE TABLE IF NOT EXISTS `Google Mobility Staging` (
  `SyntheticPrimaryKey` INT NOT NULL AUTO_INCREMENT,
  `Date` TEXT NULL DEFAULT NULL,
  `Country` TEXT NULL DEFAULT NULL,
  `State` TEXT NULL DEFAULT NULL,
  `County` TEXT NULL DEFAULT NULL,
  `Rec` TEXT NULL DEFAULT NULL,
  `Grocery` TEXT NULL DEFAULT NULL,
  `Parks` TEXT NULL DEFAULT NULL,
  `Transit_Station` TEXT NULL DEFAULT NULL,
  `Work` TEXT NULL DEFAULT NULL,
  `Residential` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`SyntheticPrimaryKey`))
ENGINE = InnoDB
AUTO_INCREMENT = 393211
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Governors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Governors` ;

CREATE TABLE IF NOT EXISTS `Governors` (
  `Governors_pk` INT NOT NULL AUTO_INCREMENT,
  `State` VARCHAR(45) NOT NULL,
  `StateNameSlug` VARCHAR(50) NULL DEFAULT NULL,
  `StateCode` VARCHAR(2) NULL DEFAULT NULL,
  `StateCodeSlug` VARCHAR(2) NULL DEFAULT NULL,
  `VoteSmart` VARCHAR(10) NULL DEFAULT NULL,
  `Title` VARCHAR(20) NULL DEFAULT NULL,
  `Party` VARCHAR(20) NULL DEFAULT NULL,
  `Name` VARCHAR(50) NULL DEFAULT NULL,
  `NameSlug` VARCHAR(50) NULL DEFAULT NULL,
  `FirstName` VARCHAR(50) NULL DEFAULT NULL,
  `MiddleName` VARCHAR(50) NULL DEFAULT NULL,
  `LastName` VARCHAR(50) NULL DEFAULT NULL,
  `NameSuffix` VARCHAR(15) NULL DEFAULT NULL,
  `GoesBy` VARCHAR(15) NULL DEFAULT NULL,
  `Pronunciation` VARCHAR(40) NULL DEFAULT NULL,
  `Gender` VARCHAR(10) NULL DEFAULT NULL,
  `Ethnicity` VARCHAR(25) NULL DEFAULT NULL,
  `Religion` VARCHAR(30) NULL DEFAULT NULL,
  `OpenlyLgbtq` VARCHAR(20) NULL DEFAULT NULL,
  `DateOfBirth` VARCHAR(15) NULL DEFAULT NULL,
  `EnteredOffice` VARCHAR(20) NULL DEFAULT NULL,
  `TermEnd` VARCHAR(20) NULL DEFAULT NULL,
  `Biography` VARCHAR(1000) NULL DEFAULT NULL,
  `Phone` VARCHAR(20) NULL DEFAULT NULL,
  `Fax` VARCHAR(20) NULL DEFAULT NULL,
  `Latitude` VARCHAR(20) NULL DEFAULT NULL,
  `Longitude` VARCHAR(20) NULL DEFAULT NULL,
  `AddressComplete` VARCHAR(110) NULL DEFAULT NULL,
  `AddressNumber` VARCHAR(10) NULL DEFAULT NULL,
  `AddressPrefix` VARCHAR(25) NULL DEFAULT NULL,
  `AddressStreet` VARCHAR(25) NULL DEFAULT NULL,
  `AddressSecUnitType` VARCHAR(25) NULL DEFAULT NULL,
  `AddressSecUnitNum` VARCHAR(25) NULL DEFAULT NULL,
  `AddressCity` VARCHAR(25) NULL DEFAULT NULL,
  `AddressState` VARCHAR(25) NULL DEFAULT NULL,
  `AddressZipcode` VARCHAR(10) NULL DEFAULT NULL,
  `AddressType` VARCHAR(25) NULL DEFAULT NULL,
  `Website` VARCHAR(100) NULL DEFAULT NULL,
  `ContactPage` VARCHAR(100) NULL DEFAULT NULL,
  `FacebookUrl` VARCHAR(100) NULL DEFAULT NULL,
  `TwitterHandle` VARCHAR(100) NULL DEFAULT NULL,
  `TwitterUrl` VARCHAR(100) NULL DEFAULT NULL,
  `PhotoUrl` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`Governors_pk`),
  INDEX `State_idx` (`State` ASC) VISIBLE,
  CONSTRAINT `State_FK`
    FOREIGN KEY (`State`)
    REFERENCES `State` (`StateName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Hospitals20`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospitals20` ;

CREATE TABLE IF NOT EXISTS `Hospitals20` (
  `Hospitals20_PK` INT NOT NULL auto_increment,
  `State` VARCHAR(45) NOT NULL,
  `TotalHospitalBeds` INT NULL DEFAULT NULL,
  `TotalICUBeds` INT NULL DEFAULT NULL,
  `HospitalBedOccupancyRate` DOUBLE NULL DEFAULT NULL,
  `ICUBedOccupancyRate` DOUBLE NULL DEFAULT NULL,
  `AvailableHospitalBeds` INT NULL DEFAULT NULL,
  `PotentiallyAvailableHospitalBeds*` INT NULL DEFAULT NULL,
  `AvailableICUBeds` INT NULL DEFAULT NULL,
  `PotentiallyAvailableICUBeds*` INT NULL DEFAULT NULL,
  `AdultPopulation` INT NULL DEFAULT NULL,
  `Population65+` INT NULL DEFAULT NULL,
  `ProjectedInfectedIndividuals` INT NULL DEFAULT NULL,
  `ProjectedHospitalizedIndividuals` INT NULL DEFAULT NULL,
  `ProjectedIndividualsNeedingICUCare` INT NULL DEFAULT NULL,
  `HospitalBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofAvailableBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofTotalBedsNeeded6Months` INT NULL DEFAULT NULL,
  `HospitalBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofAvailableBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofTotalBedsNeeded12Months` INT NULL DEFAULT NULL,
  `HospitalBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofAvailableBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofTotalBedsNeeded18Months` INT NULL DEFAULT NULL,
  `ICUBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofAvailableICUBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableICUBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofTotalICUBedsNeeded6Months` INT NULL DEFAULT NULL,
  `ICUBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofAvailableICUBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableICUBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofTotalICUBedsNeeded12Months` INT NULL DEFAULT NULL,
  `ICUBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofAvailableICUBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableICUBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofTotalICUBedsNeeded18Months` INT NULL DEFAULT NULL,
  PRIMARY KEY (`Hospitals20_PK`),
  CONSTRAINT `Hospitals20_State_FK`
    FOREIGN KEY (`State`)
    REFERENCES `State` (`StateName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Hospitals20_staging`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hospitals20_staging` ;

CREATE TABLE IF NOT EXISTS `Hospitals20_staging` (
  `State` VARCHAR(45),
  `TotalHospitalBeds` INT NULL DEFAULT NULL,
  `TotalICUBeds` INT NULL DEFAULT NULL,
  `HospitalBedOccupancyRate` DOUBLE NULL DEFAULT NULL,
  `ICUBedOccupancyRate` DOUBLE NULL DEFAULT NULL,
  `AvailableHospitalBeds` INT NULL DEFAULT NULL,
  `PotentiallyAvailableHospitalBeds*` INT NULL DEFAULT NULL,
  `AvailableICUBeds` INT NULL DEFAULT NULL,
  `PotentiallyAvailableICUBeds*` INT NULL DEFAULT NULL,
  `AdultPopulation` INT NULL DEFAULT NULL,
  `Population65+` INT NULL DEFAULT NULL,
  `ProjectedInfectedIndividuals` INT NULL DEFAULT NULL,
  `ProjectedHospitalizedIndividuals` INT NULL DEFAULT NULL,
  `ProjectedIndividualsNeedingICUCare` INT NULL DEFAULT NULL,
  `HospitalBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofAvailableBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofTotalBedsNeeded6Months` INT NULL DEFAULT NULL,
  `HospitalBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofAvailableBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofTotalBedsNeeded12Months` INT NULL DEFAULT NULL,
  `HospitalBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofAvailableBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofTotalBedsNeeded18Months` INT NULL DEFAULT NULL,
  `ICUBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofAvailableICUBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableICUBedsNeeded6Months` INT NULL DEFAULT NULL,
  `%ofTotalICUBedsNeeded6Months` INT NULL DEFAULT NULL,
  `ICUBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofAvailableICUBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableICUBedsNeeded12Months` INT NULL DEFAULT NULL,
  `%ofTotalICUBedsNeeded12Months` INT NULL DEFAULT NULL,
  `ICUBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofAvailableICUBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofPotentiallyAvailableICUBedsNeeded18Months` INT NULL DEFAULT NULL,
  `%ofTotalICUBedsNeeded18Months` INT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `JHCovidStat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JHCovidStat` ;

CREATE TABLE IF NOT EXISTS `JHCovidStat` (
  `CovidStatKey_pk` INT NOT NULL AUTO_INCREMENT,
  `CountyUID` VARCHAR(8) NOT NULL,
  `CountyName` VARCHAR(45) NOT NULL,
  `State` VARCHAR(45) NOT NULL,
  `Date` Date NOT NULL,
  `TotalCountyPopulation` FLOAT NULL DEFAULT NULL,
  `CumulativeCases` INT NULL DEFAULT NULL,
  `CumulativeCasesPer100000` FLOAT NULL DEFAULT NULL,
  `CumulativeDeaths` INT NULL DEFAULT NULL,
  `CumulativeDeathsPer100000` FLOAT NULL DEFAULT NULL,
  `NewCases` INT NULL DEFAULT NULL,
  `NewDeaths` INT NULL DEFAULT NULL,
  `NewCasesPer100000` FLOAT NULL DEFAULT NULL,
  `NewDeathsPer100000` VARCHAR(45) NULL DEFAULT NULL,
  `NewCases7DayRollingAverage` FLOAT NULL DEFAULT NULL,
  `NewDeaths7DayRollingAverage` FLOAT NULL DEFAULT NULL,
  `JHCountyStat_FipsCode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CovidStatKey_pk`),
  INDEX `fk_JHCovidStat_JHCountyStat1_idx` (`JHCountyStat_FipsCode` ASC) VISIBLE,
  CONSTRAINT `fk_JHCovidStat_JHCountyStat1`
    FOREIGN KEY (`JHCountyStat_FipsCode`)
    REFERENCES `JHCountyStat` (`FipsCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `JHStagingTable`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JHStagingTable` ;

CREATE TABLE IF NOT EXISTS `JHStagingTable` (
  `CountyUID` VARCHAR(15) NULL DEFAULT NULL,
  `CountyName` VARCHAR(45) NULL DEFAULT NULL,
  `FipsCode` VARCHAR(45) NULL DEFAULT NULL,
  `State` VARCHAR(45) NULL DEFAULT NULL,
  `Date` VARCHAR(15) NULL DEFAULT NULL,
  `TotalCountyPopulation` VARCHAR(45) NULL DEFAULT NULL,
  `CumulativeCases` VARCHAR(45) NULL DEFAULT NULL,
  `CumulativeCasesPer100000` VARCHAR(45) NULL DEFAULT NULL,
  `CumulativeDeaths` VARCHAR(45) NULL DEFAULT NULL,
  `CumulativeDeathsPer100000` VARCHAR(45) NULL DEFAULT NULL,
  `NewCases` VARCHAR(45) NULL DEFAULT NULL,
  `NewDeaths` VARCHAR(45) NULL DEFAULT NULL,
  `NewCasesPer100000` VARCHAR(45) NULL DEFAULT NULL,
  `NewDeathsPer100000` VARCHAR(45) NULL DEFAULT NULL,
  `NewCases7DayRollingAverage` VARCHAR(45) NULL DEFAULT NULL,
  `NewDeaths7DayAverage` VARCHAR(45) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CensusRecord`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CensusRecord` ;

CREATE TABLE IF NOT EXISTS `CensusRecord` (
  `census_data_pk` INT NOT NULL AUTO_INCREMENT,
  `FipsCode` VARCHAR(45) NOT NULL,
  `CountyName` VARCHAR(45) NOT NULL,
  `YEAR` INT NULL DEFAULT NULL,
  `AGEGRP` INT NULL DEFAULT NULL,
  `TOT_POP` INT NULL DEFAULT NULL,
  `TOT_MALE` INT NULL DEFAULT NULL,
  `TOT_FEMALE` INT NULL DEFAULT NULL,
  `WA_MALE` INT NULL DEFAULT NULL,
  `WA_FEMALE` INT NULL DEFAULT NULL,
  `BA_MALE` INT NULL DEFAULT NULL,
  `BA_FEMALE` INT NULL DEFAULT NULL,
  `IA_MALE` INT NULL DEFAULT NULL,
  `IA_FEMALE` INT NULL DEFAULT NULL,
  `AA_MALE` INT NULL DEFAULT NULL,
  `AA_FEMALE` INT NULL DEFAULT NULL,
  `NA_MALE` INT NULL DEFAULT NULL,
  `NA_FEMALE` INT NULL DEFAULT NULL,
  `TOM_MALE` INT NULL DEFAULT NULL,
  `TOM_FEMALE` INT NULL DEFAULT NULL,
  `WAC_MALE` INT NULL DEFAULT NULL,
  `WAC_FEMALE` INT NULL DEFAULT NULL,
  `BAC_MALE` INT NULL DEFAULT NULL,
  `BAC_FEMALE` INT NULL DEFAULT NULL,
  `IAC_MALE` INT NULL DEFAULT NULL,
  `IAC_FEMALE` INT NULL DEFAULT NULL,
  `AAC_MALE` INT NULL DEFAULT NULL,
  `AAC_FEMALE` INT NULL DEFAULT NULL,
  `NAC_MALE` INT NULL DEFAULT NULL,
  `NAC_FEMALE` INT NULL DEFAULT NULL,
  `NH_MALE` INT NULL DEFAULT NULL,
  `NH_FEMALE` INT NULL DEFAULT NULL,
  `NHWA_MALE` INT NULL DEFAULT NULL,
  `NHWA_FEMALE` INT NULL DEFAULT NULL,
  `NHBA_MALE` INT NULL DEFAULT NULL,
  `NHBA_FEMALE` INT NULL DEFAULT NULL,
  `NHIA_MALE` INT NULL DEFAULT NULL,
  `NHIA_FEMALE` INT NULL DEFAULT NULL,
  `NHAA_MALE` INT NULL DEFAULT NULL,
  `NHAA_FEMALE` INT NULL DEFAULT NULL,
  `NHNA_MALE` INT NULL DEFAULT NULL,
  `NHNA_FEMALE` INT NULL DEFAULT NULL,
  `NHTOM_MALE` INT NULL DEFAULT NULL,
  `NHTOM_FEMALE` INT NULL DEFAULT NULL,
  `NHWAC_MALE` INT NULL DEFAULT NULL,
  `NHWAC_FEMALE` INT NULL DEFAULT NULL,
  `NHBAC_MALE` INT NULL DEFAULT NULL,
  `NHBAC_FEMALE` INT NULL DEFAULT NULL,
  `NHIAC_MALE` INT NULL DEFAULT NULL,
  `NHIAC_FEMALE` INT NULL DEFAULT NULL,
  `NHAAC_MALE` INT NULL DEFAULT NULL,
  `NHAAC_FEMALE` INT NULL DEFAULT NULL,
  `NHNAC_MALE` INT NULL DEFAULT NULL,
  `NHNAC_FEMALE` INT NULL DEFAULT NULL,
  `H_MALE` INT NULL DEFAULT NULL,
  `H_FEMALE` INT NULL DEFAULT NULL,
  `HWA_MALE` INT NULL DEFAULT NULL,
  `HWA_FEMALE` INT NULL DEFAULT NULL,
  `HBA_MALE` INT NULL DEFAULT NULL,
  `HBA_FEMALE` INT NULL DEFAULT NULL,
  `HIA_MALE` INT NULL DEFAULT NULL,
  `HIA_FEMALE` INT NULL DEFAULT NULL,
  `HAA_MALE` INT NULL DEFAULT NULL,
  `HAA_FEMALE` INT NULL DEFAULT NULL,
  `HNA_MALE` INT NULL DEFAULT NULL,
  `HNA_FEMALE` INT NULL DEFAULT NULL,
  `HTOM_MALE` INT NULL DEFAULT NULL,
  `HTOM_FEMALE` INT NULL DEFAULT NULL,
  `HWAC_MALE` INT NULL DEFAULT NULL,
  `HWAC_FEMALE` INT NULL DEFAULT NULL,
  `HBAC_MALE` INT NULL DEFAULT NULL,
  `HBAC_FEMALE` INT NULL DEFAULT NULL,
  `HIAC_MALE` INT NULL DEFAULT NULL,
  `HIAC_FEMALE` INT NULL DEFAULT NULL,
  `HAAC_MALE` INT NULL DEFAULT NULL,
  `HAAC_FEMALE` INT NULL DEFAULT NULL,
  `HNAC_MALE` INT NULL DEFAULT NULL,
  `HNAC_FEMALE` INT NULL DEFAULT NULL,
  PRIMARY KEY (`census_data_pk`),
  INDEX `FipsCode_idx` (`FipsCode` ASC) VISIBLE,
  CONSTRAINT `FipsCode_FK`
    FOREIGN KEY (`FipsCode`)
    REFERENCES `JHCountyStat` (`FipsCode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CensusRecordST`
-- -----------------------------------------------------
DROP TABLE IF exists `CensusRecordST`;

CREATE TABLE `CensusRecordST` (
  `SUMLEV` int DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `COUNTY` int DEFAULT NULL,
  `STNAME` varchar(45) DEFAULT NULL,
  `CTYNAME` varchar(45) DEFAULT NULL,
  `YEAR` int DEFAULT NULL,
  `AGEGRP` int DEFAULT NULL,
  `TOT_POP` int DEFAULT NULL,
  `TOT_MALE` int DEFAULT NULL,
  `TOT_FEMALE` int DEFAULT NULL,
  `WA_MALE` int DEFAULT NULL,
  `WA_FEMALE` int DEFAULT NULL,
  `BA_MALE` int DEFAULT NULL,
  `BA_FEMALE` int DEFAULT NULL,
  `IA_MALE` int DEFAULT NULL,
  `IA_FEMALE` int DEFAULT NULL,
  `AA_MALE` int DEFAULT NULL,
  `AA_FEMALE` int DEFAULT NULL,
  `NA_MALE` int DEFAULT NULL,
  `NA_FEMALE` int DEFAULT NULL,
  `TOM_MALE` int DEFAULT NULL,
  `TOM_FEMALE` int DEFAULT NULL,
  `WAC_MALE` int DEFAULT NULL,
  `WAC_FEMALE` int DEFAULT NULL,
  `BAC_MALE` int DEFAULT NULL,
  `BAC_FEMALE` int DEFAULT NULL,
  `IAC_MALE` int DEFAULT NULL,
  `IAC_FEMALE` int DEFAULT NULL,
  `AAC_MALE` int DEFAULT NULL,
  `AAC_FEMALE` int DEFAULT NULL,
  `NAC_MALE` int DEFAULT NULL,
  `NAC_FEMALE` int DEFAULT NULL,
  `NH_MALE` int DEFAULT NULL,
  `NH_FEMALE` int DEFAULT NULL,
  `NHWA_MALE` int DEFAULT NULL,
  `NHWA_FEMALE` int DEFAULT NULL,
  `NHBA_MALE` int DEFAULT NULL,
  `NHBA_FEMALE` int DEFAULT NULL,
  `NHIA_MALE` int DEFAULT NULL,
  `NHIA_FEMALE` int DEFAULT NULL,
  `NHAA_MALE` int DEFAULT NULL,
  `NHAA_FEMALE` int DEFAULT NULL,
  `NHNA_MALE` int DEFAULT NULL,
  `NHNA_FEMALE` int DEFAULT NULL,
  `NHTOM_MALE` int DEFAULT NULL,
  `NHTOM_FEMALE` int DEFAULT NULL,
  `NHWAC_MALE` int DEFAULT NULL,
  `NHWAC_FEMALE` int DEFAULT NULL,
  `NHBAC_MALE` int DEFAULT NULL,
  `NHBAC_FEMALE` int DEFAULT NULL,
  `NHIAC_MALE` int DEFAULT NULL,
  `NHIAC_FEMALE` int DEFAULT NULL,
  `NHAAC_MALE` int DEFAULT NULL,
  `NHAAC_FEMALE` int DEFAULT NULL,
  `NHNAC_MALE` int DEFAULT NULL,
  `NHNAC_FEMALE` int DEFAULT NULL,
  `H_MALE` int DEFAULT NULL,
  `H_FEMALE` int DEFAULT NULL,
  `HWA_MALE` int DEFAULT NULL,
  `HWA_FEMALE` int DEFAULT NULL,
  `HBA_MALE` int DEFAULT NULL,
  `HBA_FEMALE` int DEFAULT NULL,
  `HIA_MALE` int DEFAULT NULL,
  `HIA_FEMALE` int DEFAULT NULL,
  `HAA_MALE` int DEFAULT NULL,
  `HAA_FEMALE` int DEFAULT NULL,
  `HNA_MALE` int DEFAULT NULL,
  `HNA_FEMALE` int DEFAULT NULL,
  `HTOM_MALE` int DEFAULT NULL,
  `HTOM_FEMALE` int DEFAULT NULL,
  `HWAC_MALE` int DEFAULT NULL,
  `HWAC_FEMALE` int DEFAULT NULL,
  `HBAC_MALE` int DEFAULT NULL,
  `HBAC_FEMALE` int DEFAULT NULL,
  `HIAC_MALE` int DEFAULT NULL,
  `HIAC_FEMALE` int DEFAULT NULL,
  `HAAC_MALE` int DEFAULT NULL,
  `HAAC_FEMALE` int DEFAULT NULL,
  `HNAC_MALE` int DEFAULT NULL,
  `HNAC_FEMALE` int DEFAULT NULL)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `Legislators`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Legislators` ;

CREATE TABLE IF NOT EXISTS `Legislators` (
  `LegislatorsKey` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `LastName` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `MiddleName` VARCHAR(45) NULL DEFAULT NULL,
  `Suffix` VARCHAR(10) NULL DEFAULT NULL,
  `Nickname` VARCHAR(20) NULL DEFAULT NULL,
  `FullName` VARCHAR(90) NULL DEFAULT NULL,
  `Birthday` DATE NOT NULL,
  `Gender` VARCHAR(10) NOT NULL,
  `Type` VARCHAR(20) NOT NULL,
  `State` VARCHAR(45) NOT NULL,
  `District` VARCHAR(25) NULL DEFAULT NULL,
  `Senate_class` VARCHAR(20) NULL DEFAULT NULL,
  `Party` VARCHAR(15) NOT NULL,
  INDEX `State_idx` (`State` ASC) VISIBLE,
  CONSTRAINT `Legislators_State_FK`
    FOREIGN KEY (`State`)
    REFERENCES `State` (`StateName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `legislators-current_stage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `legislators-current_stage` ;

CREATE TABLE IF NOT EXISTS `legislators-current_stage` (
  `last_name` TEXT NULL DEFAULT NULL,
  `first_name` TEXT NULL DEFAULT NULL,
  `middle_name` TEXT NULL DEFAULT NULL,
  `suffix` TEXT NULL DEFAULT NULL,
  `nickname` TEXT NULL DEFAULT NULL,
  `full_name` TEXT NULL DEFAULT NULL,
  `birthday` TEXT NULL DEFAULT NULL,
  `gender` TEXT NULL DEFAULT NULL,
  `type` TEXT NULL DEFAULT NULL,
  `state` TEXT NULL DEFAULT NULL,
  `district` TEXT NULL DEFAULT NULL,
  `senate_class` TEXT NULL DEFAULT NULL,
  `party` TEXT NULL DEFAULT NULL,
  `url` TEXT NULL DEFAULT NULL,
  `address` TEXT NULL DEFAULT NULL,
  `phone` TEXT NULL DEFAULT NULL,
  `contact_form` TEXT NULL DEFAULT NULL,
  `rss_url` TEXT NULL DEFAULT NULL,
  `twitter` TEXT NULL DEFAULT NULL,
  `facebook` TEXT NULL DEFAULT NULL,
  `youtube` TEXT NULL DEFAULT NULL,
  `youtube_id` TEXT NULL DEFAULT NULL,
  `bioguide_id` TEXT NULL DEFAULT NULL,
  `thomas_id` TEXT NULL DEFAULT NULL,
  `opensecrets_id` TEXT NULL DEFAULT NULL,
  `lis_id` TEXT NULL DEFAULT NULL,
  `fec_ids` TEXT NULL DEFAULT NULL,
  `cspan_id` TEXT NULL DEFAULT NULL,
  `govtrack_id` TEXT NULL DEFAULT NULL,
  `votesmart_id` TEXT NULL DEFAULT NULL,
  `ballotpedia_id` TEXT NULL DEFAULT NULL,
  `washington_post_id` TEXT NULL DEFAULT NULL,
  `icpsr_id` TEXT NULL DEFAULT NULL,
  `wikipedia_id` TEXT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS UnemploymentStatST;
CREATE TABLE `UnemploymentStatST` (
  `LAUSCode` TEXT NULL DEFAULT NULL,
  `StateFipsCode` TEXT NULL DEFAULT NULL,
  `CountyFipsCode` TEXT NULL DEFAULT NULL,
  `CountyNameAndStateAbbreviation` TEXT NULL DEFAULT NULL,
  `Period` TEXT NULL DEFAULT NULL,
  `LaborForce` TEXT NULL DEFAULT NULL,
  `Employed` INT NULL DEFAULT NULL,
  `Unemployed` INT NULL DEFAULT NULL,
  `UnemploymentRatePercentage` DOUBLE NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS UnemploymentStat;
CREATE TABLE `UnemploymentStat` (
  `UnemploymentPK` INT auto_increment,
  `FipsCode` VARCHAR(45),
  `Period` DATE NULL DEFAULT NULL,
  `LaborForce` TEXT NULL DEFAULT NULL,
  `Employed` INT NULL DEFAULT NULL,
  `Unemployed` INT NULL DEFAULT NULL,
  `UnemploymentRatePercentage` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`UnemploymentPK`),
  CONSTRAINT `fk_unemployment`
    FOREIGN KEY (`FipsCode`)
    REFERENCES `JHCountyStat` (`FipsCode`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `sp500_STAGE` ;
DROP TABLE IF EXISTS `sp500` ;

CREATE TABLE IF NOT EXISTS `sp500_STAGE` (
  `Date` DATE NOT NULL,
  `marketValue` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Date`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sp500` (
  `Date` DATE NOT NULL,
  `marketValue` NUMERIC(6,2) NOT NULL,
  PRIMARY KEY (`Date`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `TRUMP_APPROVAL_ST`;
CREATE TABLE IF NOT EXISTS `TRUMP_APPROVAL_ST` (
`President` Varchar(45),
`Subgroup` Varchar(45),
`ModelDate` text,
`StartDate` text,
`EndDate` text,
`Pollster` text,
`Grade` Varchar(45),
`SampleSize` int,
`Population` Varchar(45),
`Weight` Double,
`Influence` Double,
`Approve` float,
`Disapprove` float,
`AdjustedApprove` float,
`AdjustedDisapprove` float,
`Multiversions` text,
`Tracking` text,
`URL` text,
`PollId` text,
`QuestionID` text,
`CreateDate` text,
`TimeStamp` text)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `TRUMP_APPROVAL`;
CREATE TABLE IF NOT EXISTS `TRUMP_APPROVAL` (
`Trump_Approval_PK` int auto_increment,
`President` Varchar(45),
`StartDate` Date,
`EndDate` Date,
`Pollster` text,
`Grade` Varchar(45),
`SampleSize` int,
`Weight` Double,
`Influence` Double,
`Approve` float,
`Disapprove` float,
`AdjustedApprove` float,
`AdjustedDisapprove` float,
`URL` text,
`PollId` text,
`QuestionID` text,
`CreateDate` date,
`TimeStamp` datetime,
PRIMARY KEY(`Trump_Approval_PK`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
