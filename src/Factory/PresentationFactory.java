package Factory;

import Model.*;

/**
 * The factory for creating the presentation and related objects. These are: Slide, TextItem, BitmapItem, SlideItemCommand 
 */
public class PresentationFactory extends AbstractPresentationFactory{

	/**
	 * Create a presentation
	 * @return the created presentation
	 */
	public Presentation createPresentation() {
		return new Presentation();
	}

	/**
	 * Create a slide
	 * @return the created slide
	 */
	public Slide createSlide() {
		return new Slide();
	}

	/**
	 * Create a text item
	 * @return The created text item
	 */
	public TextItem createTextItem(int level, String text) {
		return new TextItem(level, text);
	}

	/**
	 * Create a bitmap item
	 * @return the created bitmap item
	 */
	public BitmapItem createBitmapItem(int level, String name) {
		return new BitmapItem(level, name);
	}
	
	/**
	 * Create a slide item command object
	 * @return The created slide item command object
	 */
	public SlideItemCommand createSlideItemCommand() {
		return new SlideItemCommand(PresentationControllerFactory.getPresentationController(),
				ApplicationControllerFactory.getApplicationController());
	}	
}