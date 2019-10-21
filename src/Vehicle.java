import java.sql.Timestamp;

public class Vehicle {
    private String driver;
    private Timestamp timestamp;
    private double priceToPay;

    public Vehicle(String driver){
        this.driver = driver;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public double calculatePrice(){
        // Calculates the amount of time parked
        Timestamp timeout = new Timestamp(System.currentTimeMillis());
        long in = this.timestamp.getTime();
        long out = timeout.getTime();
        long timeParked = (out - in) / (60 * 60 * 1000);
        this.priceToPay = (double) (timeParked * 2.5);
        return this.priceToPay;
    }
}
