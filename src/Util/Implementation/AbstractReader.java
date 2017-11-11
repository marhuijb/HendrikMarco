package Util.Implementation;

import Factory.Interface.*;
import Model.Presentation;

public abstract class AbstractReader{
	protected IPresentationFactory presentationFactory;
	
	 protected AbstractReader(IPresentationFactory presentationFactory){
		this.presentationFactory = presentationFactory;
	}
	
	public abstract Presentation readPresentation(String fileName);
}