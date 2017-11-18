package Factory.Implementation;

import File.*;

/**
 * Factory class to create a Saver class.
 */
public class SaverFactory extends AbstractSaverFactory{
	private FileFormatFactory fileFormatFactory;
	
	/**
	 * Constructor
	 * @param fileFormatFactory The file format factory 
	 */
	public SaverFactory(FileFormatFactory fileFormatFactory) {
		this.fileFormatFactory = fileFormatFactory;
	}
	
	/**
	 * Create the saver object
	 * @return The saver object
	 */
	public AbstractSaver createSaver() {
		return new Saver(new PresentationFactory(), fileFormatFactory);
	}
}