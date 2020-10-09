CREATE DATABASE IF NOT EXISTS transmilenio;
USE transmilenio;

-- -----------------------------------------------------
-- Table dias
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS dias (
  id_dia INT(11) NOT NULL,
  combinacion_dias VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_dia))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table troncales
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS troncales (
  id_troncal INT(11) NOT NULL,
  nombre_troncal VARCHAR(30) NOT NULL,
  letra_troncal VARCHAR(1) NOT NULL,
  PRIMARY KEY (id_troncal))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table zonas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS zonas (
  id_zona INT(11) NOT NULL,
  letra_zona VARCHAR(1) NOT NULL,
  color_zona VARCHAR(10) NOT NULL,
  troncales_id_troncal INT(11) NOT NULL,
  PRIMARY KEY (id_zona),
  CONSTRAINT fk_zonas_troncales1
    FOREIGN KEY (troncales_id_troncal)
    REFERENCES troncales (id_troncal)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table estaciones
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estaciones (
  id_estacion INT(11) NOT NULL,
  nombre_estacion VARCHAR(30) NOT NULL,
  portal TINYINT(1) NULL DEFAULT NULL,
  zonas_id_zona INT(11) NOT NULL,
  PRIMARY KEY (id_estacion),
  CONSTRAINT fk_estaciones_zonas1
    FOREIGN KEY (zonas_id_zona)
    REFERENCES zonas (id_zona)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table tipo_servicio
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipo_servicio (
  id_tipo_servicio INT(11) NOT NULL,
  nombre_tipo_servicio VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_tipo_servicio))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table servicios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS servicios (
  id_servicio INT(11) NOT NULL,
  nombre_servicio VARCHAR(10) NOT NULL,
  color_servicio VARCHAR(10) NOT NULL,
  descripcion_servicio VARCHAR(50) NULL DEFAULT NULL,
  tiempo_opera ENUM('PARCIAL', 'COMPLETO') NOT NULL,
  tipo_servicio_id_tipo_servicio INT(11) NOT NULL,
  PRIMARY KEY (id_servicio),
  CONSTRAINT fk_servicios_tipo_servicio1
    FOREIGN KEY (tipo_servicio_id_tipo_servicio)
    REFERENCES tipo_servicio (id_tipo_servicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table usuarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuarios (
  id_usuario INT(11) NOT NULL,
  nombre_usuario VARCHAR(45) NOT NULL,
  apellido_usuario VARCHAR(45) NOT NULL,
  numero_celular VARCHAR(45) NOT NULL,
  email VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (id_usuario))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table rutas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas (
  servicios_id_servicio INT(11) NOT NULL,
  estaciones_id_estacion INT(11) NOT NULL,
  origen TINYINT NOT NULL,
  destino TINYINT NOT NULL,
  PRIMARY KEY (servicios_id_servicio, estaciones_id_estacion),
  CONSTRAINT fk_servicios_has_estaciones_servicios1
    FOREIGN KEY (servicios_id_servicio)
    REFERENCES servicios (id_servicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_servicios_has_estaciones_estaciones1
    FOREIGN KEY (estaciones_id_estacion)
    REFERENCES estaciones (id_estacion)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table recorridos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS recorridos (
  usuarios_id_usuario INT(11) NOT NULL,
  fecha_servicio DATE NOT NULL,
  hora TIME NOT NULL,
  PRIMARY KEY (usuarios_id_usuario),
  CONSTRAINT fk_servicios_has_usuarios_usuarios1
    FOREIGN KEY (usuarios_id_usuario)
    REFERENCES usuarios (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table horario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS horario (
  servicios_id_servicio INT(11) NOT NULL,
  dias_id_dia INT(11) NOT NULL,
  hora_inicio TIME NOT NULL,
  hora_fin TIME NOT NULL,
  PRIMARY KEY (servicios_id_servicio, dias_id_dia),
  CONSTRAINT fk_servicios_has_dias_servicios1
    FOREIGN KEY (servicios_id_servicio)
    REFERENCES servicios (id_servicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_servicios_has_dias_dias1
    FOREIGN KEY (dias_id_dia)
    REFERENCES dias (id_dia)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table recorridos_has_servicios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS recorridos_has_servicios (
  recorridos_usuarios_id_usuario INT(11) NOT NULL,
  servicios_id_servicio INT(11) NOT NULL,
  estacionInicio INT(11) NOT NULL,
  estacioneFin INT(11) NOT NULL,
  orden VARCHAR(45) NOT NULL,
  PRIMARY KEY (recorridos_usuarios_id_usuario, servicios_id_servicio),
  CONSTRAINT fk_recorridos_has_servicios_recorridos1
    FOREIGN KEY (recorridos_usuarios_id_usuario)
    REFERENCES recorridos (usuarios_id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_recorridos_has_servicios_servicios1
    FOREIGN KEY (servicios_id_servicio)
    REFERENCES servicios (id_servicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_recorridos_has_servicios_estaciones1
    FOREIGN KEY (estacionInicio)
    REFERENCES estaciones (id_estacion)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_recorridos_has_servicios_estaciones2
    FOREIGN KEY (estacioneFin)
    REFERENCES estaciones (id_estacion)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;