package Factory;

import File.*;

/**
 * Factory class to create a reader.
 */
public class ReaderFactory extends AbstractReaderFactory{
	private FileFormatFactory fileFormatFactory;
	
	/**
	 * Constructor
	 * @param fileFormatFactory The factory to create file format objects
	 */
	public ReaderFactory(FileFormatFactory fileFormatFactory) {
		this.fileFormatFactory = fileFormatFactory;
	}
	
	/**
	 * Create a reader object
	 * @return the created reader object
	 */
	public AbstractReader createReader() {
		return new Reader(new PresentationFactory(), fileFormatFactory);
	}
}