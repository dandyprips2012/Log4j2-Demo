package org.practice.log4j2.cpl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogApp {
	static Logger log = LogManager.getLogger(LogApp.class.getName());
	
	public static void main(String[] args) throws IOException{
		//System.out.println("Please type something");
		String s = "POST: /poc/logging HTTP/1.1\r\n" + 
				"Content-Type: application/xml\r\n" + 
				"cache-control: no-cache\r\n" + 
				"Postman-Token: e1c78e36-7c95-4804-a9a3-68df148a3aaf\r\n" + 
				"User-Agent: PostmanRuntime/7.1.1\r\n" + 
				"Accept: */*\r\n" + 
				"Host: localhost:8081\r\n" + 
				"accept-encoding: gzip, deflate\r\n" + 
				"content-length: 18\r\n" + 
				"Connection: keep-alive\r\n" + 
				"\r\n" + 
				"<INPUT>new</INPUT>";
		/*Scanner scanner = new Scanner(System.in);
		String scan = scanner.nextLine();*/
		log.info(s);
		//scanner.close();
	}
	
}