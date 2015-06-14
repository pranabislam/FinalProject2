import javax.sound.sampled.*;
import java.io.*;

public class Mic{
    
    
    
    public static void main(String[] args){
	System.out.println("Sound test starting");
	
	try {
	    AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);

	    DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
	    if(!AudioSystem.isLineSupported(info))
		{
		    System.err.println("Line is not supported");
		}

	    final TargetDataLine targetLine = (TargetDataLine)AudioSystem.getLine(info); 
	    targetLine.open();

	    System.out.println("Recording voice");
	    targetLine.start();
	    
	    Thread thread = new Thread();
	    
	    {
		//@Override public void run();
		
		{
		    
		    AudioInputStream audioStream = new AudioInputStream(targetLine);
		    File audioFile = new File("Recording.wav");
		    System.out.println("test5");
		    try { System.out.println("test9");
			AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);
			System.out.println("audio writing test");
		    }
		    
		    catch(IOException e){
			e.printStackTrace();
		    }
		    System.out.println("test6");
		    System.out.println("Recording Stopped");
		    
		}
	    };
	    thread.start();
	    Thread.sleep(5000);
	    targetLine.stop();
	    targetLine.close();
	    
	    System.out.println("Ended sound test");
	}
	catch(InterruptedException ie){
	    ie.printStackTrace();
	}
	catch(LineUnavailableException e){
	    e.printStackTrace();
	}
        
    }



}
