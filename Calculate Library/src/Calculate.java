// Alex Fang
// APSC 1st period
// This program include methods that are can be used in DoMath
// It will calculate what ever math operation you want to perform
// If it the number is not possible such as a negative number in a square root,
// the console will say illegal argument expression

public class Calculate {
	//returns square of a number
	public static int square(int number){
		return(number * number);
	}
	//multiplies a number by itself 3 times
	public static int cube(int number){
		return(number * number * number);
	}
	//finds average of 2 doubles
	public static double average(double numOne, double numTwo){
		return((numOne + numTwo)/2);
	}
	//finds average of 3 doubles
	public static double average(double num1, double num2, double num3){
		return((num1 + num2 + num3)/3);
	}
	//converts angle measurement in radians to degrees
	public static double toDegrees(double number){
		return number * (180/ 3.14159);
	}
	//converts angle measurement in degrees to radians
	public static double toRadians(double number){
		return ((number * 3.14159) / 180);
	}
	//returns the value of the discriminant
	public static double discriminant(double a, double b, double c){
		double answer;
		answer = (b * b) - (4 * a * c);
		return answer;
	}
	//takes a mixed number and returns it as an improper fraction string
	public static String toImproperFrac(int num1, int num2, int num3){
		return (((num1 * num3) + num2) + "/" + num3);

	}
	//takes improper fraction and returns it as a mixed number string
	public static String toMixedNum(int a, int b){
		String toMixedNum;
		if(a % b != 0){
			toMixedNum = ((a / b) + "_" + (a % b) + "/" + b);
		}else{
			toMixedNum = Integer.toString(a / b);
		}
		return toMixedNum;
	}
	//takes binomial multiplication form and returns string of it multiplied out
	public static String foil (int a, int b, int c , int d, String x){
		String answer;
		String var = "";
		int e = b*d;
		if(b*d < 0){
			var = "–";
			e = e*-1;
	}
		answer = (a * c) + "x^2 + " + ((d * a) + (b * c)) + "x " + var + " " + e;
		return answer;
	}
	//determines of one integer can evenly go into another integer
	public static boolean isDivisibleBy(int num1, int num2){
		if(num2==0){
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		if(num1%num2 == 0){
			return(true);
		}else{
			return(false);
		}
	}
	//gives the absolute value of a double
	public static double absValue(double num1){
		if(num1>=0){
			return(num1);
		}else{
			return(num1 * -1.0);
		}
	}
	//gives back the larger number of 2 integers
	public static double max(double number1, double number2) {
		if(number1 > number2){
			return number1;
		}else{
			return number2;
		}
	}
	//returns max out of 3 doubles
	public static double max(double num1, double num2, double num3) {
		if(num1 > num2 && num1 > num3){
			return num1;
		}else if(num2 > num1 && num2 > num3){
			return num2;
		}else{
			return num3;
		}
	}
	//takes 2 integers and determines the smaller one
	public static double min(double number1, double number2) {
		if(number1 < number2){
			return number1;
		}else{
			return number2;
		}
	}	
	//takes a double and rounds it to 2 decimal places
	public static double round2(double number){
		double x=number*1000;
		double y=x%10;
		if (y >=5){
			return (x-y+10)/1000;
		}else{
			return (x - y)/1000;
		}

	}
	//takes a double and an integer and raises the double to the exponent power
	public static double exponent(double base, int exponent){
		if(base == 0 && exponent == 0){
			throw new IllegalArgumentException("Cannot have base 0 and exponent 0");
		}
		double answer = 1;
		for(int i = 0; i < exponent; i++){
			answer *= base;
		}
		return answer;
	}
	//adds up numbers between 0 and user integer
	public static int factorial(int num1){
		int answer = 1;
			if(num1<0){
				throw new IllegalArgumentException("Cannot find factorial of this number");
			}
		for(int i = 1; i<=num1; i++){
			answer = answer * i;
		}
		return answer;
	}
	//determines whether a number is prime or not
	public static boolean isPrime(int num1){
		boolean prime;
		num1 = (int) absValue(num1);
		for(int i = 2; i<=num1-1; i++){
			prime = Calculate.isDivisibleBy(num1, i);
			System.out.println(i);
			if(prime ==true){
				return false;
			}
		}
		return true;
	}
	//finds greatest common factor between 2 integers
	public static int gcf(int num1, int num2){
		int greatestCommonFactor = 1;
		for(int i=1; i<=num1; i++){
			if(isDivisibleBy(num1,i) && isDivisibleBy(num2,i)){
				greatestCommonFactor=i;
			}
		}
		return (greatestCommonFactor);
	}
	//returns square root of value accurate to 2 decimal places
	public static double sqrt(double num1){
		double i = 0;
		double sqrt = num1/2.0;
		if(num1<=0){
			throw new IllegalArgumentException("Cannot square root this number");
		}
		do{
			i=sqrt;
			sqrt=(i+(num1/i))/2.0;
			
		}while(i-sqrt !=0);
		sqrt = round2(sqrt);
		return sqrt;
	}
	//uses coefficients of quadratic formula to approximate the real roots
	//there are three conditions where:
	//if no real root print "no real root"
	//if there is a repeated root it will only print it once
	//if there are two real roots returns them as strings exactly two decimal places. 
	//the smaller one will come first
	public static String quadForm(int a, int b, int c){
		double root1;
		double root2;
		double discriminant = Calculate.discriminant(a, b, c);
		if (discriminant < 0) {
			return ("no real roots");
		}
		if (discriminant == 0) {
			root1= (b * (-1)) / (a * 2);
			root1= Calculate.round2(root1);
			return ("" + root1);
		}
		if (discriminant > 0) {
			root1 = ((b * (-1)) + sqrt(discriminant)) / (2 * a);
			root1 = Calculate.round2(root1);
			root2 = ((b * (-1)) - sqrt(discriminant)) / (2 * a);
			root2 = Calculate.round2(root2);
			double max = Calculate.max(root1, root2);
			double min = Calculate.min(root1, root2);
			return (min + " and " + max);
		}
		return ("");
	}	
}



