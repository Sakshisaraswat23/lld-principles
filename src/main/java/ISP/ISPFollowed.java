package ISP;

// Separate interface for 2D shapes
interface TwoDimensionalShape {
    double area();
}

// Separate interface for 3D shapes
interface ThreeDimensionalShape {
    double area();
    double volume();
}

// Square implements only the 2D interface
class SquareShape implements TwoDimensionalShape {
    private double side;

    public SquareShape(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }
}

// Rectangle implements only the 2D interface
class RectangleShape implements TwoDimensionalShape {
    private double length, width;

    public RectangleShape(double l, double w) {
        this.length = l;
        this.width  = w;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Cube implements the 3D interface
class CubeShape implements ThreeDimensionalShape {
    private double side;

    public CubeShape(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

public class ISPFollowed {
    public static void main(String[] args) {

        /*
        IMPORTANT:
        Using TwoDimensionalShape provides abstraction, loose coupling, and flexibility.
Using SquareShape ties the code to a specific implementation.
Both create the same object, but the reference type decides what operations are allowed.

This is same what is there in LSP as well [ directly using new class() )

Rest do chatgpt and ask why to use TwoDimensionalShape instead of SquareShape

Using interface class is recommended as tu abhi 3 calls kar rhi..but in future run time pe
decide karna zyada dynamic + sahi hai
         */
        TwoDimensionalShape squareShape    = new SquareShape(5);
        TwoDimensionalShape rectangle = new RectangleShape(4, 6);
        ThreeDimensionalShape cube     = new CubeShape(3);

        System.out.println("Square Area: "    + squareShape.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Cube Area: "      + cube.area());
        System.out.println("Cube Volume: "    + cube.volume());
    }
}