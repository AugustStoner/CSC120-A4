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
        try {
            return (this.maxCapacity - passengersOnboard.size());
        } catch (Exception NullPointerException) {
            System.out.println("There are no passengers in the car.");
            return (this.maxCapacity);
        }
        //return (this.maxCapacity - passengersOnboard.size());
    }


    public static void main(String[] args) {
        Car myCar = new Car(100);
        System.out.println("This car has " + myCar.getCapacity() + " total seats.");
        System.out.println("This car has " + myCar.seatsRemaining() + " seats remaining.");


    }
}