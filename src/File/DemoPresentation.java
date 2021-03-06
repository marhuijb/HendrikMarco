package File;

import Factory.*;
import Model.*;

/** Een ingebouwde demo-presentatie
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class DemoPresentation extends FileFormat {

	public DemoPresentation(AbstractPresentationFactory presentationFactory) {
		super(presentationFactory); 
	}

	private Presentation loadFile(String unusedFilename) {
		Presentation presentation = presentationFactory.createPresentation();
		presentation.setTitle("Demo Presentation");		
		Slide slide = presentationFactory.createSlide();
		slide.setTitle(presentationFactory.createTextItem(0, "JabberPoint Hendrik&Marco versie"));
		slide.append(presentationFactory.createTextItem(1, "Het Java Presentatie Tool"));
		slide.append(presentationFactory.createTextItem(2, "Copyright (c) 1996-2000: Ian Darwin"));
		slide.append(presentationFactory.createTextItem(2, "Copyright (c) 2000-now:"));
		slide.append(presentationFactory.createTextItem(2, "Gert Florijn en Sylvia Stuurman"));
		slide.append(presentationFactory.createTextItem(4, "JabberPoint aanroepen zonder bestandsnaam"));
		slide.append(presentationFactory.createTextItem(4, "laat deze presentatie zien"));
		slide.append(presentationFactory.createTextItem(1, "Navigeren:"));
		slide.append(presentationFactory.createTextItem(3, "Volgende slide: PgDn of Enter"));
		slide.append(presentationFactory.createTextItem(3, "Vorige slide: PgUp of up-arrow"));
		slide.append(presentationFactory.createTextItem(3, "Stoppen: q or Q"));
		presentation.append(slide);

		slide = presentationFactory.createSlide();
		slide.setTitle(presentationFactory.createTextItem(0, "Demonstratie van levels en stijlen"));
		slide.append(presentationFactory.createTextItem(1, "Level 1"));
		slide.append(presentationFactory.createTextItem(2, "Level 2"));
		slide.append(presentationFactory.createTextItem(1, "Nogmaals level 1"));
		slide.append(presentationFactory.createTextItem(1, "Level 1 heeft stijl nummer 1"));
		slide.append(presentationFactory.createTextItem(2, "Level 2 heeft stijl nummer 2"));
		slide.append(presentationFactory.createTextItem(3, "Zo ziet level 3 er uit"));
		slide.append(presentationFactory.createTextItem(4, "En dit is level 4"));
		presentation.append(slide);

		slide = presentationFactory.createSlide();
		slide.setTitle(presentationFactory.createTextItem(0, "De derde slide"));
		slide.append(presentationFactory.createTextItem(1, "Om een nieuwe presentatie te openen,"));
		slide.append(presentationFactory.createTextItem(2, "gebruik File->Open uit het menu."));
		slide.append(presentationFactory.createTextItem(1, " "));
		slide.append(presentationFactory.createTextItem(1, "Dit is het einde van de presentatie."));
		slide.append(new BitmapItem(1, "JabberPoint.jpg"));
		presentation.append(slide);
		
		return presentation;
	}
	
	/*
	 * Load the demo presentation
	 * @param unusedFilename parameter isn't used
	 * @return the presentation 
	 */	
	public Presentation loadPresentation(String fileName) {		
		return loadFile(fileName);
	}

	/*
	 * Not implemented
	 */
	public void savePresentation(Presentation presentation) {
		//No implementation		
	}
}
