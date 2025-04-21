import java.util.*;

import org.omg.CORBA.MARSHAL;

import java.io.File;

class Matrix{
    private int row, column;
    private int[][] data;

    Matrix(int row, int column){
        this.row = row;
        this.column = column;
        this.data = new int[row][column];
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

    // determinant 
    int determinant(){
        int det = 0;
        int t=1;    
        int c=0;
        //  row == column
        for (int i=0; i<this.row; i++){
            for (int j=0; j<this.row; j++){
                t *= this.data[(i+c) % this.row][(j+c) % this.row];
                c++;
            }
            c=0;
        }
        det += t;
        t=1;
        for (int i=0; i<this.row; i++){
            for (int j=this.row-1; j>=0; j--){
                t *= this.data[(i+c) % this.row][(j+c) % this.row];
                c++;
            }
            c=0;
        }
        return det;
    }
    // matrix inversion
    // matrix rank

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

}

class MatrixOperations {
    public static void main(String[] args) {

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
    }
}
