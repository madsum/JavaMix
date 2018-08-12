package com.ma.home;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FromatedStringToNumber {

   static Number getNumber(String input){
        if(input.contains(",")){
            DecimalFormat decimalFormat = new DecimalFormat("#,##",
                    new DecimalFormatSymbols(new Locale("fi", "FI")));
            Number number = null;
            try {
                number = decimalFormat.parse( input );
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Double doubleValue = number.doubleValue();
           // doubleValue = decimalFormat.format(doubleValue);
            return doubleValue;
        }else{
            DecimalFormat decimalFormat = new DecimalFormat("#,##",
                    new DecimalFormatSymbols(new Locale("fi", "FI")));
            Number number = null;
            try {
                number = decimalFormat.parse( input );
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Double doubleValue = number.doubleValue();
            return doubleValue;
        }
    }

    public static void main( String[] args )
    {
       // System.out.printf(getNumber("1000,30").toString());
        double d1 = 123456.78;
        double d2 = 567890;
// self commenting issue, the code is easier to understand
        //Locale fmtLocale = Locale.getDefault(Locale.Category.FORMAT);
        NumberFormat formatter = NumberFormat.getInstance(new Locale("fi", "FI"));
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
          formatter.format(d1);
        System.out.println(formatter.format(d1));
        System.out.println(formatter.format(d2));
        try {
            Double val =  NumberFormat.getInstance(new Locale("fi", "FI")).parse("1000,30").doubleValue();
            System.out.printf(val.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Number n = null;
        try {
            n = NumberFormat.getNumberInstance(Locale.FRANCE).parse("123,45");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(n);

        Number number = new CorrectlyDisplayedDouble(Double.parseDouble("1000.30"));
       // Double doubleValue =  number.doubleValue();
        System.out.printf(number.toString());
       // System.out.println(fmtLocale.toLanguageTag());
    }
}
