// Name: Robin Martin van den Berg
// This project is all my own work.
// I have not knowingly allowed others to copy my work.

package project_1_SCICOMP102;

import java.util.Scanner; // Import Scanner class. 

public class Project1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // Define Scanner object called input.

		String[] validWords = { "apt", "pat", "tap", "are", "ear", "era", "arm", "mar", "ram", "art", "rat", "tar", "asp", 
				"pas", "sap", "spa", "ate", "eat", "eta", "tea", "bat", "tab", "now", "own", "won", "opt",
				"pot", "top", "own", "now", "won", "bib", "bob", "dad", "did", "dud", "eke", "ere", "eve",
				"ewe", "eye", "gag", "gig", "mum", "nan", "nun", "pap", "pep", "pip", "pop", "pup", "tat", 
				"tit", "tot", "pet", "let", "net", "mom", "ten", "ape", "pea", "pen", "cat", "dog", "bog" }; // Defines a String Array consisting of several valid 3 letter words. 

		int userResponse; // Declare a variable for the user's response when presented with the menu.

		char[][] characterArray = new char[3][3]; // Define a blank 3x3 character array that will be used in the program. 

		do {
			displayMenu();
			userResponse = input.nextInt();

			switch ( userResponse ) {

			case 1: enterChars(characterArray); break;
			case 2: displayArray( characterArray ); break; 
			case 3: wordCount( characterArray, validWords ); break;
			case 4: palindromeCount( characterArray, validWords ); break;
			case 5: anagramCount( characterArray, validWords ); break;

			}

		} while ( userResponse < 6 ) ;

		System.out.println(" ");
		System.out.print("You have exited the program. ");

	}

	public static void displayMenu() { // Define method to re-display the menu to the user after every selection (except for 6).

		// Displays menu options.
		System.out.println("");
		System.out.println("Menu: ");
		System.out.println("1) Enter 9 characters to fill a 3x3 array. ");
		System.out.println("2) Display the 3x3 character array. ");
		System.out.println("3) Display the number of legal words in the columns. ");
		System.out.println("4) Display the number of legal words in the columns that are also palindromes. ");
		System.out.println("5) Display the number of legal words in the columns that are also anagrams. ");
		System.out.println("6) Quit. ");
		System.out.println("Please enter your choice (from 1 - 6). ");
		System.out.println("");

	}

	public static void enterChars(char[][] array) { // Define a method for retrieving the input for the 3x3 character array.

		Scanner input = new Scanner(System.in);

		System.out.println(" ");
		System.out.println("Please enter 9 characters to fill a 3 x 3 character array, with each character seperated by a space: ");
		System.out.println(" ");

		for ( int i = 0 ; i < array.length ; i++ ) {

			for ( int j = 0 ; j < array[i].length ; j++ ) {

				array[j][i] = input.next().charAt(0); // Enter the characters 1 by 1 down the columns.

			}
		}

	}

	public static void displayArray( char array[][] ) { // Define a method that displays the 3x3 character array.

		System.out.println("");

		for ( int i = 0 ; i < array.length ; i++ ) { 

			for ( int j = 0 ; j < array[i].length ; j++ ) { 

				System.out.print( array[i][j] + " " ); // Print the characters 1 by 1 across the rows.

			}

			System.out.println("");

		}

		System.out.println("");

	}

	public static void wordCount(char[][] array, String[] validWords) { // Define a method that counts the number of valid words.

		int legalWordsCount = 0;

		String wordColumn1 = new String(); // Create string variables for the 3 possible words down the columns.
		String wordColumn2 = new String();
		String wordColumn3 = new String();

		for ( int i = 0 ; i < array.length ; i++ ) { // Construct the 3 possible words down each column.

			wordColumn1 = wordColumn1 + array[i][0];
			wordColumn2 = wordColumn2 + array[i][1];
			wordColumn3 = wordColumn3 + array[i][2];

		}

		if ( isValidWord(  wordColumn1 , validWords ) == true ) { // If the constructed word is a valid one then increase the word count.

			legalWordsCount++;

		}

		if ( isValidWord(  wordColumn2 , validWords ) == true ) {

			legalWordsCount++;

		}

		if ( isValidWord(  wordColumn3 , validWords ) == true ) {

			legalWordsCount++;

		}

		System.out.println("");
		System.out.println("The columns of your 3 x 3 character array contain " + legalWordsCount + " legal words. ");
		System.out.println("");

	}

	public static boolean isValidWord(String string, String[] validWords) { // Define a method for determining if a string is a valid word.

		for(int i = 0 ; i < validWords.length ; i++ ) {

			if (string.equals(validWords[i])) {

				return true;

			}

		}

		return false;

	}

	public static void palindromeCount(char[][] array, String[] validWords) { // Define a method for counting the number of palindromes.

		int palindromeCount = 0;

		String wordColumn1 = new String(); // Create string variables for the 3 possible words down the columns.
		String wordColumn2 = new String();
		String wordColumn3 = new String();

		for (int i = 0 ; i < array.length ; i++ ) { // Construct the 3 possible words down each column.

			wordColumn1 = wordColumn1 + array[i][0];
			wordColumn2 = wordColumn2 + array[i][1];
			wordColumn3 = wordColumn3 + array[i][2];

		}

		if ( ( isPalindrome( wordColumn1 , validWords ) == true ) ) { // If the constructed word is a valid word and a palindrome then increase the palindrome count.

			palindromeCount++;

		}

		if ( ( isPalindrome( wordColumn2 , validWords ) == true ) ) {

			palindromeCount++;

		}

		if ( ( isPalindrome( wordColumn3 , validWords ) == true ) ) {

			palindromeCount++;

		}

		System.out.println(" ");
		System.out.println("The columns of your 3 x 3 character array contain " + palindromeCount + " legal words that are also palindromes. ");
		System.out.println(" ");

	}

	public static boolean isPalindrome(String word, String[] validWords) { // Define a method for determining if a word is a plaindrome.

		String reversedWord = new String(); // Declares a String that will hold the reversed word.

		for (int i = word.length() - 1 ; i >= 0 ; i-- ) {

			reversedWord = reversedWord + word.charAt(i); // The reversedWord String is filled with the same characters as the principal word, but in reverse order.

		}

		if ( word.equals( reversedWord ) && isValidWord( reversedWord , validWords) ) { // If the principal word is a legal word and is the same as the reversed word then the principal word is a palindrome. 

			return true;
		}

		return false;

	}

	public static void anagramCount(char[][] array, String[] validWords) { // Define a method for counting the number of anagrams.

		int anagramCount = 0; 

		String wordColumn1 = new String(); // Create string variables for the 3 possible words down the columns.
		String wordColumn2 = new String();
		String wordColumn3 = new String();

		for (int i = 0 ; i < array.length ; i++ ) { // Construct the 3 possible words down each column.

			wordColumn1 = wordColumn1 + array[i][0];
			wordColumn2 = wordColumn2 + array[i][1];
			wordColumn3 = wordColumn3 + array[i][2];

		}

		if ( ( isAnagram( wordColumn1, validWords ) == true ) ) { // If the constructed word is a legal word and an anagram then increase the anagram count.

			anagramCount++;

		}

		if ( ( isAnagram( wordColumn2, validWords ) == true ) ) {

			anagramCount++;

		}

		if ( ( isAnagram( wordColumn3, validWords ) == true ) ) {

			anagramCount++;

		}

		System.out.println(" ");
		System.out.println("The columns of your 3 x 3 character array contain " + anagramCount + " legal words that are also anagrams. ");
		System.out.println(" ");

	}

	public static boolean isAnagram( String word, String[] validWords ) { // Define a method for determining if a word is an anagram.

		// We note that a 3 letter word can only be rearranged a maximum of 5 other ways (if we disregard the principal 3 letter word).  

		String newWord1 = new String(); // Define 5 new strings that will hold our 5 new possible words.
		String newWord2 = new String();
		String newWord3 = new String();
		String newWord4 = new String();
		String newWord5 = new String();

		newWord1 = newWord1 + word.charAt(0) + word.charAt(2) + word.charAt(1); // Construct 5 new possible words using the principal word.
		newWord2 = newWord2 + word.charAt(1) + word.charAt(0) + word.charAt(2);
		newWord3 = newWord3 + word.charAt(1) + word.charAt(2) + word.charAt(0);
		newWord4 = newWord4 + word.charAt(2) + word.charAt(0) + word.charAt(1);
		newWord5 = newWord5 + word.charAt(2) + word.charAt(1) + word.charAt(0);

		String[] potentialAnagrams = { newWord1 , newWord2 , newWord3 , newWord4 , newWord5 }; // Create a String array that contains all of the new possible words.

		for( int i = 0 ; i < potentialAnagrams.length ; i++ ) { // Loop through the String array of potential anagrams.

			for ( int j = 0 ; j < validWords.length ; j++ ) { // Loop through the String array of valid words.

				// If the potential word is a valid word AND the potential word is not the same as the principal word, then it is an anagram.

				if ( ( potentialAnagrams[i].equals( validWords[j] ) == true ) && ( potentialAnagrams[i].equals( word ) == false ) ) { 

					return true;

				}

			}

		}

		return false;

	}


	// t o p e a r a r e

}
