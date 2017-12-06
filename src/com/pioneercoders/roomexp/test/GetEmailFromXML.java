package com.pioneercoders.roomexp.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetEmailFromXML {

	static List<String> emailList = new ArrayList<String>();

	public static List<String> getEmailList() {

		try {
			File file = new File("C:/Users/Jakesh/Desktop/MyXMLFile.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Root element "
					+ doc.getDocumentElement().getNodeName());
			NodeList nodeLst = doc.getElementsByTagName("roomMate");
			System.out.println("Information of all employees");

			for (int s = 0; s < nodeLst.getLength(); s++) {

				Node firstNode = nodeLst.item(s);

				if (firstNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstElement = (Element) firstNode;
//					NodeList firstNameElementList = firstElement
//							.getElementsByTagName("firstname");
//					Element firstNameElement = (Element) firstNameElementList
//							.item(0);
//					NodeList firstName = firstNameElement.getChildNodes();
//					System.out.println("First Name : "
//							+ ((Node) firstName.item(0)).getNodeValue());
					NodeList emailElementList = firstElement
							.getElementsByTagName("email");
					Element emailNameElement = (Element) emailElementList
							.item(0);
					NodeList lstNm = emailNameElement.getChildNodes();
					emailList.add(((Node) lstNm.item(0)).getNodeValue());
//					System.out.println("Email ID : "
//							+ ((Node) lstNm.item(0)).getNodeValue());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emailList;

	}

	public static void main(String argv[]) {
		
		GetEmailFromXML gex = new GetEmailFromXML();
		
		System.out.println(gex.getEmailList());
		
	}
}
