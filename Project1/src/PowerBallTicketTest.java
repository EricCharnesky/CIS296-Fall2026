import static org.junit.jupiter.api.Assertions.*;

class PowerBallTicketTest {

    @org.junit.jupiter.api.Test
    void getWinnings0() {
        // Arrange
        int expectedWinnings = 0;

        int[] numbers = { 1,2,3,4,5};
        PowerBallTicket winningTicket = new PowerBallTicket(numbers, 6);
        int[] otherNumbers = { 6,7,8,9,10};
        PowerBallTicket ticket = new PowerBallTicket(otherNumbers, 11);

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);

    }

    @org.junit.jupiter.api.Test
    void getWinnings4() {
        // Arrange
        int expectedWinnings = 4;

        int[] numbers = { 1,2,3,4,5};
        PowerBallTicket winningTicket = new PowerBallTicket(numbers, 6);
        int[] otherNumbers = { 6,7,8,9,10};
        PowerBallTicket ticket = new PowerBallTicket(otherNumbers, 6);

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);

    }

    @org.junit.jupiter.api.Test
    void getWinnings7_two_white_and_red() {
        // Arrange
        int expectedWinnings = 7;

        int[] numbers = { 1,2,3,4,5};
        PowerBallTicket winningTicket = new PowerBallTicket(numbers, 6);
        int[] otherNumbers = { 5,4,8,9,10};
        PowerBallTicket ticket = new PowerBallTicket(otherNumbers, 6);

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);

    }

    @org.junit.jupiter.api.Test
    void getWinnings7_three_white() {
        // Arrange
        int expectedWinnings = 7;

        int[] numbers = { 1,2,3,4,5};
        PowerBallTicket winningTicket = new PowerBallTicket(numbers, 6);
        int[] otherNumbers = { 5,4,3,9,10};
        PowerBallTicket ticket = new PowerBallTicket(otherNumbers, 7);

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);

    }


    @org.junit.jupiter.api.Test
    void getWinnings100_three_white_and_red() {
        // Arrange
        int expectedWinnings = 100;

        int[] numbers = { 1,2,3,4,5};
        PowerBallTicket winningTicket = new PowerBallTicket(numbers, 6);
        int[] otherNumbers = { 5,4,3,9,10};
        PowerBallTicket ticket = new PowerBallTicket(otherNumbers, 6);

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);

    }

    @org.junit.jupiter.api.Test
    void getWinnings100_four_white() {
        // Arrange
        int expectedWinnings = 100;

        int[] numbers = { 1,2,3,4,5};
        PowerBallTicket winningTicket = new PowerBallTicket(numbers, 6);
        int[] otherNumbers = { 5,4,3,2,10};
        PowerBallTicket ticket = new PowerBallTicket(otherNumbers, 7);

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);

    }


    @org.junit.jupiter.api.Test
    void getWinnings50000_four_white_and_red() {
        // Arrange
        int expectedWinnings = 50000;

        int[] numbers = { 1,2,3,4,5};
        PowerBallTicket winningTicket = new PowerBallTicket(numbers, 6);
        int[] otherNumbers = { 5,4,3,2,10};
        PowerBallTicket ticket = new PowerBallTicket(otherNumbers, 6);

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);

    }


    @org.junit.jupiter.api.Test
    void getWinnings1000000_five_white() {
        // Arrange
        int expectedWinnings = 1000000;

        int[] numbers = { 1,2,3,4,5};
        PowerBallTicket winningTicket = new PowerBallTicket(numbers, 6);
        int[] otherNumbers = { 5,4,3,2,1};
        PowerBallTicket ticket = new PowerBallTicket(otherNumbers, 7);

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);

    }


    @org.junit.jupiter.api.Test
    void getWinningsJackpot() {
        // Arrange
        int expectedWinnings = Integer.MAX_VALUE;

        int[] numbers = { 1,2,3,4,5};
        PowerBallTicket winningTicket = new PowerBallTicket(numbers, 6);
        int[] otherNumbers = { 5,4,3,2,1};
        PowerBallTicket ticket = new PowerBallTicket(otherNumbers, 6);

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);

    }
}