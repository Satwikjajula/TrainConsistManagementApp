import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BogieTest {

    @Test
    public void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72),
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 60),
                new TrainConsistManagementApp.PassengerBogie("First Class", 90)
        );
        List<TrainConsistManagementApp.PassengerBogie> filtered =
                TrainConsistManagementApp.filterBogieLoop(bogies, 60);
        assertEquals(2, filtered.size());
        filtered.forEach(b -> assertTrue(b.capacity > 60));
    }

    @Test
    public void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72),
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 60),
                new TrainConsistManagementApp.PassengerBogie("First Class", 90)
        );
        List<TrainConsistManagementApp.PassengerBogie> filtered =
                TrainConsistManagementApp.filterBogieStream(bogies, 60);
        assertEquals(2, filtered.size());
        filtered.forEach(b -> assertTrue(b.capacity > 60));
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72),
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 60),
                new TrainConsistManagementApp.PassengerBogie("First Class", 90)
        );
        List<TrainConsistManagementApp.PassengerBogie> loopFiltered =
                TrainConsistManagementApp.filterBogieLoop(bogies, 60);
        List<TrainConsistManagementApp.PassengerBogie> streamFiltered =
                TrainConsistManagementApp.filterBogieStream(bogies, 60);
        assertEquals(loopFiltered.size(), streamFiltered.size());
        assertTrue(loopFiltered.containsAll(streamFiltered));
    }

    @Test
    public void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new TrainConsistManagementApp.PassengerBogie("Sleeper", 50 + i % 50));
        }

        long start = System.nanoTime();
        TrainConsistManagementApp.filterBogieLoop(bogies, 60);
        long end = System.nanoTime();
        assertTrue((end - start) > 0);

        start = System.nanoTime();
        TrainConsistManagementApp.filterBogieStream(bogies, 60);
        end = System.nanoTime();
        assertTrue((end - start) > 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new TrainConsistManagementApp.PassengerBogie("Bogie-" + i, i % 100));
        }
        List<TrainConsistManagementApp.PassengerBogie> loopFiltered =
                TrainConsistManagementApp.filterBogieLoop(bogies, 60);
        List<TrainConsistManagementApp.PassengerBogie> streamFiltered =
                TrainConsistManagementApp.filterBogieStream(bogies, 60);

        assertEquals(loopFiltered.size(), streamFiltered.size());
        loopFiltered.forEach(b -> assertTrue(b.capacity > 60));
        streamFiltered.forEach(b -> assertTrue(b.capacity > 60));
    }
}