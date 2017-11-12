package Factory.Implementation;
import Controller.Command.*;
import Controller.Interface.*;
import Factory.Interface.ICommandFactory;

/*
 * Factory for creating command objects
 */
public class CommandFactory implements ICommandFactory{
	private static final String COMMAND_NOT_FOUND = "Command not found"; 
	
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
	 * Create FirstSlide Command
	 *  @see Controller.Command.FirstSlideCommand
	 */
	public AbstractCommand createFirstSlideCommand() {
		return new FirstSlideCommand(presentationController);
	}
	
	/*
	 * Create Last slide Command
	 * @see Controller.Command.LastSlideCommand
	 */
	public AbstractCommand createLastSlideCommand() {
		return new LastSlideCommand(presentationController);
	}

	/*
	 * Create GoTo Slide Command
	 * @see Controller.Command.GotoSlideCommand
	 */
	public AbstractCommand createGoToSlideCommand() {
		return new GoToSlideCommand(presentationController);
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

	/*
	 * Create Play Sound command
	 * @see Controller.Command.PlaySoundCommand
	 */
	public AbstractCommand createPlaySoundCommand() {
		return new PlaySoundCommand();
	}

	/*
	 * Create new presentation command
	 * @see Controller.Command.NewPresentationCommand
	 */
	public AbstractCommand createNewPresentationCommand() {
		return new NewPresentationCommand(presentationController, applicationController);
	}

	/*
	 * Create save presentation command
	 * @see Controller.Command.SavePresentationCommand
	 */
	public AbstractCommand createSavePresentationCommand() {
		return new SavePresentationCommand(presentationController, applicationController);
	}

	/*
	 * Create the open presentation command
	 * @see Controller.Command.OpenPresentationCommand
	 */
	public AbstractCommand createOpenPresentationCommand() {
		return new OpenPresentationCommand(presentationController, applicationController);
	}
	
	/*
	 * Create a command. The following command's are available: next, previous, first, last, open, go, beep
	 * @param command The name of the command to be created
	 * @throws 
	 * @return The created command object
	 */
	public AbstractCommand createCommand(String command) {
		switch(command) {
			case "next":
				return createNextSlideCommand();
			case "previous":
				return createPreviousSlideCommand();
			case "first":
				return createFirstSlideCommand();
			case "last":
				return createLastSlideCommand();
			case "open":
				return createOpenPresentationCommand();
			case "go":
				return createGoToSlideCommand();
			case "beep":			
				return createPlaySoundCommand();
			default:
				throw new IllegalArgumentException(COMMAND_NOT_FOUND);				
		}
	}
}