/*****************************************************
* Beginning Java Game Programming, 2nd Edition
* by Jonathan S. Harbour
* AnimationClass program
*****************************************************/
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.image.*;
import java.net.*;

public class AnimationClass extends Applet  implements Runnable {
    static int SCREENWIDTH = 640;
    static int SCREENHEIGHT = 480;
    Thread gameloop;
    Random rand = new Random();

    //double buffer objects
    BufferedImage backbuffer;
    Graphics2D g2d;

    Image background;

    //sprite variables
    AnimatedSprite ball;

    private URL getURL(String filename) {
         URL url = null;
         try {
             url = this.getClass().getResource(filename);
         }
         catch (Exception e) {}
         return url;
    }

    public void init() {
        //create the back buffer for smooth graphics
        backbuffer = new BufferedImage(SCREENWIDTH, SCREENHEIGHT,
            BufferedImage.TYPE_INT_RGB);
        g2d = backbuffer.createGraphics();

        //load the background image
        Toolkit tk = Toolkit.getDefaultToolkit();
        background = tk.getImage(getURL("woodgrain.png"));

        //load the ball animation strip
        ball = new AnimatedSprite(this, g2d);
        ball.load("xball.png", 8, 8, 64, 64);
        ball.setPosition(new Point2D(300,200));
        ball.setFrameDelay(1);
        ball.setVelocity(new Point2D(1,1));
        ball.setRotationRate(1.0);
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
                Thread.sleep(5);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameUpdate();
            repaint();
        }
    }

    public void gameUpdate() {
        //see if it's time to animate
        ball.updateAnimation();

        //update the ball position
        ball.updatePosition();
        if ((ball.position().X() < 0) || (ball.position().X() > SCREENWIDTH - 64)) {
            double x = ball.velocity().X() * -1;
            ball.setVelocity(new Point2D(x, ball.velocity().Y()));
            x = ball.position().X();
            ball.setPosition(new Point2D(x, ball.position().Y()));
        }
        if ((ball.position().Y() < 0) || (ball.position().Y() > SCREENHEIGHT - 64)) {
            double y = ball.velocity().Y() * -1;
            ball.setVelocity(new Point2D(ball.velocity().X(), y));
            y = ball.position().Y() + ball.velocity().Y();
            ball.setPosition(new Point2D(ball.position().X(), y));
        }

        //lastly, update the rotation
        ball.updateRotation();
    }

    public void update(Graphics g) {
        //draw the background
        g2d.drawImage(background, 0, 0, SCREENWIDTH-1, SCREENHEIGHT-1, this);

        //draw the current frame of animation
        ball.draw();

        g2d.setColor(Color.BLACK);
        g2d.drawString("Position: " + ball.position().X() + "," +
                       ball.position().Y(), 5, 10);
        g2d.drawString("Velocity: " + ball.velocity().X() + "," +
                       ball.velocity().Y(), 5, 25);
        g2d.drawString("Animation: " + ball.currentFrame(), 5, 40);

        paint(g);
    }


    public void paint(Graphics g) {
        //draw the back buffer to the screen
        g.drawImage(backbuffer, 0, 0, this);
    }


}

