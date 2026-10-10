import java.awt.*;
import java.applet.*;

public class DataTypes extends Applet {

    //paint on the applet window
    public void paint(Graphics g) {
        //select a nice font
        g.setFont(new Font("Courier New", Font.PLAIN, 12));

        //display minimum and maximum values for numeric data types
        g.drawString("Byte   : " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE, 5, 20);
        g.drawString("Short  : " + Short.MIN_VALUE + " to " + Short.MAX_VALUE, 5, 35);
        g.drawString("Int    : " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE, 5, 50);
        g.drawString("Long   : " + Long.MIN_VALUE + " to " + Long.MAX_VALUE, 5, 65);
        g.drawString("Float  : " + Float.MIN_VALUE + " to " + Float.MAX_VALUE, 5, 80);
        g.drawString("Double : " + Double.MIN_VALUE + " to " + Double.MAX_VALUE, 5, 95);
    }

    public void test() {
        int[] gameLevel = {
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
        2, 1, 1, 1, 1, 1, 1, 1, 1, 2,
        2, 1, 1, 1, 1, 1, 1, 1, 1, 2,
        2, 1, 1, 1, 1, 1, 1, 1, 1, 2,
        2, 1, 1, 1, 1, 1, 1, 1, 1, 2,
        2, 1, 1, 1, 1, 1, 1, 1, 1, 2,
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2
    };

    }
}
