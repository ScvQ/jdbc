package cn.spiderpig.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.spiderpig.jdbc.Test;
import cn.spiderpig.jdbc.domain.DBConfig;

public class DBConfigUtil {

	public static DBConfig getConfig() {
		
		InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("读取jdbc配置文件失败");
		}
		DBConfig config = new DBConfig();
		config.setDriver(properties.getProperty("driver"));
		config.setUrl(properties.getProperty("url"));
		config.setUsername(properties.getProperty("username"));
		config.setPassword(properties.getProperty("password"));
		return config;
		
	}

}
