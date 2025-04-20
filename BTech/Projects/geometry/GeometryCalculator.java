package BTech.Projects.geometry;

import java.util.Scanner;

public class GeometryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point2D[] points2D = new Point2D[4]; // Array for 2D points (2 per line)
        Point3D[] points3D = new Point3D[4]; // Array for 3D points (2 per line)

        while (true) {
            System.out.println("\nGeometry Calculator Menu:");
            System.out.println("1. Calculate Midpoint (2D)");
            System.out.println("2. Calculate Distance (2D)");
            System.out.println("3. Calculate Slope and Line Equation (2D)");
            System.out.println("4. Find Intersection of Two Lines (2D)");
            System.out.println("5. Check if Two Lines are Skew (3D)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 6) break;

                if (choice >= 1 && choice <= 4) {
                    // Input 2D points for two lines
                    for (int i = 0; i < 4; i++) {
                        System.out.printf("Enter x-coordinate for Point %d (2D): ", i + 1);
                        double x = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Enter y-coordinate for Point %d (2D): ", i + 1);
                        double y = Double.parseDouble(scanner.nextLine());
                        points2D[i] = new Point2D(x, y);
                    }
                    Line2D line1 = new Line2D(points2D[0], points2D[1]);
                    Line2D line2 = new Line2D(points2D[2], points2D[3]);

                    switch (choice) {
                        case 1:
                            Point2D midpoint = line1.getMidpoint();
                            System.out.printf("Midpoint: (%.2f, %.2f)\n", midpoint.getX(), midpoint.getY());
                            break;
                        case 2:
                            double distance = line1.getDistance();
                            System.out.printf("Distance: %.2f\n", distance);
                            break;
                        case 3:
                            double slope = line1.getSlope();
                            String equation = line1.getLineEquation();
                            System.out.printf("Slope: %.2f\nLine Equation: %s\n", slope, equation);
                            break;
                        case 4:
                            Point2D intersection = line1.getIntersection(line2);
                            if (intersection != null) {
                                System.out.printf("Intersection: (%.2f, %.2f)\n", intersection.getX(), intersection.getY());
                            }
                            break;
                    }
                } else if (choice == 5) {
                    // Input 3D points for two lines
                    for (int i = 0; i < 4; i++) {
                        System.out.printf("Enter x-coordinate for Point %d (3D): ", i + 1);
                        double x = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Enter y-coordinate for Point %d (3D): ", i + 1);
                        double y = Double.parseDouble(scanner.nextLine());
                        System.out.printf("Enter z-coordinate for Point %d (3D): ", i + 1);
                        double z = Double.parseDouble(scanner.nextLine());
                        points3D[i] = new Point3D(x, y, z);
                    }
                    Line3D line1 = new Line3D(points3D[0], points3D[1]);
                    Line3D line2 = new Line3D(points3D[2], points3D[3]);
                    boolean isSkew = line1.isSkew(line2);
                    System.out.println("Lines are " + (isSkew ? "skew" : "not skew"));
                } else {
                    System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter numeric values.");
            } catch (GeometryException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

// Base class for points
abstract class Point {
    protected double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
}

// 2D Point class
class Point2D extends Point {
    public Point2D(double x, double y) {
        super(x, y);
    }
}

// 3D Point class
class Point3D extends Point2D {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() { return z; }
}

// Custom exception
class GeometryException extends Exception {
    public GeometryException(String message) {
        super(message);
    }
}

// 2D Line class
class Line2D {
    private Point2D p1, p2;

    public Line2D(Point2D p1, Point2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point2D getMidpoint() {
        double midX = (p1.getX() + p2.getX()) / 2;
        double midY = (p1.getY() + p2.getY()) / 2;
        return new Point2D(midX, midY);
    }

    public double getDistance() {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getSlope() throws GeometryException {
        double dx = p2.getX() - p1.getX();
        if (dx == 0) throw new GeometryException("Undefined slope (vertical line)");
        return (p2.getY() - p1.getY()) / dx;
    }

    public String getLineEquation() throws GeometryException {
        double m = getSlope();
        double c = p1.getY() - m * p1.getX();
        return String.format("y = %.2fx + %.2f", m, c);
    }

    public Point2D getIntersection(Line2D other) throws GeometryException {
        double m1 = getSlope();
        double m2 = other.getSlope();
        if (Math.abs(m1 - m2) < 0.0001) throw new GeometryException("Parallel lines: No intersection");

        double c1 = p1.getY() - m1 * p1.getX();
        double c2 = other.p1.getY() - m2 * other.p1.getX();
        double x = (c2 - c1) / (m1 - m2);
        double y = m1 * x + c1;
        return new Point2D(x, y);
    }
}

// 3D Line class
class Line3D {
    private Point3D p1, p2;

    public Line3D(Point3D p1, Point3D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean isSkew(Line3D other) {
        // Direction vectors
        double[] d1 = {p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ()};
        double[] d2 = {other.p2.getX() - other.p1.getX(), other.p2.getY() - other.p1.getY(), other.p2.getZ() - other.p1.getZ()};

        // Check if parallel (cross product = 0)
        double[] cross = {
            d1[1] * d2[2] - d1[2] * d2[1],
            d1[2] * d2[0] - d1[0] * d2[2],
            d1[0] * d2[1] - d1[1] * d2[0]
        };
        boolean isParallel = Math.abs(cross[0]) < 0.0001 && Math.abs(cross[1]) < 0.0001 && Math.abs(cross[2]) < 0.0001;

        if (isParallel) return false;

        // Check if intersecting (solve for t, s in parametric equations)
        double[] pDiff = {other.p1.getX() - p1.getX(), other.p1.getY() - p1.getY(), other.p1.getZ() - p1.getZ()};
        double det = d1[0] * (d2[1] * cross[2] - d2[2] * cross[1]) +
                     d1[1] * (d2[2] * cross[0] - d2[0] * cross[2]) +
                     d1[2] * (d2[0] * cross[1] - d2[1] * cross[0]);
        if (Math.abs(det) > 0.0001) return true; // Non-coplanar, non-intersecting: skew
        return false; // Coplanar, may intersect
    }
}