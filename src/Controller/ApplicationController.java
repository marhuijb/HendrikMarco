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
	
	//protected static final String IOEX = "IO Exception: ";
	//protected static final String LOADERR = "Load Error";
	//protected static final String SAVEERR = "Save Error";
	
	/*
	 * Open a new presentation
	 */
	public void open(Presentation presentation) {
		presentation.clear();
		
		if (readerFactory != null) {
			AbstractReader reader = readerFactory.createReader();
			presentation = reader.readPresentation(TESTFILE);
		}
		/*
		Accessor xmlAccessor = new XMLAccessor();
		try {
			xmlAccessor.loadFile(presentation, TESTFILE);
			presentation.setSlideNumber(0);
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
		}*/
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
/*
		Accessor xmlAccessor = new XMLAccessor();
		try {
			xmlAccessor.saveFile(presentation, SAVEFILE);
		} catch (IOException exc) {
			JOptionPane.showMessageDialog(parent, IOEX + exc, 
					SAVEERR, JOptionPane.ERROR_MESSAGE);
		}*/
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