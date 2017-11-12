package Controller;
import javax.swing.JOptionPane;

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
	
	/*
	 * Go to the previous slide if available.
	 */
	public void previousSlide() {
		presentation.prevSlide();
	}
	
	/*
	 * Go to the first slide of the presentation.
	 */
	public void firstSlide() {
		presentation.setSlideNumber(0);
	}
	
	/*
	 * Go to the last slide of the presentation.
	 */
	public void lastSlide() {		
		presentation.setSlideNumber(presentation.getSize() - 1);		
	}
	
	/*
	 * Ask user for slide number and go to that slide. If slide numbers doesn't exist a message is displayed.
	 */
	public void goToSlide() {				
		String pageNumberStr = JOptionPane.showInputDialog("Page number?");
		int pageNumber = Integer.parseInt(pageNumberStr);
		
		goToSlide(pageNumber);
	}
	
	/*
	 * Go to the given slide number
	 * @param slideNumber go to this slide number
	 */
	public void goToSlide(int slideNumber) {
		
		if (slideNumber > presentation.getSize()) {
			JOptionPane.showMessageDialog(null, "Page doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);			
		}
		else {
			presentation.setSlideNumber(slideNumber - 1);
		}
	}
	
	/*
	 * Set the presentation
	 * @param presentation The presentation to be set.
	 */
	public void setPresentation(Presentation presentation){
		this.presentation = presentation;
	}
	
	/*
	 * Clear the presentation
	 */
	public void clear()
	{
		this.presentation.clear();
	}
	
	/*
	 * Get the current presentation
	 */
	public Presentation getPresentation()
	{
		return this.presentation;
	}
}