package Model;

import Controller.Command.*;
import Controller.Interface.*;

public class SlideCommand extends AbstractCommand{

	protected SlideCommand(IPresentationController presentatieController,
			IApplicationController applicationController) {
		super(presentatieController, applicationController);		
	}

	
	public void execute() {			
	}
}