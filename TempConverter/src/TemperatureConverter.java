
/*If its given -32*F it outputs 0*C. Use variables to represent both temperatures. 
 * Include comments that contain your name,
 * the program name and the date. Enter and compile your code in Eclipse. (5/9)(F-32) = C
 * 
 * Alex Fang
 * 9/1/16
 * AP Comp Sci First period
 * This program would convert Celsius to Farenheit.
 */


public class TemperatureConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double C;
		double F = 32;
		
		C = (5.0/9.0)*(F-32.0);
		System.out.println(C + " Degress Celsius Equals " + F + " Degree Farenheit" );
	}

}
