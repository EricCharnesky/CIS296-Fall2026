import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        long totalSpent = 0;
        long totalWon = 0;

        String playAgain = "Y";

        while ( playAgain.equalsIgnoreCase("Y")){
            System.out.println("Enter 1 to pick powerball numbers, or 2 to buy random tickets");
            int choice = Integer.parseInt(keyboard.nextLine());

            if ( choice == 1){
                int[] whiteNumbers = new int[5];
                for ( int index=  0; index < 5; index++){
                    System.out.println("Enter a white number 1-69: ");
                    whiteNumbers[index] = Integer.parseInt(keyboard.nextLine());
                }
                System.out.println("Enter a red number 1-26: ");
                int redNumber = Integer.parseInt(keyboard.nextLine());

                PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
                PowerBallTicket winningTicket = new PowerBallTicket();

                System.out.println("Winning Ticket: " + winningTicket);
                int winnings = ticket.getWinnings(winningTicket);
                totalSpent += PowerBallTicket.TICKET_PRICE;
                totalWon += winnings;

            } else if ( choice == 2){
                System.out.println("How many random tickets do you want to buy?");
                int numberOfTickets = Integer.parseInt(keyboard.nextLine());

                PowerBallTicket winningTicket = new PowerBallTicket();

                System.out.println("Winning Ticket: " + winningTicket);

                for ( int ticketNumber = 0; ticketNumber < numberOfTickets; ticketNumber++ ){
                    PowerBallTicket ticket = new PowerBallTicket();
                    int winnings = ticket.getWinnings(winningTicket);
                    totalSpent += PowerBallTicket.TICKET_PRICE;
                    totalWon += winnings;

                    if ( winnings > 0 ){
                        //System.out.println("$" + winnings + " - " + ticket);
                    }
                }
            }
            displayTotals(totalSpent, totalWon);
            System.out.println("Do you want to keep playing PowerBall ( y/n )");
            playAgain = keyboard.nextLine().toUpperCase();
        }
    }

    private static void displayTotals(long totalSpent, long totalWon) {
        // https://www.bing.com/search?pglt=297&q=java+numver+formaating+for+print+with+digit+separtor&cvid=e8d278c362434d019b764c4449d386a9&gs_lcrp=EgRlZGdlKgYIABBFGDkyBggAEEUYOTIHCAEQ6wcYQNIBCDg0MTRqMGo3qAIAsAIA&FORM=ANNTA1&adppc=EDGEINJP&PC=W099
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println("Total Spent: $" + nf.format(totalSpent));
        System.out.println("Total Won: $" + nf.format(totalWon));
        System.out.println("Net loss: $" + nf.format(( totalWon - totalSpent) ));
    }
}