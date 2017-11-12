package Factory.Interface;

import Model.*;

public interface IPresentationFactory{
	public Presentation createPresentation();
	public Slide createSlide();
	public TextItem createTextItem(int level, String text);
	public BitmapItem createBitmapItem(int level, String name);	
	public SlideCommand createSlideCommand();
}