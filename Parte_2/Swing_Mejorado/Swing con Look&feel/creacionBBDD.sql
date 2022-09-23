-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bdgestionfct
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdgestionfct
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdgestionfct` DEFAULT CHARACTER SET utf8 ;
USE `bdgestionfct` ;

-- -----------------------------------------------------
-- Table `bdgestionfct`.`Alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgestionfct`.`Alumnos` (
  `Cod_Alumno` INT AUTO_INCREMENT NOT NULL,
  `DNI` VARCHAR(9) NULL,
  `Nombre` VARCHAR(25) NULL,
  `Apellidos` VARCHAR(50) NULL,
  `Fecha_Nac` DATE NULL,
  PRIMARY KEY (`Cod_Alumno`),
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdgestionfct`.`Tutores P`
-- ----------------------------------alumnos-------------------
CREATE TABLE IF NOT EXISTS `bdgestionfct`.`Tutores_P` (
  `Cod_Tutor` INT AUTO_INCREMENT NOT NULL,
  `DNI` VARCHAR(9) NULL,
  `Nombre` VARCHAR(45) NULL,
  `Apellidos` VARCHAR(50) NULL,
  `Mail` VARCHAR(45) NULL,
  `Tlfn` VARCHAR(15) NULL,
  PRIMARY KEY (`Cod_Tutor`),
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdgestionfct`.`Empresas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgestionfct`.`Empresas` (
  `Cod_Empresas` INT AUTO_INCREMENT NOT NULL,
  `CIF` VARCHAR(15) NULL,
  `Nombre` VARCHAR(45) NULL,
  `Direccion` VARCHAR(45) NULL,
  `CP` VARCHAR(5) NULL,
  `Localidad` VARCHAR(45) NULL,
  `Jornada` ENUM('Continua', 'Partida') NULL,
  `Modalidad` ENUM('Presencial', 'Semipresencial', 'Distancia') NULL,
  `Mail` VARCHAR(45) NULL,
  `DNI_RL` VARCHAR(15) NULL,
  `Nombre_RL` VARCHAR(45) NULL,
  `Apellidos_RL` VARCHAR(45) NULL,
  `DNI_TL` VARCHAR(15) NULL,
  `Nombre_TL` VARCHAR(45) NULL,
  `Apellidos_TL` VARCHAR(45) NULL,
  `Tlfn_TL` VARCHAR(15) NULL,
  PRIMARY KEY (`Cod_Empresas`),
  UNIQUE INDEX `CIF_UNIQUE` (`CIF` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdgestionfct`.`Asignación`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgestionfct`.`Asignacion` (
  `Cod_Alumno` INT NOT NULL,
  `Cod_Tutor` INT NOT NULL,
  `Cod_Empresas` INT NOT NULL,
  `Fecha_Asignacion` TIMESTAMP,
  PRIMARY KEY (`Cod_Alumno`, `Cod_Tutor`, `Cod_Empresas`),
  INDEX `fk_Asignación_Tutores P1_idx` (`Cod_Tutor` ASC) VISIBLE,
  INDEX `fk_Asignación_Empresas1_idx` (`Cod_Empresas` ASC) VISIBLE,
  CONSTRAINT `fk_Asignación_Alumnos`
    FOREIGN KEY (`Cod_Alumno`)
    REFERENCES `bdgestionfct`.`Alumnos` (`Cod_Alumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asignación_Tutores P1`
    FOREIGN KEY (`Cod_Tutor`)
    REFERENCES `bdgestionfct`.`Tutores P` (`Cod_Tutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asignación_Empresas1`
    FOREIGN KEY (`Cod_Empresas`)
    REFERENCES `bdgestionfct`.`Empresas` (`Cod_Empresas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
