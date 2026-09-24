import game.Card;
import game.Face;
import game.Suit;

public class Main {
    public static void main(String[] args) {

        Card twoOfClubs = new Card(Suit.CLUBS, Face.TWO);

        Item item = new Item("a", 1, 1);

        Student student = new Student(10, "eric", "D.Eng dropout");
        System.out.println(student);

        Rectangle rectangle = new Rectangle(2,4);
        rectangle.setSideLength(0, 2);
        rectangle.setSideLength(1, 3);
        rectangle.setSideLength(2, 4);
        rectangle.setSideLength(3, 5);
    }
}