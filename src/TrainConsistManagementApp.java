import java.util.ArrayList;
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

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("Executive", 80));

        System.out.println("All Passenger Bogies:");
        bogies.forEach(System.out::println);

        // Calculate total seating capacity using map() + reduce()
        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)          // extract capacities
                .reduce(0, Integer::sum);        // sum all capacities

        System.out.println("\nTotal Seating Capacity in Train: " + totalSeats);
    }
}