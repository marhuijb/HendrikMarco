package Model;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import Controller.Command.AbstractCommand;

/**
 * <p>
 * De abstracte klasse voor een item op een Slide
 * <p>
 * <p>
 * Alle SlideItems hebben tekenfunctionaliteit.
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
public abstract class SlideItem {
	private AbstractCommand slideItemCommand;

	private int level = 0; // het level van het slideitem

	private Rectangle hyperlinkBox = null;

	protected boolean hoverStatus = false;

	/**
	 * Constructor
	 * @param level The level of the slide item
	 */
	public SlideItem(int level) {
		this.level = level;
	}

	/**
	 * Constructor. The level will be 0
	 */
	public SlideItem() {
		this(0);
	}

	/**
	 * Get the level of the slide item
	 * @return The level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Change the hover state of the slide item
	 * @param inside the state of the hover
	 */
	public void setHoverStatus(boolean inside) {
		hoverStatus = inside;
	}

	/**
	 * Get the hover state
	 * @return The hover state
	 */
	public boolean getHoverStatus() {
		return hoverStatus;
	}

	/**
	 * Set the hyper link box
	 * @param hyperlinkBox The rectangle of the hyper link box
	 */
	public void setHyperlinkBox(Rectangle hyperlinkBox) {
		this.hyperlinkBox = hyperlinkBox;
	}

	/**
	 * Get the hyper link box
	 * @return The hyper link box
	 */
	public Rectangle getHyperlinkBox() {
		return this.hyperlinkBox;
	}

	/**
	 * Set the slide item command
	 * @param slideItemCommand The slide item command
	 */
	public void setSlideItemCommand(AbstractCommand slideItemCommand) {
		this.slideItemCommand = slideItemCommand;
	}

	/**
	 * Execute the command which is connected to this item.
	 */
	public void execute() {
		if (slideItemCommand != null) {
			slideItemCommand.execute();
		}
	}

	/**
	 * Get the slide item bounding box
	 */
	public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

	/**
	 * Draw the slide item
	 */
	public abstract void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);
	
	/**
	 * Get the slide command
	 * @return The slide command
	 */
	public AbstractCommand getSlideItemCommand() {
	 return this.slideItemCommand;
	}
	
}
