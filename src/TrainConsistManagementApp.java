import java.util.ArrayList;
import java.util.List;

public class Train_Consist_Management_App {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("Initializing Train Consist...");

        // Creating an empty list of bogies
        List<String> bogieList = new ArrayList<>();

        // Displaying initial summary
        System.out.println("Initial Bogie Count: " + bogieList.size());
        System.out.println("Train initialized successfully!");
    }
}