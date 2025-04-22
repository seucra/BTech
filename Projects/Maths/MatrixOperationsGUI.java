import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/*class Matrix {
    private int row, column;
    private int[][] data;

    Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.data = new int[row][column];
    }

    Matrix(int row, int column, int[][] data) {
        this(row, column);
        this.data = data;
    }

    void setValue(int row, int col, int value) {
        if (row >= 0 && row < this.row && col >= 0 && col < this.column) {
            data[row][col] = value;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid row or column index.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    int[][] getData() {
        return data;
    }

    static Matrix addMatrix(Matrix a, Matrix b) {
        if (a.row == b.row && a.column == b.column) {
            Matrix result = new Matrix(a.row, a.column);
            for (int i = 0; i < a.row; i++) {
                for (int j = 0; j < a.column; j++) {
                    result.data[i][j] = a.data[i][j] + b.data[i][j];
                }
            }
            return result;
        } else {
            JOptionPane.showMessageDialog(null, "Matrices must have the same dimensions for addition.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    static Matrix subMatrix(Matrix a, Matrix b) {
        if (a.row == b.row && a.column == b.column) {
            Matrix result = new Matrix(a.row, a.column);
            for (int i = 0; i < a.row; i++) {
                for (int j = 0; j < a.column; j++) {
                    result.data[i][j] = a.data[i][j] - b.data[i][j];
                }
            }
            return result;
        } else {
            JOptionPane.showMessageDialog(null, "Matrices must have the same dimensions for subtraction.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    static Matrix multiplyMatrix(Matrix a, Matrix b) {
        if (a.column == b.row) {
            Matrix result = new Matrix(a.row, b.column);
            for (int i = 0; i < result.row; i++) {
                for (int j = 0; j < result.column; j++) {
                    for (int k = 0; k < a.column; k++) {
                        result.data[i][j] += a.data[i][k] * b.data[k][j];
                    }
                }
            }
            return result;
        } else {
            JOptionPane.showMessageDialog(null, "Number of columns in the first matrix must equal the number of rows in the second.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    Matrix transposeMatrix() {
        Matrix transposed = new Matrix(this.column, this.row);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                transposed.data[j][i] = this.data[i][j];
            }
        }
        return transposed;
    }

    void scalarMultiplyMatrix(int n) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                this.data[i][j] *= n;
            }
        }
    }

    public Matrix minorMatrix(int row, int col) {
        Matrix minorMatrix = new Matrix(this.row - 1, this.column - 1);
        int minorRow = 0;
        for (int i = 0; i < this.row; i++) {
            if (i == row) continue;
            int minorCol = 0;
            for (int j = 0; j < this.column; j++) {
                if (j == col) continue;
                minorMatrix.setValue(minorRow, minorCol, this.data[i][j]);
                minorCol++;
            }
            minorRow++;
        }
        return minorMatrix;
    }

    public int determinant() {
        if (this.row != this.column) {
            JOptionPane.showMessageDialog(null, "Matrix must be square to calculate the determinant.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        if (this.row == 1) return this.data[0][0];
        if (this.row == 2) return this.data[0][0] * this.data[1][1] - this.data[0][1] * this.data[1][0];

        int det = 0;
        for (int i = 0; i < this.column; i++) {
            det += Math.pow(-1, i) * this.data[0][i] * minorMatrix(0, i).determinant();
        }
        return det;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int val : row) {
                sb.append(String.format("%-5d", val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class MatrixOperationsGUI extends JFrame implements ActionListener {
    private List<Matrix> storedMatrices = new ArrayList<Matrix>();
    private JTextArea outputArea;
    private JList<String> matrixList;
    private DefaultListModel<String> listModel;

    public MatrixOperationsGUI() {
        setTitle("Matrix Operations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<String>();
        matrixList = new JList<String>(listModel);
        add(new JScrollPane(matrixList), BorderLayout.WEST);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridLayout(2, 4));
        String[] buttons = { "Create", "View", "Add", "Subtract", "Multiply", "Scalar Multiply", "Transpose", "Determinant" };
        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton(buttons[i]);
            btn.addActionListener(this);
            controlPanel.add(btn);
        }

        add(controlPanel, BorderLayout.NORTH);
        setVisible(true);
    }

    private void createNewMatrixDialog() {
        JTextField rowField = new JTextField(5);
        JTextField colField = new JTextField(5);
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Rows:"));
        panel.add(rowField);
        panel.add(new JLabel("Columns:"));
        panel.add(colField);

        if (JOptionPane.showConfirmDialog(this, panel, "Create Matrix", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                int rows = Integer.parseInt(rowField.getText());
                int cols = Integer.parseInt(colField.getText());
                if (rows <= 0 || cols <= 0) throw new NumberFormatException();

                int[][] data = new int[rows][cols];
                JPanel dataPanel = new JPanel(new GridLayout(rows, cols));
                JTextField[][] fields = new JTextField[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        fields[i][j] = new JTextField(3);
                        dataPanel.add(fields[i][j]);
                    }
                }

                if (JOptionPane.showConfirmDialog(this, new JScrollPane(dataPanel), "Enter Matrix Values", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            data[i][j] = Integer.parseInt(fields[i][j].getText());
                        }
                    }
                    Matrix m = new Matrix(rows, cols, data);
                    storedMatrices.add(m);
                    listModel.addElement("Matrix " + storedMatrices.size() + " (" + rows + "x" + cols + ")");
                    outputArea.append("Created Matrix " + storedMatrices.size() + ":\n" + m + "\n");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid dimensions or data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Matrix getSelectedMatrix() {
        int idx = matrixList.getSelectedIndex();
        if (idx >= 0 && idx < storedMatrices.size()) return storedMatrices.get(idx);
        JOptionPane.showMessageDialog(this, "Select one matrix.", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    private Matrix[] getTwoSelectedMatrices() {
        int[] idx = matrixList.getSelectedIndices();
        if (idx.length == 2) return new Matrix[] { storedMatrices.get(idx[0]), storedMatrices.get(idx[1]) };
        JOptionPane.showMessageDialog(this, "Select exactly two matrices.", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Create")) {
            createNewMatrixDialog();
        } else if (cmd.equals("View")) {
            Matrix m = getSelectedMatrix();
            if (m != null) outputArea.append("Selected Matrix:\n" + m + "\n");
        } else if (cmd.equals("Add")) {
            Matrix[] m = getTwoSelectedMatrices();
            if (m != null) addResult(Matrix.addMatrix(m[0], m[1]), "Addition");
        } else if (cmd.equals("Subtract")) {
            Matrix[] m = getTwoSelectedMatrices();
            if (m != null) addResult(Matrix.subMatrix(m[0], m[1]), "Subtraction");
        } else if (cmd.equals("Multiply")) {
            Matrix[] m = getTwoSelectedMatrices();
            if (m != null) addResult(Matrix.multiplyMatrix(m[0], m[1]), "Multiplication");
        } else if (cmd.equals("Transpose")) {
            Matrix m = getSelectedMatrix();
            if (m != null) addResult(m.transposeMatrix(), "Transpose");
        } else if (cmd.equals("Scalar Multiply")) {
            Matrix m = getSelectedMatrix();
            if (m != null) {
                String input = JOptionPane.showInputDialog(this, "Enter scalar:");
                try {
                    int scalar = Integer.parseInt(input);
                    m.scalarMultiplyMatrix(scalar);
                    outputArea.append("Matrix scaled by " + scalar + ":\n" + m + "\n");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Invalid scalar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (cmd.equals("Determinant")) {
            Matrix m = getSelectedMatrix();
            if (m != null) outputArea.append("Determinant: " + m.determinant() + "\n");
        }
    }

    private void addResult(Matrix result, String operation) {
        if (result != null) {
            storedMatrices.add(result);
            listModel.addElement("Matrix " + storedMatrices.size() + " (" + result.getRow() + "x" + result.getColumn() + ")");
            outputArea.append(operation + " Result:\n" + result + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MatrixOperationsGUI();
            }
        });
    }
}
*/
class Matrix {
    private int row, column;
    private int[][] data;

    Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.data = new int[row][column];
    }

    Matrix(int row, int column, int[][] data) {
        this(row, column);
        this.data = data;
    }

    void setValue(int row, int col, int value) {
        if (row >= 0 && row < this.row && col >= 0 && col < this.column) {
            data[row][col] = value;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid row or column index.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    int[][] getData() {
        return data;
    }

    static Matrix addMatrix(Matrix a, Matrix b) {
        if (a.row == b.row && a.column == b.column) {
            Matrix result = new Matrix(a.row, a.column);
            for (int i = 0; i < a.row; i++) {
                for (int j = 0; j < a.column; j++) {
                    result.data[i][j] = a.data[i][j] + b.data[i][j];
                }
            }
            return result;
        } else {
            JOptionPane.showMessageDialog(null, "Matrices must have the same dimensions for addition.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    static Matrix subMatrix(Matrix a, Matrix b) {
        if (a.row == b.row && a.column == b.column) {
            Matrix result = new Matrix(a.row, a.column);
            for (int i = 0; i < a.row; i++) {
                for (int j = 0; j < a.column; j++) {
                    result.data[i][j] = a.data[i][j] - b.data[i][j];
                }
            }
            return result;
        } else {
            JOptionPane.showMessageDialog(null, "Matrices must have the same dimensions for subtraction.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    static Matrix multiplyMatrix(Matrix a, Matrix b) {
        if (a.column == b.row) {
            Matrix result = new Matrix(a.row, b.column);
            for (int i = 0; i < result.row; i++) {
                for (int j = 0; j < result.column; j++) {
                    for (int k = 0; k < a.column; k++) {
                        result.data[i][j] += a.data[i][k] * b.data[k][j];
                    }
                }
            }
            return result;
        } else {
            JOptionPane.showMessageDialog(null, "Number of columns in the first matrix must equal the number of rows in the second.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    Matrix transposeMatrix() {
        Matrix transposed = new Matrix(this.column, this.row);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                transposed.data[j][i] = this.data[i][j];
            }
        }
        return transposed;
    }

    void scalarMultiplyMatrix(int n) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                this.data[i][j] *= n;
            }
        }
    }

    public Matrix minorMatrix(int row, int col) {
        Matrix minorMatrix = new Matrix(this.row - 1, this.column - 1);
        int minorRow = 0;
        for (int i = 0; i < this.row; i++) {
            if (i == row) continue;
            int minorCol = 0;
            for (int j = 0; j < this.column; j++) {
                if (j == col) continue;
                minorMatrix.setValue(minorRow, minorCol, this.data[i][j]);
                minorCol++;
            }
            minorRow++;
        }
        return minorMatrix;
    }

    public int determinant() {
        if (this.row != this.column) {
            JOptionPane.showMessageDialog(null, "Matrix must be square to calculate the determinant.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        if (this.row == 1) return this.data[0][0];
        if (this.row == 2) return this.data[0][0] * this.data[1][1] - this.data[0][1] * this.data[1][0];

        int det = 0;
        for (int i = 0; i < this.column; i++) {
            det += Math.pow(-1, i) * this.data[0][i] * minorMatrix(0, i).determinant();
        }
        return det;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            sb.append("| ");
            for (int val : row) {
                sb.append(String.format("%-5d", val));
            }
            sb.append("|\n");
        }
        return sb.toString();
    }
}

public class MatrixOperationsGUI extends JFrame implements ActionListener {
    private List<Matrix> storedMatrices = new ArrayList<>();
    private JTextArea outputArea;
    private JList<String> matrixList;
    private DefaultListModel<String> listModel;

    public MatrixOperationsGUI() {
        setTitle("Matrix Operations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        matrixList = new JList<>(listModel);
        add(new JScrollPane(matrixList), BorderLayout.WEST);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));  // Set monospaced font for readability
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridLayout(2, 4));
        String[] buttons = { "Create", "View", "Add", "Subtract", "Multiply", "Scalar Multiply", "Transpose", "Determinant" };
        for (String label : buttons) {
            JButton btn = new JButton(label);
            btn.addActionListener(this);
            controlPanel.add(btn);
        }

        add(controlPanel, BorderLayout.NORTH);
        setVisible(true);
    }

    private void createNewMatrixDialog() {
        JTextField rowField = new JTextField(5);
        JTextField colField = new JTextField(5);
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Rows:"));
        panel.add(rowField);
        panel.add(new JLabel("Columns:"));
        panel.add(colField);

        if (JOptionPane.showConfirmDialog(this, panel, "Create Matrix", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                int rows = Integer.parseInt(rowField.getText());
                int cols = Integer.parseInt(colField.getText());
                if (rows <= 0 || cols <= 0) throw new NumberFormatException();

                int[][] data = new int[rows][cols];
                JPanel dataPanel = new JPanel(new GridLayout(rows, cols));
                JTextField[][] fields = new JTextField[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        fields[i][j] = new JTextField(3);
                        dataPanel.add(fields[i][j]);
                    }
                }

                if (JOptionPane.showConfirmDialog(this, new JScrollPane(dataPanel), "Enter Matrix Values", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            data[i][j] = Integer.parseInt(fields[i][j].getText());
                        }
                    }
                    Matrix m = new Matrix(rows, cols, data);
                    storedMatrices.add(m);
                    listModel.addElement("Matrix " + storedMatrices.size() + " (" + rows + "x" + cols + ")");
                    outputArea.append("Created Matrix " + storedMatrices.size() + ":\n" + m + "\n");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid dimensions or data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Matrix getSelectedMatrix() {
        int idx = matrixList.getSelectedIndex();
        if (idx >= 0 && idx < storedMatrices.size()) return storedMatrices.get(idx);
        JOptionPane.showMessageDialog(this, "Select one matrix.", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    private Matrix[] getTwoSelectedMatrices() {
        int[] idx = matrixList.getSelectedIndices();
        if (idx.length == 2) return new Matrix[] { storedMatrices.get(idx[0]), storedMatrices.get(idx[1]) };
        JOptionPane.showMessageDialog(this, "Select exactly two matrices.", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Create")) {
            createNewMatrixDialog();
        } else if (cmd.equals("View")) {
            Matrix m = getSelectedMatrix();
            if (m != null) outputArea.append("Selected Matrix:\n" + m + "\n");
        } else if (cmd.equals("Add")) {
            Matrix[] m = getTwoSelectedMatrices();
            if (m != null) addResult(Matrix.addMatrix(m[0], m[1]), "Addition");
        } else if (cmd.equals("Subtract")) {
            Matrix[] m = getTwoSelectedMatrices();
            if (m != null) addResult(Matrix.subMatrix(m[0], m[1]), "Subtraction");
        } else if (cmd.equals("Multiply")) {
            Matrix[] m = getTwoSelectedMatrices();
            if (m != null) addResult(Matrix.multiplyMatrix(m[0], m[1]), "Multiplication");
        } else if (cmd.equals("Transpose")) {
            Matrix m = getSelectedMatrix();
            if (m != null) addResult(m.transposeMatrix(), "Transpose");
        } else if (cmd.equals("Scalar Multiply")) {
            Matrix m = getSelectedMatrix();
            if (m != null) {
                String input = JOptionPane.showInputDialog(this, "Enter scalar:");
                try {
                    int scalar = Integer.parseInt(input);
                    m.scalarMultiplyMatrix(scalar);
                    outputArea.append("Matrix scaled by " + scalar + ":\n" + m + "\n");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Invalid scalar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (cmd.equals("Determinant")) {
            Matrix m = getSelectedMatrix();
            if (m != null) outputArea.append("Determinant: " + m.determinant() + "\n");
        }
    }

    private void addResult(Matrix result, String operation) {
        if (result != null) {
            storedMatrices.add(result);
            listModel.addElement("Matrix " + storedMatrices.size() + " (" + result.getRow() + "x" + result.getColumn() + ")");
            outputArea.append(operation + " Result:\n" + result + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MatrixOperationsGUI());
    }
}
