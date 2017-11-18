package Factory;

import java.awt.Color;

import Model.Style;

public class StyleBuilder {
	private String fontName;
	private int fontStyle;
	private int fontSize;
	private Color fontColor;

	private int indent;
	private int leading;

	public String getFontName() {
		return fontName;
	}

	public StyleBuilder fontName(final String fontName) {
		this.fontName = fontName;
		return this;
	}

	public int getFontStyle() {
		return fontStyle;
	}

	public StyleBuilder fontStyle(final int fontStyle) {
		this.fontStyle = fontStyle;
		return this;
	}

	public int getFontSize() {
		return fontSize;
	}

	public StyleBuilder fontSize(final int fontSize) {
		this.fontSize = fontSize;
		return this;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public StyleBuilder fontColor(final Color fontColor) {
		this.fontColor = fontColor;
		return this;
	}

	public int getIndent() {
		return indent;
	}

	public StyleBuilder indent(final int indent) {
		this.indent = indent;
		return this;
	}

	public int getLeading() {
		return leading;
	}

	public StyleBuilder leading(final int leading) {
		this.leading = leading;
		return this;
	}

	public Style build() {
		return new Style(this);
	}

}
