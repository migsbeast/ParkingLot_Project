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
        long timeParked = (out - in);
        this.priceToPay = (double) (timeParked * 2.5); // They get charged $2.50 for each millisecond they parked
        return this.priceToPay;
    }

    @Override
    //toString method
    public String toString() {
        return "Vehicle's Data [Owner:" + driver + "; Timestamp:" + timestamp + "]";
    }

    @Override
    //Comparing two vehicles
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }else{
            Vehicle other = (Vehicle) obj;
            if(this.driver.equals(other.driver) && this.timestamp.equals(other.timestamp)){
                return true;
            }else{
                return false;
            }
        }
    }

    public String getDriver() {
        return driver;
    }
}
