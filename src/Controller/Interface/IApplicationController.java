package Controller.Interface;

import java.io.IOException;

import Factory.Interface.*;
import Model.*;
import View.SlideViewerFrame;

public interface IApplicationController{
	public void open(Presentation presentation);
	public void open(Presentation presentation, String fileName);
	public void save(Presentation presentation) throws IOException;	
	public void createNew();
	public void about();
	public void setFrame(SlideViewerFrame frame);
	public void setReaderFactory(IReaderFactory readerFactory);
	public void setSaverFactory(ISaverFactory saverFactory);
	public void setCommandFactory(ICommandFactory commandFactory);
	public void setPresentationController(IPresentationController presentationController);
}