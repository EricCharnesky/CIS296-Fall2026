import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    void TestGetWinLoseDraw_Win() {
        // AAA convention

        // Arrange - setup the variables we need to test
        String expectedResult = "Win";

        // Act - call the code we're testing
        String actualResultRockBeatsScissors = Main.getWinLoseOrDraw(Main.SCISSORS, Main.ROCK);
        String actualResultScissorsBeatsPaper = Main.getWinLoseOrDraw(Main.PAPER, Main.SCISSORS);
        String actualResultPaperBeatsRock = Main.getWinLoseOrDraw(Main.ROCK, Main.PAPER);

        // Assert - did we get what we expected
        assertEquals(expectedResult, actualResultRockBeatsScissors);
        assertEquals(expectedResult, actualResultScissorsBeatsPaper);
        assertEquals(expectedResult, actualResultPaperBeatsRock);

    }


    @Test
    void TestGetWinLoseDraw_Lose() {
        // AAA convention

        // Arrange - setup the variables we need to test
        String expectedResult = "Lose";

        // Act - call the code we're testing
        String actualResultScissorsLosesRock = Main.getWinLoseOrDraw(Main.ROCK, Main.SCISSORS );
        String actualResultPaperLosesScissors = Main.getWinLoseOrDraw(Main.SCISSORS, Main.PAPER) ;
        String actualResultRockLosesPaper = Main.getWinLoseOrDraw(Main.PAPER, Main.ROCK );

        // Assert - did we get what we expected
        Assertions.assertEquals(expectedResult, actualResultScissorsLosesRock);
        Assertions.assertEquals(expectedResult, actualResultPaperLosesScissors);
        Assertions.assertEquals(expectedResult, actualResultRockLosesPaper);

    }

    @Test
    void TestGetWinLoseDraw_Draw() {
        // AAA convention

        // Arrange - setup the variables we need to test
        String expectedResult = "Tie";

        // Act - call the code we're testing
        String actualResult = Main.getWinLoseOrDraw(Main.ROCK, Main.ROCK );

        // Assert - did we get what we expected
        Assertions.assertEquals(expectedResult, actualResult);

    }
}