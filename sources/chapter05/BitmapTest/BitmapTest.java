/*****************************************************
* Beginning Java Game Programming, 2nd Edition
* by Jonathan S. Harbour
* BitmapTest program
*****************************************************/

import java.awt.*;
import java.applet.*;
import java.util.*;
import java.net.*;

public class BitmapTest extends Applet implements Runnable {
    int screenWidth = 640;
    int screenHeight = 480;
    Image image;
    Thread gameloop;
    Random rand = new Random();

    private URL getURL(String filename) {
        URL url = null;
        try {
            url = this.getClass().getResource(filename);
        }
        catch (Exception e) { }
        return url;
    }

    public void init() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        image = tk.getImage(getURL("asteroid1.png"));
    }

    public void start() {
        gameloop = new Thread(this);
        gameloop.start();
    }

    public void stop() {
        gameloop = null;
    }

    public void run() {
        Thread t = Thread.currentThread();
        while (t == gameloop) {
            try {
                Thread.sleep(20);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = screenWidth - image.getWidth(this) - 1;
        int height = screenHeight - image.getHeight(this) - 1;
        g2d.drawImage(image, rand.nextInt(width), rand.nextInt(height), this);
    }


}
