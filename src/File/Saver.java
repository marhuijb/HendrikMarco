package File;

import Factory.*;
import Model.*;

/**
 * Class for saving a presentation 
 */
public class Saver extends AbstractSaver{
	public Saver(AbstractPresentationFactory presentationFactory, FileFormatFactory fileFormatFactory) {
		super(presentationFactory, fileFormatFactory);
	}
	
	/**
	 * Save a presentation following the JabberPoint2.dtd format
	 * @param presentation This presentation is saved to the file with the name "dump.xml"
	 */
	public void savePresentation(Presentation presentation)  {	
		FileFormat fileFormat = fileFormatFactory.GetFileFormatV2();
		fileFormat.savePresentation(presentation);
	}
	
}