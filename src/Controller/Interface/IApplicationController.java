package Controller.Interface;

import javax.swing.JFrame;

import Model.*;

public interface IApplicationController{
	public void open(Presentation presentation);
	public void save(Presentation presentation);
	public void exit();
	public void createNew();
	public void about();
	public void setFrame(JFrame frame);
}