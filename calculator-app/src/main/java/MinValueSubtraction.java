
public class MinValueSubtraction {
	public static void main(String[] args) {
		int minValue = Integer.MIN_VALUE;
		int result = minValue - 1;
		System.out.println("Integer.MIN_VALUE: " + minValue);
		System.out.println("Integer.MIN_VALUE - 1: " + result);
		System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
		
		if(result > Integer.MIN_VALUE) {
			System.out.println("TRUE: Subtraction did not result in Integer.MIN_VALUE");
		}else {
			System.out.println("FALSE: Subtraction did result in Integer.MIN_VALUE");
		}
	}
}