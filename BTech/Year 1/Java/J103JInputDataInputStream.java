import java.io.*;

//Calculator Program
class J103JInputDataInputStream {
    public static void main(String[] args) {
        Float pAmt = new Float(0);
        Float roInterst = new Float(0);
        int noofYears = 0;

        //Create object of Data Input Stream
        DataInputStream in = new DataInputStream(System.in);

        String tempString;
        System.out.print("Enter Ammount = ");
        
        //Clear the buffer
        System.out.flush();
        tempString = in.readLine();
        pAmt = Float.valueOf(tempString);
        
        System.out.print("Enter Rate Of Interest = ");
        System.out.flush();
        tempString = in.readLine();
        roInterst = Float.valueOf(tempString);
        
        System.out.print("Enter Number of Years = ");
        System.out.flush();
        tempString = in.readLine();
        noofYears = Integer.parseInt(tempString);
        
        float intrestTotal = pAmt*roInterst*noofYears;
        System.out.println("total intrest = "+intrestTotal);
    }
}
