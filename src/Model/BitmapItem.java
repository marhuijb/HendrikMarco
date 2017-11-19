package Model;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import java.io.IOException;

/**
 * <p>
 * De klasse voor een Bitmap item
 * </p>
 * <p>
 * Bitmap items hebben de verantwoordelijkheid om zichzelf te tekenen.
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
public class BitmapItem extends SlideItem {
	private BufferedImage bufferedImage;
	private String imageName;

	protected static final String FILE = "Bestand ";
	protected static final String NOTFOUND = " niet gevonden";

	/**
	 * Constructor
	 * @param level The item level
	 * @param name Name of the file that contains the image  
	 */
	public BitmapItem(int level, String name) {
		super(level);
		imageName = name;
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		} catch (IOException e) {
			System.err.println(FILE + imageName + NOTFOUND);
		}
	}
 
	/**
	 * Constructor
	 * Create a empty bitmap item 
	 */
	public BitmapItem() {
		this(0, null);
	}

	/**
	 * Get the file name of the image
	 * @return The file name
	 */
	public String getName() {
		return imageName;
	}

	/**
	 * Get the bounding box of the image
	 * @param g Not used!
	 * @param observer
	 * @param scale The scale factor
	 * @param myStyle The style of the image
	 * @return The bounding box of the image
	 */ 
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
		return new Rectangle((int) (myStyle.getIndent() * scale), 0, (int) (bufferedImage.getWidth(observer) * scale),
				((int) (myStyle.getLeading() * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
	}

	/**
	 * Draw the image
	 * @param x The x position of the image
	 * @param y The y position of the image
	 * @param scale The scale factor
	 * @param myStyle The style of image
	 * @param observer 
	 */
	public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
		int width = x + (int) (myStyle.getIndent() * scale);
		int height = y + (int) (myStyle.getLeading() * scale);
		g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
				(int) (bufferedImage.getHeight(observer) * scale), observer);
 
		if (super.getSlideItemCommand() != null) {

			int rectX = width;
			int rectY = height;
			int rectW = (int) (bufferedImage.getWidth(observer) * scale);
			int rectH = (int) (bufferedImage.getHeight(observer) * scale);

			if (getHoverStatus()) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.BLUE);
			}

			g.drawRect(rectX, rectY, rectW, rectH);
			setHyperlinkBox(new Rectangle(rectX, rectY, rectW, rectH));
		}
	}

	/**
	 * Get a string line of the class
	 */
	public String toString() {
		return "BitmapItem[" + getLevel() + "," + imageName + "]";
	}
}
