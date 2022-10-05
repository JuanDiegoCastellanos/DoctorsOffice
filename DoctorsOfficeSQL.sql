-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `edad` INT(10) NOT NULL,
  `genero` VARCHAR(1) NOT NULL,
  `documento` VARCHAR(20) NOT NULL,
  `tipo_documento` VARCHAR(40) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `Medico_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Usuario_Medico1_idx` (`Medico_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Medico1`
    FOREIGN KEY (`Medico_id`)
    REFERENCES `mydb`.`Medico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Paciente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `edad` INT(10) NOT NULL,
  `genero` SMALLINT(1) NOT NULL,
  `documento` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(20) NULL,
  `eps` VARCHAR(20) NOT NULL,
  `tipo_documento` VARCHAR(40) NOT NULL,
  `Usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Paciente_Usuario1_idx` (`Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Paciente_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `mydb`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `mydb`.`Cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cita` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` VARCHAR(45) NOT NULL,
  `Paciente_id` INT NOT NULL,
  `Medico_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cita_Paciente1_idx` (`Paciente_id` ASC) VISIBLE,
  INDEX `fk_Cita_Medico1_idx` (`Medico_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cita_Paciente1`
    FOREIGN KEY (`Paciente_id`)
    REFERENCES `mydb`.`Paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_Medico1`
    FOREIGN KEY (`Medico_id`)
    REFERENCES `mydb`.`Medico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FormulaMedica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`FormulaMedica` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `cantidad_medicamento` INT NOT NULL,
  `Paciente_id` INT NOT NULL,
  `Medico_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_FormulaMedica_Paciente_idx` (`Paciente_id` ASC) VISIBLE,
  INDEX `fk_FormulaMedica_Medico1_idx` (`Medico_id` ASC) VISIBLE,
  CONSTRAINT `fk_FormulaMedica_Paciente`
    FOREIGN KEY (`Paciente_id`)
    REFERENCES `mydb`.`Paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FormulaMedica_Medico1`
    FOREIGN KEY (`Medico_id`)
    REFERENCES `mydb`.`Medico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Agenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Agenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `semana` DATETIME NOT NULL,
  `dia` DATETIME NULL,
  `hora` TIMESTAMP NULL,
  `Medico_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Agenda_Medico1_idx` (`Medico_id` ASC) VISIBLE,
  CONSTRAINT `fk_Agenda_Medico1`
    FOREIGN KEY (`Medico_id`)
    REFERENCES `mydb`.`Medico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medicamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `laboratorio` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MedicamentoFormula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MedicamentoFormula` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `FormulaMedica_id` INT NOT NULL,
  `Medicamento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_MedicamentoFormula_FormulaMedica1_idx` (`FormulaMedica_id` ASC) VISIBLE,
  INDEX `fk_MedicamentoFormula_Medicamento1_idx` (`Medicamento_id` ASC) VISIBLE,
  CONSTRAINT `fk_MedicamentoFormula_FormulaMedica1`
    FOREIGN KEY (`FormulaMedica_id`)
    REFERENCES `mydb`.`FormulaMedica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MedicamentoFormula_Medicamento1`
    FOREIGN KEY (`Medicamento_id`)
    REFERENCES `mydb`.`Medicamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `Usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Rol_Usuario1_idx` (`Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Rol_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `mydb`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

