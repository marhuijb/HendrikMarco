package Factory;

import Controller.*;
import Controller.Interface.*;

/**
 * Creates a singleton object of the PresentationController
 */
public class PresentationControllerFactory{
	private static IPresentationController instance;
	
	/**
	 * Private constructor to prevent creating a object of this class
	 */
	private PresentationControllerFactory() {
		
	}
	
	/**
	 * Get the instance of the presentation controller.  
	 * @return The presentation controller
	 */
	public static IPresentationController getPresentationController() {
		if (instance == null) {
			instance = new PresentationController();
		}
		
		return instance;
	}
	
}