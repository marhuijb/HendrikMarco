package Factory.Implementation;

import File.*;

/**
 * Abstract class for the reader factory 
 */
public abstract class AbstractReaderFactory{
	public abstract AbstractReader createReader();
}