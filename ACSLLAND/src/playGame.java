import java.util.Arrays;
import java.util.Scanner;

public class playGame {
	
	ASCLLand playerA = new ASCLLand (0);
	ASCLLand playerB = new ASCLLand (0);
	
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++){
			System.out.println(playGame.round(i));
		}

	}
	
	public static String round (int i){
		System.out.print("Line #" + i + ": ");
		Scanner userInput = new Scanner (System.in);
		String diceRolls [] = (userInput.nextLine()).split(",");
		


	}
	
	public int movePosition (int roll){
		playerA.getPosition();
		System.out.println(playerA.getPosition());
		
		playerB.getPosition();
		System.out.println(playerB.getPosition());
	
	}



}