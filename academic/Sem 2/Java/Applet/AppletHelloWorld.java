//	First Java Applet
//	Applet to print hello world

import java.applet.Applet;
import java.awt.Graphics;

public class AppletHelloWorld extends Applet{
	public void init(){
		resize(200,200);
	}

	public void paint(Graphics g){
		g.drawString("Hello World!",150,150);
	}
}
