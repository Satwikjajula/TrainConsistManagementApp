// UC4: Maintain Ordered Train Consist

import java.util.LinkedList;

public class TrainConsistUC4 {

    public static void main(String[] args) {

        // Create LinkedList
        LinkedList<String> consist = new LinkedList<>();

        // Add bogies
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        // Print initial consist
        System.out.println("Initial Consist:");
        System.out.println(consist);

        // Insert Pantry Car at position 2
        consist.add(2, "Pantry");

        System.out.println("\nAfter adding Pantry:");
        System.out.println(consist);

        // Remove first and last bogie
        consist.removeFirst();
        consist.removeLast();

        // Final consist
        System.out.println("\nFinal Consist:");
        System.out.println(consist);
    }
}