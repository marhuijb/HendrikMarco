package Controller.Command;

import Controller.Interface.*;

/**
 * Command class for open a presentation.
 */
public class OpenPresentationCommand extends CommandDecorator{
	protected String fileName;
	
	/**
	 * Constructor
	 * @param presentationController The presentation controller
	 * @param applicationController The application controller
	 */
	public OpenPresentationCommand(IPresentationController presentationController, IApplicationController applicationController) {
		super(presentationController, applicationController);		
	}

	/**
	 * Constructor
	 * @param presentationController The presentation controller
	 * @param applicationController The application controller
	 * @param fileName Open the presentation in this file
	 */
	public OpenPresentationCommand(IPresentationController presentationController, IApplicationController applicationController,
			String fileName) {
		super(presentationController, applicationController);
		
		this.fileName = fileName;
	}
	
	/**
	 * Execute the command
	 */
	public void execute() {	
		if (applicationController != null && presentationController != null) {
			if (fileName == "") {
				applicationController.open(presentationController.getPresentation());
			}
			else {
				applicationController.open(presentationController.getPresentation(), fileName);
			}
		}
		
		super.execute();
	}
	
	public String getFileName() {
		return fileName;
	}
}