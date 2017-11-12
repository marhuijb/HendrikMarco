package Model;

import Controller.Command.*;
import Controller.Interface.*;

public class SlideItemCommand extends AbstractCommand{

	public SlideItemCommand(IPresentationController presentatieController,
			IApplicationController applicationController) {
		super(presentatieController, applicationController);		
	}

	public void execute() {			
	}
}