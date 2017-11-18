package File;

import java.io.IOException;

import Factory.*;
import Model.*;

/**
 * Abstract class for saving the presentation
 */
public abstract class AbstractSaver{
	protected FileFormatFactory fileFormatFactory;
	protected AbstractPresentationFactory presentationFactory;
	
	/**
	 * Constructor 
	 * @param presentationFactory The factory for creating presentation objects
	 * @param fileFormatFactory The factory for creating file format objects
	 */
	protected AbstractSaver(AbstractPresentationFactory presentationFactory, FileFormatFactory fileFormatFactory) {
		this.presentationFactory = presentationFactory;
		this.fileFormatFactory = fileFormatFactory;
	}
	
	public abstract void savePresentation(Presentation presentation) throws IOException;
}