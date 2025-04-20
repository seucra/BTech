import java.applet.Applet;
import java.awt.Graphics;

public class EmbeddedHtml extends Applet{
	public void paint(Graphics g){
		g.drawString("Hello World!",150,150);
	}
}

/*
    <applet code="EmbeddedHtml" width="400" height="400">
	</applet>
*/