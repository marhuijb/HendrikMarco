package Controller.Command;

/*
 * Command class to exit the application
 */
public class ExitCommand extends CommandDecorator{

	public ExitCommand() {
		super(null, null);
	}

	public void execute(){
		System.exit(0);
	}
}