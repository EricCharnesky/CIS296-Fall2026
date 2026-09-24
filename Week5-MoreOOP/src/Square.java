public class Square extends Rectangle {

    public Square(int length) {
        super(length, length);
    }

    @Override
    public void setLength(int length){
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(int width){
        super.setLength(width);
        super.setWidth(width);
    }

    @Override
    public void setSideLength(int sideIndex, int length){
        setLength(length);
    }
}
