package Controller;
import Controller.Interface.*;
import Model.*;

/*
 * This class controls a presentation and givs functionality to act on this presentation.
 */
public class PresentationController implements IPresentationController{		
	private Presentation presentation;
	
	/*
	 * Go to the next slide of the presentation if available.
	 */
	public void nextSlide() {
		presentation.nextSlide();
	}
	
	public void previousSlide() {
		presentation.prevSlide();
	}
	
	public void firstSlide() {
		presentation.setSlideNumber(0);
	}
	
	public void lastSlide() {
		presentation.setSlideNumber(0);		
	}
	
	public void goToSlide() {		
	}
	
	public void goToSlide(int slideNumber) {
		
	}
	
	public void setPresentation(Presentation presentation){
		this.presentation = presentation;
	}
}