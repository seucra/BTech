package Projects.Maths;

import java.util.*;
import java.io.*;

class Matrix{
    private int row, column;
    private double[][] data;

    // Constructors

    Matrix(int row, int column){
        if (row <= 0 || column <= 0){
            throw new IllegalArgumentException("Matrix Dimentions must be positive.");
        }
        this.row = row;
        this.column = column;
        this.data = new double[row][column];
    }

    Matrix(int row, int column, double[][] data){
        this(row, column);
        if (data == null || data.length != row || (data.length > 0 && data[0].length != column)){
            throw new IllegalArgumentException("Data Array dimentions do no match specified rows and column.");
        }
        for (int i=0; i<row; i++){
            System.arraycopy(data[i], 0, this.data[i], 0, column);
        }
    }

    Matrix(double[][] data) {
        if (data == null || data == null || data[0] == null){
            throw new IllegalArgumentException("Data Array dimentions do no match specified rows and column.");
        }
        this.row = data.length;
        this.column = data[0].length;
        for (int i=0; i<row; i++){
            System.arraycopy(data[i], 0, this.data[i], 0, column);
        }
    }

    // Setter Methords

    void setMatrix(double[][] data){
        if (data == null || data.length != this.row || data[0].length != row){
            throw new IllegalArgumentException("Data Array dimentions do not match Matrix dimentions");
        }
        for (int i=0; i<this.row; i++){
            System.arraycopy(data[i], 0, this.data[i], 0, column);
        }
    }

    void setValue(int row, int col, double data) {
        if (row <= 0 || row > this.row || col <= 0 || col> column){
            throw new IllegalArgumentException("Element index out of bounds.");
        }
        this.data[row][col] = data;
    }

    void setMatrix(List<int[]> rows, int i) {
        // Set data for each row in matrix
        for (int j = 0; j < rows.get(i).length; j++) {
            this.data[i][j] = rows.get(i)[j];
        }
    }

    // Getter Methords

    int getRow(){
        return row;
    }

    int getColumn(){
        return column;
    }

    // Add Matrix

