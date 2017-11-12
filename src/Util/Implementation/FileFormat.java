package Util.Implementation;

import Factory.Interface.IPresentationFactory;
import Model.*;

public abstract class FileFormat{
	protected IPresentationFactory presentationFactory;
	
	protected FileFormat(IPresentationFactory presentationFactory){
		this.presentationFactory = presentationFactory;
	}
	
	public abstract Presentation loadPresentation(String fileName);
	
	public abstract void savePresentation(Presentation presentation);
}