package Controller;

import javax.swing.JFrame;
import Controller.Interface.*;
import View.*;

/*
 * Controller class for the JabberPoint application.
 */
public class ApplicationController implements IApplicationController{
	private JFrame parent;
	
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