import java.util.Iterator;
import java.util.List;

import org.w3c.dom.css.Counter;

class CrackingTheCodingInterview {
	public static void main(String[] args) {
//		createNByNMatrix(3);
		test(2);
	}
	
	
	static void createNByNMatrix(int dimension){
		int counter = 0;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(++counter +" ");
				if (dimension - j == 1) {
					System.out.println();
				}
			}
		}
		
	}
	
	static void test(int n) {
		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i >= 0; i--) {
				System.out.println(i + "" + j);
			}
		}
	}

	
	static String stringCompression(String string) {
		if (string.length() == 1) return string + "1";
		
		StringBuilder compressedStringBuilder = new StringBuilder();
		char[] stringArray = string.toCharArray();
		int counter = 1;
		
		for (int i = 1; i < stringArray.length; i++) {
			if (stringArray[i-1] == stringArray[i]) 
				counter++;
			
			else {
				compressedStringBuilder.append(stringArray[i-1] + "" + counter);
				counter = 1;
			}
			
			if (stringArray.length - 1 == i) 
				compressedStringBuilder.append(stringArray[i] + "" + counter);
		}
		
		String compressedString = compressedStringBuilder.toString();
		
		return (compressedString.length() >= string.length()) ?  string : compressedString;
	}

	static boolean oneAway(String string1, String string2) {
		// Zero edits
		if (string1.equals(string2)) return true; //O(S1 + S2)

		// One edit
		char[] string1Array = string1.toCharArray();
		char[] string2Array = string2.toCharArray();
		int differences = 0;

		/*
		 * Time complexity of below code is S1 * S2, assuming the time complexity for contains is linear
		 */
		
		// For each char in string1 look for it is string2
		if (string1.length() >= string2.length())
			for (char c : string1Array) {
				if (!string2.contains(String.valueOf(c))) differences++;
				if (differences > 1) return false;
			}
		
		// For each char in string2 look for it is string1
		else {
			for (char c : string2Array) {
				if (!string1.contains(String.valueOf(c))) differences++;
				if (differences > 1) return false;
			}
		}

		return true;
	}

	static boolean isUnique(String string) {
		char[] stringAsArray = string.toCharArray();
		StringBuilder sBuilder = new StringBuilder();

		for (char ch : stringAsArray)
			if (sBuilder.toString().contains(String.valueOf(ch)))
				return false;
			else
				sBuilder.append(ch);

		return true;
	}

	static void urlify(String string, int length) {
		char[] stringAsArray = string.toCharArray();
		StringBuilder output = new StringBuilder();

		for (int i = 0; i < length; i++)

			if (stringAsArray[i] == ' ')
				output.append("%20");
			else
				output.append(stringAsArray[i]);

		System.out.println(output.toString());
	}

	static void printArray(char[] array) {
		for (char c : array) {
			System.out.print(c + "");
		}
	}

}