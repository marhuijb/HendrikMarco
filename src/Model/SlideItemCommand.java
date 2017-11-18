package Model;

import Controller.Command.*;
import Controller.Interface.*;

/**
 * The class for the slide item command.  
 */
public class SlideItemCommand extends AbstractCommand{

	/**
	 * Constructor
	 * @param presentatieController The presentation controller
	 * @param applicationController The application controller
	 */
	public SlideItemCommand(IPresentationController presentatieController,
			IApplicationController applicationController) {
		super(presentatieController, applicationController);		
	}

	/**
	 * Execute the command (Empty)
	 */
	public void execute() {			
	}
}