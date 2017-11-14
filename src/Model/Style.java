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

	private Style(Builder builder) {
		this.fontName = builder.fontName;
		this.fontStyle = builder.fontStyle;
		this.fontSize = builder.fontSize;
		this.fontColor = builder.fontColor;

		this.indent = builder.indent;
		this.leading = builder.leading;
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
	
	public static class Builder {
		private String fontName;
		private int fontStyle;
		private int fontSize;
		private Color fontColor;

		private int indent;
		private int leading;

		public Builder fontName (final String fontName) {
			this.fontName = fontName;
			return this;
		}
		public Builder fontStyle (final int fontStyle) {
			this.fontStyle = fontStyle;
			return this;
		}
		public Builder fontSize (final int fontSize) {
			this.fontSize = fontSize;
			return this;
		}
		public Builder fontColor (final Color fontColor) {
			this.fontColor = fontColor;
			return this;
		}
		
		public Builder indent (final int indent) {
			this.indent = indent;
			return this;
		}
		public Builder leading (final int leading) {
			this.leading = leading;
			return this;
		}

		public Style build() {
			return new Style(this);
		}		
	}	
	
	public String toString() {
		return "["+ indent + "," + fontColor + "; " + fontSize + " on " + leading +"]";
	}

	public Font getFont(float scale) {
		return new Font(this.fontName, this.fontStyle, this.fontSize).deriveFont(fontSize * scale);
	}

}
