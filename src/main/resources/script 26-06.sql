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
-- Table `maestrinodb`.`estilo_musical`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`estilo_musical` (
  `idestilo_musical` INT NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idestilo_musical`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`master` (
  `idmaster` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(150) NULL DEFAULT NULL,
  `email` VARCHAR(200) NULL DEFAULT NULL,
  `senha` VARCHAR(45) NULL DEFAULT NULL,
  `foto_perfil` MEDIUMBLOB NULL DEFAULT NULL,
  `link_fb` VARCHAR(200) NULL DEFAULT NULL,
  `link_ig` VARCHAR(200) NULL DEFAULT NULL,
  `descricao` VARCHAR(800) NULL DEFAULT NULL,
  `tipo_usuario` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idmaster`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 47
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`estudio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`estudio` (
  `idestudio` INT NOT NULL AUTO_INCREMENT,
  `localizacao` VARCHAR(200) NULL DEFAULT NULL,
  `idmaster` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idestudio`),
  INDEX `fk_estudio_master1_idx` (`idmaster` ASC) VISIBLE,
  CONSTRAINT `fk_estudio_master1`
    FOREIGN KEY (`idmaster`)
    REFERENCES `maestrinodb`.`master` (`idmaster`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`instrumento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`instrumento` (
  `idinstrumento` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idinstrumento`))
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`luthier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`luthier` (
  `idluthier` INT NOT NULL AUTO_INCREMENT,
  `localizacao` VARCHAR(100) NULL DEFAULT NULL,
  `idmaster` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idluthier`),
  INDEX `fk_luthier_master1_idx` (`idmaster` ASC) VISIBLE,
  CONSTRAINT `fk_luthier_master1`
    FOREIGN KEY (`idmaster`)
    REFERENCES `maestrinodb`.`master` (`idmaster`))
ENGINE = InnoDB
AUTO_INCREMENT = 47
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`luthier_instrumento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`luthier_instrumento` (
  `idluthier` INT NOT NULL,
  `idinstrumento` INT NOT NULL,
  `instrumentos_order` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idluthier`, `idinstrumento`),
  INDEX `idinstrumento` (`idinstrumento` ASC) VISIBLE,
  CONSTRAINT `idinstrumento`
    FOREIGN KEY (`idinstrumento`)
    REFERENCES `maestrinodb`.`instrumento` (`idinstrumento`),
  CONSTRAINT `idluthier`
    FOREIGN KEY (`idluthier`)
    REFERENCES `maestrinodb`.`luthier` (`idluthier`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`musico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`musico` (
  `idmusico` INT NOT NULL AUTO_INCREMENT,
  `idmaster` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idmusico`),
  INDEX `fk_musico_master_idx` (`idmaster` ASC) VISIBLE,
  CONSTRAINT `fk_musico_master`
    FOREIGN KEY (`idmaster`)
    REFERENCES `maestrinodb`.`master` (`idmaster`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`musico_estilo_musical`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`musico_estilo_musical` (
  `idmusico` INT NOT NULL,
  `idestilo_musical` INT NOT NULL,
  PRIMARY KEY (`idmusico`, `idestilo_musical`),
  INDEX `idestilo_musical_idx` (`idestilo_musical` ASC) VISIBLE,
  CONSTRAINT `idmusico`
    FOREIGN KEY (`idmusico`)
    REFERENCES `maestrinodb`.`musico` (`idmusico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idestilo_musical`
    FOREIGN KEY (`idestilo_musical`)
    REFERENCES `maestrinodb`.`estilo_musical` (`idestilo_musical`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `maestrinodb`.`musico_instrumento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `maestrinodb`.`musico_instrumento` (
  `idmusico` INT NOT NULL,
  `idinstrumento` INT NOT NULL,
  PRIMARY KEY (`idmusico`, `idinstrumento`),
  INDEX `idinstrumento_idx` (`idinstrumento` ASC) VISIBLE,
  CONSTRAINT `idmusico`
    FOREIGN KEY (`idmusico`)
    REFERENCES `maestrinodb`.`musico` (`idmusico`),
  CONSTRAINT `instrumentoid`
    FOREIGN KEY (`idinstrumento`)
    REFERENCES `maestrinodb`.`instrumento` (`idinstrumento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
