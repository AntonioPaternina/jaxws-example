package com.baeldung.jaxws.server.topdown.main;

import javax.xml.ws.Endpoint;

public class Main {

	public static void main(String args[]) {
		
		Endpoint e = Endpoint.create(new BookServiceImpl());
		e.publish("http://localhost:8888/test_service");
		
	}
	
}
