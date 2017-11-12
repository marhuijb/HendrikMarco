package Util.Implementation;

import java.io.IOException;

import Factory.Interface.*;
import Model.*;

public class XMLFormatV1 extends FileFormat{

	public XMLFormatV1(IPresentationFactory presentationFactory) {
		super(presentationFactory);
		// TODO Auto-generated constructor stub
	}

	/*
	 * 
	 * @see Util.Implementation.FileFormat#loadPresentation(java.lang.String)
	 */
	public Presentation loadPresentation(String fileName) {
		Presentation presentation = presentationFactory.createPresentation();
		
		XMLAccessor accessor = new XMLAccessor();
		try {
			accessor.loadFile(presentation, fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return presentation;
	}
}