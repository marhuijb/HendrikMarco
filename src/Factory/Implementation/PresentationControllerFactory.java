package Factory.Implementation;

import Controller.*;
import Controller.Interface.*;

/*
 * Creates a singleton object of the PresentationController
 */
public class PresentationControllerFactory{
	private static IPresentationController instance;
	
	private PresentationControllerFactory() {
		
	}
	
	public static IPresentationController getPresentationController() {
		if (instance == null) {
			instance = new PresentationController();
		}
		
		return instance;
	}
	
}