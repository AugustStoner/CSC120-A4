import java.util.*;  
public class Car {

    /* Attributes */
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    /* Constructor */
    public Car(int max) {
        this.maxCapacity = max;
        ArrayList<Passenger> passengersOnboard = new ArrayList<Passenger>(maxCapacity); // needs to be restricted by max capacity

    }

    /* Getters */
    public int getCapacity() {
        return this.maxCapacity;
    }
    public int seatsRemaining() {
        return (this.maxCapacity - passengersOnboard.size());
    }


    public static void main(String[] args) {
        


    }
}