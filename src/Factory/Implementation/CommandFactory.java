package Factory.Implementation;
import Controller.Command.*;
import Controller.Interface.*;
import Factory.Interface.ICommandFactory;

public class CommandFactory implements ICommandFactory{
	private IPresentationController presentationController;
	
	/* 
	 * Constructor
	 * @param presentationController 
	 */
	public CommandFactory(IPresentationController presentationController){
		this.presentationController = presentationController;
	}
	
	public AbstractCommand createNextSlideCommand() {
		return new NextSlideCommand(presentationController);
	}
}