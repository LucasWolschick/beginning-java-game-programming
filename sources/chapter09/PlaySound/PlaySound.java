/******************************************************************
 * Beginning Java Game Programming, 2nd Edition
 * by Jonathan S. Harbour
 * PlaySound program
 ******************************************************************/

import java.awt.*;
import java.applet.*;
import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

public class PlaySound extends Applet {

    String filename = "gong.wav";
    AudioInputStream sample;

    private URL getURL(String filename) {
        URL url = null;
        try {
            url = new java.net.URL(getCodeBase() + filename);
        }
        catch (MalformedURLException e) { e.printStackTrace(); }

        return url;
    }

    //Initialize the applet
    public void init() {
        try {
            sample = AudioSystem.getAudioInputStream(getURL(filename));
            //create a sound buffer
            Clip clip = AudioSystem.getClip();
            //load the audio file
            clip.open(sample);
            //play sample
            clip.start();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch (LineUnavailableException e) {
        } catch (UnsupportedAudioFileException e) {
        } catch (Exception e) { }
    }

    public void paint(Graphics g) {
        int y = 1;
        g.drawString("Sample file: " + filename, 10, 15*y++);
        g.drawString("  " + sample.getFormat().toString(), 10, 15*y++);
        g.drawString("  Sampling rate: " + (int)sample.getFormat().getSampleRate(), 10, 15*y++);
        g.drawString("  Sample channels: " + sample.getFormat().getChannels() , 10, 15*y++);
        g.drawString("  Encoded format: " + sample.getFormat().getEncoding().toString(), 10, 15*y++);
        g.drawString("  Sample size: " + sample.getFormat().getSampleSizeInBits() + "-bit", 10, 15*y++);
        g.drawString("  Frame size: " + sample.getFormat().getFrameSize(), 10, 15*y++);
    }
}
