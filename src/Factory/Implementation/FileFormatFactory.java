package Factory.Implementation;

import Factory.Interface.*;
import Util.Implementation.*;

public class FileFormatFactory{
	private IPresentationFactory presentationFactory;
	
	public FileFormatFactory(IPresentationFactory presentationFactory) {
		this.presentationFactory = presentationFactory;
	}
		
	public DemoPresentation createDemoPresentation(){
		return new DemoPresentation(presentationFactory);
	}
}