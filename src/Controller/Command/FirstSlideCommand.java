package Controller.Command;

import Controller.Interface.*;

/**
 * Command class for showing the first slide of a presentation. 
 */
public class FirstSlideCommand extends CommandDecorator{
	/*
	 * Constructor
	 * @param presentationController 
	 */
	public FirstSlideCommand(IPresentationController presentationController) {
		super(presentationController, null);
	}
	
	public void execute() {
		if (presentationController != null) {
			presentationController.firstSlide();				
		}
		
		super.execute();
	}
}