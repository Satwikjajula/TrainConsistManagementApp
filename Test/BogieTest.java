import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BogieTest {

    @Test
    public void testException_ValidCapacityCreation() throws TrainConsistManagementApp.InvalidCapacityException {
        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.getType());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    public void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("AC Chair", -10)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("First Class", 0)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", -5)
        );
        assertTrue(exception.getMessage().contains("Capacity must be greater than zero"));
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws TrainConsistManagementApp.InvalidCapacityException {
        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 80);
        assertEquals("AC Chair", bogie.getType());
        assertEquals(80, bogie.getCapacity());
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws TrainConsistManagementApp.InvalidCapacityException {
        TrainConsistManagementApp.PassengerBogie b1 = new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);
        TrainConsistManagementApp.PassengerBogie b2 = new TrainConsistManagementApp.PassengerBogie("AC Chair", 60);
        TrainConsistManagementApp.PassengerBogie b3 = new TrainConsistManagementApp.PassengerBogie("First Class", 90);

        assertEquals(72, b1.getCapacity());
        assertEquals(60, b2.getCapacity());
        assertEquals(90, b3.getCapacity());
    }
}