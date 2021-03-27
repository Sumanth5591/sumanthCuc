package com.qa.util;

import com.github.javafaker.Faker;

import java.util.Random;

public class MockLib {

    static Faker faker = new Faker();
    static char[] password;
    static String str;


    public static void main(String[] args) {
        System.out.println(indPhoneNumber());
        System.out.println(firstName());
        System.out.print(lastName());
        System.out.println(emailAddress());
        System.out.println(aadharCard());
        System.out.println(pANCard());
        System.out.println(setPassword(10));
        System.out.println(setConfirmPassword());
    }

    public static String randomGSTNumbers(){
        Faker faker = new Faker();
        String s = faker.regexify("[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}");
        return s;
    }
    //^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$

    public static String aadharCard(){
        Faker faker = new Faker();
        String s = faker.regexify("[0-9]{12}");
        return s;
    }

    //[A-Z]{5}[0-9]{4}[A-Z]{1}

    public static String pANCard(){
        Faker faker = new Faker();
        String s = faker.regexify("[A-Z]{5}[0-9]{4}[A-Z]{1}");
        return s;
    }

    public static String indPhoneNumber(){
        Random generator = new Random();
        String strippedNum;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        num1 = generator.nextInt(100) + 900;//numbers can't include an 8 or 9, can't go below 100.
        num2 = generator.nextInt(641) + 100;//number has to be less than 742//can't go below 100.
        num3 = generator.nextInt(8999) + 1000; // make numbers 0 through 9 for each digit.//can't go below 1000.
        String indPhonenumber = (num1 +""+ num2+"" + num3);
        return indPhonenumber;
    }

    public static String firstName(){
        String str =  faker.name().firstName();
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        return str;
    }

    public static String lastName(){
        String str =  faker.name().lastName();
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        return str;
    }


    public static String emailAddress(){
        String str =  faker.internet().emailAddress();
        return str;
    }

    public static String setPassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "@$!%*?&";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        str = String.valueOf(password);
        return str;
    }

    public  static String setConfirmPassword(){
        return str;
    }





}
