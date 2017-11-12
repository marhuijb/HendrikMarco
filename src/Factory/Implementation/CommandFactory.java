package Factory.Implementation;

import java.util.*;
import Controller.Command.*;
import Controller.Interface.*;
import Factory.Interface.ICommandFactory;

/*
 * Factory for creating command objects
 */
public class CommandFactory implements ICommandFactory{
	protected static final String COMMAND_NOT_FOUND = "Command not found"; 
    
	protected static final String NAME_ATTR = "name";
	protected static final String SLIDENUMBER_ATTR = "slideNumber";
    protected static final String FILENAME_ATTR = "fileName";
	
    protected IPresentationController presentationController;
	protected IApplicationController applicationController;
	
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
	 * Create GoTo Slide Command
	 * @see Controller.Command.GotoSlideCommand
	 * @param slideNumber Go to this slide number
	 */
	public AbstractCommand createGoToSlideCommand(int slideNumber) {
		return new GoToSlideCommand(presentationController, slideNumber);
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
	 * Create the open presentation command
	 * @see Controller.Command.OpenPresentationCommand
	 * @param fileName
	 */
	public AbstractCommand createOpenPresentationCommand(String fileName) {
		return new OpenPresentationCommand(presentationController, applicationController, fileName);
	}
	
	/*
	 * Create a command. The following command's are available: next, previous, first, last, open, go, beep
	 * @attributes A list with attributes for creating a command
	 * @throws IllegalArgumentException If the command doesn't exist
	 * @return The created command object
	 */
	public AbstractCommand createCommand(HashMap<String, Object> attributes) {
		String command = (String)attributes.get(NAME_ATTR);
		
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
				String fileName = (String)attributes.get(FILENAME_ATTR);
				return createOpenPresentationCommand(fileName);
			case "go":
				int slideNumber = (int)attributes.get(SLIDENUMBER_ATTR);
				return createGoToSlideCommand(slideNumber);
			case "beep":			
				return createPlaySoundCommand();
			default:
				throw new IllegalArgumentException(COMMAND_NOT_FOUND);				
		}
	}
}