package Factory.Interface;
import Controller.Command.*;

/**
 * Interface for the CommandFactory
 * @author Marco Huijben 
 */
public interface ICommandFactory{
	public AbstractCommand createNextSlideCommand();
	public AbstractCommand createPreviousSlideCommand();
	public AbstractCommand createExitCommand();
	public AbstractCommand createAboutCommand();
}