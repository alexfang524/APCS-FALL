
public class StringExplorer {

	public static void main(String[] args) {
		String sample = "The quick brown fox jumped over the lazy dog.";

		// Demonstrate the indexOf method.
		// if substring does not occur in the string return -1
		int position = sample.indexOf("quick");
		System.out.println("sample.indexOf(\"quick\") = " + position);

		// Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println("sample.toLowerCase() = " + lowerCase);
		System.out.println("After toLowerCase(), sample = " + sample);

		// Try other methods here:
		int notFoundPsm = sample.indexOf("slow");
		System.out.println("sample.indexOf(\"slow\") = "+ notFoundPsm);

		
	}

}
