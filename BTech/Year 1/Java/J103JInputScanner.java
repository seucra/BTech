import java.util.Scanner;

class J103JInputScanner {
    public static void main(String[] args) {
        //Construct scanner class object
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number = ");
        int num;

        //read number
        num = sc.nextInt();

        System.out.println("Your no. = "+num);
        System.exit(0);
    }
}
