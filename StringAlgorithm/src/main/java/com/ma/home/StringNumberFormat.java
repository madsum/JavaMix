package com.ma.home;

import org.apache.commons.lang3.StringUtils;

public class StringNumberFormat {

    public static double convertToDouble(String temp){
        // it will remove all white space as well as invisible non digit character.
        temp =    temp.replaceAll("[^\\x00-\\x7f]", "");
        //replace all commas if present with dot
        temp = temp.replaceAll(",",".").trim();
        // if there are any empty spaces also take it out.
        temp = temp.replaceAll(" ", "");
        //now convert the string to double
        double result = Double.parseDouble(temp);
        return result; // return the result
    }

    public static void main(String[] args) {
       System.out.println(convertToDouble("437 570,68"));
    }
}
