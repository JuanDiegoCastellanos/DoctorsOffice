USE `DoctorsOffice` ;
CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`DOCTORS` (
  `doctor_id` INT NOT NULL AUTO_INCREMENT,
  `doctor_name` VARCHAR(50) NOT NULL,
  `doctor_lastname` VARCHAR(50) NOT NULL,
  `doctor_age` INT(10) NOT NULL,
  `doctor_gender` VARCHAR(1) NOT NULL,
  `doctor_document` VARCHAR(30) NOT NULL,
  `doctor_documentType` VARCHAR(30) NOT NULL,
  `doctor_phoneNumber` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`doctor_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`SCHEDULES` (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `schedule_week` DATETIME NOT NULL,
  `schedule_day` DATETIME NULL,
  `schedule_hour` TIMESTAMP NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`schedule_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`PATIENTS` (
  `patient_id` INT NOT NULL AUTO_INCREMENT,
  `patient_name` VARCHAR(50) NOT NULL,
  `patient_lastname` VARCHAR(50) NOT NULL,
  `patient_age` INT(10) NOT NULL,
  `patient_gender` SMALLINT(1) NOT NULL,
  `patient_document` VARCHAR(30) NOT NULL,
  `patient_documentType` VARCHAR(30) NOT NULL,
  `patient_phoneNumber` VARCHAR(20) NULL,
  `patient_eps` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`patient_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`APPOINTMENTS` (
  `appointments_id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `hour` TIMESTAMP NOT NULL,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`appointments_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`MEDICALPRESCRIPTIONS` (
  `medicalprescription_id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `amount_medicines` INT NOT NULL,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`medicalprescription_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`MEDICINES` (
  `medicine_id` INT NOT NULL AUTO_INCREMENT,
  `medicine_name` VARCHAR(45) NULL,
  `laboratory` VARCHAR(45) NULL,
  PRIMARY KEY (`medicine_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `DoctorsOffice`.`MEDICINESPRESCRIPTIONS` (
  `medicineprescription_id` INT NOT NULL AUTO_INCREMENT,
  `medicalprescription_id` INT NOT NULL,
  `medicine_id` INT NOT NULL,
  PRIMARY KEY (`medicineprescription_id`))
ENGINE = InnoDB;

# RELATIONS ---- APPOINTMENTS ---DOCTORS ---PATIENTS
ALTER TABLE `DoctorsOffice`.`APPOINTMENTS` 
ADD INDEX `fk_appointment_doctor_idx` (`doctor_id` ASC) VISIBLE,
ADD INDEX `fk_appointment_patient_idx` (`patient_id` ASC) VISIBLE;
;
ALTER TABLE `DoctorsOffice`.`APPOINTMENTS` 
ADD CONSTRAINT `fk_appointment_doctor`
  FOREIGN KEY (`doctor_id`)
  REFERENCES `DoctorsOffice`.`DOCTORS` (`doctor_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_appointment_patient`
  FOREIGN KEY (`patient_id`)
  REFERENCES `DoctorsOffice`.`PATIENTS` (`patient_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;

# RELATIONS ---- MEDICALPRESCRIPTIONS --- DOCTORS --- PATIENTS
ALTER TABLE `DoctorsOffice`.`MEDICALPRESCRIPTIONS` 
ADD INDEX `fk_medicalprescriptions_doctor_idx` (`doctor_id` ASC) VISIBLE,
ADD INDEX `fk_medicalprescriptions_patient_idx` (`patient_id` ASC) VISIBLE;
;
ALTER TABLE `DoctorsOffice`.`MEDICALPRESCRIPTIONS` 
ADD CONSTRAINT `fk_medicalprescriptions_doctor`
  FOREIGN KEY (`doctor_id`)
  REFERENCES `DoctorsOffice`.`DOCTORS` (`doctor_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_medicalprescriptions_patient`
  FOREIGN KEY (`patient_id`)
  REFERENCES `DoctorsOffice`.`PATIENTS` (`patient_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;
  
#RELATIONS --- MEDICINESPRESCRIPTIONS --- MEDICALPRESCRIPTIONS --- MEDICINE
ALTER TABLE `DoctorsOffice`.`MEDICINESPRESCRIPTIONS` 
ADD INDEX `fk_MEDICINESPRESCRIPTIONS_1_idx` (`medicalprescription_id` ASC) VISIBLE,
ADD INDEX `fk_medicineprescription_medicine_idx` (`medicine_id` ASC) VISIBLE;
;
ALTER TABLE `DoctorsOffice`.`MEDICINESPRESCRIPTIONS` 
ADD CONSTRAINT `fk_medicineprescription_medicalprescription`
  FOREIGN KEY (`medicalprescription_id`)
  REFERENCES `DoctorsOffice`.`MEDICALPRESCRIPTIONS` (`medicalprescription_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_medicineprescription_medicine`
  FOREIGN KEY (`medicine_id`)
  REFERENCES `DoctorsOffice`.`MEDICINES` (`medicine_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;
  
#RELATIONS  SCHEDULES --- DOCTORS
ALTER TABLE `DoctorsOffice`.`SCHEDULES` 
ADD INDEX `fk_schedule_doctor_idx` (`doctor_id` ASC) VISIBLE;
;
ALTER TABLE `DoctorsOffice`.`SCHEDULES` 
ADD CONSTRAINT `fk_schedule_doctor`
  FOREIGN KEY (`doctor_id`)
  REFERENCES `DoctorsOffice`.`DOCTORS` (`doctor_id`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;

#RELATIONS

