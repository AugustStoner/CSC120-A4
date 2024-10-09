public class Passenger {
    
    /* Attribute */
    private String name;

    /* Constructor */
    public Passenger(String name) {
        this.name = name;
    }

    /* Getter */
    public String getName() {
        return this.name;
    }

    /* Methods */
    public void boardCar(Car c) {
        if (c.addPassenger(this) == true) {
            System.out.println(this.name + " boarded the train car.");
        }
        else {
            System.out.println(this.name + " was not able to board.");
        }
    }
    public void getOffCar(Car c) {
        if (c.removePassenger(this) == true) {
            System.out.println(this.name + " exited the train car.");
        }
        else {
            System.out.println(this.name + " was not able to get off.");
        }
    }

}
