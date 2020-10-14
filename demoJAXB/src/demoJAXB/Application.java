package demoJAXB;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.Endpoint;


public class Application {
	
	public static void main(String[] args) throws Exception {
		
		//S�rialisation Objet
		/*
		JAXBContext jc = JAXBContext.newInstance(Peinture.class); // quelle classe � s�rialiser
		
		Peinture p1 = new Peinture("khorne red", "rouge", "base", "3/4"); // cr�ation nouvel objet
		
		Marshaller m = jc.createMarshaller(); // Cr�ation d'un objet Marshaller sur l'objet JAXBContext
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // formate
		
		m.marshal(p1,  new File("serialisation.xml")); // s�rialisation de l'objet p1 dans le fichier ...
		
		System.out.println("fin");
		*/
		
		
		//S�rialisation Liste d'objets
		
		Peinture p1 = new Peinture("khorne red", "rouge", "base", "3/4");
		Peinture p2 = new Peinture("kantor blue", "bleu", "base", "1/4");
		Peinture p3 = new Peinture("nuln oil", "noir", "shade", "neuf");
		ArrayList<Peinture> liste = new ArrayList<Peinture>();
		liste.add(p1);
		liste.add(p2);
		liste.add(p3);
		Palette pal = new Palette(liste);
		
		JAXBContext jc = JAXBContext.newInstance(Palette.class); // quelle classe � s�rialiser
		
		Marshaller m = jc.createMarshaller(); // Cr�ation d'un objet Marshaller sur l'objet JAXBContext
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // formate
		
		m.marshal(pal,  new File("serialisation2.xml")); // s�rialisation de l'objet p1 dans le fichier ...
		
		System.out.println("fin");
		
		
		
		//WebService d�ploiement
		/*
		String url = "http://localhost:8080/";
		WebServiceSoap wss = new WebServiceSoap();
		Endpoint.publish(url, wss);
		System.out.println("Service web d�ploy� et le WSDL, Seb Service Description est disponible � : " + url + "?wsdl");
		*/
	}
	
}
