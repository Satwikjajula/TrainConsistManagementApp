import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {

    // Method to validate Train ID
    public static boolean validateTrainID(String trainID) {
        String trainPattern = "TRN-\\d{4}";
        Pattern pattern = Pattern.compile(trainPattern);
        Matcher matcher = pattern.matcher(trainID);
        return matcher.matches();
    }

    // Method to validate Cargo Code
    public static boolean validateCargoCode(String cargoCode) {
        String cargoPattern = "PET-[A-Z]{2}";
        Pattern pattern = Pattern.compile(cargoPattern);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Validate Train ID
        System.out.print("Enter Train ID (format TRN-1234): ");
        String trainID = scanner.nextLine();
        if (validateTrainID(trainID)) {
            System.out.println("Train ID is valid.");
        } else {
            System.out.println("Invalid Train ID!");
        }

        // Validate Cargo Code
        System.out.print("Enter Cargo Code (format PET-AB): ");
        String cargoCode = scanner.nextLine();
        if (validateCargoCode(cargoCode)) {
            System.out.println("Cargo Code is valid.");
        } else {
            System.out.println("Invalid Cargo Code!");
        }

        scanner.close();
    }
}