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
DROP SCHEMA IF EXISTS `maestrinodb`;
-- -----------------------------------------------------
-- Schema maestrinodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `maestrinodb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `maestrinodb` ;

-- -----------------------------------------------------
-- Table `maestrinodb`.`master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`master` (
  `idmaster` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NULL,
  `email` VARCHAR(200) NULL,
  `senha` VARCHAR(45) NULL,
  `foto_perfil` MEDIUMBLOB NULL,
  `link_fb` VARCHAR(200) NULL,
  `link_ig` VARCHAR(200) NULL,
  `descricao` VARCHAR(800) NULL,
  PRIMARY KEY (`idmaster`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `maestrinodb`.`estudio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`estudio` (
  `idestudio` INT NOT NULL AUTO_INCREMENT,
  `localizacao` VARCHAR(200) NULL DEFAULT NULL,
  `idmaster` INT NOT NULL,
  PRIMARY KEY (`idestudio`),
  INDEX `fk_estudio_master1_idx` (`idmaster` ASC) VISIBLE,
  CONSTRAINT `fk_estudio_master1`
    FOREIGN KEY (`idmaster`)
    REFERENCES `maestrinodb`.`master` (`idmaster`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `maestrinodb`.`luthier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`luthier` (
  `idluthier` INT NOT NULL AUTO_INCREMENT,
  `instrumentos` VARCHAR(100) NULL DEFAULT NULL,
  `localizacao` VARCHAR(200) NULL DEFAULT NULL,
  `idmaster` INT NOT NULL,
  PRIMARY KEY (`idluthier`),
  INDEX `fk_luthier_master1_idx` (`idmaster` ASC) VISIBLE,
  CONSTRAINT `fk_luthier_master1`
    FOREIGN KEY (`idmaster`)
    REFERENCES `maestrinodb`.`master` (`idmaster`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `maestrinodb`.`musico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`musico` (
  `idmusico` INT NOT NULL AUTO_INCREMENT,
  `instrumentos` VARCHAR(100) NULL DEFAULT NULL,
  `estilo_musical` VARCHAR(45) NULL DEFAULT NULL,
  `idmaster` INT NOT NULL,
  PRIMARY KEY (`idmusico`),
  INDEX `fk_musico_master_idx` (`idmaster` ASC) VISIBLE,
  CONSTRAINT `fk_musico_master`
    FOREIGN KEY (`idmaster`)
    REFERENCES `maestrinodb`.`master` (`idmaster`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
