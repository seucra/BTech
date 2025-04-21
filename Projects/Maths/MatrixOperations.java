import java.util.*;


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
*/
        int[][] data = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        Matrix matrix = new Matrix(4, 4, data);
        System.out.println("Determinant: " + matrix.determinant());
    }
}
