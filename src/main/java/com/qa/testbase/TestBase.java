package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public static int RESPONSE_STATUS_CODE_200=200;
	
	public static int RESPONSE_STATUS_CODE_201=201;
	
	public static int RESPONSE_STATUS_CODE_401=401;
	
	public Properties pro;

	public TestBase() {

		try {
			pro = new Properties();
			FileInputStream fin = new FileInputStream(
					System.getProperty("user.dir")
							+ "\\src\\main\\java\\com\\qa\\configuration\\configuration.properties");
			pro.load(fin);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
