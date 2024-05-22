-- Active: 1715877999224@@mysql-2fcbc876-towerdefense.k.aivencloud.com@10284@mydb
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
-- Table `mydb`.`table1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`table1` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`jogador` (
  `idJogador` INT NOT NULL AUTO_INCREMENT,
  `usuário` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `admin` TINYINT NOT NULL,
  PRIMARY KEY (`idJogador`))
ENGINE = InnoDB;

ALTER TABLE jogador RENAME COLUMN usuário TO usuario;
ALTER TABLE jogador MODIFY usuario VARCHAR(45) NULL;
ALTER TABLE jogador ADD UNIQUE (email);

SELECT * FROM jogador;

DESC jogador;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;