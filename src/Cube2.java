public class Cube2 {
    private Cube basicCube;
    private String color;

    // constructor with no parameters
    public Cube2() {
        this.basicCube = new Cube(1);
        this.color = "black";
    }

    // constructor with a single integer parameter
    public Cube2(int side) {
        this.basicCube = new Cube(side);
        this.color = "black";
    }

    // constructor with side and color parameters
    public Cube2(int side, String color) {
        this.basicCube = new Cube(side);
        this.color = color;
    }

    // a getter method called getSide() (given)
    public int getSide() {
        return basicCube.getSide();
    }

    // a setter method called setSide(int side)
    public void setSide(int side) {
        if (side < 1) {
            throw new IllegalArgumentException("A cube’s side length must be equal to or greater than 1!");
        }
        this.basicCube.setSide(side);
    }

    // a getter method called getColor()
    public String getColor() {
        return color;
    }

    // a setter method called setColor(String color)
    public void setColor(String color) {

        this.color = color;
    }

    // a method that returns the surface area of the cube
    public int calculateSurfaceArea() {
        int side = getSide();
        return 6 * side * side;
    }

    // a method that returns the volume of the cube
    public int calculateVolume() {
        int side = getSide();
        return side * side * side;
    }

    // a toString method that returns a String
    public String toString() {
        return "Cube{side=" + getSide() + ", color=\"" + color + "\"}";
    }

    // add method
    public Cube2 add(Cube2 otherCube) {
        int side1 = this.getSide();
        int side2 = otherCube.getSide();
        int newSide = (int) Math.sqrt(side1 * side1 + side2 * side2);
        if (side1 * side1 + side2 * side2 == newSide * newSide) {
            return new Cube2(newSide, this.color);
        } else {
            throw new IllegalArgumentException("The sides do not form a Pythagorean triple");
        }
    }

    // minus method
    public Cube2 minus(Cube2 otherCube) {
        int surfaceArea1 = this.calculateSurfaceArea();
        int surfaceArea2 = otherCube.calculateSurfaceArea();
        int newSurfaceArea = (int) Math.abs(surfaceArea1 - surfaceArea2);
        double side = Math.sqrt(newSurfaceArea / 6);
        int newSide = (int) side;

        if (newSide == side) {
            return new Cube2(newSide, this.color);
        } else {
            throw new IllegalArgumentException("The sides do not form a Pythagorean triple");
        }

    }
}
