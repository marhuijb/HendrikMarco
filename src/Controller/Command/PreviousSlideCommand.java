package Controller.Command;
import Controller.Interface.*;

/*
 * Class for showing the previous slide of a presentation
 */
public class PreviousSlideCommand extends CommandDecorator{

	public PreviousSlideCommand(IPresentationController presentationController) {
		super(presentationController, null);		
	}
	
	public void execute() {
		if (presentationController != null) {
			presentationController.previousSlide();				
		}
		
		super.execute();
	}
}