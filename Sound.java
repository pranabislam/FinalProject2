import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

public class Sound{
    
    public static Mixer mixxy;
    public static Clip clippy;
    public static AudioFormat mic;
    public static void main(String[] args){
	
	Mixer.Info[] mixArray = AudioSystem.getMixerInfo();
	
	/*	for(Mixer.Info info : mixArray){
	    
	    System.out.println(info.getName() + "  -  " + info.getDescription());

	    }*/
	mixxy = AudioSystem.getMixer(mixArray[0]);
	mic = new AudioFormat(8000.0f, 16, 1, true, true);

	DataLine.Info data = new DataLine.Info(Clip.class, null);
	try {
	    clippy = (Clip)mixxy.getLine(data);
		}
	catch(LineUnavailableException e){
	    e.printStackTrace();
	}
    
	try {
	    URL SoundURL = Sound.class.getResource("   ");
	    AudioInputStream stream = AudioSystem.getAudioInputStream(SoundURL);
	    clippy.open(stream);
	    
	}

	catch(LineUnavailableException e) {
	    e.printStackTrace();
	}
	catch(UnsupportedAudioFileException ee){
	    ee.printStackTrace();
	}
	catch(IOException eee){
	    eee.printStackTrace();
	}

	clippy.start();

	do 
	    {
		try { Thread.sleep(50); } 
		catch(InterruptedException ie) { ie.printStackTrace(); }
	    } 
	while (clippy.isActive());
    }

}
