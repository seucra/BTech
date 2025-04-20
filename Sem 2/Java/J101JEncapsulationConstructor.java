class circle{
    double x,y;
    double r;

    double Circumference(){
        return 2*3.14159*r;
    }
    double Area(){
        return (22/7)*r*r;
    }

    circle(double a, double b, double c){
        x = a;  y = b;  r = c;
    }
}

class J101JEncapsulationConstructor {
    public static void main(String[] args) {
        circle c1 = new circle(0.0, 0.0, 5.0);
        circle c2 = new circle(1.1, 2.2, 6.6);

        System.out.println("Circumference 1 = "+c1.Circumference());
        System.out.println("Area 1 = "+c1.Area());
        System.out.println("Circumference 2 = "+c2.Circumference());
        System.out.println("Area 2 = "+c2.Area());
    }
}
