package Factory.Implementation;

import Factory.Interface.*;
import Util.Implementation.*;

/*
 * Factory class to create a Saver class.
 */
public class SaverFactory implements ISaverFactory{
	public AbstractSaver createSaver() {
		return new Saver();
	}
}