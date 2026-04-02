import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BogieTest {

    @Test
    public void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(172, totalSeats);
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Sleeper", 70));

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(242, totalSeats);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Executive", 80));

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(80, totalSeats);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, totalSeats);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        List<Integer> capacities = bogies.stream()
                .map(Bogie::getCapacity)
                .toList();

        assertEquals(List.of(72, 60), capacities);
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 40));

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        int sumManual = 72 + 60 + 40;
        assertEquals(sumManual, totalSeats);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(2, bogies.size()); // original list unchanged
    }
}