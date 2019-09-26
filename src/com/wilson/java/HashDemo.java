package com.wilson.java;


public class HashDemo {


    public static void main(String[] args) {

        System.out.println(" hashCode");

        Person person =new  Person("wilson");
        System.out.print(person.hashCode());
    }
}


class Person extends  Object{


    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();

//        return 222;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}