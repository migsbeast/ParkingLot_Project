import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;



public class TestParking {
    public static void main(String[] args) throws FileNotFoundException {
        //Choosing the test file
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path of the text file you would like to test:");
        File test = new File(sc.nextLine());
        Scanner ts = new Scanner(test);

        //Creating a new ParkingLot object
        ParkingLot lot = new ParkingLot(20);
        System.out.println("Capacity of parking lot = " + lot.getCapacity());

        //Reading from the test file until the file does not have anymore lines of text
        while(ts.hasNextLine()){
            /* If we have reached the capacity of the parking lot, we will tell the
             * user to wait until a spot opens up so they can go ahead and park, and if
             * we haven't reached the capacity give the spot to the next driver
             */
            if(lot.getOccupied() == lot.getCapacity()){
                System.out.println("\nSorry, it looks like there are no available parking spots at this moment, please wait!");
                //We choose a random car to leave the parking lot
                Random r = new Random();
                int index = r.nextInt(lot.getOccupied());
                Vehicle rc = lot.getCars().get(index);
                System.out.println("\nA car is trying to leave the lot!");
                System.out.println("\n"+rc.getDriver() +" please pay the following amount: $" + rc.calculatePrice()+"0");
                // Opens a spot for the next car to come and park in
                lot.freeSpot(rc);
                lot.giveSpot(ts.nextLine());
            }else {
                lot.giveSpot(ts.nextLine());
            }
        }

        /* Remove all the cars that have been parked
         * until there are no more cars in the parking lot
         */
        while(lot.getOccupied()!=0){
            //choose a random car to leave parking lot
            Random r = new Random();
            int index = r.nextInt(lot.getOccupied());
            Vehicle rc = lot.getCars().get(index);
            System.out.println("\nA car is trying to leave the lot!");
            System.out.println("\n"+rc.getDriver() +" please pay the following amount: $" + rc.calculatePrice()+"0");
            lot.freeSpot(rc);
        }
    }
}
