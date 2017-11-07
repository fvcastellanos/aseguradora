-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema aseguradora
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema aseguradora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aseguradora` DEFAULT CHARACTER SET utf8 ;
USE `aseguradora` ;

-- -----------------------------------------------------
-- Table `aseguradora`.`poliza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aseguradora`.`poliza` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `no_poliza` VARCHAR(150) NOT NULL,
  `tipo` CHAR(1) NOT NULL DEFAULT 'M',
  `fecha_emision` DATE NOT NULL,
  `fecha_vencimiento` DATE NOT NULL,
  `activa` SMALLINT(1) NOT NULL DEFAULT '1',
  `monto` DOUBLE NOT NULL,
  `no_pagos` SMALLINT(2) NOT NULL DEFAULT '1',
  `nombres` VARCHAR(150) NOT NULL,
  `apellidos` VARCHAR(150) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `telefono` VARCHAR(30) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `no_poliza_UNIQUE` (`no_poliza` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aseguradora`.`boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aseguradora`.`boleta` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `poliza_id` INT(10) UNSIGNED NOT NULL,
  `codigo` VARCHAR(50) NOT NULL,
  `anio` INT(11) NOT NULL,
  `mes` INT(11) NOT NULL,
  `fecha_pago` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_boleta_poliza1_idx` (`poliza_id` ASC),
  CONSTRAINT `fk_boleta_poliza1`
    FOREIGN KEY (`poliza_id`)
    REFERENCES `aseguradora`.`poliza` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aseguradora`.`consulta_cobertura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aseguradora`.`consulta_cobertura` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `autorizacion` VARCHAR(150) NOT NULL,
  `poliza` VARCHAR(150) NOT NULL,
  `nit_proveedor` VARCHAR(20) NOT NULL,
  `fecha_consulta` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aseguradora`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aseguradora`.`proveedor` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `nit` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nit_UNIQUE` (`nit` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
