-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema maestrinodb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema maestrinodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `maestrinodb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `maestrinodb` ;

-- -----------------------------------------------------
-- Table `maestrinodb`.`estudio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`estudio` (
  `idestudio` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `instrumentos` VARCHAR(100) NULL,
  `localizacao` VARCHAR(45) NULL,
  `foto_perfil` VARCHAR(45) NULL,
  `link_fb` VARCHAR(45) NULL,
  `link_ig` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idestudio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maestrinodb`.`luthier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`luthier` (
  `idluthier` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `instrumentos` VARCHAR(100) NULL,
  `localizacao` VARCHAR(45) NULL,
  `foto_perfil` VARCHAR(45) NULL,
  `link_fb` VARCHAR(45) NULL,
  `link_ig` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idluthier`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maestrinodb`.`musico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`musico` (
  `idmusico` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `instrumentos` VARCHAR(100) NULL,
  `localizacao` VARCHAR(45) NULL,
  `foto_perfil` VARCHAR(45) NULL,
  `link_fb` VARCHAR(45) NULL,
  `link_ig` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idmusico`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
