public class Engine {

    /* Attributes */

    private FuelType type;
    private final double max;
    private double currentFuel;
    private static final double FILLAMOUNT = -50;

    /* Constructor */

    public Engine(FuelType f, double maxFuel, double fuelLevel) {
        this.type = f;
        this.max = maxFuel;
        this.currentFuel = fuelLevel;
    }

    /* Getters */

    public double getFuel() {
        return this.currentFuel;
    }
    public double getMaxFuel() {
        return this.max;
    }

    /* Setters */

    private void setFuelLevel(double amt) { // given specific input

        if (amt == 0) { // no fuel given
            System.out.println("No fuel added. Current fuel: " + getFuel());
            return;   
        }
        if (amt < 0) { // negative amount entered
            System.out.println("Cannot add negative fuel. Current fuel: " + getFuel());  
            return;
        }
        if ((amt + this.currentFuel) < max) { // check that tank has space
            this.currentFuel = amt + this.currentFuel;
            System.out.println("Tank filled, new fuel level: " + getFuel());     
        }
        else { // if amount is too high, fill tank to max
            this.currentFuel = this.max;
            System.out.println("Tank filled, fuel level: " + getFuel()); 
        }


    }
    private void setFuelLevel() { // no fuel level provided, fill to max
        this.currentFuel = this.max;
        System.out.println("Tank filled to max, fuel level: " + this.currentFuel);
    }

    /* Methods */

    public void refuel() {
        if (getFuel() <= 0) { // if filling fuel out of necessity, max tank
            setFuelLevel();
        }
        else {                // otherwise, use default amount
            setFuelLevel(FILLAMOUNT);
        }
    }



    public static void main(String[] args) {
        Engine angie = new Engine(FuelType.STEAM, 120, 70);
        System.out.println("Engine has " + angie.getFuel() + " units of fuel remaining.");

        angie.refuel();
        System.out.println("Engine has " + angie.getFuel() + " units of fuel remaining.");
    }

}