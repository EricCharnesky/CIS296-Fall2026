

public class Triangle extends Polygon{

    public Triangle(int sideALength, int sideBLength, int sideCLength){
        super(3);
        setSideLength(0, sideALength);
        setSideLength(1, sideBLength);
        setSideLength(2, sideCLength);
    }


    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2.0;

        return Math.sqrt(semiPerimeter*
                        (semiPerimeter-getSideLength(0))*
                        (semiPerimeter-getSideLength(1))*
                        (semiPerimeter-getSideLength(2))
                        );
    }
}
