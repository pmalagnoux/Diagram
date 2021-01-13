package server;

import javax.xml.ws.Endpoint;

import webService.Securite;

public class Publication {
	public static void main(String[] args) {
		String url = "http://localhost:8686/?wsdl";
		Endpoint.publish(url, new Securite());
		System.out.println(url);
	}
}
