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

class J101JEncapsulationMultiObjects {
    public static void main(String args[]){
        cirlce c1 = new cirlce();
        cirlce c2 = new cirlce();

        c1.x = 0.0;
        c1.y = 0.0;
        c1.r = 5.0;

        c2.x = 1.1;
        c2.y = 2.2;
        c2.r = 6.6;

        System.out.println("Circumference 1 = "+c1.Circumference());
        System.out.println("Area 1 = "+c1.Area());
        System.out.println("Circumference 2 = "+c2.Circumference());
        System.out.println("Area 2 = "+c2.Area());

    }
}
