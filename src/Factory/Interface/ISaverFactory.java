package Factory.Interface;

import Util.Implementation.AbstractSaver;

public interface ISaverFactory{
	public AbstractSaver createSaver();
}