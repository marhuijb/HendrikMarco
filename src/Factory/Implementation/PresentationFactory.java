package Factory.Implementation;

import Factory.Interface.*;
import Model.*;

public class PresentationFactory implements IPresentationFactory{

	public Presentation createPresentation() {
		return new Presentation();
	}

	public Slide createSlide() {
		return new Slide();
	}

	public TextItem createTextItem() {
		return new TextItem();
	}

	//TODO: Bitmap 
	public BitmapItem createBitmapItem() {
		return new BitmapItem();
	}
	
}