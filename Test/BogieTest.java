import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BogieTest {

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagementApp.validateTrainID("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistManagementApp.validateTrainID("TRAIN12"));
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN12A"));
        assertFalse(TrainConsistManagementApp.validateTrainID("1234-TRN"));
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-123"));
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-12345"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistManagementApp.validateCargoCode("PET-AB"));
        assertTrue(TrainConsistManagementApp.validateCargoCode("PET-XY"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET-ab"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET123"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("AB-PET"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET-ABC"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistManagementApp.validateTrainID(""));
        assertFalse(TrainConsistManagementApp.validateCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-1234X")); // extra char
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET-AB1")); // extra char
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET-ab")); // lowercase letters
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-123"));   // less than 4 digits
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-12345")); // more than 4 digits
    }
}
