package Controller;

import javax.swing.JFrame;
import Controller.Interface.*;
import View.*;

/*
 * Controller class for the JabberPoint application.
 */
public class ApplicationController implements IApplicationController{
	private static IApplicationController instance;
	private JFrame parent;
	
	private ApplicationController() {
	}
	
	public static IApplicationController getInstance()
	{
		if (instance == null) {
			instance = new ApplicationController();
		}
		
		return instance;
	}
	
	public void open() {
		
	}
	
	public void save() {
		
	}
	
	public void exit() {
		
	}
	
	public void createNew() {
		
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
}