package Controller;

import java.io.IOException;

import Controller.Interface.*;
import Factory.Implementation.*;
import Factory.Interface.ICommandFactory;
import Model.*;
import File.*;
import View.*;

/*
 * Controller class for the JabberPoint application.
 */
public class ApplicationController implements IApplicationController{
	private SlideViewerFrame parent;
	private AbstractReaderFactory readerFactory;
	private AbstractSaverFactory saverFactory;
	private ICommandFactory commandFactory;
	private IPresentationController presentationController;
	
	protected static final String TESTFILE = "test.xml";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";
	
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
	 * @param fileName Open this file as the new presentation. 
	 */
	public void open(Presentation presentation, String fileName) {
		if (fileName == "") {
			fileName = TESTFILE;
		}
		
		AbstractReader reader = readerFactory.createReader();
		Presentation newPresentation = reader.readPresentation(fileName);
		presentationController.setPresentation(newPresentation);			

		if (parent == null){
			SlideViewerFrame frame = new SlideViewerFrame(JABVERSION, newPresentation, commandFactory);
			parent = frame;
		}
		else{

			parent.setupWindow(newPresentation);
		}
		newPresentation.setSlideNumber(0);
		
		parent.repaint();
	}
		
	/*
	 * Save the presentation to a file.
	 * @param The presentation to be saved.
	 */
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
	
	/*
	 * Show the application's about form 
	 */
	public void about() {
		if (parent != null) {
			AboutBox.show(parent);
		}
	}
	
	/*
	 * Set the frame 
	 */
	public void setFrame(SlideViewerFrame frame){
		this.parent = frame;
	}
	
	public void setReaderFactory(AbstractReaderFactory readerFactory) {
		this.readerFactory = readerFactory;
	}

	public void setSaverFactory(AbstractSaverFactory saverFactory) {
		this.saverFactory = saverFactory;
	}

	public void setCommandFactory(ICommandFactory commandFactory) {
		this.commandFactory = commandFactory;	
	}
	
	public void setPresentationController(IPresentationController presentationController) {
		this.presentationController = presentationController;
	}
}