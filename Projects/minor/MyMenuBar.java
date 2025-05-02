import javax.swing.*;

public class MyMenuBar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MenuBar Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");

        fileMenu.add(newItem);
        fileMenu.add(openItem);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}
