import java.util.LinkedList;

public class ParkingLot {

    private int capacity = 0;
    private int occupied = 0;
    private LinkedList<Vehicle> cars = null;

    public ParkingLot(int cap){
        this.capacity = cap;
        this.occupied = 0;
        this.cars = new LinkedList<Vehicle>();
    }

    public void giveSpot(String driver){
        if(this.occupied == this.capacity){
            System.out.println("\nSorry, it looks like there are no available parking spots at this moment, please wait!");
        }
        else {
            Vehicle newCar = new Vehicle(driver);
            cars.add(newCar);
            this.occupied++;
            System.out.println("\nA new car is parking!");
            System.out.println(newCar);
        }
    }

    public void freeSpot(Vehicle byeCar){
        boolean isLeaving = cars.remove(byeCar);
        if(isLeaving){
            byeCar.calculatePrice();
            this.occupied--;
            System.out.println("\nThe spot with " + byeCar + " has just left.");
        }
        else{
            System.out.println("Sorry, there is no car like that here...");
        }
    }

    //getter for cars
    public LinkedList<Vehicle> getCars() {
        return cars;
    }

    //getter for size
    public int getOccupied() {
        return occupied;
    }

    //getter for capacity
    public int getCapacity() {
        return capacity;
    }
}
