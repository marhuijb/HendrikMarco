package Factory.Interface;
import Controller.Command.*;

/**
 * Interface for the CommandFactory
 * @author Marco Huijben 
 */
public interface ICommandFactory{
	public AbstractCommand createNextSlideCommand();
	public AbstractCommand createPreviousSlideCommand();
	public AbstractCommand createFirstSlideCommand();
	public AbstractCommand createLastSlideCommand();	
	public AbstractCommand createGoToSlideCommand();
	
	public AbstractCommand createPlaySoundCommand();	
	public AbstractCommand createNewPresentationCommand();
	public AbstractCommand createSavePresentationCommand();
	public AbstractCommand createOpenPresentationCommand();
	
	public AbstractCommand createExitCommand();
	public AbstractCommand createAboutCommand();
	
	public AbstractCommand createCommand(String command);
}