package Controller.Command;

import Controller.Interface.*;

/**
 * Command class for open a presentation.
 */
public class OpenPresentationCommand extends CommandDecorator{
	/*
	 * Constructor
	 * @param applicationController 
	 */
	public OpenPresentationCommand(IPresentationController presentationController, IApplicationController applicationController) {
		super(presentationController, applicationController);
	}
	
	public void execute() {	
		if (applicationController != null && presentationController != null) {
			applicationController.open(presentationController.getPresentation());				
		}
		
		super.execute();
	}
}