import java.beans.VetoableChangeListener;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @org.junit.jupiter.api.Test
    void constructor() {
        // Arrange
        String expectedMake = "Mercedes";
        String expectedModel = "Benz";
        String expectedColor = "black";
        double expectedKilometersPerLiter = 10;
        double expectedMaxLitersInTank = 15;
        double expectedCurrentLitersInTank = 0;
        double expectedKilometersDriven = 0;

        // Act
        Vehicle vehicle = new Vehicle(expectedMake, expectedModel, expectedColor, expectedKilometersPerLiter, expectedMaxLitersInTank);
        String actualMake = vehicle.getMake();
        String actualModel = vehicle.getModel();
        String actualColor = vehicle.getColor();
        double actualKilometersPerLiter = vehicle.getKilometersPerLiter();
        double actualMaxLitersInTank = vehicle.getMaxLitersInTank();
        double actualCurrentLitersInTank = vehicle.getCurrentLitersInTank();
        double actualKilometersDrive = vehicle.getKilometersDriven();

        // Assert
        assertEquals(expectedMake, actualMake);
        assertEquals(expectedModel, actualModel);
        assertEquals(expectedColor, actualColor);
        assertEquals(expectedKilometersPerLiter, actualKilometersPerLiter);
        assertEquals(expectedMaxLitersInTank, actualMaxLitersInTank);
        assertEquals(expectedCurrentLitersInTank, actualCurrentLitersInTank);
        assertEquals(expectedKilometersDriven, actualKilometersDrive);


    }

    @org.junit.jupiter.api.Test
    void addGasWorks() {
        // Arrange
        Vehicle vehicle = new Vehicle("", "", "", 10, 10);
        double expectedLitersInTank = 5;

        // Act
        vehicle.addGas(expectedLitersInTank);
        double actualLitersInTank = vehicle.getCurrentLitersInTank();

        // Assert
        assertEquals(expectedLitersInTank,actualLitersInTank);
    }


// example from https://www.bing.com/search?q=junit+5+assert+throws+example
    @org.junit.jupiter.api.Test
    void addTooMuchGasThrowsException() {
        // Arrange
        Vehicle vehicle = new Vehicle("", "", "", 10, 10);

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> vehicle.addGas(100)
        );

        assertEquals("Would overflow tank", thrown.getMessage());

    }

    @org.junit.jupiter.api.Test
    void addNegativeGasThrowsException() {
        // Arrange
        Vehicle vehicle = new Vehicle("", "", "", 10, 10);

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> vehicle.addGas(-100)
        );

        assertEquals("Can't add negative gas", thrown.getMessage());

    }

    @org.junit.jupiter.api.Test
    void driveWorks() {
        // Arrange
        Vehicle vehicle = new Vehicle("", "", "", 10, 10);
        vehicle.addGas(10);
        double expectedLitersInTank = 5;
        double expectedKilometersDriven = 50;

        // Act
        vehicle.drive(expectedKilometersDriven);
        double actualLitersInTank = vehicle.getCurrentLitersInTank();
        double actualKilometersDriven = vehicle.getKilometersDriven();

        // Assert
        assertEquals(expectedLitersInTank,actualLitersInTank);
        assertEquals(expectedKilometersDriven, actualKilometersDriven);
    }
}