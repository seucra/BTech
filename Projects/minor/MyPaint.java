import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MyPaint extends Applet implements MouseListener, MouseMotionListener, KeyListener {
    private ArrayList<int[]> points = new ArrayList<>();
    private Color myc = Color.blue;

    public void init() {
        setBackground(Color.black);
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setFocusable(true);
        System.out.println("Applet Initialized");
    }

    public void start() {
        System.out.println("Applet Started");
    }

    public void paint(Graphics g) {
        g.setColor(myc);

        for(int i=1; i<points.size(); i++) {
            int[] prev = points.get(i-1);
            int[] cur  = points.get(i);
            g.drawLine(prev[0], prev[1], cur[0], cur[1]);
        }
    }

    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2) {
            points.clear();
            repaint();
        }
        else{
            points.add(new int[] {e.getX(), e.getY()});
            repaint();
        }
    }

    public void mouseDragged(MouseEvent e){
        points.add(new int[]{e.getX(), e.getY()});
        repaint();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}

    public void keyPressed(KeyEvent e) {
        char g = e.getKeyChar();
        if (g == 'r' || g == 'R') {
            myc = Color.red;
        }
        if (g == 'b' || g == 'B') {
            myc = Color.blue;
        }
        if (g == 'y' || g == 'Y') {
            myc = Color.yellow;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public void stop() {
        System.out.println("Applet Stopped");
    }
    
    public void destroy() {
        System.out.println("Applet Destroyed");
    }
}