package Factory.Interface;

import Model.*;

public interface IPresentationFactory{
	public Presentation createPresentation();
	public Slide createSlide();
	public TextItem createTextItem();
	public BitmapItem createBitmapItem();	
}