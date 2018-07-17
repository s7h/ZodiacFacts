package com.project.yourzodiac;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class HandlingXMLStuff extends DefaultHandler{
	
String zodiac_sign=null;
	
XMLDataCollected info=new XMLDataCollected();
	
	public String getInformation(){
		return info.set();
	}
	
	public void getParseWord(String a){
		zodiac_sign=a;
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if(localName.equals(zodiac_sign)){
			String sign=attributes.getValue("data");
			info.get(sign);
		}
	}

	
	
}
