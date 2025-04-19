class cirlce{
    double x,y;
    double r;

    double Circumference(){
        return 2*3.14159*r;
    }
    double Area(){
        return (22/7)*r*r;
    }
}

class J101JEncapsulation {
    public static void main(String args[]){
        cirlce c = new cirlce();
        c.x = 0.0;
        c.y = 0.0;
        c.r = 5.0;
        System.out.println("Circumference = "+c.Circumference());
        System.out.println("Area = "+c.Area());
    }
}
