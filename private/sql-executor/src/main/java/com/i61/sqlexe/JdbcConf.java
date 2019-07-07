package com.i61.sqlexe;

import org.apache.commons.lang3.StringUtils;

class JdbcConf {
	String jdbcUrl;
	String userName;
	String password;
	public JdbcConf(String jdbcUrl, String userName, String password) {
		if(StringUtils.isAnyBlank(jdbcUrl,userName,password)){
			throw new RuntimeException("数据库配置有误");
		}
		this.jdbcUrl = jdbcUrl;
		this.userName = userName;
		this.password = password;
	}
	
}
