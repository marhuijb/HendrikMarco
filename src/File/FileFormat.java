package File;

import Factory.AbstractPresentationFactory;
import Model.*;

/**
 * Abstract class for the format of a file 
 *
 */
public abstract class FileFormat{
	protected AbstractPresentationFactory presentationFactory;
	
	/**
	 * Constructor to prevent instantiation of the abstract object
	 * @param presentationFactory The factory for creating presentation objects
	 */
	protected FileFormat(AbstractPresentationFactory presentationFactory){
		this.presentationFactory = presentationFactory;
	}
	
	public abstract Presentation loadPresentation(String fileName);
	
	public abstract void savePresentation(Presentation presentation);
}