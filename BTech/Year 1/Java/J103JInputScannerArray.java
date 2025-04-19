import java.util.ArrayList;
import java.util.Scanner;

public class J103JInputScannerArray {
    public static void main(String[] args) {
        int sum = 0;    int avg = 0;

        //New way of defining Array
        ArrayList <Integer> arr = new ArrayList<Integer>();
        
        System.out.print("Enter Input : ");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt())
            arr.add(sc.nextInt());
        for (int i=0; i<arr.size(); i++)
            sum += arr.get(i);
        avg = sum / arr.size();
        System.out.println("Sum = "+sum+"\nAvrage = "+avg);
    }
}
