package com.wilson.java.handler.InvocationHandler;

public class Teacher implements People {
    @Override
    public String work() {
        System.out.println("老师教书育人...");
        return "教书";
    }
}
