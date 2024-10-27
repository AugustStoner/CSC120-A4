public class Engine {

    /* Attributes */

    private FuelType type;
    private final double max;
    private double currentFuel;
    private static final double FILLAMOUNT = 50;
    private boolean check;

    /* Constructor */

    public Engine(FuelType f, double maxFuel) {
        this.type = f;
        this.max = maxFuel;
        this.currentFuel = maxFuel;
    }

    /* Getters */

    public double getFuel() {
        return this.currentFuel;
    }
    private double getMaxFuel() {
        return this.max;
    }

    /* Setters */

    private void setFuelLevel(double amt) { // given specific input

        if (amt == 0) { // no fuel given
            System.out.println("No fuel added. Current fuel: " + getFuel());
            return;   
        }
        /* 
        if (amt < 0) { // negative amount entered
            System.out.println("Cannot add negative fuel. Current fuel: " + getFuel());  
            return;
        }
        */
        if ((amt + this.currentFuel) < max) { // check that tank has space
            this.currentFuel = amt + this.currentFuel;
            System.out.println("New fuel level: " + getFuel());
                 
        }
        if ((amt + this.currentFuel) > max) { // if amount is too high, fill tank to max
            this.currentFuel = this.max;
            System.out.println("Tank filled, fuel level: " + getFuel()); 
            
        }


    }
    private void setFuelLevel() { // no fuel level provided, fill to max
        this.currentFuel = this.max;
        System.out.println("Tank filled to max, fuel level: " + this.currentFuel);
    }

    /* Methods */

    private void refuel() {
        if (getFuel() <= 0) { // if filling fuel out of necessity, max tank
            setFuelLevel();
        }
        else {                // otherwise, use default amount
            setFuelLevel(FILLAMOUNT);
        }
    }
    private boolean go() {
        if (getFuel()>0) {
            setFuelLevel(-10);
            System.out.println(getFuel() + " units of fuel remaining.");
            if (getFuel()>0) {
                check = true;
            }
        }
        if (getFuel() <= 0) {
            check = false;
        }
        return check;
    }

    public String toString(){
        String s = String.format("%s", this.type);
        
        return("This is an Engine with fuel type " + s.toLowerCase() + " and fuel level " + this.currentFuel);
    }


    public static void main(String[] args) {

        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        System.out.println(myEngine.toString());
        
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
        
    }

}