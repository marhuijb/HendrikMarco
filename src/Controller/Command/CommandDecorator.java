package Controller.Command;

import Controller.Interface.*;

/*
 * Abstract class for the command class and is used in the decorator patterns for chaining commands to each others. 
 */
public abstract class CommandDecorator extends AbstractCommand{
	protected CommandDecorator(IPresentationController presentationController) {
		super(presentationController);
	}
	
	/*
	 * A reference to the next command, which will be executed after this command.
	 */
	private AbstractCommand nextCommand;
	
	/*
	 * Execute the next command if available
	 * @see Controller.Command.AbstractCommand#execute()
	 */
	public void execute(){
		if (nextCommand == null) {
			nextCommand.execute();
		}
	}
}