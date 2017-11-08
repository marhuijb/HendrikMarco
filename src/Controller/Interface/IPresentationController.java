package Controller.Interface;

import Model.Presentation;

/*
 * 
 */
public interface IPresentationController{
	public void nextSlide();
	public void previousSlide();
	public void firstSlide();
	public void lastSlide();
	public void goToSlide();
	public void goToSlide(int slideNumber);
	public void setPresentation(Presentation presentation);
}
