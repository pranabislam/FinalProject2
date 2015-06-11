import javax.sound.*;
import javax.sound.sampled.*;

public class Sound{
    
    public static Mixer mixxy;
    public static Clip clippy;
    public static void main(String[] args){
	
	Mixer.Info[] mixArray = AudioSystem.getMixerInfo();
	
	/*	for(Mixer.Info info : mixArray){
	    
	    System.out.println(info.getName() + "  -  " + info.getDescription());

	    }*/
	mixxy = AudioSystem.getMixer(mixInfos[0]);
	
	DataLine.Info data = new DataLine.Info(Clip.class, null);
	try {
	    clip - (Clip)mixxy.getLine(data);
		}
	catch(LineUnavailableException e){
	    e.printStackTrace();
	}
    
	try {
	    URL SoundURL = Sound.class.getResource("   ");
	    AudioInputStream stream = AudioSystem.getAudioInputStream(SoundURL);
	    clip.open(stream);
	    
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

	clip.start();

	do 
	    {
		try { Thread.sleep(50); } 
		catch{InterruptedException ie) { ie.printStackTrace(); }
	    } 
	while (clip.isActive());
    }

}
