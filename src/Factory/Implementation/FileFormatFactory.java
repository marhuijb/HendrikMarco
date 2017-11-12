package Factory.Implementation;

import Factory.Interface.*;
import Util.Implementation.*;

import java.io.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

/*
 * Factory class to create the correct file format class
 */
public class FileFormatFactory{
	private IPresentationFactory presentationFactory;
	private ICommandFactory commandFactory;
	
	public static final String V1 = "jabberpoint.dtd";
	public static final String V2 = "jabberPoint2.dtd";
	
	public FileFormatFactory(IPresentationFactory presentationFactory, ICommandFactory commandFactory) {
		this.presentationFactory = presentationFactory;
		this.commandFactory = commandFactory;
	}
		
	/*
	 * Create a demo presentation format
	 */
	public DemoPresentation createDemoPresentation(){
		return new DemoPresentation(presentationFactory);
	}
	
	/*
	 * Determine the file format of a file. Therefore the dtd file is read from the file 
	 * @param fileName The name of the file which format is determined.
	 * @return The file format of the file.
	 */
	public FileFormat GetFileFormat(String fileName) {
		String dtdType = readDtdName(fileName);
		
		switch(dtdType) {
			case V1:
				return new XMLFormatV1(presentationFactory);				
			case V2:
				return GetFileFormatV2();				
			default:
				break;
		}
		
		return null;
	}
	
	/*
	 * Get file format V2
	 */
	public FileFormat GetFileFormatV2() {
		return new XMLFormatV2(presentationFactory, commandFactory);
	}
	
	/*
	 * Read the dtd from the file
	 * @param fileName
	 */
	private String readDtdName(String fileName) {
		//determine if file is V1 of V2 of the xml file
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	    builderFactory.setNamespaceAware(true);       // Set namespace aware
	    builderFactory.setValidating(true);           // and validating parser feaures
	    builderFactory.setIgnoringElementContentWhitespace(true); 
	    DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    File file = new File(fileName);
		Document xmlDoc = null;
		try {
			xmlDoc = builder.parse(file);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DocumentType docType = xmlDoc.getDoctype(); 
		return docType.getSystemId();		
	}
}