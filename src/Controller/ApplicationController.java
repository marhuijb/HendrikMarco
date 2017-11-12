package Controller;

import java.io.IOException;

import javax.swing.JFrame;

import Controller.Interface.*;
import Factory.Interface.*;
import Model.*;
import Util.Implementation.*;
import View.*;

/*
 * Controller class for the JabberPoint application.
 */
public class ApplicationController implements IApplicationController{
	private JFrame parent;
	private IReaderFactory readerFactory;
	private ISaverFactory saverFactory;
	
	protected static final String TESTFILE = "test.xml";		
	
	/*
	 * Open a new presentation
	 * @param presentation Fill with the new presentation
	 */
	public void open(Presentation presentation) {
		presentation.clear();
		
		if (readerFactory != null) {
			AbstractReader reader = readerFactory.createReader();
			presentation = reader.readPresentation(TESTFILE);
		}
		parent.repaint();
	}

	/*
	 * Open a new presentation
	 * @param presentation Fill with the new presentation 
	 * @param fileName Open this file as the new presentation
	 */
	public void open(Presentation presentation, String fileName) {
		presentation.clear();
		
		if (readerFactory != null) {
			AbstractReader reader = readerFactory.createReader();
			Presentation newPresentation = reader.readPresentation(fileName);
			newPresentation.setShowView(presentation);
			newPresentation.setSlideNumber(0);
			presentation = newPresentation;
		}
		parent.repaint();
	}
		
	
	public void save(Presentation presentation) {
		if (saverFactory != null) {
			AbstractSaver saver = saverFactory.createSaver();
			try {
				saver.savePresentation(presentation);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Create a new presentation
	 */
	public void createNew() {		
		if (parent != null) {				
			parent.repaint();
		}
	}
	
	public void about() {
		if (parent != null) {
			AboutBox.show(parent);
		}
	}
	
	/*
	 * Set the frame 
	 */
	public void setFrame(JFrame frame){
		this.parent = frame;
	}
	
	public void setReaderFactory(IReaderFactory readerFactory) {
		this.readerFactory = readerFactory;
	}

	public void setSaverFactory(ISaverFactory saverFactory) {
		this.saverFactory = saverFactory;
	}

}