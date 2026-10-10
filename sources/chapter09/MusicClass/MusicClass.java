/******************************************************************
 * Beginning Java Game Programming, 2nd Edition
 * by Jonathan S. Harbour
 * MusicClass program
 ******************************************************************/

import java.awt.*;
import java.applet.*;

public class MusicClass extends Applet {
    MidiSequence midi;

    //initialize the applet
    public void init() {
        midi = new MidiSequence();
        midi.load("bsg.mid");
        if (midi.isLoaded()) midi.play();
    }

    //repaint the applet window
    public void paint(Graphics g) {
        int x=10, y = 1;
        if (midi.isLoaded()) {
            g.drawString("Midi File: " + midi.getFilename(), x, 15 * y++);
            g.drawString("Resolution: " + midi.getSong().getResolution(), x, 15 * y++);
            g.drawString("Tick length: " + midi.getSong().getTickLength(), x, 15 * y++);
            g.drawString("Tracks: " + midi.getSong().getTracks().length, x, 15 * y++);
        } else {
            g.drawString("Error loading sequence file " + midi.getFilename(), 10, 15);
        }
    }

}
