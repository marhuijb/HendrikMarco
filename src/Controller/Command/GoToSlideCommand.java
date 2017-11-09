package Controller.Command;

import Controller.Interface.*;

/**
 * Command class for going to a specefic slide oof a presentation. 
 */
public class GoToSlideCommand extends CommandDecorator{
	/*
	 * Constructor
	 * @param presentationController 
	 */
	public GoToSlideCommand(IPresentationController presentationController) {
		super(presentationController, null);
	}
	
	public void execute() {
		if (presentationController != null) {
			presentationController.goToSlide();				
		}
		
		super.execute();
	}
}