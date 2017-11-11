package Factory.Implementation

/*
 * Factory class to create a reader.
 */
public class ReaderFactory implements IReaderFactory{
	public IReader createReader() {
		return new Reader();
	}
}