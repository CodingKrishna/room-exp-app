package com.pioneercoders.roomexp.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlFileGenerations {
	public void createXml(String name, String mobile, String email)  {
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document document = docBuilder.newDocument();
			Element rootElement = document.createElement("Room");
			document.appendChild(rootElement);

			// for defining student elements
			Element user = document.createElement("User");
			rootElement.appendChild(user);

			// for setting an attribute for student
			Attr attribute = document.createAttribute("id");
			attribute.setValue("1");
			user.setAttributeNode(attribute);
			
			Element name1 = document.createElement("username");
			name1.appendChild(document.createTextNode(name));
			user.appendChild(name1);
			
			Element name2 = document.createElement("mobile");
			name2.appendChild(document.createTextNode(mobile));
			user.appendChild(name2);
			
			Element name3 = document.createElement("email");
			name3.appendChild(document.createTextNode(email));
			user.appendChild(name3);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			
			File file = new File("C:\\Users\\SATEESH\\Desktop\\xmlfile.xml");	
			if(!file.exists()){
    			try {
					file.createNewFile();
					System.out.println("file not exists then new file is created");
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}

		public static void main(String argv[]) {
		XmlFileGenerations xml = new XmlFileGenerations();
		xml.createXml("sateesh", "9916370371", "codingsatti@gmail.com");
		//xml.createXml("sat", "9916370371", "codingsatti@gmail.com");
		
		System.out.println("XML File sccessflly created!!");

	}
}