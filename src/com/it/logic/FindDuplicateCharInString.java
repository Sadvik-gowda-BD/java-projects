package com.it.logic;


//Find Duplicate char without collection
public class FindDuplicateCharInString {

    public static void main(String[] args) {

        String str = "Virat vrAt";
        System.out.println("Duplicate char in string sensitive: " + str + " is :" + getDuplicateChar(str));
        System.out.println("Duplicate char in string insensitive: " + str + " is :" + getDuplicateCharCaseInsensitive(str));
    }

    private static String getDuplicateChar(String str) {
        StringBuilder duplicateCharString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String currentCharString = String.valueOf(str.charAt(i));
            String unvisitedString = getUnvisitedString(str, i + 1);
            if (unvisitedString.contains(currentCharString) && !duplicateCharString.toString().contains(currentCharString))
                duplicateCharString.append(currentCharString);
        }
        return duplicateCharString.toString();
    }

    private static String getDuplicateCharCaseInsensitive(String str) {
        StringBuilder duplicateCharString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String currentCharString = String.valueOf(str.charAt(i));
            String unvisitedString = getUnvisitedString(str, i + 1);
            if (containsInSensitive(unvisitedString, currentCharString) && !containsInSensitive(duplicateCharString.toString(), currentCharString))
                duplicateCharString.append(currentCharString);
        }
        return duplicateCharString.toString();
    }

    private static boolean containsInSensitive(String str, String givenChar) {
        int charAsciNum = givenChar.charAt(0);
        String upperCase;
        String lowerCase;

        if (charAsciNum <= 90) {
            int lowerCaseInt = charAsciNum + 32;
            upperCase = givenChar;
            lowerCase = String.valueOf((char) lowerCaseInt);
        } else {
            int upperCaseInt = charAsciNum - 32;
            upperCase = String.valueOf((char) upperCaseInt);
            lowerCase = givenChar;
        }
        return str.contains(lowerCase) || str.contains(upperCase);
    }

    private static String getUnvisitedString(String originalString, int index) {
        return originalString.substring(index);
    }

}
