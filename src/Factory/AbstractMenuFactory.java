package Factory;

import java.awt.*;

/**
 * Abstract class for the menu factory   
 */
public abstract class AbstractMenuFactory {
	public abstract Menu createMenu(String name); 
	public abstract MenuItem createMenuItem(String name, char shortCut);
}
