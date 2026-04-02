import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // GoodsBogie class to store type and cargo
    public static class GoodsBogie {
        String type;   // e.g., Cylindrical, Rectangular
        String cargo;  // e.g., Petroleum, Coal, Grain

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " Bogie carrying " + cargo;
        }
    }

    // Method to check safety compliance
    public static boolean isTrainSafetyCompliant(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));
    }

    public static void main(String[] args) {

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Open", "Grain"));

        System.out.println("Goods bogies in the train:");
        goodsBogies.forEach(System.out::println);

        boolean isSafe = isTrainSafetyCompliant(goodsBogies);
        if (isSafe) {
            System.out.println("Train is safety compliant for goods bogies.");
        } else {
            System.out.println("Train is NOT safety compliant! Check cylindrical bogie cargo.");
        }
    }
}