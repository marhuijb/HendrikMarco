package Factory;

import Model.*;

/**
 * Abstract class for the presentation factory 
 */
public abstract class AbstractPresentationFactory{
	public abstract Presentation createPresentation();
	public abstract Slide createSlide();
	public abstract TextItem createTextItem(int level, String text);
	public abstract BitmapItem createBitmapItem(int level, String name);	
	public abstract SlideItemCommand createSlideItemCommand();
}