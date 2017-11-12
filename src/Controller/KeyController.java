package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import Controller.Command.AbstractCommand;
import Factory.Interface.ICommandFactory;

/**
 * <p>
 * This is the KeyController (KeyListener)
 * </p>
 * 
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter {
	HashMap<Integer, AbstractCommand> keys = null;

	public KeyController(ICommandFactory commandFactory) {
		keys = new HashMap<Integer, AbstractCommand>();

		keys.put(KeyEvent.VK_PAGE_DOWN, commandFactory.createNextSlideCommand());
		keys.put(KeyEvent.VK_DOWN, commandFactory.createNextSlideCommand());
		keys.put(KeyEvent.VK_ENTER, commandFactory.createNextSlideCommand());
		keys.put((int) '+', commandFactory.createNextSlideCommand());

		keys.put(KeyEvent.VK_PAGE_UP, commandFactory.createPreviousSlideCommand());
		keys.put(KeyEvent.VK_UP, commandFactory.createPreviousSlideCommand());
		keys.put((int) '-', commandFactory.createPreviousSlideCommand());

		keys.put((int) 'q', commandFactory.createExitCommand());
		keys.put((int) 'Q', commandFactory.createExitCommand());

	}

	public void keyPressed(KeyEvent keyEvent) {

		keys.get(keyEvent.getKeyCode()).execute();

	}
}
