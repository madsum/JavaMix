package com.ma.home;

import java.text.NumberFormat;
import java.text.ParseException;

public class NegativeStringToNumber {

    public static void main(String[] args) {


        String string = "-100";
        NumberFormat format = NumberFormat.getIntegerInstance();
        try {
            Number number = format.parse( string );
            int intVal = number.intValue();
            long longVal = number.longValue();
            System.out.println("Int: "+intVal+" Long: "+longVal);
        }
        catch ( ParseException e ) {
            System.out.println(e.getMessage());
        }


    }
}
