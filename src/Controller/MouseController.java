package Controller;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.event.MouseInputAdapter;

import Model.Presentation;
import Model.SlideItem;

public class MouseController extends MouseInputAdapter {
	private Presentation presentation; // Er worden commando's gegeven aan de
										// presentatie

	public MouseController(Presentation p) {
		presentation = p;
	}

	public void mouseClicked(MouseEvent e) {

		int x = e.getX();
		int y = e.getY() - 50;
		//System.out.println("clicked: " + x + " : " + y);

		try {
			Vector<SlideItem> slideItems = presentation.getCurrentSlide().getSlideItems();

			for (SlideItem slideItem : slideItems) {

				Rectangle rect = slideItem.getBoundingBox();

				if (rect != null && rect.contains(x, y)) {					
					System.out.println("Click in " + slideItem.toString()); // + ":" + rect.toString());
					slideItem.execute();
				}
			}
		} catch (NullPointerException e1) {
		}
	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY() - 50;
		
		try {
			Vector<SlideItem> slideItems = presentation.getCurrentSlide().getSlideItems();

			for (SlideItem slideItem : slideItems) {

				Rectangle rect = slideItem.getBoundingBox();

				if (rect != null && rect.contains(x, y)) {
					// en dus niet
					// slideItem.SetHoverStatus(!slideItem.GetHoverStatus())
					// want dan gaan we voortdurend wijzigen van status!

					if (!slideItem.GetHoverStatus()) {
						slideItem.SetHoverStatus(true);
						// System.out.println("Hover!");
						presentation.rePaint();
					}
				} else {
					if (slideItem.GetHoverStatus()) {
						slideItem.SetHoverStatus(false);
						// System.out.println("not so much Hover!");
						presentation.rePaint();
					}
				}
			}
		} catch (NullPointerException e1) {
		}
	}
}
