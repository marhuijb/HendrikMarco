package Model;
import java.awt.Color;
import java.awt.Font;

/** <p>Style staat voor Indent, Color, Font and Leading.</p>
 * <p>De koppeling tussen style-nummer en item-level is nu direct:
 * in Slide wordt de style opgehaald voor een item
 * met als style-nummer het item-level.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class Style {	

	private final String fontName;
	private final int fontStyle;
	private final int fontSize;
	private final Color fontColor;

	private final int indent;
	private final int leading;

	/**
	 * Constructor
	 * @param styleBuilder The style builder
	 */
	public Style(Factory.StyleBuilder styleBuilder) {
		this.fontName = styleBuilder.getFontName();
		this.fontStyle = styleBuilder.getFontStyle();
		this.fontSize = styleBuilder.getFontSize();
		this.fontColor = styleBuilder.getFontColor();

		this.indent = styleBuilder.getIndent();
		this.leading = styleBuilder.getLeading();
	}

	/**
	 * Get the name of the font
	 * @return The name of the font
	 */
	public String getFontName() {
		return fontName;
	}

	/**
	 * Get the style of the font 
	 * @return The style of the font
	 */
	public int getFontStyle() {
		return fontStyle;
	}

	/**
	 * Get the size of the font
	 * @return The size of the font
	 */
	public int getFontSize() {
		return fontSize;
	}

	/**
	 * Get the color of the font
	 * @return The color of the font
	 */
	public Color getFontColor() {
		return fontColor;
	}

	/**
	 * Get the ident
	 * @return The ident value
	 */
	public int getIndent() {
		return indent;
	}

	/**
	 * Get the leading value
	 * @return The leading value
	 */
	public int getLeading() {
		return leading;
	}

	
	public String toString() {
		return "["+ indent + "," + fontColor + "; " + fontSize + " on " + leading +"]";
	}

	/**
	 * Get the font of the style
	 * @param scale Scale factor for the size of the font
	 * @return The created font
	 */
	public Font getFont(float scale) {
		return new Font(this.fontName, this.fontStyle, this.fontSize).deriveFont(fontSize * scale);
	}
}
