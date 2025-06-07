class J107JRecursiveFactorial {
    int n;
    long factorical(int n){
        if(n==0 || n==1)
            return 1;
        else
            return n*factorical(n-1);
    }

    public static void main(String[] args) {
        J107JRecursiveFactorial x = new J107JRecursiveFactorial();
        x.n = Integer.parseInt(args[0]);
        System.out.println("Factorial of "+x.n+" is : "+x.factorical(x.n));
    }
}
