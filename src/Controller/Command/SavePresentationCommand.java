package Controller.Command;

import java.io.IOException;

import Controller.Interface.*;

/**
 * Command class for saving the presentation.
 */
public class SavePresentationCommand extends CommandDecorator{
	
	/**
	 * Constructor
	 * @param applicationController The application controller 
	 */
	public SavePresentationCommand(IPresentationController presentationController, IApplicationController applicationController) {
		super(presentationController, applicationController);
	}
	
	/**
	 * Save the application
	 */
	public void execute() {
		if (applicationController != null && presentationController != null) {
			try {
				applicationController.save(presentationController.getPresentation());
			} catch (IOException e) {		
				e.printStackTrace();
			}				
		}
		
		super.execute();
	}
}