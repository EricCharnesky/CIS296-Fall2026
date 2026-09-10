import java.util.ArrayList;
import java.util.Scanner;


public class Main{

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);


        String playAgain = "Y";

        while (playAgain.equalsIgnoreCase("Y")) {


            TicTacToe game = new TicTacToe();

            while (!game.isGameOver()) {
                System.out.println(game);
                System.out.println(game.getCurrentPlayer() + "'s turn");

                System.out.println("Enter row index: ");
                int row = Integer.parseInt(keyboard.nextLine());

                System.out.println("Enter column index: ");
                int column = Integer.parseInt(keyboard.nextLine());

                if (!game.mark(row, column)) {
                    System.out.println("Invalid location, try again");
                }
            }
            System.out.println(game);
            System.out.println("Game over!");

            System.out.println("Do you want to play again?");
            playAgain = keyboard.nextLine();
        }


        Vehicle[] vehicles;

        // array initializer syntax
        int[] numbers = { 1,2,3,4,5};

        ArrayList<Vehicle> vehicleList;


        System.out.println("How many vehicles do you have?");
        int vehicleCount = Integer.parseInt(keyboard.nextLine());

        vehicles = new Vehicle[vehicleCount];

        vehicleList = new ArrayList<>();



        for ( int index = 0; index < vehicleCount; index++){
            System.out.println("Enter make: ");
            String make = keyboard.nextLine();

            System.out.println("Enter model: ");
            String model = keyboard.nextLine();

            System.out.println("Enter color: ");
            String color = keyboard.nextLine();

            System.out.println("Enter kilometers per liter: ");
            double kilometersPerLiter = Double.parseDouble(keyboard.nextLine());

            System.out.println("Enter max liters in tank: ");
            double maxLitersInTank = Double.parseDouble(keyboard.nextLine());

            vehicles[index] = new Vehicle(make, model, color, kilometersPerLiter, maxLitersInTank);
            vehicleList.add( new Vehicle(make, model, color, kilometersPerLiter, maxLitersInTank));
        }

        for ( Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }

        System.out.println("Done");
    }
}