// UC5: Preserve Insertion Order using LinkedHashSet

import java.util.LinkedHashSet;

public class TrainConsistUC5 {

    public static void main(String[] args) {

        // Create LinkedHashSet
        LinkedHashSet<String> train = new LinkedHashSet<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");

        // Attempt to add duplicate
        train.add("Sleeper"); // duplicate (will be ignored)

        // Display final formation
        System.out.println("Final Train Formation:");
        System.out.println(train);
    }
}