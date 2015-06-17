import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class WavAppender {
    public static void main(String[] args) {
	String wavFile1 = "Recording.wav";
	String wavFile2 = "Beat.wav";

	try {
	    AudioInputStream clip1 = AudioSystem.getAudioInputStream(new File(wavFile1));
	    AudioInputStream clip2 = AudioSystem.getAudioInputStream(new File(wavFile2));

	    AudioInputStream appendedFiles = 
		new AudioInputStream(
				     new SequenceInputStream(clip1, clip2),     
				     clip1.getFormat(), 
				     clip1.getFrameLength() + clip2.getFrameLength());

	    AudioSystem.write(appendedFiles, 
			      AudioFileFormat.Type.WAVE, 
			      new File("1/Combined.wav"));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}

