import java.util.*;  
public class Car {

    /* Attributes */

    private ArrayList<Passenger> passengersOnboard;
    private final int maxCapacity;

    /* Constructor */

    public Car(int max) {
        this.maxCapacity = max;
        this.passengersOnboard = new ArrayList<Passenger>(maxCapacity); // needs to be restricted by max capacity
    }

    /* Getters */

    public int getCapacity() {
        return this.maxCapacity;
    }
    public int seatsRemaining() {
        /* 
        try {
            return (this.maxCapacity - passengersOnboard.size());
        } catch (Exception NullPointerException) {
            System.out.println("There are no passengers in the car.");
            return (this.maxCapacity);
        }
        */
        return (this.maxCapacity - passengersOnboard.size());
    }

    /* Modifiers */

    public boolean addPassenger(Passenger p) {
        if (this.seatsRemaining() > 0) {                    // there are seats open &
            try { if (passengersOnboard.contains(p) == false) {
                passengersOnboard.add(p);                   // add the passenger to the array list
                return true;
                }
                else if (passengersOnboard.contains(p) == true) {
                    System.out.println("This passenger is already on the car!");
                    return false;
                }
            } catch (Exception NullPointerException) {
                System.out.println("There are no passengers in the car.");
                passengersOnboard.add(p);
                return true;
            }
            /* 
            if (passengersOnboard.contains(p) == false) {   // the passenger is not already on the car
                passengersOnboard.add(p);                   // add the passenger to the array list
                return true;
            }
            */
        }
        System.out.println("There are no seats left on this car.");
        return false;
    }

    public static void main(String[] args) {
        Car myCar = new Car(100);
        System.out.println("This car has " + myCar.getCapacity() + " total seats.");
        System.out.println("This car has " + myCar.seatsRemaining() + " seats remaining.");

        Passenger pat = new Passenger("Patrick");
        myCar.addPassenger(pat);
        System.out.println("This car has " + myCar.seatsRemaining() + " seats remaining.");

    }
}