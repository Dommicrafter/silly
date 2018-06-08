/**
 * Test Class for the Calculator
 * ADS 1 - Telematik - TH Wildau
 *
 * @author Roman Kobosil
 * @version 1.0, 29.03.17
 */
public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Example: 11-3*4+10/(2+3*(7.3-6.3)) should be 1");
        System.out.println("Result: " + calculator.getResult("11-3*4+10/(2+3*(7.3-6.3))"));
    }
}
