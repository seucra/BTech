class J106JNestedClass {
    static class Circle{
        static double x,y,r;
        Circle(double r){
            this.r = r; this.x = 0.0;
        }
        static class Point{
            double x,y;
            void dispplay(){
                System.out.println("(x,y) : ("+this.x+","+y+")");
            }
            Point (double x, double y){
                this.x = x;
                this.y = y;
            }
        }
        boolean isInside(Point p){
            double dx = p.x - x;
            double dy = p.y - y;
            double distance = Math.sqrt((dx*dx)+(dy*dy));

            if (distance < r)   return true;
            else                return false;
        }
        static void _main_(String arg[]){
            Circle a = new Circle(2.0);
            Point pa = new Point (1.2, 1.3);
            pa.dispplay();
            System.out.println("is point pa inside circle a? : "+a.isInside(pa));
            Circle b = new Circle(3.0);
            Point pb = new Point(123.2, 12.4);
            pb.dispplay();
            System.out.println("is point pa inside circle b ? : "+b.isInside(pb));
        }
    }
    public static void main(String[] args) {
        Circle._main_(args);
    }
}
