class Circle{
    static int circlecount=0; // class variable
    public double x,y,r; // instance variables

    Circle (double x, double y, double r) {
        this.x= x; this.y = y; this.r = r;
        circlecount++;
    }
    Circle (double r) {
        this (0.0,0.0,r);
        circlecount++;
    }
    Circle (Circle c) {
        this (c.x,c.y,c.r);
        circlecount++;
    }
    Circle() {
        this (0.0,0.0,0.1);
        circlecount++;
    }
    
    public double circumference () {
        return (2*3.14159*r);
    }    
    public double area() {  
        return (3.14159*r*r);   
    }
}

class J105JStaticVariable{
    public static void main(String args[]){
        Circle cl = new Circle();
        Circle c2 = new Circle (5.0);
        Circle c3 = new Circle (cl);
        System.out.println("cl "+Circle.circlecount+"\nc2 "+Circle.circlecount+"\nc3 "+Circle.circlecount);
    }
}