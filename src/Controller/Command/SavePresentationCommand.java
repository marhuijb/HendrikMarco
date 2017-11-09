package Controller.Command;

import Controller.Interface.*;

/**
 * Command class for saving the presentation.
 */
public class SavePresentationCommand extends CommandDecorator{
	/*
	 * Constructor
	 * @param applicationController 
	 */
	public SavePresentationCommand(IPresentationController presentationController, IApplicationController applicationController) {
		super(presentationController, applicationController);
	}
	
	public void execute() {
		if (applicationController != null && presentationController != null) {
			applicationController.save(presentationController.getPresentation());				
		}
		
		super.execute();
	}
}