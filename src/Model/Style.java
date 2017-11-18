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

	public Style(Factory.StyleBuilder styleBuilder) {
		this.fontName = styleBuilder.getFontName();
		this.fontStyle = styleBuilder.getFontStyle();
		this.fontSize = styleBuilder.getFontSize();
		this.fontColor = styleBuilder.getFontColor();

		this.indent = styleBuilder.getIndent();
		this.leading = styleBuilder.getLeading();
	}

	public String getFontName() {
		return fontName;
	}

	public int getFontStyle() {
		return fontStyle;
	}

	public int getFontSize() {
		return fontSize;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public int getIndent() {
		return indent;
	}

	public int getLeading() {
		return leading;
	}

	public String toString() {
		return "["+ indent + "," + fontColor + "; " + fontSize + " on " + leading +"]";
	}

	public Font getFont(float scale) {
		return new Font(this.fontName, this.fontStyle, this.fontSize).deriveFont(fontSize * scale);
	}

}
