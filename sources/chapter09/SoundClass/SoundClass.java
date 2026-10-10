/******************************************************************
 * Beginning Java Game Programming, 2nd Edition
 * by Jonathan S. Harbour
 * SoundClass test program
 ******************************************************************/

import java.awt.*;
import java.applet.*;

public class SoundClass extends Applet {

    SoundClip clip;

    //initialize the applet
    public void init() {
        clip = new SoundClip();
        clip.load("screamandrun.aiff");
        if (clip.isLoaded()) clip.play();
    }

    //redraw the screen
    public void paint(Graphics g) {
        if (clip.isLoaded()) {
            g.drawString("Sample file: " + clip.getFilename(), 10, 15);
            g.drawString(clip.getClip().getFormat().toString(), 10, 30);
        } else {
            g.drawString("Error loading sound file " + clip.getFilename(), 10, 15);
        }
    }
}
