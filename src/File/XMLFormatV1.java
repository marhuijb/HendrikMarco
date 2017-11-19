package File;

import java.io.IOException;

import Factory.*;
import Model.*;

/**
 * Read and Save the presentation in format of version 1  
 */
public class XMLFormatV1 extends FileFormat{
	protected static final String SAVEFILE = "dump.xml";

	/**
	 * The constructor
	 * @param presentationFactory The factory to create presentation objects
	 */
	public XMLFormatV1(AbstractPresentationFactory presentationFactory) {
		super(presentationFactory);
	}

	/**
	 * Load the presentation 
	 * @param fileName Load the file with this name
	 * @return The loaded presentation 
	 */
	public Presentation loadPresentation(String fileName) {
		Presentation presentation = presentationFactory.createPresentation();
		
		XMLAccessor accessor = new XMLAccessor();
		try {
			accessor.loadFile(presentation, fileName);
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
		return presentation;
	}
	
	/**
	 * Save the presentation
	 * @param presentation The presentation to be saved
	 */
	public void savePresentation(Presentation presentation) {
		XMLAccessor accessor = new XMLAccessor();
		try {
			accessor.saveFile(presentation, SAVEFILE);
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}