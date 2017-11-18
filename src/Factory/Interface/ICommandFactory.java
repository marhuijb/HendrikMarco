package Factory.Interface;
import Controller.Command.*;
import java.util.*;

/**
 * Interface for the CommandFactory
 */
public interface ICommandFactory{
	public AbstractCommand createNextSlideCommand();
	public AbstractCommand createPreviousSlideCommand();
	public AbstractCommand createFirstSlideCommand();
	public AbstractCommand createLastSlideCommand();	
	public AbstractCommand createGoToSlideCommand();
	public AbstractCommand createGoToSlideCommand(int slideNumber);
	
	public AbstractCommand createPlaySoundCommand();	
	public AbstractCommand createNewPresentationCommand();
	public AbstractCommand createSavePresentationCommand();
	public AbstractCommand createOpenPresentationCommand();
	public AbstractCommand createOpenPresentationCommand(String fileName);
	
	public AbstractCommand createExitCommand();
	public AbstractCommand createAboutCommand();
	
	public AbstractCommand createCommand(HashMap<String, Object> attributes);
	public String getCommandName(AbstractCommand command);
}