/*************************************************************
 * Beginning Java Game Programming, 2nd Edition
 * by Jonathan S. Harbour
 * DrawImage program
 *************************************************************/

import java.awt.*;
import java.applet.*;
import java.net.*;

public class DrawImage extends Applet {
    //image variable
    private Image image;

    private URL getURL(String filename) {
        URL url = null;
        try {
            url = this.getClass().getResource(filename);
        }
        catch (Exception e) { }
        return url;
    }

    //applet init event
    public void init() {
        image = getImage(getURL("castle.png"));
    }

    //applet paint event
    public void paint(Graphics g) {
        //create an instance of Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        //fill the background with black
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getSize().width, getSize().height);

        //draw the image
        g2d.drawImage(image, 0, 0, this);
    }
}
