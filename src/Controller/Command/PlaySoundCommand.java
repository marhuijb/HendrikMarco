package Controller.Command;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * Command class for playing a sound 
 */
public class PlaySoundCommand extends CommandDecorator{
	private static final String sound = "/sound/yeehaw.wav";

	/**
	 * Constructor
	 */
	public PlaySoundCommand() {
		super(null, null);
	}
	
	/**
	 * Exceute the command
	 */
	public void execute() {
		play(sound);
		super.execute();
	}
	
	/**
	 * Play a sound
	 * @param url The url of the sound to be played
	 */
	private void play(String url) {
		Clip clip = null;
		try {
			InputStream in = getClass().getResourceAsStream(url);
			InputStream buf = new BufferedInputStream(in);
			AudioInputStream ain = AudioSystem.getAudioInputStream(buf);
			AudioFormat format = ain.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(ain);
			clip.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}