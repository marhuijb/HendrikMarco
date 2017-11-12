package Util.Implementation;

import Factory.Implementation.*;
import Factory.Interface.*;
import Model.Presentation;

/*
 * Class for reading presentation from files.
 */
public class Reader extends AbstractReader{
	private FileFormatFactory fileFormatFactory;

	public Reader(IPresentationFactory presentationFactory, FileFormatFactory fileFormatFactory) {
		super(presentationFactory);
		
		this.fileFormatFactory = fileFormatFactory;
	}
	
	/*
	 * Read a presentation from file
	 * @param fileName The file is read and converted to a presentation  
	 */
	public Presentation readPresentation(String fileName) {
		Presentation presentation = presentationFactory.createPresentation(); //TODO: later weghalen
		FileFormat fileFormat; 		
		
		if (fileName.length() == 0)
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