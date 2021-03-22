package testrunners;

import com.github.javafaker.Faker;

public class test {

    public static void main(String[] args) {
        Faker faker = new Faker();

        String streetName = faker.address().streetName();
        String number = faker.address().buildingNumber();
        String city = faker.address().city();
        String country = faker.address().country();

        System.out.println(String.format("%s\n%s\n%s\n%s",
                number,
                streetName,
                city,
                country));





    }

    public static String randomGSTNumbers(){
        Faker faker = new Faker();
        String s = faker.regexify("[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}");
        return s;
    }
}
