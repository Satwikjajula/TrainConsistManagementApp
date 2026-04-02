public class TrainConsistManagementApp {

    // Custom Exception for invalid bogie capacity
    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // PassengerBogie class with capacity validation
    public static class PassengerBogie {
        private String type;  // e.g., Sleeper, AC Chair, First Class
        private int capacity; // seat capacity

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " Bogie with capacity " + capacity;
        }
    }

    public static void main(String[] args) {

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);  // This will throw exception
        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }

        try {
            PassengerBogie b3 = new PassengerBogie("First Class", 90);
            System.out.println("Created bogie: " + b3);
        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }

    }
}