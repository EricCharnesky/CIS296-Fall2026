public class TicTacToe {
    private String[][] grid;
    private String currentPlayer;

    public TicTacToe(){
        grid = new String[][]{
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };

        currentPlayer = "X";
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver(){
        return isTied() || hasWinner();
    }

    private boolean hasWinner() {
        return hasWinnerByRow() || hasWinnerByColumn() || hasWinnerByDiagonal();
    }

    private boolean hasWinnerByDiagonal() {
        return ( !grid[1][1].equalsIgnoreCase(" ") &&
                ( ( grid[1][1].equalsIgnoreCase( grid[0][0]) &&
                    grid[1][1].equalsIgnoreCase( grid[2][2])  ) ||
                ( grid[1][1].equalsIgnoreCase( grid[0][2]) &&
                    grid[1][1].equalsIgnoreCase( grid[2][0]) ) ) );
    }

    private boolean hasWinnerByColumn() {
        for ( int columnIndex = 0; columnIndex < 3; columnIndex++ ){
            if (!grid[0][columnIndex].equalsIgnoreCase(" ")
                && grid[0][columnIndex].equalsIgnoreCase(grid[1][columnIndex])
                && grid[0][columnIndex].equalsIgnoreCase(grid[2][columnIndex]) ){
                return true;
            }
        }
        return false;
    }

    private boolean hasWinnerByRow() {
        for (String[] row : grid){
            if (!row[0].equalsIgnoreCase(" ") && row[0].equalsIgnoreCase(row[1]) && row[0].equalsIgnoreCase(row[2])){
                return true;
            }
        }
        return false;
    }


    private boolean isTied() {
        if ( hasWinner() ){
            return false;
        }
        for ( String[] row : grid ){
            for ( String value : row ){
                if (value.equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }


    public boolean mark(int row, int column){
        if ( row < 0 || row > 2 || column < 0 || column > 2 ||
                !grid[row][column].equals(" ")){
            return false;
        }
        grid[row][column] = currentPlayer;
        if ( currentPlayer.equalsIgnoreCase("X")){
            currentPlayer = "O";
        }else {
            currentPlayer = "X";
        }
        return true;
    }

    @Override
    public String toString(){
        String result = "";
        result += grid[0][0] + "|" + grid[0][1] + "|" + grid[0][2];
        result += "\n-----\n";
        result += grid[1][0] + "|" + grid[1][1] + "|" + grid[1][2];
        result += "\n-----\n";
        result += grid[2][0] + "|" + grid[2][1] + "|" + grid[2][2];
        result += "\n";
        return result;
    }
}
