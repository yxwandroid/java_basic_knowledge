package com.wilson.java.wilson.demo;

/**
 * java 枚举类型使用
 */
enum Lamp {

    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private String next;

    Lamp(String next) {
        this.next = next;
     }

    public Lamp nextLamp() {
        return Lamp.valueOf(next);
    }
}


class EnumDemo {
    public static void main(String[] args) {

        Lamp lamp = Lamp.RED;


        if (lamp == Lamp.RED) {
            System.out.println("red");
        } else if (lamp == lamp.GREEN) {
            System.out.println("green");
        }


    }
}