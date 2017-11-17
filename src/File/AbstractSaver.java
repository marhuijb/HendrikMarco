package File;

import java.io.IOException;

import Factory.Implementation.*;
import Factory.Interface.*;
import Model.*;

public abstract class AbstractSaver{
	protected FileFormatFactory fileFormatFactory;
	protected IPresentationFactory presentationFactory;
	
	protected AbstractSaver(IPresentationFactory presentationFactory, FileFormatFactory fileFormatFactory) {
		this.presentationFactory = presentationFactory;
		this.fileFormatFactory = fileFormatFactory;
	}
	
	public abstract void savePresentation(Presentation presentation) throws IOException;
}