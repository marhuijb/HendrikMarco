package Controller.Command;

import Controller.Interface.*;

/**
 * Command for showing the next slide of a presentation. 
 */
public class NextSlideCommand extends CommandDecorator{
	public NextSlideCommand(IPresentationController presentationController) {
		super(presentationController);
	}
	
	public void execute() {
		if (presentationController != null) {
			presentationController.nextSlide();				
		}
		
		super.execute();
	}
}