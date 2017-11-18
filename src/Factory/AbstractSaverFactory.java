package Factory;

import File.AbstractSaver;

/**
 * Abstract class for the saver factory 
 */
public abstract class AbstractSaverFactory{
	public abstract AbstractSaver createSaver();
}