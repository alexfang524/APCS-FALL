
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		String trim = statement.trim();
		int lengthOfTrim = trim.length();
		if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("Mr.") >= 0) {
			response = "He sounds like a good teacher";
		}else if (statement.indexOf("Mrs.") >= 0){
			response = "She sounds like a good teacher."; 
		}else if(statement.indexOf("yes") >= 0){
			response = "You are so positive!";
		}else if(statement.indexOf("food") >= 0){
			response = "Are you a food lover? Me too!";
		}else if(statement.indexOf("school") >= 0){
			response = "School will prepare you for the future.";
		}else if(statement.indexOf("name") >= 0){
			response = "My name is !";
		}else if(lengthOfTrim == 0){
			response = "Say something, please";
		}
		else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "That is brilliant!";
		} else if (whichResponse == 5) {
			response = "I understand.";
		}
		return response;
	}
}
