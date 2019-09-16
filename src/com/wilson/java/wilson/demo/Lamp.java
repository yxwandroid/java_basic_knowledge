package com.wilson.java.wilson.demo;

import java.util.Arrays;

/**
 * Created by yangxuewu on 2018/7/11.
 */
public enum Lamp {

    RED("GREEN"),GREEN("YELLOW"),YELLOW("RED");

    private String next;
    private Lamp(String next){
        this.next = next;
    }

    public Lamp nextLamp(){
        return Lamp.valueOf(next);
    }
}



class mydemo {
    public static void main(String[] args) {

        Lamp red = Lamp.RED;
       // red.nextLamp();
        System.out.print(red);

        System.out.print(red.nextLamp());
//        System.out.print(Arrays.toString(numbers));
//        quickSort(numbers, 0, numbers.length - 1);
//        System.out.print(Arrays.toString(numbers));

    }
}