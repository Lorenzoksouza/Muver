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
CREATE SCHEMA IF NOT EXISTS `maestrinodb` DEFAULT CHARACTER SET utf8mb4 ;
USE `maestrinodb` ;

-- -----------------------------------------------------
-- Table `maestrinodb`.`master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`master` (
  `idmaster` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NULL DEFAULT NULL,
  `email` VARCHAR(200) NULL DEFAULT NULL,
  `senha` VARCHAR(200) NULL DEFAULT NULL,
  `foto_perfil` MEDIUMBLOB NULL DEFAULT NULL,
  `link_fb` VARCHAR(200) NULL DEFAULT NULL,
  `link_ig` VARCHAR(200) NULL DEFAULT NULL,
  `descricao` VARCHAR(800) NULL DEFAULT NULL,
  `tipo_usuario` VARCHAR(45) NULL DEFAULT NULL,
  `nota` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`idmaster`),
  UNIQUE INDEX `nome` (`nome` ASC) ,
  UNIQUE INDEX `email` (`email` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 62
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`estudio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`estudio` (
  `idestudio` INT(11) NOT NULL AUTO_INCREMENT,
  `localizacao` VARCHAR(600) NULL DEFAULT NULL,
  `idmaster` INT(11) NULL DEFAULT NULL,
  `disponibilidade` VARCHAR(600) NULL DEFAULT NULL,
  PRIMARY KEY (`idestudio`),
  INDEX `fk_estudio_master1_idx` (`idmaster` ASC) ,
  CONSTRAINT `fk_estudio_master1`
    FOREIGN KEY (`idmaster`)
    REFERENCES `maestrinodb`.`master` (`idmaster`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 61
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`luthier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`luthier` (
  `idluthier` INT(11) NOT NULL AUTO_INCREMENT,
  `localizacao` VARCHAR(600) NULL DEFAULT NULL,
  `idmaster` INT(11) NULL DEFAULT NULL,
  `disponibilidade` VARCHAR(600) NULL DEFAULT NULL,
  `instrumento` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`idluthier`),
  INDEX `fk_luthier_master1_idx` (`idmaster` ASC) ,
  CONSTRAINT `fk_luthier_master1`
    FOREIGN KEY (`idmaster`)
    REFERENCES `maestrinodb`.`master` (`idmaster`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 50
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`musico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`musico` (
  `idmusico` INT(11) NOT NULL AUTO_INCREMENT,
  `estilo_musical` VARCHAR(300) NULL DEFAULT NULL,
  `idmaster` INT(11) NULL DEFAULT NULL,
  `instrumento` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`idmusico`),
  INDEX `fk_musico_master_idx` (`idmaster` ASC) ,
  CONSTRAINT `fk_musico_master`
    FOREIGN KEY (`idmaster`)
    REFERENCES `maestrinodb`.`master` (`idmaster`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 62
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
