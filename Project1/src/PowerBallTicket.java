import java.util.*;

public class PowerBallTicket {
    private final ArrayList<Integer> whiteNumbers;
    private final int redNumber;

    public static final int TICKET_PRICE = 2;
    private static final Random random = new Random();

    public PowerBallTicket(){
        whiteNumbers = new ArrayList<Integer>(5);

        while ( whiteNumbers.size() != 5 ){
            int whiteNumber = random.nextInt(1,70);
            while ( whiteNumbers.contains(whiteNumber)){
                whiteNumber = random.nextInt(1,70);
            }
            whiteNumbers.add(whiteNumber);
        }

        redNumber = random.nextInt(1,27);
    }

    public PowerBallTicket(int[] whiteNumbers, int redNumber ){
        if (whiteNumbers.length != 5){
            throw new IllegalArgumentException("must have 5 white numbers");
        }

        this.whiteNumbers = new ArrayList<Integer>(5);

        for(int number : whiteNumbers){
            if ( number < 1 || number > 69){
                throw new IllegalArgumentException("numbers must be 1-69");
            }
            if ( this.whiteNumbers.contains(number)){
                throw new IllegalArgumentException("no repeat white numbers");
            }
            this.whiteNumbers.add(number);
        }

        if ( redNumber < 1 || redNumber > 26 ){
            throw new IllegalArgumentException("Red number must be 1-26");
        }
        this.redNumber = redNumber;
    }

    public int getWinnings(PowerBallTicket winningTicket){

        // FIXME
        int whiteMatches = 0;
        for ( int myWhiteNumber : whiteNumbers){
            if ( winningTicket.whiteNumbers.contains(myWhiteNumber)){
                whiteMatches++;
            }
        }
        boolean redMatches = redNumber == winningTicket.redNumber;

        if (whiteMatches == 5 && redMatches){
            return Integer.MAX_VALUE;
        }
        if ( whiteMatches == 5){
            return 1000000;
        }
        if ( whiteMatches == 4 && redMatches){
            return 50000;
        }
        if ( whiteMatches == 4 || ( whiteMatches == 3 && redMatches ) ){
            return 100;
        }
        if (whiteMatches == 3 || ( whiteMatches == 2 && redMatches )){
            return 7;
        }
        if (  redMatches ){
            return 4;
        }
        return 0;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for ( int number : whiteNumbers ){
            result.append(number).append(" ");
        }
        result.append("PowerBall: ").append(redNumber);
        return result.toString();
    }
}
