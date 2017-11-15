package Factory.Implementation;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import Model.Style;

/**
 * Factory class to create the different styles
 */
public class StyleFactory {

	private static Vector<Style> styles;

	public static void createStyleFactory() {
		styles = new Vector<Style>();
		createStyles();
	}
	
	private static void createStyles() {

		styles.addElement(new Style.Builder() // style voor item-level 0
				.fontName("Helvetica").fontStyle(Font.BOLD).fontSize(48).fontColor(Color.RED).indent(0).leading(20)
				.build());

		styles.addElement(new Style.Builder() // style voor item-level 1
				.fontName("Helvetica").fontStyle(Font.BOLD).fontSize(40).fontColor(Color.BLUE).indent(20).leading(10)
				.build());

		styles.addElement(new Style.Builder() // style voor item-level 2
				.fontName("Helvetica").fontStyle(Font.BOLD).fontSize(36).fontColor(Color.BLACK).indent(50).leading(10)
				.build());

		styles.addElement(new Style.Builder() // style voor item-level 3
				.fontName("Helvetica").fontStyle(Font.BOLD).fontSize(30).fontColor(Color.BLACK).indent(70).leading(10)
				.build());

		styles.addElement(new Style.Builder() // style voor item-level 4
				.fontName("Helvetica").fontStyle(Font.BOLD).fontSize(24).fontColor(Color.BLACK).indent(90).leading(10)
				.build());
	}

	public static Style getStyle(int level) {
		if (level >= styles.size()) {
			return styles.lastElement();
		} else {
			return styles.elementAt(level);
		}
	}

}
