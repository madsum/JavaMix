package com.ma.home;



import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class JavaRegx
{
    public static void main( String[] args )
    {
        //String regex= ("\\s*");
       // System.out.println(Pattern.matches(regex, "0 0"));
      //  System.out.println(""+"aaaa".matches("^\\s*$"));
  /*      Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher("space here");
        Matcher matcher2 = pattern.matcher("noSpaceHere");
        boolean foundSpace = matcher.find();
        boolean noSpace = matcher.find();
        System.out.println("Space found "+foundSpace);
        System.out.println("Any space found "+noSpace);*/
        System.out.println(StringUtils.contains("asdfasdf.Stock", "Stock"));
        System.out.println(StringUtils.containsIgnoreCase("asdfasdf.Stock", "stock"));
    }
}
