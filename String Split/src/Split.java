import java.util.Arrays;
//Alex Fang 1st period

public class Split 
{
	public static void main(String[] args) {
		//String.split();
				//It's a method that acts on a string, <StringName>.split(<String sp>);
				//Where sp is the string where the string splits
				//And it returns an array
		
		// Example 1: "I really like really red apples"split("really")
		String red = "I really like really red apples";
		String[] really = red.split("really");
		System.out.println(Arrays.toString(really));
		
		//Example 2: play around with String.split! what happens if you "I reallyreally like apples".split("really") ?	
		String str = "I reallyreally like apples";
		String[] split = str.split("really");
		System.out.println(Arrays.toString(split));
		
		// Example 3: "I like apples!".split(" "); 
				//		it will split at spaces and return an array of ["I","like","apples!"]
		String apples = "I like apples!";
		String[] half = apples.split(" ");
		System.out.println(Arrays.toString(half));
		
		//Task #1
		midOfSandwich("applespineapplesbreadlettustomatobaconmayohambreadcheesebread");
		
		//Task #2
		midOfSandwichWithSpaces("bread apples pineapples lettus tomato bacon mayo ham bread cheese bread ");
	}
	
		//Your task #1:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		 * use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		 * What if it's a fancy sandwich with multiple pieces of bread?
		 * //put numbers into an array
		*first ind, last ind, assign both to negative one and if first index not equal to -1 overide last ind
		*/
		public static void midOfSandwich(String sandwich){
				String[] breadArray = sandwich.split("bread");
				if(breadArray.length <= 2){
					System.out.println("Not a sandwich");
				}else{
				for(int i = 1; i <breadArray.length; i++){
					String breadMiddleStatement = breadArray[i];
					System.out.println("Between pieces of bread is : " + breadMiddleStatement);
				}
				}

			}
		
		
		//Your task pt 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		 * Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/
		public static void midOfSandwichWithSpaces(String sandwich){
			String [] sandwichNumber2 = sandwich.split("bread");
			if(sandwichNumber2.length <= 2){
				System.out.println("Not a sandwich");
			}else {
				if(sandwichNumber2[1].equals(" ")){
					System.out.println("Not a sandwich");
				}else{
				for(int i = 1; i < sandwichNumber2.length-1; i++){
					String insideBread = sandwichNumber2[i];
					System.out.println("Between pieces of bread(with spaces) is: " + insideBread);
				}
				}
			}

		}
}
