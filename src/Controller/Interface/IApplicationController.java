package Controller.Interface;

import java.io.IOException;

import Factory.Implementation.*;
import Factory.Interface.*;
import Model.*;
import View.SlideViewerFrame;

/**
 * Interface for the applidation controller
 */
public interface IApplicationController{
	public void open(Presentation presentation);
	public void open(Presentation presentation, String fileName);
	public void save(Presentation presentation) throws IOException;	
	public void createNew();
	public void about();
	public void setFrame(SlideViewerFrame frame);
	public void setReaderFactory(AbstractReaderFactory readerFactory);
	public void setSaverFactory(AbstractSaverFactory saverFactory);
	public void setCommandFactory(ICommandFactory commandFactory);
	public void setPresentationController(IPresentationController presentationController);
}