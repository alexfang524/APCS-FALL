package fracCalc;
import java.util.*;

//Alex Fang
//APCS 1st period
//12/3/16

public class FracCalc {

	public static void main(String[] args) 
    {   // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner (System.in);
    	System.out.println("Enter in equation");
    	String inputString = userInput.nextLine();
    	
       	while (!inputString.equals("quit")){
       		//runs until user enters "quit"
       		if (inputString.indexOf("/0") >0){
       			System.out.println("Can't divide by zero!");
       		}else if (inputString.indexOf("++") >0 || inputString.indexOf("--") >0 ||inputString.indexOf("**") >0 || inputString.indexOf("//") >0){
       			System.out.println("Cannot have that input!");
       		}else{
       			System.out.println(produceAnswer(inputString));
       		}  
       		System.out.println("Enter in another equation");
	        inputString = userInput.nextLine();        	
        }
    }	    
	
	public static String produceAnswer(String input)
    {	// This method takes in any length of fraction input and calculates the answer two operands 
		//at a time from left to right takes away spaces and places the input string into an array
    	String [] array = input.split(" ");
    	String operand = "";
    	String operator = "";
    	String operand2 = "";
    	int i = 0;
    	String finalAnswer = array[0];
    	
    	//the loop separates the string to calculate two numbers at a time, and replaces the first operand each time with the previous answer
    	while (i <= array.length-3){
        	operand = finalAnswer;
        	operator = array[i+1];
        	operand2 = array[i+2];
        	finalAnswer = calculateBothOperands(operand2, operand, operator);
        	i += 2;
    	}
    	return finalAnswer;
    	  
    }
    
    public static String calculateBothOperands (String operand2, String operand, String operator){
    	//this method calculates the answer to two operands

    	//call the parse function to separate operand1
    	int [] parsedOne = FracCalc.parse(operand);
    	int numeratorOne =  parsedOne [0];
    	int denominatorOne = parsedOne [1];
    	int wholeNumberOne = parsedOne [2];
    	
    	//call the parse function to separate operand2
    	int [] parsedTwo = FracCalc.parse(operand2);
    	int numeratorTwo =  parsedTwo [0];
    	int denominatorTwo = parsedTwo [1];
    	int wholeNumberTwo = parsedTwo [2];
    	
    	//call calculate function on the two operands' parsed components
    	String calculateAnswer = FracCalc.Calculate(numeratorOne, denominatorOne, wholeNumberOne, numeratorTwo, denominatorTwo, wholeNumberTwo, operator);
    	
    	//returns the solution
        return calculateAnswer;
    }
     
    public static String Calculate(int numeratorOne, int denominatorOne, int wholeNumberOne, int numeratorTwo, int denominatorTwo, int wholeNumberTwo, String operator){
    	//this method takes in parsed components and does calculations
    	String calculateAnswer = " ";
    	int impropNumeratorOne;
    	int impropNumeratorTwo;
    	
    	//Changes operands 1 and 2 to improper fractions	
    	if (wholeNumberOne < 0){
    		wholeNumberOne *= -1;
    		impropNumeratorOne = -1 *(wholeNumberOne*denominatorOne+numeratorOne);
    		}else {
    			impropNumeratorOne = wholeNumberOne*denominatorOne+numeratorOne;
    	}
    	
    	if (wholeNumberTwo < 0){	
    		wholeNumberTwo *= -1;
    		impropNumeratorTwo = -1 *(wholeNumberTwo*denominatorTwo+numeratorTwo);
    		}else{
    			impropNumeratorTwo = wholeNumberTwo*denominatorTwo+numeratorTwo;
    	}
    	
    	//initializing variables for reduced
    	int answerNumerator;
    	int sameDenominator = denominatorOne * denominatorTwo;
    	int quotientforDenominator = denominatorOne * impropNumeratorTwo;
    	
    	//calls method depending on operator
    	if (operator.equals("+")){  		
    		answerNumerator = add(impropNumeratorOne,denominatorOne, impropNumeratorTwo,denominatorTwo);
    		calculateAnswer = convertToProperForm(answerNumerator,sameDenominator);
    	}else if (operator.equals("-")){
    		answerNumerator = subtract(impropNumeratorOne,denominatorOne, impropNumeratorTwo,denominatorTwo);
    		calculateAnswer = convertToProperForm(answerNumerator,sameDenominator);
    	}else if (operator.equals("*")){
    		answerNumerator = multiply(impropNumeratorOne,denominatorOne, impropNumeratorTwo,denominatorTwo);
    		calculateAnswer = convertToProperForm(answerNumerator,sameDenominator);
    	}else {
    		answerNumerator = divide(impropNumeratorOne,denominatorOne, impropNumeratorTwo,denominatorTwo);
    		calculateAnswer = convertToProperForm(answerNumerator,quotientforDenominator);
    	}   
		return calculateAnswer;
    }
    
