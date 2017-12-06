package com.pioneercoders.roomexp.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLManagerImpl implements IRoommateEntryManager{

	private static final String MOBILE_TAG = "mobile";
	private static final String EMAIL_TAG = "email";
	private static final String USERNAME_TAG = "username";
	private static final String ROOMMATE_TAG = "roomate";
	private static final String ROOT_TAG ="root";
	
	private final static XMLManagerImpl xmlMang = new XMLManagerImpl();

	public XMLManagerImpl(){
		
	}
	
	public static XMLManagerImpl getInstance(){
		return xmlMang;
	}
	
	private void createFile() {
		File fXmlFile = new File(XML_FILE_NAME);
		try {
			fXmlFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * create new  XML file.
	 */
	private void createXMLFile(){
		createFile();
		DocumentBuilder docBuilder = getDocumentBuilder();
		Document document = docBuilder.newDocument();
		Element rootElement = document.createElement(ROOT_TAG);
		document.appendChild(rootElement);
		writeDocumentToFile(document);
	}
	
	private DocumentBuilder getDocumentBuilder() {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return docBuilder;
	}
		
	private void writeDocumentToFile(Document document){
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer=null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(XML_FILE_NAME));
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	private Document getXMLDocument(){
		DocumentBuilder docBuilder = getDocumentBuilder();
		File fXmlFile =new File(XML_FILE_NAME);
		
		Document document=null;
		try {
			document = docBuilder.parse(fXmlFile);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	
	
	@Override
	public void addRoommate(String name, String email, String mobile) {
			File fXmlFile =new File(XML_FILE_NAME);
			if(!fXmlFile.exists()){
				createXMLFile();
			}
		
			Document document = getXMLDocument();
			document.getDocumentElement().normalize();
			Element rootElement =document.getDocumentElement();

			Element user = createNewNode(name, email, mobile, document);
			
			rootElement.appendChild(user);
			writeDocumentToFile(document);
	}

	private Element createNewNode(String name, String email, String mobile,
			Document document) {
		Element user = document.createElement(ROOMMATE_TAG);
		
		Element nameElement = document.createElement(USERNAME_TAG);
		nameElement.appendChild(document.createTextNode(name));

		Element emailElement = document.createElement(EMAIL_TAG);
		emailElement.appendChild(document.createTextNode(email));
		
		Element mobileNoElement = document.createElement(MOBILE_TAG);
		mobileNoElement.appendChild(document.createTextNode(mobile));
		
		user.appendChild(nameElement);
		user.appendChild(emailElement);
		user.appendChild(mobileNoElement);
		return user;
	}

	@Override
	public void removeRoommate(String email) {

		Document document = getXMLDocument();
		document.getDocumentElement().normalize();
		Element rootElement = document.getDocumentElement();
		NodeList nList = rootElement.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				String emailVal = eElement.getElementsByTagName(EMAIL_TAG).item(0).getTextContent();
				System.out.println("emailVal::"+emailVal);
				if(emailVal.equals(email)){
					Node parent = eElement.getParentNode();
					System.out.println("parent"+parent.getNodeName());
				    parent.removeChild(eElement);
				    parent.normalize();
				    break;
				}
				
			}

		}
		
		writeDocumentToFile(document);
	}
	
		

	public String getRoomatesEmailList() {
		
		StringBuilder emalListString = new StringBuilder();
		String seperator = ", ";
		
		Document document = getXMLDocument();
		document.getDocumentElement().normalize();
		Element rootElement = document.getDocumentElement();
		NodeList nList = rootElement.getChildNodes();

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				String emailVal = eElement.getElementsByTagName(EMAIL_TAG).item(0).getTextContent();
				System.out.println("emailVal::"+emailVal);
				if(emalListString.equals("")){
					emalListString.append(emailVal);
				}else{
					emalListString.append(seperator).append(emailVal);
				}
				
			}

		}
		
		return emalListString.toString();
	
	}
	
	
}
