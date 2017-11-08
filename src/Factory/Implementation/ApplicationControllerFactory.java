package Factory.Implementation;

import Controller.*;
import Controller.Interface.*;

/*
 * Creates a singleton object of the ApplicationController
 */
public class ApplicationControllerFactory{
	private static IApplicationController instance;
	
	private ApplicationControllerFactory() {
		
	}
	
	public static IApplicationController getApplicationController() {
		if (instance == null) {
			instance = new ApplicationController();
		}
		
		return instance;
	}
	
}