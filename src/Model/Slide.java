package Model;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

import Factory.StyleFactory;

/** <p>Een slide. Deze klasse heeft tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class Slide {
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;

	protected TextItem title; 
	protected Vector<SlideItem> items; 

	/**
	 * Constructor
	 */
	public Slide() {
		items = new Vector<SlideItem>();
	}

	/**
	 * Add an slide item to the slide
	 * @param anItem This item is added to the slide
	 */
	public void append(SlideItem anItem) {
		items.addElement(anItem);
	}

	/**
	 * Get the title of the slide
	 * @return The title of the slide
	 */
	public String getTitle() {
		return title.getText();
	}

	/**
	 * Set the title of the slide
	 * @param newTitle The new title
	 */
	public void setTitle(TextItem newTitle) {		
		this.title = newTitle;
	}

	/**
	 * Get a specific slide item
	 * @param number Number of the requested slide item 
	 * @return The requested slide item
	 */
	public SlideItem getSlideItem(int number) {
		return (SlideItem)items.elementAt(number);
	}

	/**
	 * Get all slide items (exclusive the title)
	 * @return All slide items
	 */
	public Vector<SlideItem> getSlideItems() {
		return items;
	}

	/**
	 * Get the amount of items on the slide
	 * @return The amount of slide items
	 */
	public int getSize() {
		return items.size();
	}

	/**
	 * Draw the slide 
	 * @param g Used to draw the slide
	 * @param area The area to be draw
	 * @param view
	 */
	public void draw(Graphics g, Rectangle area, ImageObserver view) {
		float scale = getScale(area);
	    int y = area.y;
		/* De titel hoeft niet meer apart behandeld te worden */
	    SlideItem slideItem = this.title;
	    Style style = StyleFactory.getStyle(slideItem.getLevel());
	    slideItem.draw(area.x, y, scale, g, style, view);
	    y += slideItem.getBoundingBox(g, view, scale, style).height;
	    for (int number=0; number<getSize(); number++) {
	      slideItem = (SlideItem)getSlideItems().elementAt(number);
	      style = StyleFactory.getStyle(slideItem.getLevel());
	      slideItem.draw(area.x, y, scale, g, style, view);
	      y += slideItem.getBoundingBox(g, view, scale, style).height;
	    }
	  }

	/**
	 * Get the scale of the slide for drawing the slide.
	 * @param area The area in which the slide is drawn.
	 * @return the scale
	 */
	private float getScale(Rectangle area) {
		return Math.min(((float)area.width) / ((float)WIDTH), ((float)area.height) / ((float)HEIGHT));
	}
}
