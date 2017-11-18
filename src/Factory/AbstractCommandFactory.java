package Factory;
import Controller.Command.*;
import java.util.*;

/**
 * abstract class for the CommandFactory
 */
public abstract class AbstractCommandFactory{
	public abstract AbstractCommand createNextSlideCommand();
	public abstract AbstractCommand createPreviousSlideCommand();
	public abstract AbstractCommand createFirstSlideCommand();
	public abstract AbstractCommand createLastSlideCommand();	
	public abstract AbstractCommand createGoToSlideCommand();
	public abstract AbstractCommand createGoToSlideCommand(int slideNumber);
	
	public abstract AbstractCommand createPlaySoundCommand();	
	public abstract AbstractCommand createNewPresentationCommand();
	public abstract AbstractCommand createSavePresentationCommand();
	public abstract AbstractCommand createOpenPresentationCommand();
	public abstract AbstractCommand createOpenPresentationCommand(String fileName);
	
	public abstract AbstractCommand createExitCommand();
	public abstract AbstractCommand createAboutCommand();
	
	public abstract AbstractCommand createCommand(HashMap<String, Object> attributes);
	public abstract String getCommandName(AbstractCommand command);
}