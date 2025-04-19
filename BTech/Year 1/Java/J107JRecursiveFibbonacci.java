class J107JRecursiveFibbonacci {
    static class RecFibbo{
        int n;
        int fibbonacci(int n){
            if (n==0)   return 0;
            else if (n==1)  return 1;
            else    return fibbonacci(n-1)+fibbonacci(n-2);
        }
        static void _main_(String args[]){
            RecFibbo x = new RecFibbo();
            x.n = Integer.parseInt(args[0]);
            for(int i=0; i<x.n; i++){
                System.out.println(i+"\t"+x.fibbonacci(i));
            }
        }
    }
    public static void main(String[] args) {
        RecFibbo._main_(args);
    }
}
