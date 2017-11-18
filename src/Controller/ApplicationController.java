package Controller;

import java.io.IOException;

import Controller.Interface.*;
import Factory.*;
import Model.*;
import File.*;
import View.*;

/**
 * Controller class for the JabberPoint application.
 */
public class ApplicationController implements IApplicationController{
	private SlideViewerFrame parent;
	private AbstractReaderFactory readerFactory;
	private AbstractSaverFactory saverFactory;
	private AbstractCommandFactory commandFactory;
	private AbstractMenuFactory menuFactory;
	private IPresentationController presentationController;	
	
	protected static final String TESTFILE = "test.xml";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";
	
	/**
	 * Open a the test presentation
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

	/**
	 * Open a new presentation.
	 * @param presentation Fill with the new presentation 
	 * @param fileName Open this file as the new presentation. If the file name isn't provided then the test presentation is loaded.
	 */
	public void open(Presentation presentation, String fileName) {
		if (fileName == "") {
			fileName = TESTFILE;
		}
		
		AbstractReader reader = readerFactory.createReader();
		Presentation newPresentation = reader.readPresentation(fileName);
		presentationController.setPresentation(newPresentation);			

		if (parent == null){
			SlideViewerFrame frame = new SlideViewerFrame(JABVERSION, newPresentation, commandFactory, menuFactory);
			parent = frame;
		}
		else{

			parent.setupWindow(newPresentation);
		}
		newPresentation.setSlideNumber(0);
		
		parent.repaint();
	}
		
	/**
	 * Save the presentation to a file.
	 * @param The presentation to be saved.
	 */
	public void save(Presentation presentation) {
		if (saverFactory != null) {
			AbstractSaver saver = saverFactory.createSaver();
			try {
				saver.savePresentation(presentation);
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Create a new presentation
	 */
	public void createNew() {		
		if (parent != null) {				
			parent.repaint();
		}
	}
	
	/**
	 * Show the application's about form 
	 */
	public void about() {
		if (parent != null) {
			AboutBox.show(parent);
		}
	}
	
	/**
	 * Set the frame 
	 */
	public void setFrame(SlideViewerFrame frame){
		this.parent = frame;
	}
	
	/**
	 * Set the reader factory
	 */
	public void setReaderFactory(AbstractReaderFactory readerFactory) {
		this.readerFactory = readerFactory;
	}

	/**
	 * Set the saver factory
	 */
	public void setSaverFactory(AbstractSaverFactory saverFactory) {
		this.saverFactory = saverFactory;
	}

	/**
	 * Set the command factory
	 */
	public void setCommandFactory(AbstractCommandFactory commandFactory) {
		this.commandFactory = commandFactory;	
	}
	
	/**
	 * Set the presentation controller
	 */
	public void setPresentationController(IPresentationController presentationController) {
		this.presentationController = presentationController;
	}
	
	/**
	 * Set the menu factory
	 * @param menuFactory
	 */
	public void setMenuFactory(AbstractMenuFactory menuFactory) {
		this.menuFactory = menuFactory;
	}
}