    void addMatrix(Matrix m){
        if (m == null || m.row != this.row || m.column != this.column){
            throw new IllegalArgumentException("Matrices must have same diementions for Addition.");
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                data[i][j] += m.data[i][j];
            }
        }
    }

    static Matrix addMatrix(Matrix a, Matrix b){
        if (a == null || b==null || a.row != b.row || a.column != b.column){
            throw new IllegalArgumentException("Matrices must have same dimentions for Addition.");
        }
        Matrix x = new Matrix(a.row, a.column);
        for (int i=0; i<a.row; i++){
            for (int j=0; j<a.column; j++){
                x.data[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        return x;
    }

    // Substract Matrix

    void subMatrix(Matrix m){
        if (m == null || m.row != this.row || m.column != this.column){
            throw new IllegalArgumentException("Matrices must have same dimentions for Substraction");
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                data[i][j] -= m.data[i][j];
            }
        }
    }

    static Matrix subMatrix(Matrix a, Matrix b){
        if (a == null || b==null || a.row != b.row || a.column != b.column){
            throw new IllegalArgumentException("Matrices must have same dimentions for Substraction.");
        }
        Matrix x = new Matrix(a.row, a.column);
        for (int i=0; i<a.row; i++){
            for (int j=0; j<a.column; j++){
                x.data[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        return x;
    }

    void multiplyMatrix(Matrix m){
        if (m == null || this.column != m.row){
            throw new IllegalArgumentException("For Matrix Multiplication number of columns in first Matrix must be equal to number of rows in second Matrix");
        }
        Matrix x = new Matrix(this.row, m.column);
        for (int i=0; i<x.row; i++){
            for (int j=0; j<x.column; j++){
                for (int k=0; k<x.row; k++){
                    x.data[i][j] += this.data[i][k] * m.data[k][j];
                }
            }
        }
        this.row = x.row;
        this.column = x.column;
        this.data = x.data;
    }

    static Matrix multiplyMatrix(Matrix a, Matrix b){
        if (a == null || b == null || a.column != b.row){
            throw new IllegalArgumentException("For Matrix Multiplication number of columns in first Matrix must be equal to number of rows in second Matrix");
        }
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

    // Transpose of Matrix

    void transposeMatrix(){
        Matrix result = new Matrix(this.column, this.column);
        for(int i=0; i<this.row; i++){
            for (int j=0; j<this.column/2; j++){
                result.data[j][i] = this.data[i][j];
            }
        }
        this.row = result.row;
        this.column = result.column;
        this.data = result.data;
    }

    static Matrix transposeMatrix(Matrix x){
        if (x == null){
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        Matrix result = new Matrix(x.column, x.row);
        for(int i=0; i<x.row; i++){
            for (int j=0; j<x.column/2; j++){
                result.data[i][j] = x.data[j][i];
            }
        }
        return result;
    }

    // Scalar
    void scalarMultiply(double n){
        for (int i=0; i<this.row; i++){
            for (int j=0; j<this.column; j++){
                this.data[i][j] *= n;
            }
        }
    }

    // Determine Type of Matrix 
    String typeOfMatrix(){
        StringBuilder type = new StringBuilder();
        if (this.row == this.column){
            if (type.length() > 0)   type.append(", ");
            type.append("Square Matrix");
        }
        if (row == 1) {
            if (type.length() > 0) type.append(", ");
            type.append("Row Matrix");
        }
        if (column == 1) {
            if (type.length() > 0) type.append(", ");
            type.append("Column Matrix");
        }
        return type.length() > 0 ? type.toString() : "General Matrix";
    }

    // Minor
    Matrix minorMatrix(int row, int col){
        if (row <0 || row >= this.row || col < 0 || col >= this.column ){
            throw new IllegalArgumentException("Invalid Index for minor.");
        }
        Matrix minorMatrix = new Matrix(this.row -1, this.column -1);
        int minorRow =0;
        for(int i=0; i<this.row; i++){
            if (i == row)   continue;

            int minorColumn =0;
            for(int j=0; j<this.column; j++){
                if (j == col)       continue;

                minorMatrix.setValue(minorRow, minorColumn, this.data[i][j]);
                minorColumn++;
            }
            minorRow++;
        }
        return minorMatrix;
    }

/**
    // determinant using cofactor expansion
    double determinant() {
        if (this.row != this.column) {
            throw new IllegalArgumentException("Matrix must be square (rows == columns)");
        }

        // Base case for 1x1 matrix
        if (this.row == 1){
            return this.data[0][0];
        }
        // Base case for 2x2 matrix
        if (this.row == 2) {
            return (this.data[0][0] * this.data[1][1]) - (this.data[0][1] * this.data[1][0]);
        }

        double det = 0;

        // Loop for cofactor expansion along the first row
        for (int i = 0; i < this.column; i++) {
            det += (int) Math.pow(-1, i) * this.data[0][i] * minorMatrix(0, i).determinant();
        }

        return det;
    }
*/

    //determinant using gaussian elimination

    // Method to convert the matrix to upper triangular form
    public void toUpperTriangular() {
        for (int i = 0; i < this.row; i++) {
            // Find the pivot row (the one with the largest absolute value in column i)
            int pivotRow = i;
            for (int j = i + 1; j < this.row; j++) {
                if (Math.abs(data[j][i]) > Math.abs(data[pivotRow][i])) {
                    pivotRow = j;
                }
            }

            // If pivot is zero, skip this column, the matrix is singular
            if (data[pivotRow][i] == 0) {
                continue;
            }

            // Swap the current row with the pivot row
            if (pivotRow != i) {
                double[] temp = data[i];
                data[i] = data[pivotRow];
                data[pivotRow] = temp;
            }

            // Perform row operations to zero out elements below the pivot
            for (int j = i + 1; j < this.row; j++) {
                double factor = data[j][i] / data[i][i];
                for (int k = i; k < this.column; k++) {
                    data[j][k] -= factor * data[i][k];
                }
            }
        }
    }

    // Method to calculate rank using upper triangular form
    public int rank() {
        toUpperTriangular(); // Convert to upper triangular form
        int rank = 0;

        // Count non-zero rows in the upper triangular matrix
        for (int i = 0; i < this.row; i++) {
            boolean isNonZeroRow = false;
            for (int j = 0; j < this.column; j++) {
                if (data[i][j] != 0) {
                    isNonZeroRow = true;
                    break;
                }
            }
            if (isNonZeroRow) {
                rank++;
            }
        }

        return rank;
    }
    // Method to calculate the determinant from upper triangular form
    public double determinant() {
        toUpperTriangular();  // Convert matrix to upper triangular form

        double det = 1;
        for (int i = 0; i < this.row; i++) {
            det *= data[i][i];  // Multiply diagonal elements
        }

        return det;
    }

    // matrix adjecency
    Matrix adjMatrix(){
        Matrix adjecentMatrix = new Matrix(this.row, this.column);
        for (int i=0; i<this.row; i++){
            for (int j=0; j<this.column; j++){
                adjecentMatrix.data[i][j] = (Math.pow(-1, i+j) *  minorMatrix(i, j).determinant());
            }
        }
        return adjecentMatrix;
    }

    // matrix inversion
    Matrix inverseofMatrix(){
        double det = this.determinant();
        if (det == 0) {
            throw new ArithmeticException("Matrix is not invertible (determinant is zero)");
        }
        Matrix inverseMatrix =  this.adjMatrix();
        double temp = 1 / this.determinant();
        inverseMatrix.scalarMultiply(temp);
        return inverseMatrix;
    }

    // matrix rank
    void printMatrix() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void writeToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        writer.write(row + "," + column);
        writer.newLine();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                writer.write(String.valueOf(data[i][j]));
                if (i != row - 1 || j != column - 1) {
                    writer.write(",");
                }
            }
        }
    }
    }

    // Method to read matrix data from a file
    static Matrix readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        // Read matrix size
        String[] sizeParts = reader.readLine().split(",");
        int rows = Integer.parseInt(sizeParts[0].trim());
        int cols = Integer.parseInt(sizeParts[1].trim());

        // Read all numbers
        String[] values = reader.readLine().split(",");
        double[][] data = new double[rows][cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = Double.parseDouble(values[index++].trim());
            }
        }

        return new Matrix(rows, cols, data);
        }
    }
}

