package productapp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests for ProductCalculations.
 *
 * @author Student
 */
public class ProductCalculationTest {

    private static final double DELTA = 0.001;

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(525.0, calc.GetVat(), DELTA);
    }

    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(175.0, calc.GetCommission(), DELTA);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(4200.0, calc.GetTotal(), DELTA);
    }
}