package Controller.Command;

import Controller.Interface.*;

/**
 * Command class for showing the last slide of a presentation. 
 */
public class LastSlideCommand extends CommandDecorator{
	/*
	 * Constructor
	 * @param presentationController 
	 */
	public LastSlideCommand(IPresentationController presentationController) {
		super(presentationController, null);
	}
	
	public void execute() {
		if (presentationController != null) {
			presentationController.lastSlide();				
		}
		
		super.execute();
	}
}