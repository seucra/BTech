class A{
    A(){
        this(5);
        System.out.println("hello a");
    }
    A(int x){
        System.out.println(x);
    }
}

class J102JthisKeywordSpecialUse {
    public static void main(String[] args) {
        A a = new A();
    }
}
