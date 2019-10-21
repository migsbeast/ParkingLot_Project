import java.util.LinkedList;

public class ParkingLot {

    private int capacity = 0;
    private int occupied = 0;
    private LinkedList<Vehicle> cars = null;

    public ParkingLot(int cap){
        capacity = cap;
        occupied = 0;
        cars = new LinkedList<Vehicle>();
    }

    public void giveSpot(String driver){
        if(this.occupied == this.capacity){
            System.out.println("Sorry, it looks like there are no available parking spots at this moment");
        }
        else{

        }
        capacity -= 1;
    }

    public void freeSpot(){
        capacity += 1;
    }

}
