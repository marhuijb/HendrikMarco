package Util.Implementation;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import Factory.Interface.*;
import Model.*;
import Controller.Command.*;

public class XMLFormatV2 extends FileFormat{
	protected static final String SAVEFILE = "dump.xml";
	
    /** Default API to use. */
    protected static final String DEFAULT_API_TO_USE = "dom";
    
    /** namen van xml tags of attributen */
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDE = "slide";    
    protected static final String LEVEL = "level";
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";
    protected static final String ACTION = "action";
    protected static final String ITEMS = "items";
    protected static final String NAME = "name";
    protected static final String SLIDENUMBER = "slideNumber";
    protected static final String FILENAME = "fileName";
	
    /** tekst van messages */
    protected static final String PCE = "Parser Configuration Exception";
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    protected static final String NFE = "Number Format Exception";
    
    protected static final int DEFAULT_LEVEL = 1;
    
    private ICommandFactory commandFactory;
    
	public XMLFormatV2(IPresentationFactory presentationFactory, ICommandFactory commandFactory) {
		super(presentationFactory);		
		
		this.commandFactory = commandFactory;
	}

	/*
	 * Read presentation from file
	 * @param fileName The name of the file with the presentation
	 * @return The loaded presentation
	 */
	public Presentation loadPresentation(String fileName) {	
		Presentation presentation = presentationFactory.createPresentation();
		int slideNumber, itemNumber, max = 0, maxItems = 0;
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();    
			Document document = builder.parse(new File(fileName)); // maak een JDOM document
			Element doc = document.getDocumentElement();
			
			//Read title of the presentation
			presentation.setTitle(getTitle(doc, SHOWTITLE));

			//Read the slides
			NodeList slides = doc.getElementsByTagName(SLIDE);
			max = slides.getLength();
			for (slideNumber = 0; slideNumber < max; slideNumber++) {
				//Read a slide
				Element xmlSlide = (Element) slides.item(slideNumber);
				
				//Read the title of the slide
				Slide slide = presentationFactory.createSlide();
				slide.setTitle(getTitle(xmlSlide, SLIDETITLE));
				presentation.append(slide);
				
				//Read the items of the slide
				NodeList items = xmlSlide.getElementsByTagName(ITEMS);
				Element xmlItems = (Element)items.item(0);
				NodeList slideItems = xmlItems.getElementsByTagName("*");				
				
				maxItems = slideItems.getLength();
				for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
					//Read a item
					Element item = (Element) slideItems.item(itemNumber);
					String parentNode = item.getParentNode().getNodeName();
					if (parentNode == ITEMS) {
						loadSlideItem(slide, item, null);
					}				
				}
			}
		} 
		catch (IOException iox) {
			System.err.println(iox.toString());
		}
		catch (SAXException sax) {
			System.err.println(sax.getMessage());
		}
		catch (ParserConfigurationException pcx) {
			System.err.println(PCE);
		}
		
		return presentation;
	}
	
	/*
	 * Load a slide item (e.g. text, image or action)
	 * @param slide The item will be added to this slide item
	 * @param item XML element will be converterd into a slide item or an slide command
	 * @param decorator The action which is coupled on a slide item. Can be null
	 */
	private void loadSlideItem(Slide slide, Element item, CommandDecorator decorator) {		
		String tagName = item.getTagName();
		switch (tagName) {
			case TEXT:
				int textLevel = getIntAttribute(item, LEVEL, DEFAULT_LEVEL);
				TextItem textItem = presentationFactory.createTextItem(textLevel, item.getTextContent());				
				
				if (decorator != null) {
					SlideItemCommand slideItemCommand = presentationFactory.createSlideItemCommand();
					decorator.setNextCommand(slideItemCommand);
					textItem.setSlideItemCommand(decorator);
				}
				
				slide.append(textItem);
				break;
			case IMAGE:
				int imageLevel = getIntAttribute(item, LEVEL, DEFAULT_LEVEL);
				BitmapItem bitmapItem = presentationFactory.createBitmapItem(imageLevel, item.getTextContent());
				slide.append(bitmapItem);
				break;
			case ACTION:								
				HashMap<String, Object> attributes = new HashMap<String, Object>();
				attributes.put(NAME, getAttribute(item, NAME));
				attributes.put(FILENAME, getAttribute(item, FILENAME));
				attributes.put(SLIDENUMBER, getIntAttribute(item, SLIDENUMBER, -1));
				
				CommandDecorator commandDecorator = (CommandDecorator)commandFactory.createCommand(attributes);
											
				if (decorator != null) {
					decorator.setNextCommand(commandDecorator);
				}
				else {
					decorator = commandDecorator;
				}
				
				NodeList items = item.getElementsByTagName("*");
			
				Element innerItem = (Element)items.item(0);					
				loadSlideItem(slide, innerItem, decorator);				
											
				break;
			default:
				System.err.println(UNKNOWNTYPE);
				break;
		}
	}
	
	/*
	 * Get the value of the level attribute
	 * @param item Reads the level of this item.
	 * @return The level
	 */
	private int getIntAttribute(Element item, String attribute, int defaultValue) {
		int level = defaultValue; 
		NamedNodeMap attributes = item.getAttributes();
		Node node = attributes.getNamedItem(attribute);
		
		if (node != null) { 
			String leveltext = node.getTextContent();
			if (leveltext != null) {
				try {
					level = Integer.parseInt(leveltext);
				}
				catch(NumberFormatException x) {
					System.err.println(NFE);
				}
			}
		}
		
		return level;
	}
	
	/*
	 * Get the value of the attribute
	 * @param item Reads the value of this attribute.
	 * @return The value of the attribute
	 */
	private String getAttribute(Element item, String attribute) {		
		NamedNodeMap attributes = item.getAttributes();
		Node node = attributes.getNamedItem(attribute);
		
		if (node != null) {
			String name = attributes.getNamedItem(attribute).getTextContent();
			return name;
		}
		
		return null;
	}	
	
	/*
	 * Get the title of the slide
	 * @param element
	 * @param tagName  
	 * @return The title
	 */
    private String getTitle(Element element, String tagName) {
    	NodeList titles = element.getElementsByTagName(tagName);
    	return titles.item(0).getTextContent();    	
    }

	/*
	 * Save a presentation
	 * @param presentation The presentation to be saved
	 */
	public void savePresentation(Presentation presentation) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(SAVEFILE));

			out.println("<?xml version=\"1.0\"?>");
			out.println("<!DOCTYPE presentation SYSTEM \"jabberPoint2.dtd\">");
			out.println("<presentation>");
			out.print("<showtitle>");
			out.print(presentation.getTitle());
			out.println("</showtitle>");
			for (int slideNumber=0; slideNumber<presentation.getSize(); slideNumber++) {
				Slide slide = presentation.getSlide(slideNumber);
				out.println("<slide>");
				out.println("<title>" + slide.getTitle() + "</title>");
				
				out.println("<items>");
				Vector<SlideItem> slideItems = slide.getSlideItems();
				for (int itemNumber = 0; itemNumber<slideItems.size(); itemNumber++) {
					SlideItem slideItem = (SlideItem) slideItems.elementAt(itemNumber);					
										
					if (slideItem instanceof TextItem) {
						out.print("<text level=\"" + slideItem.getLevel() + "\">");
						out.print( ( (TextItem) slideItem).getText());
						out.print("</text>");
					}
					else {
						if (slideItem instanceof BitmapItem) {
							out.print("<image level=\"" + slideItem.getLevel() + "\">");
							out.print( ( (BitmapItem) slideItem).getName());
							out.print("</image>");
						}
						else {
							System.out.println("Ignoring " + slideItem);
						}
					}
										
				}
				out.println("</items>");
				out.println("</slide>");
			}
			out.println("</presentation>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}