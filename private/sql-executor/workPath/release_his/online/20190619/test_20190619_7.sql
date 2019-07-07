delimiter 
create procedure pro()
begin
declare i int;
declare j int;  #定义i变量
set i=1;
set j=1;
CREATE TABLE `test_run_sql_bak` (
	`t1` INT(11) NOT NULL AUTO_INCREMENT,
	`t2` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`t1`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
while(i<=1) do  #对手机号码的循环
insert test_run_sql(t1,t2) values(3,'aaa'),(4,'aaa');
set i=i+1;
end while;
 update test_run_sql set t2='ccc' where t1=111
end 
DELIMITER ;
$  #存储过程结束
