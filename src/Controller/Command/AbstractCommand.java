package Controller.Command;
import Controller.Interface.*;

/*
 * Abstract class for a command
 */
public abstract class AbstractCommand{
	protected IPresentationController presentationController;
	
	protected AbstractCommand(IPresentationController presentatieController) {
		this.presentationController = presentatieController;
	}
	
	public abstract void execute();
}