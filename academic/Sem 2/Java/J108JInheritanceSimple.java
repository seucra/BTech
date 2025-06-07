// Simple inheritance example

class Point2D{
    int x, y;
    void display(){
        System.out.println("X = "+x+",Y = "+y);
    }
}
class Point3D extends Point2D{
    int z;
    void display(){
        System.out.println("X = "+x+", Y = "+y+", Z = "+z);
    }
}

public class J108JInheritanceSimple {
    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        Point3D p2 = new Point3D();
        p1.x = 10;
        p1.y = 20;
        System.out.print("Point p1 : ");
        p1.display();
        p2.x = 30;
        p2.y = 40;
        p2.z = 50;
        System.out.print("Point p2 : ");
        p2.display();
    }
}