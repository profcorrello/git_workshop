public class MathService {
    private Calculator calculator;
    public MathService(Calculator calculator) {
        this.calculator = calculator;
    }
    public int doubleAddition(int a, int b) {
        try {
            return 2 * calculator.add(a, b);
        } catch (Exception e) {
            throw new RuntimeException("Failed to compute double addition", e);
        }
    }
}