package com.corrientazo.droneProject.utils;

import java.io.File;

public class Constants {
	public static final String ROUTES_FILE_NAME = "in#.txt";
	public static final String REPORT_FILE_NAME = "out#.txt";
	public static final String ROUTES_PATH = "src" + File.separator + "com" + File.separator + 
			"corrientazo" + File.separator + "dronProject" + File.separator + "utils" + File.separator +
			"sources" + File.separator;
	public static final String REPORTS_PATH = "src" + File.separator + "com" + File.separator + 
			"corrientazo" + File.separator + "dronProject" + File.separator + "utils" + File.separator +
			"reports" + File.separator;
	
	public static final int MAX_DRONES = new File(ROUTES_PATH).listFiles().length;
}
