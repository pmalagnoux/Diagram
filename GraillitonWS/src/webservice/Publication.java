package webservice;

import javax.xml.ws.Endpoint;

public class Publication {
	public static void main(String[] args) {
		String url = "http://localhost:8686/?wsdl";
		Endpoint.publish(url, new WebServiceSOAP());
		System.out.println(url);
	}
}
