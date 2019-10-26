import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;



public class TestParking {
    public static void main(String[] args) throws FileNotFoundException {
        //Choosing the test file
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path of the text file you would like to test:");
        File test = new File(sc.nextLine());
        Scanner ts = new Scanner(test);

        //Creating first ParkingLot object
        String l_name1 = "Lot 1";
        ParkingLot lot1 = new ParkingLot(10, l_name1);
        System.out.println("Capacity of parking lot 1= " + lot1.getCapacity());

        //Creating second ParkingLot object
        String l_name2 = "Lot 2";
        ParkingLot lot2 = new ParkingLot(10, l_name2);
        System.out.println("Capacity of parking lot 2= " + lot2.getCapacity());

        //Creating third ParkingLot object
        String l_name3 = "Lot 3";
        ParkingLot lot3 = new ParkingLot(80, l_name3);
        System.out.println("Capacity of parking lot 3= " + lot3.getCapacity()+"\n");

        //Creating Groups that control the Lots
        LotGroup g1 = new LotGroup(lot1);
        LotGroup g2 = new LotGroup(lot2);
        g2.addLot(lot3);

        //Price Range for any lot
        double rangeMin = 2.50;
        double rangeMax = 50;
        Random pr = new Random();

        //Reading from the test file until the file does not have anymore lines of text
        while(ts.hasNextLine()){
            double randomValue1 = rangeMin + (rangeMax - rangeMin) * pr.nextDouble();
            double randomValue2 = rangeMin + (rangeMax - rangeMin) * pr.nextDouble();
            g1.setPrice(randomValue1);
            g2.setPrice(randomValue2);

            Vehicle testVehicle = new Vehicle(ts.nextLine());
            LotGroup selected = testVehicle.pickLot(g1, g2);
            ParkingLot testLot = selected.getLot(0);
            if(randomValue1<randomValue2){
                testLot.setPrice(randomValue1);
            }else{
                testLot.setPrice(randomValue2);
            }
            String price = String.format("%.2f",testVehicle.checkPrice(testLot));
            System.out.println("Test car checking parking Lot price: " + price );

            /* If we have reached the capacity of the parking lot, we will tell the
             * user to wait until a spot opens up so they can go ahead and park, and if
             * we haven't reached the capacity give the spot to the next driver
             */
            if(testLot.getOccupied() == testLot.getCapacity()){
                System.out.println("\nSorry, it looks like there are no available parking spots at this moment, please wait!");
                //We choose a random car to leave the parking lot
                Random r = new Random();
                int index = r.nextInt(testLot.getOccupied());
                Vehicle rc = testLot.getCars().get(index);
                String pr_out = String.format("%.2f",rc.calculatePrice());
                System.out.println("\nA car is trying to leave the lot!");
                System.out.println(rc.getDriver() +" please pay the following amount: $" + pr_out);
                // Opens a spot for the next car to come and park in
                testLot.freeSpot(rc);
                testLot.giveSpot(ts.nextLine());
            }
            else {
                testLot.giveSpot(ts.nextLine());
            }
            System.out.println("Test Check Space: "+ testVehicle.checkSpaceAvailablity(lot1));
            System.out.println("Test Check Space: "+ testVehicle.checkSpaceAvailablity(lot2)+"\n");
        }

        LinkedList<ParkingLot> allLots = new LinkedList<ParkingLot>();
        allLots.add(lot1);
        allLots.add(lot2);
        /* Remove all the cars that have been parked
         * until there are no more cars in the parking lot
         */
        for(ParkingLot lt : allLots){
            while(lt.getOccupied()!=0){
                //choose a random car to leave parking lot
                Random r = new Random();
                int index = r.nextInt(lt.getOccupied());
                Vehicle rc = lt.getCars().get(index);
                String pr_out = String.format("%.2f",rc.calculatePrice());
                System.out.println("\nA car is trying to leave the lot!");
                System.out.println(rc.getDriver() + " please pay the following amount: $" + pr_out);
                lt.freeSpot(rc);
            }
        }
    }
}
