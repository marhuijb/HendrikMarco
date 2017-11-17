package File;

import Factory.Implementation.*;
import Factory.Interface.*;
import Model.Presentation;

public abstract class AbstractReader{
	protected FileFormatFactory fileFormatFactory;
	protected IPresentationFactory presentationFactory;
	
	 protected AbstractReader(IPresentationFactory presentationFactory, FileFormatFactory fileFormatFactory){
		this.presentationFactory = presentationFactory;
		this.fileFormatFactory = fileFormatFactory;
	}
	
	public abstract Presentation readPresentation(String fileName);
}