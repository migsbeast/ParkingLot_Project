import java.util.LinkedList;

public class ParkingLot extends LotGroup{
    private String lotN;
    private int capacity;
    private int occupied;
    private LinkedList<Vehicle> cars;


    public ParkingLot(int cap, String _num){
        super();
        this.capacity = cap;
        this.occupied = 0;
        this.cars = new LinkedList<Vehicle>();
        this.lotN = _num;
    }

    public void giveSpot(String driver){
        if(this.occupied == this.capacity){
            System.out.println("Sorry, it looks like there are no available parking spots at this moment, please wait!");
        }
        else {
            Vehicle newCar = new Vehicle(driver);
            newCar.setTimestamp();
            cars.add(newCar);
            this.occupied++;
            newCar.setLotIParkedAt(this);
            System.out.println("A new car is parking!");
            System.out.println(newCar);
        }
    }

    public void giveSpot(Vehicle car){
        if(this.occupied == this.capacity){
            System.out.println("Sorry, it looks like there are no available parking spots at this moment, please wait!");
        }
        else {
            car.setTimestamp();
            cars.add(car);
            this.occupied++;
            car.setLotIParkedAt(this);
            System.out.println("A new car is parking!");
            System.out.println(car);
        }
    }

    public void freeSpot(Vehicle byeCar){
        boolean isLeaving = cars.remove(byeCar);
        if(isLeaving){
            byeCar.calculatePrice();
            this.occupied--;
            System.out.println("The spot with " + byeCar + " has just left.");
        }
        else{
            System.out.println("Sorry, there is no car like that here...");
        }
    }

    public void setLotN(String name){
        this.lotN = name;
    }

    public String getLotN(){ return lotN; }

    //getter for list of cars
    public LinkedList<Vehicle> getCars() {
        return cars;
    }

    //getter for the current amount of cars parked
    public int getOccupied() {
        return occupied;
    }

    //getter for capacity
    public int getCapacity() {
        return capacity;
    }

    @Override
    //toString method
    public String toString() {
        return "Parking Lot No.: " + lotN;
    }
}