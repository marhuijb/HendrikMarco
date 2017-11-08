package Controller.Command;
import Controller.Interface.*;

/*
 * Command class for showing the about window
 */
public class AboutCommand extends CommandDecorator{

	public AboutCommand(IApplicationController applicationController) {
		super(null, applicationController); 
	}
	
	public void execute(){
		applicationController.about();
	}
}