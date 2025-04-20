//	First Java Applet
//	Applet to print hello world

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Background extends Applet{
	public void init(){
		setBackground(Color.RED);
	}

	public void paint(Graphics g){
		g.drawString("Hello World!",0,50);
	}
}
