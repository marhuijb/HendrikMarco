package Controller.Command;

import Controller.Interface.*;

/**
 * Command class creating a new presentation. 
 */
public class NewPresentationCommand extends CommandDecorator{
	/*
	 * Constructor
	 * @param applicationController 
	 */
	public NewPresentationCommand(IPresentationController presentationController, IApplicationController applicationController) {
		super(presentationController, applicationController);
	}
	
	public void execute() {
		if (presentationController != null){					
			presentationController.clear();			
		}
		
		if (applicationController != null) {
			applicationController.createNew();				
		}
		
		super.execute();
	}
}