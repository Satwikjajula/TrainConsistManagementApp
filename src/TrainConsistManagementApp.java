// UC3: Track Unique Bogie IDs

import java.util.HashSet;

public class TrainConsistUC3 {

    public static void main(String[] args) {

        // Create HashSet
        HashSet<String> bogieIds = new HashSet<>();

        // Add bogie IDs (with duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display unique bogie IDs
        System.out.println("Unique Bogie IDs:");
        System.out.println(bogieIds);
    }
}