-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema peerhelping
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema peerhelping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `peerhelping` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `peerhelping` ;

-- -----------------------------------------------------
-- Table `peerhelping`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peerhelping`.`users` (
  `sid` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`sid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `peerhelping`.`calendar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peerhelping`.`calendar` (
  `sid` INT NOT NULL,
  `avaliableTimeStarts` VARCHAR(45) NOT NULL,
  `avaliableTimeDuration` VARCHAR(45) NOT NULL,
  INDEX `fk_calendar_users1_idx` (`sid` ASC) VISIBLE,
  CONSTRAINT `fk_calendar_users`
    FOREIGN KEY (`sid`)
    REFERENCES `peerhelping`.`users` (`sid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `peerhelping`.`courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peerhelping`.`courses` (
  `courseId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `courseCode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`courseId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `peerhelping`.`interestedIn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peerhelping`.`interestedIn` (
  `sid` INT NOT NULL,
  `courseId` INT NOT NULL,
  `teach` VARCHAR(45) NOT NULL,
  INDEX `fk_interestedIn_users1_idx` (`sid` ASC) VISIBLE,
  INDEX `fk_interestedIn_courses1_idx` (`courseId` ASC) VISIBLE,
  CONSTRAINT `fk_interestedIn_courses`
    FOREIGN KEY (`courseId`)
    REFERENCES `peerhelping`.`courses` (`courseId`),
  CONSTRAINT `fk_interestedIn_users`
    FOREIGN KEY (`sid`)
    REFERENCES `peerhelping`.`users` (`sid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `peerhelping`.`matchs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `peerhelping`.`matches` (
  `matchID` INT NOT NULL,
  `studentSid` INT NOT NULL,
  `tutorSid` INT NOT NULL,
  `courseId` INT NOT NULL,
  `matchTime` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matchID`),
  INDEX `fk_matchs_users_idx` (`studentSid` ASC) VISIBLE,
  INDEX `fk_matchs_users1_idx` (`tutorSid` ASC) VISIBLE,
  INDEX `fk_matchs_courses1_idx` (`courseId` ASC) VISIBLE,
  CONSTRAINT `fk_matchs_courses`
    FOREIGN KEY (`courseId`)
    REFERENCES `peerhelping`.`courses` (`courseId`),
  CONSTRAINT `fk_matchs_students`
    FOREIGN KEY (`studentSid`)
    REFERENCES `peerhelping`.`users` (`sid`),
  CONSTRAINT `fk_matchs_tutors`
    FOREIGN KEY (`tutorSid`)
    REFERENCES `peerhelping`.`users` (`sid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
