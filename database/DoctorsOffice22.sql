USE DoctorsOffice;
CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`doctors` (
  `doctor_id` INT NOT NULL AUTO_INCREMENT,
  `doctor_name` VARCHAR(50) NOT NULL,	
  `doctor_lastname` VARCHAR(50) NOT NULL,
  `doctor_age` INT(10) NOT NULL,
  `doctor_gender` VARCHAR(1) NOT NULL,
  `doctor_document` VARCHAR(30) NOT NULL,
  `doctor_document_type` VARCHAR(30) NOT NULL,
  `doctor_phone_number` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`doctor_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`schedules` (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `schedule_week` DATETIME NOT NULL,
  `schedule_day` DATETIME NULL,
  `schedule_hour` TIMESTAMP NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`schedule_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`patients` (
  `patient_id` INT NOT NULL AUTO_INCREMENT,
  `patient_name` VARCHAR(50) NOT NULL,
  `patient_lastname` VARCHAR(50) NOT NULL,
  `patient_age` INT(10) NOT NULL,
  `patient_gender` SMALLINT(1) NOT NULL,
  `patient_document` VARCHAR(30) NOT NULL,
  `patient_document_type` VARCHAR(30) NOT NULL,
  `patient_phone_number` VARCHAR(20) NULL,
  `patient_eps` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`patient_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`appointments` (
  `appointments_id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `hour` TIMESTAMP NOT NULL,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`appointments_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`medicalprescriptions` (
  `medicalprescription_id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `amount_medicines` INT NOT NULL,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`medicalprescription_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`medicines` (
  `medicine_id` INT NOT NULL AUTO_INCREMENT,
  `medicine_name` VARCHAR(45) NULL,
  `laboratory` VARCHAR(45) NULL,
  PRIMARY KEY (`medicine_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`medicinesprescriptions` (
  `medicineprescription_id` INT NOT NULL AUTO_INCREMENT,
  `medicalprescription_id` INT NOT NULL,
  `medicine_id` INT NOT NULL,
  PRIMARY KEY (`medicineprescription_id`))
ENGINE = InnoDB;

# RELATIONS ---- APPOINTMENTS ---DOCTORS ---PATIENTS

ALTER TABLE `DoctorsOffice`.`appointments` 
ADD INDEX `fk_appointment_doctor_idx` (`doctor_id` ASC) VISIBLE,
ADD INDEX `fk_appointment_patient_idx` (`patient_id` ASC) VISIBLE;

ALTER TABLE `DoctorsOffice`.`appointments` 
ADD CONSTRAINT `fk_appointment_doctor`
  FOREIGN KEY (`doctor_id`)
  REFERENCES `DoctorsOffice`.`doctors` (`doctor_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_appointment_patient`
  FOREIGN KEY (`patient_id`)
  REFERENCES `DoctorsOffice`.`patients` (`patient_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;

# RELATIONS ---- MEDICALPRESCRIPTIONS --- DOCTORS --- PATIENTS

ALTER TABLE `DoctorsOffice`.`medicalprescriptions` 
ADD INDEX `fk_medicalprescriptions_doctor_idx` (`doctor_id` ASC) VISIBLE,
ADD INDEX `fk_medicalprepatient_agexscriptions_patient_idx` (`patient_id` ASC) VISIBLE;

ALTER TABLE `DoctorsOffice`.`medicalprescriptions` 
ADD CONSTRAINT `fk_medicalprescriptions_doctor`
  FOREIGN KEY (`doctor_id`)
  REFERENCES `DoctorsOffice`.`doctors` (`doctor_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_medicalprescriptions_patient`
  FOREIGN KEY (`patient_id`)
  REFERENCES `DoctorsOffice`.`patients` (`patient_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;
  

ALTER TABLE `DoctorsOffice`.`medicinesprescriptions` 
ADD INDEX `fk_medicinesprescriptions_1_idx` (`medicalprescription_id` ASC) VISIBLE,
ADD INDEX `fk_medicineprescription_medicine_idx` (`medicine_id` ASC) VISIBLE;
;

ALTER TABLE `DoctorsOffice`.`medicinesprescriptions` 
ADD CONSTRAINT `fk_medicineprescription_medicalprescription`
  FOREIGN KEY (`medicalprescription_id`)
  REFERENCES `DoctorsOffice`.`medicalprescriptions` (`medicalprescription_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_medicineprescription_medicine`
  FOREIGN KEY (`medicine_id`)
  REFERENCES `DoctorsOffice`.`medicines` (`medicine_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;
  
ALTER TABLE `DoctorsOffice`.`schedules` 
ADD INDEX `fk_schedule_doctor_idx` (`doctor_id` ASC) VISIBLE;

ALTER TABLE `DoctorsOffice`.`schedules` 
ADD CONSTRAINT `fk_schedule_doctor`
  FOREIGN KEY (`doctor_id`)
  REFERENCES `DoctorsOffice`.`doctors` (`doctor_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;

