package com.wilson.java.innerclass;

//java匿名内部类
public class InnerClass {

    public static void main(String[] args) {

        InnerClassA innerClassA = new InnerClassA();
        innerClassA.add();
        innerClassA.c.run();
        System.out.println(innerClassA);
    }
}

class InnerClassA {

    private ClassB b = new ClassB() {
        @Override
        void run() {
            super.run();
        }
    };

    public   ClassC c=new ClassC();

    public void add() {
        ClassD classD = new ClassD();

    }
}


class ClassB {
    void run() {
    }
}
class ClassC {
    void run() {
    }
}

class ClassD {
    void run() {
    }
}

interface ClassE {
    void run();
}
