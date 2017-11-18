package Controller.Command;

import Controller.Interface.*;

/**
 * Command class for showing the next slide of a presentation. 
 */
public class NextSlideCommand extends CommandDecorator{
	
	/**
	 * Constructor
	 * @param presentationController 
	 */
	public NextSlideCommand(IPresentationController presentationController) {
		super(presentationController, null);
	}
	
	public void execute() {
		if (presentationController != null) {
			presentationController.nextSlide();				
		}
		
		super.execute();
	}
}