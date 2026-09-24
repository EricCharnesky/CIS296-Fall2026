public class Rectangle extends Polygon {


    public Rectangle(int length, int width){
        super(4);
        setLength(length);
        setWidth(width);
    }

    public int getLength(){
        return getSideLength(0);
    }

    public int getWidth(){
        return getSideLength(1);
    }

    public void setLength(int length)
    {
        super.setSideLength(0, length);
        super.setSideLength(2, length);
    }

    public void setWidth(int width){
        super.setSideLength(1, width);
        super.setSideLength(3, width);
    }

    @Override
    public void setSideLength(int sideIndex, int length){
        if (sideIndex % 2 == 0){
            setLength(length);
        } else {
            setWidth(length);
        }
    }

    public double getArea(){
        return getLength() * getWidth();
    }
}
