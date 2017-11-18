package File;

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

/**
 * Read and Save the presentation in format of version 2  
 */
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
    
	/**
	 * The constructor
	 * @param presentationFactory The factory to create presentation objects
	 * @param commandFactory The factory to create commands
	 */
	public XMLFormatV2(IPresentationFactory presentationFactory, ICommandFactory commandFactory) {
		super(presentationFactory);		
		
		this.commandFactory = commandFactory;
	}

	/**
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
						loadSlideItem(slide, item, null, null);
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
	
	/**
	 * Load a slide item (e.g. text, image or action)
	 * @param slide The item will be added to this slide item
	 * @param item XML element will be converted into a slide item or an slide command
	 * @param decorator The action which is coupled on a slide item. Can be null
	 * @param head The first action of the slide. Can be null
	 */
	private void loadSlideItem(Slide slide, Element item, CommandDecorator decorator, CommandDecorator head) {		
		String tagName = item.getTagName();
		switch (tagName) {
			case TEXT:
				slide.append(handleTextElement(item, decorator, head));
				break;
			case IMAGE:
				slide.append(handleImageItem(item, decorator, head));
				break;
			case ACTION:								
				CommandDecorator commandDecorator = createCommand(item);				
											
				if (decorator != null) {
					decorator.setNextCommand(commandDecorator);					
				}
				else {
					
					head = commandDecorator;
				}
				
				decorator = commandDecorator;
				NodeList items = item.getElementsByTagName("*");
			
				Element innerItem = (Element)items.item(0); 					
				loadSlideItem(slide, innerItem, decorator, head);				
											
				break;
			default:
				System.err.println(UNKNOWNTYPE);
				break;
		}
	}

	/**
	 * Create a new command depending on the item.
	 * @param item Contains information which command has to be created.
	 * @return The created command
	 */
	private CommandDecorator createCommand(Element item) {
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put(NAME, getAttribute(item, NAME));
		attributes.put(FILENAME, getAttribute(item, FILENAME));
		attributes.put(SLIDENUMBER, getIntAttribute(item, SLIDENUMBER, -1));
		
		CommandDecorator commandDecorator = (CommandDecorator)commandFactory.createCommand(attributes);
		return commandDecorator;
	}

	/**
	 * Handle a image element.
	 * @param item the item to be handled
	 * @param decorator current position of the decorator chain. 
	 * @param head The head of the decorator chain 
	 * @return a TextItem object
	 */
	private BitmapItem handleImageItem(Element item, CommandDecorator decorator, CommandDecorator head) {
		int imageLevel = getIntAttribute(item, LEVEL, DEFAULT_LEVEL);
		BitmapItem bitmapItem = presentationFactory.createBitmapItem(imageLevel, item.getTextContent());

		addDecorator(decorator, head, bitmapItem);
		return bitmapItem;
	}

	/**
	 * Add a decorator element to the slide item 
	 * @param decorator If not not null  Can be null
	 * @param head The first command of the decorator chain
	 * @param slideItem The decorator is added to this slide item
	 */
	private void addDecorator(CommandDecorator decorator, CommandDecorator head, SlideItem slideItem) {
		if (decorator != null) {
			SlideItemCommand slideItemCommand = presentationFactory.createSlideItemCommand();
			decorator.setNextCommand(slideItemCommand);
			slideItem.setSlideItemCommand(head);
		}
	}

	/**
	 * Handle a TextItem element.
	 * @param item the item to be handled
	 * @param decorator current position of the decorator chain. 
	 * @param head The head of the decorator chain 
	 * @return a TextItem object
	 */
	private TextItem handleTextElement(Element item, CommandDecorator decorator, CommandDecorator head) {
		int textLevel = getIntAttribute(item, LEVEL, DEFAULT_LEVEL);
		TextItem textItem = presentationFactory.createTextItem(textLevel, item.getTextContent());				
		
		addDecorator(decorator, head, textItem);
		return textItem;
	}
	
	/**
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
	
	/**
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
	
	/**
	 * Get the title of the slide
	 * @param element
	 * @param tagName  
	 * @return The title
	 */
    private String getTitle(Element element, String tagName) {
    	NodeList titles = element.getElementsByTagName(tagName);
    	return titles.item(0).getTextContent();    	
    }

	/**
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
			
			printTitle(presentation, out, 1);
			
			for (int slideNumber=0; slideNumber<presentation.getSize(); slideNumber++) {
				Slide slide = presentation.getSlide(slideNumber);
				out.println(addIdent(1) + "<slide>");
				out.println(addIdent(2) + "<title>" + slide.getTitle() + "</title>");
				
				out.println(addIdent(2) + "<items>");
				Vector<SlideItem> slideItems = slide.getSlideItems();
				int ident;
				for (int itemNumber = 0; itemNumber<slideItems.size(); itemNumber++) {
					ident = 3;
					SlideItem slideItem = (SlideItem) slideItems.elementAt(itemNumber);					
						
					CommandDecorator command = (CommandDecorator)slideItem.getSlideItemCommand();									
					
					if (command != null){						
						printStartActionElement(out, ident, command);						
						printElement(command, out, ident+1, slideItem);						
						
						out.println(addIdent(ident) + "</action>");
					}
					else {
						printSlideItem(slideItem, out, ident);
					}					
										
				}
				out.println(addIdent(2) + "</items>");
				out.println(addIdent(1) + "</slide>");
			}
			out.println("</presentation>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Print the start action element <action ... >
	 * @param out Print to this writer
	 * @param ident the ident level of the element
	 * @command command The command to be printed
	 */
	private void printStartActionElement(PrintWriter out, int ident, AbstractCommand command) {
		String attributes = getAttributes(command);
		out.println(addIdent(ident) + "<action " + attributes + ">");
	}

	/**
	 * Gets the attributes as a string for a action, e.g. name="open" attr2="..." 
	 * @param command Create the attributes string for this command
	 * @return the attribute string
	 */
	private String getAttributes(AbstractCommand command) {
		String attributes = "name=\"" + commandFactory.getCommandName(command) + "\"";
		
		if (command instanceof GoToSlideCommand) {
			GoToSlideCommand goToSlideCommand = (GoToSlideCommand)command;
			attributes = attributes + " slideNumber=\"" + goToSlideCommand.getSlideNumber() + "\"";
		}
		else if (command instanceof OpenPresentationCommand) {
			OpenPresentationCommand openPresentationCommand = (OpenPresentationCommand)command;
			attributes = attributes + " fileName=\"" + openPresentationCommand.getFileName() + "\"";
		}
		
		return attributes;
	}
	
	/**
	 * Print a slide item
	 * @param slideItem The slide item to be printed.
	 * @param out 
	 * @param indent The ident level
	 */
	private void printSlideItem(SlideItem slideItem, PrintWriter out, int ident) {
		if (slideItem instanceof TextItem) {
			out.print(addIdent(ident) + "<text level=\"" + slideItem.getLevel() + "\">");
			out.print( ( (TextItem) slideItem).getText());
			out.println("</text>");
		}
		else {
			if (slideItem instanceof BitmapItem) {
				out.print(addIdent(ident) + "<image level=\"" + slideItem.getLevel() + "\">");
				out.print( ( (BitmapItem) slideItem).getName());
				out.println("</image>");
			}
			else {
				System.out.println("Ignoring " + slideItem);
			}
		}
	}

	/**
	 * Print a action or a slide item element
	 * @param command Print the command, can be null. The command belongs to the slide item
	 * @param out Print to this writer
	 * @param ident The ident level of the element
	 * @param slideItem The slide item to be printed
	 */
	private void printElement(CommandDecorator command, PrintWriter out, int ident, SlideItem slideItem) {
		AbstractCommand nextCommand = command != null ? command.getNextCommand() : null;
		if (nextCommand instanceof CommandDecorator) {		
			printStartActionElement(out, ident, nextCommand);	
			printElement((CommandDecorator)nextCommand, out, ident+1, slideItem);
			out.println(addIdent(ident) + "</action>");
		}
		else {
			printSlideItem(slideItem, out, ident);
		}		
	}

	/**
	 * Print the title of the presentation
	 * @param presentation Print the title of this presentation
	 * @param out Print to this writer
	 * @param ident The ident level
	 */
	private void printTitle(Presentation presentation, PrintWriter out, int ident) {
		out.print(addIdent(ident) + "<showtitle>");
		out.print(presentation.getTitle());
		out.println("</showtitle>");
	}

	/**
	 * Return a tab character for each ident
	 * @param ident The ident value
	 * @return a string of tab characters
	 */
	private String addIdent(int ident) {
		String str = "";
		for(int i=0;i<ident;i++)
			str += "\t";
		
		return str;
	}
}