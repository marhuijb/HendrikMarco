package Factory.Implementation;
import Controller.Command.*;
import Controller.Interface.*;
import Factory.Interface.ICommandFactory;

/*
 * Factory for creating command objects
 */
public class CommandFactory implements ICommandFactory{
	private IPresentationController presentationController;
	private IApplicationController applicationController;
	
	/* 
	 * Constructor
	 * @param presentationController 
	 */
	public CommandFactory(IPresentationController presentationController, IApplicationController applicationController){
		this.presentationController = presentationController;
		this.applicationController = applicationController;
	}
	
	/*
	 * Create NextSlide Command
	 *  @see Controller.Command.NextSlideCommand
	 */
	public AbstractCommand createNextSlideCommand() {
		return new NextSlideCommand(presentationController);
	}
	
	/*
	 * Create Previous slide Command
	 * @see Controller.Command.PreviousSlideCommand
	 */
	public AbstractCommand createPreviousSlideCommand() {
		return new PreviousSlideCommand(presentationController);
	}
	
	/*
	 * Create Exit Command
	 * @see Controller.Command.ExitCommand
	 */
	public AbstractCommand createExitCommand() {
		return new ExitCommand();
	}
	
	/*
	 * Create About Command
	 * @see Controller.Command.ExitCommand
	 */
	public AbstractCommand createAboutCommand() {
		return new AboutCommand(applicationController);
	}
}