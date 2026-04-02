// UC8: Filter Passenger Bogies Using Streams

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Bogie class reused from UC7
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

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Create a list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Executive", 80));

        System.out.println("All Passenger Bogies:");
        bogies.forEach(System.out::println);

        // Filter bogies with capacity > 70
        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        System.out.println("\nHigh-Capacity Bogies (Capacity > 70):");
        highCapacityBogies.forEach(System.out::println);
    }
}