package org.practice.log4j2.cpl;

import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogApp {
	static Logger log = LogManager.getLogger(LogApp.class.getName());
	
	public static void main(String[] args) throws IOException{
		System.out.println("Please type something");
		Scanner scanner = new Scanner(System.in);
		String scan = scanner.nextLine();
		log.info(scan);
		scanner.close();
	}
	
}