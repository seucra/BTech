//Passing Values

import java.applet.Applet;
import java.awt.Graphics;

public class PassingValues extends Applet{
    public void paint(Graphics g){

        int x=0;
        int y=0;
        String msg="";

        x = Integer.parseInt(getParameter("xPos"));
        y = Integer.parseInt(getParameter("yPos"));
        msg = getParameter("msg");

        g.drawString(msg, x, y);
    }
}
