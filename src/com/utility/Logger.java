package com.utility;

public class Logger {
	
	public static void info(String info) {
		if(Constants.INFO)System.out.println("Info : " + info);
	}
	public static void error(String error) {
		if(Constants.ERROR)System.out.println("Error : " + error);
	}
	public static void debug(String debug) {
		if(Constants.DEBUG)System.out.println("Debug : " + debug);
	}
	public static void warning(String warning) {
		if(Constants.WARNING)System.out.println("Error : " + warning);
	}

}