    public static String convertToProperForm (int answerNumerator, int answerDenominator){
    	//reduces the fraction into proper form by calculating the greatest common factor (ignores the signs)
    	int a = abs(answerNumerator);
    	int b = abs(answerDenominator);
    	
    	int gcf = 1;
    	while (b > 0){
    		gcf = b;
    		b = a % b;
    		a = gcf;
    	}
    		
    	//reduces by the greatest common factor
    	answerNumerator /= gcf;
    	answerDenominator /= gcf;
    	if (answerNumerator % answerDenominator == 0){
           	// return answer for integer
    		return answerNumerator/answerDenominator + "";
    	}else if (answerNumerator / answerDenominator != 0 ){
    		//return answer for mixed number
    		return answerNumerator/answerDenominator + "_" + abs(answerNumerator) % abs(answerDenominator) + "/" + abs(answerDenominator);
    	}else {
			//answer for simple fraction
    		if (answerDenominator<0) {
    			answerNumerator *= -1;
    			return answerNumerator + "/" + abs(answerDenominator);
    		}
    		return answerNumerator + "/" + answerDenominator;
    	}
    }
    
    public static int[] parse(String operand){

        //this method separates each operand into the whole number, numerator, and denominator       
        	int numerator = 0;
        	int denominator = 1;
        	int wholeNumber = 0;
        	
        	if (!(operand.indexOf("/")>0)){
        		//if operand is an integer
        		wholeNumber = Integer.parseInt(operand);
        		}else if (!(operand.indexOf("_")>0) && (operand.indexOf("/")>0)){
        			//if operand is a fraction
        			numerator = Integer.parseInt(operand.substring(0, operand.indexOf("/")));
        			denominator = Integer.parseInt(operand.substring(operand.indexOf("/")+1));
        		}else {
        			//if operand is a mixed number	
        			numerator = Integer.parseInt(operand.substring(operand.indexOf("_")+1, operand.indexOf("/")));
        			denominator = Integer.parseInt(operand.substring(operand.indexOf("/")+1));
        			wholeNumber = Integer.parseInt(operand.substring(0,operand.indexOf("_")));
        		}  
        	
        	//method returns the components as elements of an array
        	int[] components = new int[3];
        	components [0] = numerator;
        	components [1] = denominator;
        	components [2] = wholeNumber;
        	return components;
        	
    }
    
    
	//operation methods
    public static int multiply(int impropNumeratorOne,
    						   int impropDenominatorOne, 
    						   int impropNumeratorTwo, 
    						   int impropDenominatorTwo){
    	int productNumerator = impropNumeratorOne * impropNumeratorTwo;
    	return productNumerator;
    }
    
    public static int add(int impropNumeratorOne,
    					  int impropDenominatorOne, 
    					  int impropNumeratorTwo, 
    					  int impropDenominatorTwo){   	
    	int sumNumerator = (impropNumeratorOne*impropDenominatorTwo)+ (impropNumeratorTwo*impropDenominatorOne);
    	return sumNumerator;
    }
    
    public static int subtract(int impropNumeratorOne,
    						   int impropDenominatorOne, 
    						   int impropNumeratorTwo, 
    						   int impropDenominatorTwo){   	
    	int sumNumerator = (impropNumeratorOne*impropDenominatorTwo)- (impropNumeratorTwo*impropDenominatorOne);
    	return sumNumerator;
    }
    
    public static int divide(int impropNumeratorOne,
    						 int impropDenominatorOne, 
    						 int impropNumeratorTwo, 
    						 int impropDenominatorTwo){ 	
    	int quotientNumerator = impropNumeratorOne * impropDenominatorTwo;
    	return quotientNumerator;
    }
    
    public static int abs (int value){
		int answer = value;
		if (value < 0){
			answer = -value;
		}
		return answer;
	}
	
  
}