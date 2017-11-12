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

	public TextItem createTextItem(int level, String text) {
		return new TextItem(level, text);
	}

	public BitmapItem createBitmapItem(int level, String name) {
		return new BitmapItem(level, name);
	}
	
	public SlideCommand createSlideCommand() {
		return new SlideCommand(PresentationControllerFactory.getPresentationController(),
				ApplicationControllerFactory.getApplicationController());
	}
}