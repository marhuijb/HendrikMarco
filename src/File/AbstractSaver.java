package File;

import java.io.IOException;

import Factory.Implementation.*;
import Factory.Interface.*;
import Model.*;

/**
 * 
 */
public abstract class AbstractSaver{
	protected FileFormatFactory fileFormatFactory;
	protected IPresentationFactory presentationFactory;
	
	/**
	 * Constructor 
	 * @param presentationFactory The factory for creating presentation objects
	 * @param fileFormatFactory The factory for creating file format objects
	 */
	protected AbstractSaver(IPresentationFactory presentationFactory, FileFormatFactory fileFormatFactory) {
		this.presentationFactory = presentationFactory;
		this.fileFormatFactory = fileFormatFactory;
	}
	
	public abstract void savePresentation(Presentation presentation) throws IOException;
}