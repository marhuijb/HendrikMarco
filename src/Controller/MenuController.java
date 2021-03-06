package Controller;

import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controller.Command.AbstractCommand;
import Factory.*;

/** <p>De controller voor het menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {	
	private static final long serialVersionUID = 227L;
	private AbstractMenuFactory menuFactory;
	
	protected static final String ABOUT = "About";
	protected static final String FILE = "File";
	protected static final String EXIT = "Exit";
	protected static final String GOTO = "Go to";
	protected static final String HELP = "Help";
	protected static final String NEW = "New";
	protected static final String NEXT = "Next";
	protected static final String OPEN = "Open";	
	protected static final String PREV = "Prev";
	protected static final String SAVE = "Save";
	protected static final String VIEW = "View";
	protected static final String FIRST = "First";
	protected static final String LAST = "Last";
	
	protected static final String TESTFILE = "test.xml";
	protected static final String SAVEFILE = "dump.xml";
	
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";
	
	/**
	 * Constructor
	 * @param commandFactory The command factory for creating commands.
	 */
	public MenuController(AbstractCommandFactory commandFactory, AbstractMenuFactory menuFactory) {				
		this.menuFactory = menuFactory;
		
		//Create file menu
		Menu fileMenu = menuFactory.createMenu(FILE);		
		fileMenu.add(createMenuItem(OPEN, commandFactory.createOpenPresentationCommand()));
		fileMenu.add(createMenuItem(NEW, commandFactory.createNewPresentationCommand()));
		fileMenu.add(createMenuItem(SAVE, commandFactory.createSavePresentationCommand()));
		fileMenu.addSeparator();
		fileMenu.add(createMenuItem(EXIT, commandFactory.createExitCommand()));		
		add(fileMenu);		
		
		//Create view menu
		Menu viewMenu = menuFactory.createMenu(VIEW);
		viewMenu.add(createMenuItem(NEXT, commandFactory.createNextSlideCommand(), 'X'));
		viewMenu.add(createMenuItem(PREV, commandFactory.createPreviousSlideCommand()));		
		viewMenu.add(createMenuItem(FIRST, commandFactory.createFirstSlideCommand()));
		viewMenu.add(createMenuItem(LAST, commandFactory.createLastSlideCommand()));
		viewMenu.add(createMenuItem(GOTO, commandFactory.createGoToSlideCommand()));
		add(viewMenu);
		
		//Create help menu
		Menu helpMenu = menuFactory.createMenu(HELP);
		helpMenu.add(createMenuItem(ABOUT, commandFactory.createAboutCommand()));		
		setHelpMenu(helpMenu);		// nodig for portability (Motif, etc.).
	}
	
	/**
	 * Create a menu item and add the command as action listener. 
	 * @param name The visible name of the menu item. The first character of the name is used as short cut.
	 * @param command The command to be executed when the menu item is clicked.
	 */
	private MenuItem createMenuItem(String name, AbstractCommand command) {
		return createMenuItem(name, command, name.charAt(0));
	}
	
	/**
	 * Create a menu item and add the command as action listener
	 * @param name The visible name of the menu item
	 * @param command The command to be executed when the menu item is clicked.
	 * @param menuShortCut The character used as menu short cut
	 */
	private MenuItem createMenuItem(String name, AbstractCommand command, char menuShortCut) {
		MenuItem menuItem = menuFactory.createMenuItem(name, menuShortCut);		
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				command.execute();
			}
		});

		return menuItem;
	}
}
