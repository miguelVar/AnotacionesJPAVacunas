-- -----------------------------------------------------
-- Schema enfermedadesbd
-- -----------------------------------------------------
DROP DATABASE IF EXISTS enfermedadesbd;
CREATE DATABASE IF NOT EXISTS enfermedadesbd;
USE enfermedadesbd;

-- -----------------------------------------------------
-- Table vacuna
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS vacuna (
  ID INT(11) NOT NULL,
  NOMBRE VARCHAR(45) NOT NULL,
  DESCRIPTION BLOB NULL DEFAULT NULL,
  PRIMARY KEY (ID))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table dosis
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS dosis (
  ID INT(11) NOT NULL,
  ID_VACUNA INT(11) NOT NULL,
  VALOR_TIEMPO INT(11) NOT NULL,
  UNIDAD_TIEMPO VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_DOSIS_ID_VACUNA_VACUNA
    FOREIGN KEY (ID_VACUNA)
    REFERENCES vacuna (ID))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table persona
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS persona (
  ID INT(11) NOT NULL,
  DOCUMENTO VARCHAR(45) NOT NULL,
  TIPO_DOCUMENTO VARCHAR(1) NOT NULL,
  NOMBRES VARCHAR(60) NOT NULL,
  APELLIDOS VARCHAR(60) NULL DEFAULT NULL,
  FECHA_NACIMIENTO DATE NOT NULL,
  PRIMARY KEY (ID))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table historial
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS historial (
  ID_PERSONA INT(11) NOT NULL,
  FECHA_CREACION DATE NOT NULL,
  PRIMARY KEY (ID_PERSONA),
  CONSTRAINT FK_PERSONA_ID_PERSONA_HISTORIAL
    FOREIGN KEY (ID_PERSONA)
    REFERENCES persona (ID))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table dosis_aplicada
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS dosis_aplicada (
  ID_DOSIS_APLICADA INT(11) NOT NULL,
  ID_HISTORIAL INT(11) NOT NULL,
  ID_DOSIS INT(11) NOT NULL,
  FECHA_APLICACION DATE NOT NULL,
  PRIMARY KEY (ID_DOSIS_APLICADA),
  CONSTRAINT FK_ID_DOSIS_DOSIS
    FOREIGN KEY (ID_DOSIS)
    REFERENCES dosis (ID),
  CONSTRAINT FK_ID_HISTORIAL_HISTORIAL
    FOREIGN KEY (ID_HISTORIAL)
    REFERENCES historial (ID_PERSONA))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table enfermedad
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS enfermedad (
  ID_ENFERMEDAD INT(11) NOT NULL,
  DESCRIPTION BLOB NULL DEFAULT NULL,
  NOMBRE VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (ID_ENFERMEDAD))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table enfermedad_vacuna
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS enfermedad_vacuna (
  ID_VACUNA INT(11) NOT NULL,
  ID_ENFERMEDAD INT(11) NOT NULL,
  PRIMARY KEY (ID_VACUNA, ID_ENFERMEDAD),
  CONSTRAINT FK_ID_ENFERMEDAD_ENFERMEDAD
    FOREIGN KEY (ID_ENFERMEDAD)
    REFERENCES enfermedad (ID_ENFERMEDAD),
  CONSTRAINT FK_ID_VACUNA_VACUNA
    FOREIGN KEY (ID_VACUNA)
    REFERENCES vacuna (ID))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table familiar
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS familiar (
  ID_FAMILIAR INT(11) NOT NULL,
  ID_PADRE INT(11) NOT NULL,
  ID_HIJO INT(11) NOT NULL,
  PRIMARY KEY (ID_FAMILIAR),
  CONSTRAINT FK_ID_HIJO_FAMILIAR
    FOREIGN KEY (ID_HIJO)
    REFERENCES persona (ID),
  CONSTRAINT FK_ID_PADRE_FAMILIAR
    FOREIGN KEY (ID_PADRE)
    REFERENCES persona (ID))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;