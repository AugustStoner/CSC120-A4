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
            if (passengersOnboard.contains(p) == true) {
                System.out.println("This passenger is already on the car!");
                return false;
                }
                else if (passengersOnboard.contains(p) == false) {
                    passengersOnboard.add(p);                   // add the passenger to the array list
                    return true;
                }
            }
            /* 
            if (passengersOnboard.contains(p) == false) {   // the passenger is not already on the car
                passengersOnboard.add(p);                   // add the passenger to the array list
                return true;
            }
            */
        System.out.println("There are no seats left on this car.");
        return false;
    }
    
    public boolean removePassenger(Passenger p) {
        if (passengersOnboard.contains(p) == true) {
            return passengersOnboard.remove(p);
        }
        else {
            System.out.println(p.getName() + " is not on board.");
            return false;
        }
        
    }

    public void printManifest() {
        if (passengersOnboard.isEmpty()) {
            System.out.println("Car is empty!");
        }
        else {
            System.out.println("Passengers on board:");
            passengersOnboard.forEach((p) -> System.out.println(p.getName()));
        }
    }
    

    public static void main(String[] args) {
        Car myCar = new Car(100);
        System.out.println("This car has " + myCar.getCapacity() + " total seats.");
        System.out.println("This car has " + myCar.seatsRemaining() + " seats remaining.");

        Passenger pat = new Passenger("Patrick");
        Passenger alec = new Passenger("Alexander");
        Passenger jean = new Passenger("Jeannie");
        pat.boardCar(myCar);
        myCar.printManifest();
        alec.boardCar(myCar);
        jean.boardCar(myCar);
        pat.getOffCar(myCar);
        myCar.printManifest();
    }
}