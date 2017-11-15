package Controller.Command;

import Controller.Interface.*;

/**
 * Command class for going to a specefic slide oof a presentation. 
 */
public class GoToSlideCommand extends CommandDecorator{
	protected static final int INITIAL_SLIDENUMBER = -1;
	
	protected int slideNumber = INITIAL_SLIDENUMBER;
	
	/*
	 * Constructor
	 * @param presentationController 
	 */
	public GoToSlideCommand(IPresentationController presentationController) {
		super(presentationController, null);
	}
	
	/*
	 * Constructor
	 * @param presentationController
	 * @param slideNumber Go to this slide number  
	 */
	public GoToSlideCommand(IPresentationController presentationController, int slideNumber) {
		super(presentationController, null);
		
		this.slideNumber = slideNumber;
	}
	
	public void execute() {
		if (presentationController != null) {
			
			if (slideNumber == INITIAL_SLIDENUMBER) {
				presentationController.goToSlide();
			}
			else {
				presentationController.goToSlide(slideNumber);
			}
		}
		
		super.execute();
	}
	
	public int getSlideNumber() {
		return slideNumber;
	}
}