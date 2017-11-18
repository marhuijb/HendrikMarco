package File;

import Factory.*;
import Model.Presentation;

/**
 * Abstract class for reading a presentation 
 */
public abstract class AbstractReader{
	protected FileFormatFactory fileFormatFactory;
	protected AbstractPresentationFactory presentationFactory;
	
	/**
	 * Constructor
	 * @param presentationFactory The factory for creating presentation objects
	 * @param fileFormatFactory The factory for creating file format objects
	 */
	 protected AbstractReader(AbstractPresentationFactory presentationFactory, FileFormatFactory fileFormatFactory){
		this.presentationFactory = presentationFactory;
		this.fileFormatFactory = fileFormatFactory;
	}
	
	public abstract Presentation readPresentation(String fileName);
}