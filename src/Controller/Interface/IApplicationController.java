package Controller.Interface;

import java.io.IOException;

import javax.swing.JFrame;

import Factory.Interface.*;
import Model.*;

public interface IApplicationController{
	public void open(Presentation presentation);
	public void open(Presentation presentation, String fileName);
	public void save(Presentation presentation) throws IOException;	
	public void createNew();
	public void about();
	public void setFrame(JFrame frame);
	public void setReaderFactory(IReaderFactory readerFactory);
	public void setSaverFactory(ISaverFactory saverFactory);
}