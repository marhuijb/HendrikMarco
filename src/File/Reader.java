package File;

import Factory.*;
import Model.Presentation;

/**
 * Class for reading presentation from files.
 */
public class Reader extends AbstractReader{	
	public Reader(AbstractPresentationFactory presentationFactory, FileFormatFactory fileFormatFactory) {
		super(presentationFactory, fileFormatFactory);
	}
	
	/**
	 * Read a presentation from file
	 * @param fileName The file is read and converted to a presentation. If empty then a demostration presentation is returned.   
	 * @return The presentation
	 */
	public Presentation readPresentation(String fileName) {
		Presentation presentation = null;
		FileFormat fileFormat; 		
		
		if (fileName == null || fileName.length() == 0)
		{
			//Read the demo presentation
			fileFormat = fileFormatFactory.createDemoPresentation();
			presentation = fileFormat.loadPresentation("");
		}
		else
		{
			fileFormat = fileFormatFactory.GetFileFormat(fileName);
			if (fileFormat != null) {
				presentation = fileFormat.loadPresentation(fileName);
			}
		}
		
		return presentation; 
	}		
}