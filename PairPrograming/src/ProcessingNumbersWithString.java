//Alex Fang collaborative programming 
//APCS 1st period
//This program will ask the user to enter a string of numbers
//The program will the print out the largest number the user input,
//The sum of the even numbers,
//the smallest number,
//and the the total of the numbers. 


import java.util.Scanner;

public class ProcessingNumbersWithString {

	private static Scanner userInput;

	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		
		System.out.println("How many numbers? ");
		int terms = userInput.nextInt();
		//ask user how many numbers they want to put
		int min = 0;
		int max = 0;
		int total = 0;
		int largestEven = 0;
		
		System.out.print("Enter a string of numbers seperated by spaces : ");
		for(int i = 1; i < terms ; i++){
			int nextNum = userInput.nextInt();
			//determines the sum of even numbers, the greatest number, the lowest number, and the largest even number
			if(i == 1)
			{
				max = nextNum;
				min = nextNum;
			}else{
				if(nextNum<min){
					min = nextNum;
				}else if (nextNum > max){
					max = nextNum;
				}
			}
			if(nextNum%2 == 0){
				if(nextNum>largestEven){
					largestEven = nextNum;
				}
				total += nextNum;
			}
			
			
		}
		//prints out the totals
		System.out.println("");
		System.out.println("The smallest number is: " + min);
		System.out.println("The largest number is: " + max);
		System.out.println("The total of even numbers are: " + total);
		System.out.println("The largest even number is: " + largestEven);
	}

}