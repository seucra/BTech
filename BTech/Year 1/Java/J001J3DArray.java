public class J001J3DArray {
    public static void main(String[] args) {
        int a[][][] = new int[5][6][7];
        for(int i=0;i<5;i++){
            for(int j=0;j<6;j++){
                for(int k=0;k<7;k++){
                    a[i][j][k] = i+j+k;
                }
            }
        }
        
        for(int i=0;i<5;i++){
            System.out.println("Face "+i);
            for(int j=0;j<6;j++){
                for(int k=0;k<7;k++){
                    System.out.print("\t"+a[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
