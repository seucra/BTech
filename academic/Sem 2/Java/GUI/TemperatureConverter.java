import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperatureConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField celsiusField = new JTextField(5);
        JTextField fahrenheitField = new JTextField(5);
        fahrenheitField.setEditable(false);
        JButton convertButton = new JButton("Convert");

        ArrayList<String> hist = new ArrayList<>();

        panel.add(new JLabel("Celsius:"));
        panel.add(celsiusField);
        panel.add(new JLabel("Fahrenheit:"));
        panel.add(fahrenheitField);
        panel.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celsiusField.getText());
                    if (celsius < -273.15) {
                        throw new NumberFormatException("Temperature below absolute zero");
                    }
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    fahrenheitField.setText("" + fahrenheit);

                    String rec = celsius + "*C = " + fahrenheit + "*F";
                    hist.add(rec);
                    System.out.println("History: "+rec);
                } catch (NumberFormatException ex) {
                    fahrenheitField.setText("Error");
                    System.out.println("Invalid input: " + ex.getMessage());
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}