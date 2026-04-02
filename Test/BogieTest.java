import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BogieTest {

    @Test
    public void testSafety_AllBogiesValid() {
        List<TrainConsistManagementApp.GoodsBogie> goodsBogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Rectangular", "Coal")
        );
        assertTrue(TrainConsistManagementApp.isTrainSafetyCompliant(goodsBogies));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> goodsBogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(TrainConsistManagementApp.isTrainSafetyCompliant(goodsBogies));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistManagementApp.GoodsBogie> goodsBogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Rectangular", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Open", "Grain")
        );
        assertTrue(TrainConsistManagementApp.isTrainSafetyCompliant(goodsBogies));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistManagementApp.GoodsBogie> goodsBogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Rectangular", "Grain")
        );
        assertFalse(TrainConsistManagementApp.isTrainSafetyCompliant(goodsBogies));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> goodsBogies = new ArrayList<>();
        assertTrue(TrainConsistManagementApp.isTrainSafetyCompliant(goodsBogies));
    }
}