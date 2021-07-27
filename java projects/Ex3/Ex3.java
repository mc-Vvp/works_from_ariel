package Ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		String s = "Hello .. World";
		String[] s1 = sentence(s);
		System.out.println(Arrays.toString(s1));
		System.out.println();
		String Q2s = "The..quick. brown,. fox. jumps  over.. the lAZy dog";
		String[] Q2s1 = dictionary(Q2s);
		System.out.println(Arrays.toString(Q2s1));System.out.println();
		String Q3s1 = "The quick,brown.fox.";
		String Q3s2 = "Lazy,dog";
		boolean q3 = sub(Q3s1, Q3s2);
		System.out.println(q3);

	}

	/*
	 * Input: String of words, numbers, spaces, commas and full stops.
	 * Output: Array of strings which contains only the words and the numbers from the original string.
	 */
	public static String[] sentence(String s) {
		String s1 = "";
		int k = 0;
		int count = countWords(s);
		String[] sArr = new String[count];
		for (int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i)==' ' || s.charAt(i)==',' || s.charAt(i)=='.')
				while((s.charAt(i)==' ' || s.charAt(i)==',' || s.charAt(i)=='.') == true)
				{
					if(i+1 == s.length())
						break;
					i++;
				}
			s1 = createString(s, i);
			if(k<count)
			{
				sArr[k] = s1;
				k++;
			}
			i += s1.length();

		}
		return sArr;
	}

	/*
	 * Input: String of words, numbers, spaces, commas and full stops. And an integer of the first letter of the substring.
	 * Output: New string that starts with the latter at index k, and ends when there is a space, comma of full stop.
	 */
	public static String createString(String s, int k) {
		String s1 = "";
		for(int i = k; i < s.length(); i++) {
			if(s.charAt(i)==' ' || s.charAt(i)==',' || s.charAt(i)=='.')
				break;
			s1 += s.charAt(i);
		}
		return s1;
	}

	/*
	 * Input: String of words, numbers, spaces, commas and full stops.
	 * Output: The number of the words or numbers(that comes without spaces between them) in the string.
	 */
	public static int countWords(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int wordCount = 0;
		boolean isWord = false;
		int endOfLine = s.length() - 1;
		char[] characters = s.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			if ((Character.isLetter(characters[i]) || ((int)characters[i] >= 48 && (int)characters[i] <= 57)) && i != endOfLine) 
				isWord = true;
			else if ((!Character.isLetter(characters[i]) || !((int)characters[i] >= 48 && (int)characters[i] <= 57)) && isWord == true) { 
				wordCount++;
				isWord = false;
			}
			else if ((Character.isLetter(characters[i]) || ((int)characters[i] >= 48 && (int)characters[i] <= 57)) && i == endOfLine) 
				wordCount++;
		}
		return wordCount;
	}



	/*
	 * Input: String of words, numbers, spaces, commas and full stops.
	 * Output: Array of strings which contains only the words and the numbers from the original string. In lower case, without duplicates and alphabetic sorted.
	 */
	public static String[] dictionary(String s) {
		s = s.toLowerCase();
		String[] s1 = sentence(s);
		s1 = sorted(s1);
		s1 = deleteDuplicates(s1);
		return s1;
	}

	/*
	 * Input: Array of strings which contains only the words and the numbers from the original string.
	 * Output: The same array, but sorted alphabetically.
	 */
	public static String[] sorted(String[] s1) {
		String s = "";
		for (int i = 0; i < s1.length; i++)
			for(int j = 0; j < s1.length; j++)
				if(s1[i].compareTo(s1[j]) < 0){
					s = s1[i];
					s1[i] = s1[j];
					s1[j] = s;
				}
		return s1;
	}

	/*
	 * Input: Array of strings which contains only the words and the numbers from the original string.
	 * Output: The same array, but without duplicates of the words in it.
	 */
	public static String[] deleteDuplicates(String[] s) {
		List<String> deleteDuplicates = new ArrayList<String>();
		for(int i = 0; i < s.length; i++)
			if(!deleteDuplicates.contains(s[i]))
				deleteDuplicates.add(s[i]);
		s = deleteDuplicates.toArray(new String[0]);
		return s;

	}



	/*
	 * Input: 2 strings of words, spaces, commas and full stops.
	 * Output: Boolean value that shows if the second string contains only words from the first one dictionary.
	 */
	public static boolean sub(String s, String t) {
		int count = 0;
		String[] sArr = dictionary(s);
		String[] tArr = dictionary(t);
		for(int i = 0; i < tArr.length; i++)
			for(int j = 0; j < sArr.length; j++)
				if(tArr[i].equals(sArr[j]))
					count++;
		if(count == tArr.length)
			return true;
		return false;
	}
}
