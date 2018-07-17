package com.project.yourzodiac;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;





public class ParsingXML {


	String information=null;
	String xyz=null;
		
	public String giveData(){
		return information;
	}
	
	
	public  void parsing(String x){
	
		xyz=x;
	try{
		
		URL website = new URL("http://www.siddprojects.netne.net/zodiac.xml");
		SAXParserFactory spf=SAXParserFactory.newInstance();
		SAXParser sp=spf.newSAXParser();
		XMLReader xr=sp.getXMLReader();
		
		HandlingXMLStuff doingWork=new HandlingXMLStuff();
		xr.setContentHandler(doingWork);
		doingWork.getParseWord(xyz);
		xr.parse(new InputSource(website.openStream()));
		
		information= doingWork.getInformation();
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	}
}
	
	
