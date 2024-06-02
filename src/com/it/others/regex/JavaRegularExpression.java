package com.it.others.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
[abc]	Find any one character from the options between the brackets. a, b, or c (simple class)
[^abc]	Any character except a, b, or c (negation)
[0-9]	Find one character from the range 0 to 9
[a-zA-Z]	a through z or A through Z, inclusive (range)

.	Find just one instance of any character
^	Finds a match as the beginning of a string as in: ^Hello
$	Finds a match at the end of the string as in: World$

[a-d[m-p]] a through d, or m through p: [a-dm-p] (union)
[a-z&&[def]] d, e, or f (intersection)
[a-z&&[^bc]] a through z, except for b and c: [ad-z] (subtraction)
[a-z&&[^m-p]] a through z, and not m through p: [a-lq-z](subtraction)


 */

public class JavaRegularExpression {

    public static void main(String[] args) {
        //Different ways
        //simpleRegEx();

        System.out.println("------------ONE----------------");
        print(Pattern.matches("","")); //true
        print(Pattern.matches("abc","abc")); //true
        print(Pattern.matches(".yz","xyy")); //false
        print(Pattern.matches(".yz","xyz")); //true
        print(Pattern.matches("..z","abz"));//true

        System.out.println("-------------TWO---------------");
        print(Pattern.matches("[abc]","jbl"));// false , expect single char but here 3 are there
        print(Pattern.matches("[abc]","b")); //true
        print(Pattern.matches("[^abc]","x")); //true

        System.out.println("------------THREE----------------");
        print(Pattern.matches("[a-zA-S]","B")); //true //one char between a-z or A-S
        print(Pattern.matches("[a-zA-S]","W")); //false


        print(Pattern.matches("[VK][a-z]{4}","Virat"));//true
        print(Pattern.matches("[VK][a-z]{5}","Virat")); //false
        print(Pattern.matches("[VK][a-z]{4}","Jirat")); //false

        System.out.println("------------QUANTIFIER----------------");
        //[X]? - X occur once or zero times
        print(Pattern.matches("[XYZ]?","Y")); //true
        print(Pattern.matches("[XYZ]?","YY")); //false
        System.out.println();


        //[X]+ - X occur once or more than once
        print(Pattern.matches("[XYZ]+","Y")); //true
        print(Pattern.matches("[XYZ]+","YY")); //true
        print(Pattern.matches("[XYZ]+","YYXYYZZZ")); //true
        print(Pattern.matches("[XYZ]+","YYA")); //false value should be X or Y Z
        System.out.println();

        //[X]* - X occur zero or more times
        print(Pattern.matches("[XYZ]*","")); //true occurring zero times
        print(Pattern.matches("[XYZ]*","A")); //false A is not in the list
        print(Pattern.matches("[XYZ]*","Y")); //true
        print(Pattern.matches("[XYZ]*","XXYZZ")); //true

        print(Pattern.matches("[A-Za-z]*","abzBJ"));//true
        print(Pattern.matches("[A-Za-z]*","abz899BJ"));//false contains numeric values


        System.out.println("------------digits-----------------");
        //check digits
        print(Pattern.matches("\\d","XXYZZ")); //false
        print(Pattern.matches("\\d","9")); //true

        System.out.println("------------length match-----------------");
        //check digits
        print(Pattern.matches("[a-zA-Z0-9]{5}","abCD")); //false -- length is not matching
        print(Pattern.matches("[a-zA-Z0-9]{5}","abCDE")); //true
        print(Pattern.matches("[a-zA-Z0-9]{5}","aBC12")); //true

        System.out.println("---------------Email matchers------------");

        String pattern = "^[A-Za-z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        print(Pattern.matches(pattern,"sadu.b@gmail.com"));//true
        print(Pattern.matches(pattern,"sadu.bgmail.com"));//false @ is missing
        print(Pattern.matches(pattern,"sadu.b@gmailcom"));//false . is missing

    }

    private static void print(boolean val){
        System.out.println(val);
    }

    private static void simpleRegEx() {
        String word = "Hello world";

        boolean isMatching1 = Pattern
                .compile("myPattern", Pattern.CASE_INSENSITIVE)
                .matcher("MY inputdata")
                .matches();
        System.out.println(isMatching1);


        //OR

        Pattern pattern = Pattern.compile("llo", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(word);
        System.out.println("Matcher.matches :-" + matcher.matches());
        System.out.println("Matcher.find :-" + matcher.find());

        //OR

        boolean isMatching2 = Pattern.matches("llo", word);
        System.out.println(isMatching2);

    }
}
