// UC7: Sort Bogies by Capacity using Comparator

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistUC7 {

    public static void main(String[] args) {

        // Create list of passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("First Class", 40));

        // Display unsorted list
        System.out.println("Passenger Bogies (Unsorted):");
        passengerBogies.forEach(System.out::println);

        // Sort bogies by capacity using Comparator
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        // Display sorted list
        System.out.println("\nPassenger Bogies (Sorted by Capacity Descending):");
        passengerBogies.forEach(System.out::println);
    }
}