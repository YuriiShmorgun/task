package com.test1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String PHONE_NUMBER_PATTERN = "123";

    public static void main(String[] args) {

        List <Person> persons = new ArrayList();
        persons.add(new Person.Builder().setName("Yurii").setAge(22).addPhone(Phone.getInstance("+380960941688")).build());
        persons.add(new Person.Builder().setName("Evgen").setAge(32).addPhone(Phone.getInstance("123")).build());
        persons.add(new Person.Builder().setName("Dmitry").setAge(15).addPhone(Phone.getInstance("+380960941688")).build());
        persons.add(new Person.Builder().setName("Olga").setAge(81).addPhone(Phone.getInstance("+380960941688")).build());
        persons.add(new Person.Builder().setName("Evgen").setAge(33).addPhone(Phone.getInstance("123")).build());
        persons.add(new Person.Builder().setName("Dmitry").setAge(16).addPhone(Phone.getInstance("+380960941688")).build());
        persons.add(new Person.Builder().setName("Oleksandr").setAge(21)
                .addPhone(Phone.getInstance("123"))
                .addPhone(Phone.getInstance("+2345678")).build());


        persons.stream()
                .filter(p -> p.getPhones().stream()
                        .anyMatch(phone -> phone.equals(Phone.getInstance(PHONE_NUMBER_PATTERN))))
                .forEach(System.out::print);

    }
}
