package Factory;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;

/**
 * Class for creating menu objects 
 *
 */
public class MenuFactory extends AbstractMenuFactory {
	/**
	 * Create a menu
	 * @param name The name of menu. 
	 * @return The created menu
	 */
	public Menu createMenu(String name) {
		return new Menu(name);
	}
	
	/**
	 * Create a menu item
	 * @param name The name of the menu item
	 * @param shortCut The short cut of the menu item
	 * @return The created menu item
	 */
	public MenuItem createMenuItem(String name, char shortCut) {
		return new MenuItem(name, new MenuShortcut(shortCut));
	}
}
