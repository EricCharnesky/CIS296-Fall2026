
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static final String ROCK = "rock";
    static final String PAPER = "paper";
    static final String SCISSORS = "scissors";


    public static void main(String[] args) {

        while (playAgain().equalsIgnoreCase("Y")) {

            String computerThrow = getComputerThrow();
            String userThrow = getUserThrow();

            System.out.println(getWinLoseOrDraw(computerThrow, userThrow));

        }

        for (int number = 0; number < 10; number++){
            System.out.println(number);
        }


        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;

        String highOrLow = (numberToGuess < 50) ? "low" : "high";

        if ( numberToGuess < 50){
            highOrLow = "low";
        }
        else{
            highOrLow = "high";
        }

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Guess a number 1-100: ");
        int guess = Integer.parseInt(keyboard.nextLine());

        while ( guess != numberToGuess ){
            if ( guess < numberToGuess){
                System.out.println("Too low!");
            }
            else{
                System.out.println("Too high");
            }
            System.out.println("Guess a number 1-100: ");
            guess = Integer.parseInt(keyboard.nextLine());

        }




        System.out.println("You guessed it!");




        int myNumber = addToNumber(10);

        String name = new String( "Eric");
        name = upperCase(name);
        System.out.println(name);



    }

    public static String getWinLoseOrDraw(String computerThrow, String userThrow) {
        if ( computerThrow.equalsIgnoreCase(userThrow)){
            return "Tie";
        }
        else if ( (userThrow.equalsIgnoreCase(Main.ROCK) && computerThrow.equalsIgnoreCase(Main.SCISSORS) )
        || (userThrow.equalsIgnoreCase(Main.PAPER) && computerThrow.equalsIgnoreCase(Main.ROCK) )
        || (userThrow.equalsIgnoreCase(Main.SCISSORS) && computerThrow.equalsIgnoreCase(Main.PAPER) ) ){
            return "Win";
        }
        else{
            return "Lose";
        }
    }

    private static String getUserThrow() {
        Scanner keyboard = new Scanner(System.in);

        int choice = 0;

        while ( choice < 1 || choice > 3){
            System.out.println("Enter 1 for rock, 2 for paper, 3 for scissors: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter only numbers");
            }

        }

        if ( choice == 1 ){
            return Main.ROCK;
        }
        if ( choice == 2 ){
            return Main.PAPER;
        }
        return Main.SCISSORS;

    }

    private static String getComputerThrow() {
        Random random = new Random();
        int choice = random.nextInt(3);
        if ( choice == 0 ){
            return Main.ROCK;
        }
        if ( choice == 1 ){
            return Main.PAPER;
        }
        return Main.SCISSORS;

    }

    private static String playAgain() {
        System.out.println("Do you want to play Rock Paper Scissors (Y/N): ");
        Scanner keyboard = new Scanner(System.in);
        String choice = keyboard.nextLine();
        while ( !choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
//            System.out.println("Enter only Y or N: ");
//            choice = keyboard.nextLine();
            throw new InputMismatchException("please enter only Y or N");
        }
        return choice.toUpperCase();
    }

    private static int addToNumber() {
        return addToNumber(1);
    }

    private static int addToNumber(int startingNumber) {
        return startingNumber + 10;
    }

    private static String upperCase(String word){
        return word.toUpperCase();
    }




}