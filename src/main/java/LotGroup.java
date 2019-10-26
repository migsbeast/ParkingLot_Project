import java.util.LinkedList;

public class LotGroup {
    protected LinkedList<ParkingLot> lotsOwned;
    protected double price;
    protected double discount;

    public LotGroup() {
        this.price = 0;
        this.discount= 0;
    }

    public LotGroup(ParkingLot parkingLot){
        this.lotsOwned = new LinkedList<ParkingLot>();
        lotsOwned.add(parkingLot);
        this.price = 0;
        this.discount= 0;
    }

    public void addLot(ParkingLot parkingLot){
        lotsOwned.add(parkingLot);
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }

    public ParkingLot getLot(int index){return this.lotsOwned.get(index);}

    public double getPrice(){
        return this.price;
    }

    public double getDiscount(){
        return this.discount;
    }
}
