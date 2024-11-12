import java.util.ArrayList;

public class Train {

        // Attributes

        private final Engine myEngine;
        private final ArrayList<Car> myCars;
        private static final double DEFAULTFUEL = 100.00;
        private static final int DEFAULTCARS = 3;
        private static final int DEFAULTSIZE = 50;

        // Constructor

        public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
            
            if (fuelCapacity<=0){               // Fuel capacity should never be negative or zero
                fuelCapacity = DEFAULTFUEL;     // Use default
            }
            if (nCars<0){                       // Number of cars should never be negative
                nCars = DEFAULTCARS;            // Use default
            }
            if (passengerCapacity<0){           // Passenger capacity should never be negative
                passengerCapacity = DEFAULTSIZE;// Use default
            }

            this.myEngine = new Engine(fuelType, fuelCapacity);
            this.myCars = new ArrayList<>(nCars);

            for (int i = 0; i < nCars; i++) {
                Car myCar = new Car(passengerCapacity);
                myCars.add(myCar);
            }

        }

        // Accessors

        public Engine getEngine(){
            return this.myEngine;
        }

        public Car getCar(int i){
            return myCars.get(i);
        }

        public int getMaxCapacity(){
            int total = 0;
            for (int i = 0; i < myCars.size(); i++){
                total += myCars.get(i).getCapacity();
            }
            return total;
        }

        public int seatsRemaining(){
            int total = 0;
            for (int i = 0; i < myCars.size(); i++){
                total += myCars.get(i).seatsRemaining();
            }
            return total;
        }

        public void printManifest(){
            for (int i = 0; i < myCars.size(); i++){
                System.out.println("Car "+ (i+1) + " passengers on board:");
                myCars.get(i).printManifest();
            }
            //myCars.forEach((Car) -> Car.printManifest());
        }

        public static void main(String[] args) {
            Train myTrain = new Train(FuelType.INTERNAL_COMBUSTION, 100, 3, 50);
            System.out.println(myTrain.seatsRemaining());
            System.out.println(myTrain.getMaxCapacity());
            myTrain.printManifest();

        }
}
