package View;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import Controller.*;
import Factory.AbstractCommandFactory;
import Model.Presentation;

/**
 * <p>Het applicatiewindow voor een slideviewcomponent</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class SlideViewerFrame extends JFrame {
	private static final long serialVersionUID = 3227L;
	private SlideViewerComponent slideViewerComponent;
	private AbstractCommandFactory commandFactory;
		
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
	/**
	 * Constructor
	 * @param title The title of the frame
	 * @param presentation The presentation to be shown
	 * @param commandFactory the command factory uses by some listeners of this frame 
	 */
	public SlideViewerFrame(String title, Presentation presentation, AbstractCommandFactory commandFactory) {
		super(title);
		this.commandFactory = commandFactory;		
		setupWindow(presentation);
	}

	/**
	 * Setup the windows
	 * @param presentation The presentation to be controlled
	 */ 
	public void setupWindow(Presentation presentation) {
		getContentPane().removeAll();
		this.slideViewerComponent = new SlideViewerComponent(presentation, this); 
		presentation.setShowView(slideViewerComponent);
		setTitle(presentation.getTitle());
		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		getContentPane().add(this.slideViewerComponent);
				
		addKeyListener(new KeyController(commandFactory)); // een controller toevoegen
		setMenuBar(new MenuController(commandFactory));	// nog een controller toevoegen
		addMouseListener(new MouseController(presentation)); // nog een controller toevoegen
		addMouseMotionListener(new MouseController(presentation)); // nog een controller toevoegen
		
		setSize(new Dimension(WIDTH, HEIGHT)); // Dezelfde maten als Slide hanteert.
		setVisible(true);
	}		
}
