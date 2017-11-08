package Controller;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.event.MouseInputAdapter;

import Model.Presentation;
import Model.SlideItem;

public class MouseController extends MouseInputAdapter { // implements MouseListener {

	private Presentation presentation; // Er worden commando's gegeven aan de
										// presentatie

	public MouseController(Presentation p) {
		presentation = p;
	}

	public void mouseClicked(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();
		System.out.println("clicked: " + x + " : " + y);

		Vector<SlideItem> slideItems = presentation.getCurrentSlide().getSlideItems();

		for (SlideItem slideItem : slideItems) {

			Rectangle rect = slideItem.getBoundingBox();

			//if (rect != null && rect.contains(x, y)) {

			if (x > rect.x && x < rect.width && y > rect.y && y < rect.height) {
				
				System.out.println("Click in " + slideItem.toString() + ":" + rect.toString());
			}

		}
	}

	public void mouseMoved(MouseEvent e) {
		//System.out.println("Mousemovement on " + e.getX() + ":" + e.getY());
	}

}
