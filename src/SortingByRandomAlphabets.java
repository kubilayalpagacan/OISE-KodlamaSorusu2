import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class SortingByRandomAlphabets {

	public static void main(String[] args) {

		System.out.println(sorting(scanToArray(), shuffleAlphabet()));
	}

//Random alphabet generation function
	public static String shuffleAlphabet() {
		char[] alphabet = { 'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'ı', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
				'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z', 'q', 'w', 'x' };
		Random rnd = new Random();

		for (int i = 0; i < alphabet.length; i++) {
			int randomIndexToSwap = rnd.nextInt(alphabet.length);
			char temp = alphabet[randomIndexToSwap];
			alphabet[randomIndexToSwap] = alphabet[i];
			alphabet[i] = temp;
		}
//used StringBuffer to convert created random alphabet array to string
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < alphabet.length; i++) {
			stringBuffer.append(alphabet[i]);
		}

		return stringBuffer.toString();
	}

//scanning and creating word array function
	public static String[] scanToArray() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter words with spaces: ");
		String names = scan.nextLine().toLowerCase();
		String[] words = names.split(" ");
		scan.close();
		return words;
	}
//sorting function
	public static boolean sorting(String[] words, String alphabetChars) {
		//temps are for the char's place in array
		//loopCount: for loop iteration number (based on short length)
		int temp1, temp2, loopCount;
		System.out.println("Random gelen alfabe: " + alphabetChars);
		//loop for to compare words
		for (int i = 0; i < words.length - 1; i++) {
			if (words[i].equals(words[i + 1])) {
				continue;
			} else if (words[i].contains(words[i + 1])) {
				return false;
			} else if (words[i + 1].contains(words[i])) {
				continue;
			}
			if (words[i].length() > words[i + 1].length()) {
				loopCount = words[i + 1].length();
			} else {
				loopCount = words[i].length();
			}
			for (int j = 0; j < loopCount - 1; j++) {
				temp1 = alphabetChars.indexOf(words[i].charAt(j));
				temp2 = alphabetChars.indexOf(words[i + 1].charAt(j));
				if (temp1 > temp2) {
					return false;
				}
			}

		}
		return true;

	}
}
