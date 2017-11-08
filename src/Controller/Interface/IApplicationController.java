package Controller.Interface;

import javax.swing.JFrame;

public interface IApplicationController{
	public void open();
	public void save();
	public void exit();
	public void createNew();
	public void about();
	public void setFrame(JFrame frame);
}