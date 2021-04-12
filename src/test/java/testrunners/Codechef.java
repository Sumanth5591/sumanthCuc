package testrunners;/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Codechef.duplicateString("2222lhgfd");
    }

    public static void duplicateString(String str){
        if(str == null){
            System.out.println("string is null");
        }

        if(str.isEmpty()){
            System.out.println("String is Empty");
        }

        if(str.length() <= 1 ){
            System.out.println("String is less than one Character");
        }

        char[] chars = str.toCharArray();
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();

        for(Character ch : chars){
            if(charMap.containsKey(ch)){
                charMap.put(ch,charMap.get(ch)+1);
            }
            else{
                charMap.put(ch,1);
            }
        }
        System.out.println(charMap);
    }


}
