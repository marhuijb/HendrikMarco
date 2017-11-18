package Controller.Command;
import Controller.Interface.*;

/**
 * Class for showing the previous slide of a presentation
 */
public class PreviousSlideCommand extends CommandDecorator{

	/**
	 * Constructor
	 * @param presentationController The presentation controller
	 */
	public PreviousSlideCommand(IPresentationController presentationController) {
		super(presentationController, null);		
	}
	
	/**
	 * Execute the command to go to the previous slide 
	 */
	public void execute() {
		if (presentationController != null) {
			presentationController.previousSlide();				
		}
		
		super.execute();
	}
}