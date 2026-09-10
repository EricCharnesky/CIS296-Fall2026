public class Vehicle {
    private final String make;
    private final String model;
    private String color;
    private final double kilometersPerLiter;
    private final double maxLitersInTank;
    private double currentLitersInTank;
    private double kilometersDriven;

    public Vehicle(String make, String model, String color, double kilometersPerLiter, double maxLitersInTank) {
        this.make = make;
        this.model = model;
        setColor(color);
        this.kilometersPerLiter = kilometersPerLiter;
        this.maxLitersInTank = maxLitersInTank;
        currentLitersInTank = 0.0;
        kilometersDriven = 0;
    }

    // https://www.bing.com/search?qs=AS&pq=java+string+int&sk=CSYN1&sc=7-15&pglt=297&q=java+string+interpolation&cvid=6a36108c11614835bf838a226a140567&gs_lcrp=EgRlZGdlKgcIABAAGPkHMgcIABAAGPkHMgYIARBFGDkyBggCEAAYQDIGCAMQABhAMgYIBBAAGEAyBggFEAAYQNIBCDIzMjFqMGo3qAIAsAIA&FORM=ANNTA1&adppc=EDGEINJP&PC=W099
    @Override
    public String toString(){
        return String.format("%s %s %s - Kilometers Driven: %f - Current Liters In Tank: %f",
                color, make, model, kilometersDriven, currentLitersInTank);
    }

    public void addGas(double litersToAdd){
        if ( currentLitersInTank + litersToAdd > maxLitersInTank){
            throw new IllegalArgumentException("Would overflow tank");
        }
        if ( litersToAdd < 0 ){
            throw new IllegalArgumentException("Can't add negative gas");
        }

        currentLitersInTank += litersToAdd;
    }

    public void drive(double kilometers){
        if ( kilometers / kilometersPerLiter > currentLitersInTank ){
            throw new IllegalArgumentException("Can't drive that far");
        }

        kilometersDriven += kilometers;
        currentLitersInTank -= kilometers / kilometersPerLiter;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getKilometersPerLiter() {
        return kilometersPerLiter;
    }

    public double getMaxLitersInTank() {
        return maxLitersInTank;
    }

    public double getCurrentLitersInTank() {
        return currentLitersInTank;
    }

    public double getKilometersDriven() {
        return kilometersDriven;
    }
}
