package com.i61.sqlexe;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class SqlExecutorHelper {

	//	static String dbPropertiesFile = "E:\\project\\sql-executor\\src\\main\\resources\\db.properties";
	static String dbPropertiesFile = ".." + File.separator + ".." + File.separator + ".." + File.separator + "db.properties";
	private static final String FILE_DBNAME_SPLITER = "_";
	public static String parseDbNameByFile(File sqlFile) throws Exception {
		return StringUtils.split(sqlFile.getName(), FILE_DBNAME_SPLITER)[0];
	}
	public static Map<String, JdbcConf> parseDbConf() {
		Map<String, JdbcConf> jdbcConf=new HashMap<>();
		try {
			Properties p = new Properties();
			p.load(new FileReader(dbPropertiesFile));

			for (Entry<Object, Object> e : p.entrySet()) {
				String key = e.getKey().toString().trim();
				if (key.startsWith("db.jdbc.url")) {
					String dbName = key.substring(key.lastIndexOf('.') + 1);
					jdbcConf.put(dbName, new JdbcConf(p.getProperty("db.jdbc.url." + dbName)
							, p.getProperty("db.jdbc.username." + dbName)
							, p.getProperty("db.jdbc.password." + dbName)));
				}
			}

		} catch (IOException e) {
			System.out.println("dbProperties 不存在");
		}
		return jdbcConf;
	}
}
