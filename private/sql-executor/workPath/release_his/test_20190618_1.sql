drop table if exists test_run_sql;
CREATE TABLE `test_run_sql` (
	`t1` INT(11) NOT NULL AUTO_INCREMENT,
	`t2` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`t1`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
