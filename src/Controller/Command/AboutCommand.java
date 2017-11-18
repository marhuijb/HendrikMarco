package Controller.Command;
import Controller.Interface.*;

/**
 * Command class for showing the about window
 */
public class AboutCommand extends CommandDecorator{

	/**
	 * Constructor
	 * @param applicationController The application controller
	 */
	public AboutCommand(IApplicationController applicationController) {
		super(null, applicationController); 
	}
	
	/**
	 * Execute the command for showing the about box
	 */
	public void execute(){
		applicationController.about();
	}
}