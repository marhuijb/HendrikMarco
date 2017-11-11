package Factory.Implementation;

import Factory.Interface.*;
import Util.Implementation.*;

/*
 * Factory class to create a reader.
 */
public class ReaderFactory implements IReaderFactory{
	private FileFormatFactory fileFormatFactory;
	
	public ReaderFactory(FileFormatFactory fileFormatFactory) {
		this.fileFormatFactory = fileFormatFactory;
	}
	
	public AbstractReader createReader() {
		return new Reader(new PresentationFactory(), fileFormatFactory);
	}
}