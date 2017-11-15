package Controller.Command;

import Controller.Interface.*;

/**
 * Command class for open a presentation.
 */
public class OpenPresentationCommand extends CommandDecorator{
	protected String fileName;
	
	/*
	 * Constructor
	 * @param applicationController 
	 */
	public OpenPresentationCommand(IPresentationController presentationController, IApplicationController applicationController) {
		super(presentationController, applicationController);		
	}
	
	public OpenPresentationCommand(IPresentationController presentationController, IApplicationController applicationController,
			String fileName) {
		super(presentationController, applicationController);
		
		this.fileName = fileName;
	}
	
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