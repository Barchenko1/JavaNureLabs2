-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema javaNureLabs2DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema javaNureLabs2DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `javaNureLabs2DB` DEFAULT CHARACTER SET latin1 ;
USE `javaNureLabs2DB` ;

-- -----------------------------------------------------
-- Table `javaNureLabs2DB`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javaNureLabs2DB`.`teacher` (
    `id` BIGINT(100) NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `countOfLessonsPerWeek` INT NOT NULL,
    `studentCount` INT NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `javaNureLabs2DB`.`occupation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `javaNureLabs2DB`.`occupation` (
    `id` BIGINT(15) NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `weekDay` VARCHAR(45) NOT NULL,
    `room` INT NOT NULL,
    `teacher_id` BIGINT(15) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_occupation_teacher_idx` (`teacher_id` ASC),
    CONSTRAINT `fk_occupation_teacher`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `javaNureLabs2DB`.`teacher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
