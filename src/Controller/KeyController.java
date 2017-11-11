package Controller;
import Controller.Command.*;
import Factory.Interface.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/** <p>This is the KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter {	
	private ICommandFactory commandFactory; 

	public KeyController(ICommandFactory c) {			
		commandFactory = c;			
	}

	public void keyPressed(KeyEvent keyEvent) {				
		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				AbstractCommand nextCommand = commandFactory.createNextSlideCommand();
				nextCommand.execute();
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				AbstractCommand previousCommand = commandFactory.createPreviousSlideCommand();
				previousCommand.execute();
				break;
			case 'q':
			case 'Q':
				AbstractCommand exitCommand = commandFactory.createExitCommand();
				exitCommand.execute();
				break; // wordt nooit bereikt als het goed is
			default:
				break;
		}
	}
}
