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
    }

}