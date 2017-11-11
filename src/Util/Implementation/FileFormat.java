package Util.Implementation;

import Factory.Interface.IPresentationFactory;

public abstract class FileFormat{
	protected IPresentationFactory presentationFactory;
	
	protected FileFormat(IPresentationFactory presentationFactory){
		this.presentationFactory = presentationFactory;
	}
}