package Factory;

import Controller.*;
import Controller.Interface.*;

/**
 * Creates a singleton object of the ApplicationController
 */
public class ApplicationControllerFactory{
	private static IApplicationController instance;
	
	/**
	 * Constructor is private to prevent instantiation of the class
	 */
	private ApplicationControllerFactory() {
		
	}
	
	/**
	 * Get the application controller object. The object is created if necessary
	 * @return the application controller object
	 */
	public static IApplicationController getApplicationController() {
		if (instance == null) {
			instance = new ApplicationController();
		}
		
		return instance;
	}
	
}