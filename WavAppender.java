import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class WavAppender {
    public static void main(String[] args) {
	String wavFile1 = "D:\\wav1.wav";
	String wavFile2 = "D:\\wav2.wav";

	try {
	    
