package Model;

import java.util.ArrayList;
import View.SlideViewerComponent;


/**
 * <p>Presentation houdt de slides in de presentatie bij.</p>
 * <p>Er is slechts één instantie van deze klasse aanwezig.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class Presentation {
	private String showTitle; // de titel van de presentatie
	private ArrayList<Slide> showList = null; // een ArrayList met de Slides
	private int currentSlideNumber = 0; // het slidenummer van de huidige Slide
	private SlideViewerComponent slideViewComponent = null; // de viewcomponent voor de Slides

	/**
	 * Constructor
	 */
	public Presentation() {
		slideViewComponent = null;
		clear();
	}

	/**
	 * Constructor
	 * @param slideViewerComponent Couples the presentation to this slide viewer
	 */
	public Presentation(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
		clear();
	}

	/**
	 * Get the amount of slides
	 * @return the amount of slides
	 */
	public int getSize() {
		return showList.size();
	}

	/**
	 * Get the title of the presentation
	 * @return The title
	 */
	public String getTitle() {
		return showTitle;
	}

	/**
	 * Set the title of the presentation
	 * @param title The title of the presentation
	 */
	public void setTitle(String title) {
		showTitle = title;
	}

	/**
	 * Set the slide view component
	 * @param slideViewerComponent
	 */
	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
	}
	
	/**
	 * Repaint the presentation
	 */
	public void rePaint() {
		slideViewComponent.repaint();
	}

	/**
	 * Get the number of the current slide
	 * @return The number of the slide
	 */
	public int getSlideNumber() {
		return currentSlideNumber;
	}

	/**
	 * Change the slide number and update the window
	 * @param number The new slide number
	 */
	public void setSlideNumber(int number) {
		currentSlideNumber = number;
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}

	/**
	 * Go to the previous slide until the first slide is already reached.
	 */
	public void prevSlide() {
		if (currentSlideNumber > 0) {
			setSlideNumber(currentSlideNumber - 1);
	    }
	}

	/**
	 * Go to the next slide, until the end of the presentations is already reached
	 */
	public void nextSlide() {
		if (currentSlideNumber < (showList.size()-1)) {
			setSlideNumber(currentSlideNumber + 1);
		}
	}

    /**
     * Clear the presentation. All slides are removed.
     */
	public void clear() {
		showList = new ArrayList<Slide>();
		setSlideNumber(-1);
	}

	/**
	 * Add a slide to the presentation
	 * @param slide The slide to be added
	 */
	public void append(Slide slide) {
		showList.add(slide);
	}

	/**
	 * Get the slide with a specific slide number
	 * @param number The number of the requested slide
	 * @return The requested slide. Null if the requested slide isn't available.
	 */
	public Slide getSlide(int number) {
		if (number < 0 || number >= getSize()){
			return null;
	    }
			return (Slide)showList.get(number);
	}

	/**
	 * Get the current slide
	 * @return The current slide
	 */
	public Slide getCurrentSlide() {
		return getSlide(currentSlideNumber);
	}
}
