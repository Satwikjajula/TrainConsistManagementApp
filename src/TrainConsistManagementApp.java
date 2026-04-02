import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // PassengerBogie class to store type and capacity
    public static class PassengerBogie {
        String type;   // e.g., Sleeper, AC Chair, First Class
        int capacity;  // seat capacity

        public PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " Bogie with capacity " + capacity;
        }
    }

    // Loop-based filtering: returns bogies with capacity > 60
    public static List<PassengerBogie> filterBogieLoop(List<PassengerBogie> bogies, int threshold) {
        List<PassengerBogie> filtered = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.capacity > threshold) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    // Stream-based filtering: returns bogies with capacity > 60
    public static List<PassengerBogie> filterBogieStream(List<PassengerBogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        // Sample bogies
        List<PassengerBogie> bogies = Arrays.asList(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair", 60),
                new PassengerBogie("First Class", 90),
                new PassengerBogie("Sleeper", 50),
                new PassengerBogie("AC Chair", 80)
        );

        int threshold = 60;

        // Loop-based filtering timing
        long loopStart = System.nanoTime();
        List<PassengerBogie> loopFiltered = filterBogieLoop(bogies, threshold);
        long loopEnd = System.nanoTime();
        System.out.println("Loop-based filtered bogies:");
        loopFiltered.forEach(System.out::println);
        System.out.println("Loop filtering time (ns): " + (loopEnd - loopStart));

        System.out.println();

        // Stream-based filtering timing
        long streamStart = System.nanoTime();
        List<PassengerBogie> streamFiltered = filterBogieStream(bogies, threshold);
        long streamEnd = System.nanoTime();
        System.out.println("Stream-based filtered bogies:");
        streamFiltered.forEach(System.out::println);
        System.out.println("Stream filtering time (ns): " + (streamEnd - streamStart));
    }
}