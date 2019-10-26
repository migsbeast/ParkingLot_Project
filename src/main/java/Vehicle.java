import java.sql.Timestamp;

public class Vehicle {
    private Timestamp timestamp;
    private ParkingLot lotIParkedAt;
    private String driver;
    private double priceToPay;

    public Vehicle(String driver){
        this.driver = driver;
    }

    public int checkSpaceAvailablity(ParkingLot pl){
        return pl.getCapacity() - pl.getOccupied();
    }

    public double checkPrice(ParkingLot pl){
        return pl.getPrice();
    }

    public LotGroup pickLot(LotGroup price1, LotGroup price2){
        if(price1.getPrice() < price2.getPrice()){
            return price1;
        }
        else {
            return price2;
        }
    }

    // Calculates the amount of cash you must pay for the amount of time parked
    public double calculatePrice(){
        Timestamp timeout = new Timestamp(System.currentTimeMillis());
        long in = this.timestamp.getTime();
        long out = timeout.getTime();
        long timeParked = (out - in);
        this.priceToPay = timeParked * this.lotIParkedAt.getPrice(); // They get charged x for each millisecond they parked
        return this.priceToPay;
    }

    @Override
    //toString method
    public String toString() {
        return "Vehicle's Data [Owner: " + driver + " ; "+ lotIParkedAt + "]";
    }

    @Override
    //Comparing two vehicles
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }else{
            Vehicle other = (Vehicle) obj;
            return this.driver.equals(other.driver);
        }
    }

    //getter for the driver's name
    public String getDriver() {
        return driver;
    }

    public ParkingLot getLotIParkedAt(){
        return this.lotIParkedAt;
    }

    public void setTimestamp(){
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public void setLotIParkedAt(ParkingLot lt){
        this.lotIParkedAt = lt;
    }
}