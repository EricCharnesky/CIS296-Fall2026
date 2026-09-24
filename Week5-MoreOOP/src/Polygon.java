public abstract class Polygon {

    private final int numberOfSides;
    private final int[] sideLengths;

    public Polygon(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        sideLengths = new int[numberOfSides];
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public int getSideLength(int sideIndex) {
        return sideLengths[sideIndex];
    }

    public void setSideLength(int sideIndex, int length){
        if ( length <= 0 ){
            throw new IllegalArgumentException("length must be > 0");
        }
        sideLengths[sideIndex] = length;
    }

    public int getPerimeter(){
        int total = 0;
        for ( int length : sideLengths){
            total += length;
        }
        return total;
    }

    public abstract double getArea();
}
