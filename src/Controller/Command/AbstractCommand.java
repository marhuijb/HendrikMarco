package Controller.Command;
import Controller.Interface.*;

/*
 * Abstract class for a command
 */
public abstract class AbstractCommand{
	protected IPresentationController presentationController;
	protected IApplicationController applicationController;
	
	protected AbstractCommand(IPresentationController presentatieController, IApplicationController applicationController) {
		this.presentationController = presentatieController;
		this.applicationController = applicationController;
	}
	
	public abstract void execute();
}