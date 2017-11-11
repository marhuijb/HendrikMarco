package Factory.Implementation

public class SaverFactory implements ISaverFactory{
	public ISave createSaver() {
		return new Saver();
	}
}