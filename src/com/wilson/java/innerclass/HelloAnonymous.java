package com.wilson.java.innerclass;

public class HelloAnonymous {

    public static void main(String[] args) {


        Client client = new Client();
        client.run();

    }
}


class Client {
    public void run() {
        System.out.println("run ");
        OuterCLass.InnerClass innerClass = new OuterCLass().new InnerClass() {
            @Override
            void test() {
                System.out.println("test");
            }
        };


        OuterCLass.InnerStaticClass innerStaticClass = new OuterCLass.InnerStaticClass() {
            @Override
            void testStatic() {

            }
        };

        OuterCLass.InnerInterFace innerInterFace = new OuterCLass.InnerInterFace() {
            @Override
            public void interFaceTest() {

            }
        };
    }
}

class OuterCLass {

    public abstract class InnerClass {
        abstract void test();
    }



    public static abstract class InnerStaticClass {
        abstract void testStatic();
    }


    public interface  InnerInterFace{
        abstract  void  interFaceTest();
    }
}