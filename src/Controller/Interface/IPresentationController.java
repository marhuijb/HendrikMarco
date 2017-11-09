package Controller.Interface;

import Model.Presentation;

/*
 * Interface for the presentation controller.
 */
public interface IPresentationController{
	public void nextSlide();
	public void previousSlide();
	public void firstSlide();
	public void lastSlide();
	public void goToSlide();
	public void goToSlide(int slideNumber);
	public void setPresentation(Presentation presentation);
	public void clear();
	public Presentation getPresentation();
}
