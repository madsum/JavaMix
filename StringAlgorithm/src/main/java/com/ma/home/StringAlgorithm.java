package com.ma.home;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class StringAlgorithm {
    /*
     * Using LinkedHashMap to find first non repeated character of String
     * Algorithm :
     *            Step 1: get character array and loop through it to build a
     *                    hash table with char and their count.
     *            Step 2: loop through LinkedHashMap to find an entry with
     *                    value 1, that's your first non-repeated character,
     *                    as LinkedHashMap maintains insertion order.
     */
    public static char getFirstNonRepeatedChar(String str) {
        Map<Character,Integer> counts = new LinkedHashMap<>(str.length());

        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }

        for (Map.Entry<Character,Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }


    /*
     * Finds first non repeated character in a String in just one pass.
     * It uses two storage to cut down one iteration, standard space vs time
     * trade-off.Since we store repeated and non-repeated character separately,
     * at the end of iteration, first element from List is our first non
     * repeated character from String.
     */
    public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }


    /*
     * Using HashMap to find first non-repeated character from String in Java.
     * Algorithm :
     * Step 1 : Scan String and store count of each character in HashMap
     * Step 2 : traverse String and get count for each character from Map.
     *          Since we are going through String from first to last character,
     *          when count for any character is 1, we break, it's the first
     *          non repeated character. Here order is achieved by going
     *          through String again.
     */
    public static char firstNonRepeatedCharacter(String word) {
        HashMap<Character,Integer> scoreboard = new HashMap<>();
        // build table [char -> count]
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.containsKey(c)) {
                scoreboard.put(c, scoreboard.get(c) + 1);
            } else {
                scoreboard.put(c, 1);
            }
        }
        // since HashMap doesn't maintain order, going through string again
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.get(c) == 1) {
                return c;
            }
        }
        throw new RuntimeException("Undefined behaviour");
    }

    public static String reverse(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] strChars = str.toCharArray();

        for (int i = strChars.length - 1; i >= 0; i--) {
            strBuilder.append(strChars[i]);
        }
        return strBuilder.toString();
    }

    public static String reverseRecursively(String str) {
        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }
        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }
    
    public static void reversStingByveriousWay(){
        //original string
        String str = "Sony is going to introduce Internet TV soon";
        System.out.println("Original String: " + str);

        //reversed string using Stringbuffer
        String reverseStr = new StringBuffer(str).reverse().toString();
        System.out.println("Reverse String in Java using StringBuffer: " + reverseStr);

        //iterative method to reverse String in Java
        reverseStr = reverse(str);
        System.out.println("Reverse String in Java using Iteration: " + reverseStr);

        //recursive method to reverse String in Java
        reverseStr = reverseRecursively(str);
        System.out.println("Reverse String in Java using Recursion: " + reverseStr);
    } 


    // Java Program to find duplicate characters in String.
    public static void printDuplicateCharacters(String word) {
        
        char[] characters = word.toCharArray(); // build HashMap with character and number of times they appear in String 

        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        } // Iterate through HashMap to print all duplicate characters of String 
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }
    
    public static void testRemoveDuplicates() {
        int[][] test = new int[][]{
                {1, 1, 2, 2, 3, 4, 5},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 1, 1, 1, 1, 1},};

        for (int[] input : test) {
            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
           // System.out.println("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)));
        }
    }

    // Regular Expression in Java to check numbers in String - Example
    
    public static void checkDoesStringHasNumber(){
        // Regular expression in Java to check if String is number or not
        Pattern pattern = Pattern.compile(".*[^0-9].*");
        //Pattern pattern = Pattern.compile(".*\\D.*");
        String [] inputs = {"123", "-123" , "123.12", "abcd123"};

        for(String input: inputs){
            System.out.println( "does " + input + " is number : "
                    + !pattern.matcher(input).matches());
        }

        // Regular expression in java to check if String is 6 digit number or not
        String [] numbers = {"123", "1234" , "123.12", "abcd123", "123456"};
        Pattern digitPattern = Pattern.compile("\\d{6}");
        //Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");


        for(String number: numbers){
            System.out.println( "does " + number + " is 6 digit number : "
                    + digitPattern.matcher(number).matches());

        }
    }

    public static String transform(String input) {
        HashSet<Character> uniqueChar = new HashSet<>();
        StringBuffer buffer = new StringBuffer();

        for(int i=0; i<input.length(); ++i) {
            uniqueChar.add(input.charAt(i));
        }

        for (Character ch : uniqueChar) {
            buffer.append(ch);
        }
        return buffer.toString();
    }
    
    // How to Convert String to Integer to String in Java with Example
    public static void stringToIntegerViceversa(String number){
        int i = Integer.parseInt(number);
        System.out.println("i: " + i);
        String price = String.valueOf(123);
        System.out.println("price: "+price);
    }
    
    public static String removeCharFromString(String word, char unwanted){
        StringBuilder sb = new StringBuilder();
        char[] letters = word.toCharArray();

        for(char c : letters){
            if(c != unwanted ){
                sb.append(c);
            }
        }
        return sb.toString();   
    }
    
    public static String removeCharFromStringRecursively(String word, char ch){
        int index = word.indexOf(ch);
        if(index == -1){
            return word;
        }
        return removeCharFromStringRecursively(word.substring(0, index) + word.substring(index +1, word.length()), ch);
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }


    
    public static void main(String[] args) {
        String str = "abbcbbb";
        printDuplicateCharacters("Programming");
        printDuplicateCharacters("Combination");
        printDuplicateCharacters("Java");

        System.out.println(AnagramCheck.isAnagram("word", "wrdo"));
        System.out.println(AnagramCheck.isAnagram("army", "mary"));

        System.out.println(firstNonRepeatedCharacter("abcdefghija"));
        System.out.println(firstNonRepeatedCharacter("hello"));
        System.out.println(firstNonRepeatedCharacter("Java"));
        System.out.println(firstNonRepeatedCharacter("simplest"));

        //reversStingByveriousWay();
        //checkDoesStringHasNumber();
        //stringToIntegerViceversa("100");
        //testRemoveDuplicates();

        System.out.println(removeCharFromString("TestUxxx", 'U'));
        System.out.println(removeCharFromStringRecursively("TestUxxx", 't'));

        permutation("abc");
    }
}
