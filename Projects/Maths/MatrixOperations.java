import java.util.*;
import java.io.*;

class Matrix{
    private int row, column;
    private int[][] data;

    Matrix(int row, int column){
        this.row = row;
        this.column = column;
        this.data = new int[row][column];
    }
    Matrix(int row, int column, int[][] data){
        this(row, column);
        this.data = data;
    }

    void setMatrix(int[][] data){
        this.data = data;
    }
    void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    int getRow(){
        return row;
    }
    int getColumn(){
        return column;
    }

    void addMatrix(Matrix m){
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                data[i][j] += m.data[i][j];
            }
        }
    }
    static Matrix addMatrix(Matrix a, Matrix b){
        Matrix x = new Matrix(a.row, a.column);
        for (int i=0; i<a.row; i++){
            for (int j=0; j<a.column; j++){
                x.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        return b;
    }
    void subMatrix(Matrix m){
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                data[i][j] -= m.data[i][j];
            }
        }
    }
    static Matrix subMatrix(Matrix a, Matrix b){
        Matrix x = new Matrix(a.row, a.column);
        for (int i=0; i<a.row; i++){
            for (int j=0; j<a.column; j++){
                x.data[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        return b;
    }
    void multiplyMatrix(Matrix m){
        Matrix x = new Matrix(this.row, m.column);
        for (int i=0; i<x.row; i++){
            for (int j=0; j<x.column; j++){
                for (int k=0; k<x.row; k++){
                    x.data[i][j] += this.data[i][k] * m.data[k][j];
                }
            }
        }
        this.row = x.row;   this.column = x.column;
        this.data = x.data;
    }
    static Matrix multiplyMatrix(Matrix a, Matrix b){
        Matrix x = new Matrix(a.row, b.column);
        for (int i=0; i<x.row; i++){
            for (int j=0; j<x.column; j++){
                for (int k=0; k<x.row; k++){
                    x.data[i][j] += a.data[i][k] * b.data[k][j];
                }
            }
        }
        return x;
    }
    void transposeMatrix(){
        int temp;
        for(int i=0; i<this.row; i++){
            for (int j=0; j<this.column/2; j++){
                temp = this.data[i][j];
                this.data[i][j] = this.data[j][i];
                this.data[j][i] = temp;
            }
        }
    }
    static Matrix transposeMatrix(Matrix x){
        int temp;
        for(int i=0; i<x.row; i++){
            for (int j=0; j<x.column/2; j++){
                temp = x.data[i][j];
                x.data[i][j] = x.data[j][i];
                x.data[j][i] = temp;
            }
        }
        return x;
    }
    void scalarMultiplyMatrix(int n){
        for (int i=0; i<this.row; i++){
            for (int j=0; j<this.column; j++){
                this.data[i][j] *= n;
            }
        }
    }
    String typeOfMatrix(){
        String type = "";
        if (this.row == this.column)    type.concat("\tSquare Matrix");
        if (this.row == 1)              type.concat("\tRow Matrix");
        if (this.column ==1)            type.concat("\tColumn Matrix");
        
        return type;
    }

    // Minor
    public Matrix minorMatrix(int row, int col){
        Matrix minorMatrix = new Matrix(this.row -1, this.column -1);
        
        int minorRow =0;
        for(int i=0; i<this.row; i++){
            if (i == row)   continue;

            int minorColumn =0;
            for(int j=0; j<this.row; j++){
                if (j == col)       continue;

                minorMatrix.setValue(minorRow, minorColumn, this.data[i][j]);
                minorColumn++;
            }
            minorRow++;
        }

        return minorMatrix;
    }
    // determinant using cofactor expansion
    public int determinant() {
        if (this.row != this.column) {
            throw new IllegalArgumentException("Matrix must be square (rows == columns)");
        }

        // Base case for 2x2 matrix
        if (this.row == 2) {
            return (this.data[0][0] * this.data[1][1]) - (this.data[0][1] * this.data[1][0]);
        }

        int det = 0;

        // Loop for cofactor expansion along the first row
        for (int i = 0; i < this.row; i++) {
            det += (int) Math.pow(-1, i) * this.data[0][i] * minorMatrix(0, i).determinant();
        }

        return det;
    }

    // matrix inversion
    // matrix rank

    public void printMatrix() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void writeToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.column; j++) {
                    writer.write(data[i][j] + " ");  // Writing each element separated by a space
                }
                writer.newLine();  // Move to the next line after each row
            }
        }
    }

    // Method to read matrix data from a file
    static Matrix readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            List<int[]> rows = new ArrayList<>();  // List to store rows as int arrays
    
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");  // Split line into string elements
                int[] row = new int[tokens.length]; // Create a new row for the matrix
    
                // Convert string elements to integers and store them in the row
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Integer.parseInt(tokens[i]);
                }
                rows.add(row);  // Add the row to the list
            }
    
            // Determine matrix dimensions (rows and columns)
            int rowCount = rows.size();
            int columnCount = rows.get(0).length;
    
            // Create a new Matrix object with the appropriate dimensions
            Matrix matrix = new Matrix(rowCount, columnCount);
    
            // Fill the matrix with data
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    matrix.setValue(i, j, rows.get(i)[j]);  // Set each element in the matrix
                }
            }
    
            return matrix;  // Return the populated matrix
        }
    }

    void setMatrix(List<int[]> rows, int i) {
        // Set data for each row in matrix
        for (int j = 0; j < rows.get(i).length; j++) {
            this.data[i][j] = rows.get(i)[j];
        }
    }
}

class MatrixOperations {
    public static void main(String[] args) {
/**
        Scanner sc = new Scanner(System.in);
        Matrix[] matrixs = new Matrix[20];
        
        int choice = 0;
        while(1){
            System.out.println("\n=======================================\n");
            sc.nextLine();
            System.out.println("1. Stored Matrixs\n2. Type of Matrix\n3. Matrix Operations\n4. Exit");
            choice = sc.nextInt();
            if (choice == 4){
                System.out.println("\n\nExiting...");
                break;
            }
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("1. View Matrix Stored\n2. Add new Matrix\n 3. Remove a Matrix\nAny other key to Go Back");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            
                            break;
                    
                        default:
                            break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\t\tInvalid Input.\n");
                    break;
            }
        }
*///
try {
    // Create a sample matrix
    Matrix m = new Matrix(3, 3);
    m.setValue(0, 0, 1);
    m.setValue(0, 1, 2);
    m.setValue(0, 2, 3);
    m.setValue(1, 0, 4);
    m.setValue(1, 1, 5);
    m.setValue(1, 2, 6);
    m.setValue(2, 0, 7);
    m.setValue(2, 1, 8);
    m.setValue(2, 2, 9);
    
    // Write the matrix to a file
    m.writeToFile("matrix.txt");

    // Read the matrix from the file
    Matrix readMatrix = Matrix.readFromFile("matrix.txt");

    // Print the matrix read from file
    readMatrix.printMatrix();

} catch (IOException e) {
    e.printStackTrace();
}
    }
}
