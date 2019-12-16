package com.test1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Immutable Class for keeping personal information. Use build method to create new instance of Person
 * Can been used 2 ways to add phone number
 * */
public final class Person implements Serializable {

    private String name;
    private int age;
    private final List<Phone> phones;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Phone> getPhones() {
        return phones.stream()
                .collect(Collectors.toList());
    }

    private Person(String name, int age, List<Phone> phones) {
        this.name = name;
        this.age = age;
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (this.hashCode() != o.hashCode()) return false;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getPhones(), person.getPhones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getPhones());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phones=" + phones +
                '}' +
                "\n";
    }

    public static class Builder {

        private String name;
        private int age;
        private List<Phone> phones;

        {
            phones = new ArrayList<>();
        }

        public Builder setName (String name){
            this.name = name;
            return this;
        }

        public  Builder setAge (int age){
            this.age = age;
            return this;
        }

        public Builder addPhones(List <Phone> phones){
            phones.stream().forEach(phone -> this.phones.add(phone));
            return this;
        }

        public Builder addPhone (Phone phone){
            phones.add(phone);
            return this;
        }

        public Person build (){
            return new Person(name, age, phones);
        }
    }
}

