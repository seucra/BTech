import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Line {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }
}

public class SimplePaint extends JFrame {
    private ArrayList<Line> lines = new ArrayList<Line>();
    private int startx, starty;

    public SimplePaint() {
        setTitle("Simple Paint");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                for (Line line : lines) {
                    line.draw(g);
                }
            }
        };
        canvas.setBackground(Color.WHITE);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    lines.clear();
                    repaint();
                }
                else{
                    startx = e.getX();
                    starty = e.getY();
                }
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int endX = e.getX();
                int endY = e.getY();
                lines.add(new Line(startx, starty, endX, endY));
                startx = endX;
                starty = endY;
                canvas.repaint();
            }
        });

        add(canvas);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new SimplePaint().setVisible(true));
    }
}