/**class MatrixOperations {
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
                    break;.
                default:
                    System.out.println("\t\tInvalid Input.\n");
                    break;
            }
        }
    }
}

*///
/**        double[][] matrixData = {
            {5, 3, 1, 4, 6, 2, 7},
            {2, 4, 7, 1, 8, 9, 3},
            {1, 5, 3, 9, 4, 7, 2},
            {6, 8, 4, 2, 1, 5, 9},
            {3, 9, 2, 7, 5, 6, 4},
            {4, 1, 5, 3, 9, 8, 6},
            {7, 2, 6, 5, 3, 4, 1}
        };
*/
    public class MatrixOperations {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            // User input for matrix dimensions and values
            System.out.print("Enter the number of rows for the matrix: ");
            int rows = sc.nextInt();
            System.out.print("Enter the number of columns for the matrix: ");
            int cols = sc.nextInt();
    
            // Create and populate first matrix
            double[][] data1 = new double[rows][cols];
            System.out.println("Enter values for the first matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Enter value for matrix1[" + (i+1) + "][" + (j+1) + "]: ");
                    data1[i][j] = sc.nextDouble();
                }
            }
    
            // Create and populate second matrix
            double[][] data2 = new double[rows][cols];
            System.out.println("Enter values for the second matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Enter value for matrix2[" + (i+1) + "][" + (j+1) + "]: ");
                    data2[i][j] = sc.nextDouble();
                }
            }
    
            Matrix matrix1 = new Matrix(rows, cols, data1);
            Matrix matrix2 = new Matrix(rows, cols, data2);
    
            int choice = 0;
            while (true) {
                System.out.println("\n=============================");
                System.out.println("Matrix Operations Menu:");
                System.out.println("1. Add Matrices");
                System.out.println("2. Subtract Matrices");
                System.out.println("3. Multiply Matrices");
                System.out.println("4. Transpose Matrix");
                System.out.println("5. Display Matrix");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
    
                switch (choice) {
                    case 1: // Add matrices
                        Matrix resultAdd = Matrix.addMatrix(matrix1, matrix2);
                        System.out.println("Matrix Addition Result:");
                        resultAdd.printMatrix();
                        break;
    
                    case 2: // Subtract matrices
                        Matrix resultSub = Matrix.subMatrix(matrix1, matrix2);
                        System.out.println("Matrix Subtraction Result:");
                        resultSub.printMatrix();
                        break;
    
                    case 3: // Multiply matrices
                        Matrix resultMul = Matrix.multiplyMatrix(matrix1, matrix2);
                        System.out.println("Matrix Multiplication Result:");
                        resultMul.printMatrix();
                        break;
    
                    case 4: // Transpose matrix
                        System.out.println("Transpose of Matrix 1:");
                        Matrix transposed = Matrix.transposeMatrix(matrix1);
                        transposed.printMatrix();
                        break;
    
                    case 5: // Display matrix
                        System.out.println("Displaying Matrix 1:");
                        matrix1.printMatrix();
                        break;
    
                    case 6: // Exit
                        System.out.println("Exiting...");
                        sc.close();
                        return;
    
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }