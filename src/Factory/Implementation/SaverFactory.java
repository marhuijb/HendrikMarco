package Factory.Implementation;

import Util.Implementation.*;

/*
 * Factory class to create a Saver class.
 */
public class SaverFactory extends AbstractSaverFactory{
	private FileFormatFactory fileFormatFactory;
	
	public SaverFactory(FileFormatFactory fileFormatFactory) {
		this.fileFormatFactory = fileFormatFactory;
	}
	
	public AbstractSaver createSaver() {
		return new Saver(new PresentationFactory(), fileFormatFactory);
	}
}