import java.util.*;
/**
 * 1.1 Implement an algorithm to determine if a string has all unique characters.
 * 	What if you cannot use additional data structures?
 *
 * idea: Make a hash table to store the character.
 * 	 The key is the position of the char in the given string;
 * 	 The value is the char in the given string.
 * By adding the char of the given string into the hash table, first check
 * 	 if the hash table has already contain the value(the particular char in String).
 * If the hash table contains a particular value, meaning the char which is adding has
 * 	 occured before, return false;
 * 	 otherwise, return true;
 *
 * Time Complexity: O(n)
 * 	Since the method of "containValue" of hash table takes constant time: O(1),
 * 	My algorithm check n times for the string. so that is O(n)?
 * 	I am not sure with the analysis.
 * Space Complexity: O(1)
 */
public class C01_01{
	
	public static void main(String[] args) {
		System.out.println("Version 1: ");
		System.out.println(cc150_01_01.allCharUnique("abcdefghijklmnopqrstuvwxyz!@#$%^&*()"));//prints "true"
		System.out.println(cc150_01_01.allCharUnique("abcdefghii"));//prints "false"
		System.out.println(cc150_01_01.allCharUnique("!@"));//prints "true"
		
		System.out.println("\nVersion 2: ");
		System.out.println(cc150_01_01.allCharUnique2("abcdefghijklmnopqrstuvwxyz!@#$%^&*()"));//prints "true"
		System.out.println(cc150_01_01.allCharUnique2("abcdefghii"));//prints "false"
		System.out.println(cc150_01_01.allCharUnique2("!@"));//prints "true"
	}
	
	/*
	 * 1. your code does not handle the corner case for empty string/null string
	 * 2. you can use a hash set for this solution, no need for <key, value> pair here,
	 * 		the key itself is the value.
	 */
	public static boolean allCharUnique(String str){
		//make a hash table to store the char of string
		Hashtable<Integer, Character> charMap = new Hashtable<Integer, Character>(str.length());
		
		//add the 1st char to the hash table
		charMap.put(0, str.charAt(0));
		
		//keep adding until the end
		for(int i = 1; i < str.length(); i++){
			//check if there is already existing the char that is adding to
			if (charMap.containsValue(str.charAt(i)  )  ) {
				return false;
			}
			//if not, add it to the hash table
			charMap.put(i, str.charAt(i));
		}
		return true;
	}
	/**
	 * revised version
	 * @param str the String for checking
	 * @return true if it include the unique character, otherwise false.
	 */
	public static boolean allCharUnique2(String str){
		//corner case:
		if (str.isEmpty()) {
			return true;
		}
		//make a hash set to store the char of string
		HashSet<Character> charMap = new HashSet<Character>(str.length());
		
		//add the 1st char to the hash set
		charMap.add(str.charAt(0));
		
		//keep adding until the end
		for(int i = 1; i < str.length(); i++){
			//check if there is already existing the char
			if (charMap.contains(str.charAt(i)  )  ) {
				return false;
			}
			//if not, add it to the hash set
			charMap.add(str.charAt(i));
		}
		return true;
	}
}