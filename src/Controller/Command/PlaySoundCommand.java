package Controller.Command;

/**
 * Command class for playing a sound 
 */
public class PlaySoundCommand extends CommandDecorator{
	/*
	 * Constructor
	 * @param presentationController 
	 */
	public PlaySoundCommand() {
		super(null, null);
	}
	
	public void execute() {
		java.awt.Toolkit.getDefaultToolkit().beep();
		
		super.execute();
	}
}