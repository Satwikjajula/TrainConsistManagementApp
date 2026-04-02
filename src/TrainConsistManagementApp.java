// UC2: Add Passenger Bogies to Train

import java.util.ArrayList;

public class TrainConsistUC2 {

    public static void main(String[] args) {

        // Create ArrayList
        ArrayList<String> bogies = new ArrayList<>();

        // Add passenger bogies
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        // Display after adding
        System.out.println("Bogies after addition:");
        System.out.println(bogies);

        // Remove a bogie
        bogies.remove("AC Chair");

        // Display after removal
        System.out.println("\nAfter removing AC Chair:");
        System.out.println(bogies);

        // Check existence
        if (bogies.contains("Sleeper")) {
            System.out.println("\nSleeper bogie exists");
        } else {
            System.out.println("\nSleeper bogie not found");
        }

        // Final state
        System.out.println("\nFinal bogie list:");
        System.out.println(bogies);
    }
}