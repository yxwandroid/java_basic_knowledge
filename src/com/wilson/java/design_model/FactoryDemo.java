package com.wilson.java.design_model;


//工厂模式

public class FactoryDemo {

    public static void main(String[] args) {
        //产品A
        Factory factoryA = new FactoryA();
        Product productA = factoryA.create();
        productA.show();
        //产品B
        Factory factoryB = new FactoryB();
        Product productB = factoryB.create();
        productB.show();


        Factory2.create(ProductA.class).show();//生产ProductA
        Factory2.create(ProductB.class).show();//生产ProductB
    }
}





abstract class  Product{
    public  abstract  void  show();

}

class  ProductA extends  Product{

    @Override
    public void show() {

        System.out.print("a");

    }
}


class  ProductB extends  Product{

    @Override
    public void show() {
        System.out.print("b");
    }
}



abstract   class  Factory {
    abstract  Product create();
}



//通过反射方式实现工厂类
class  Factory2{

    public  static  <T extends  Product> T create(Class<T> clz){
        Product  product = null;
        try {

            product =(Product)Class.forName(clz.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  (T)product;
    }
}



class FactoryA extends  Factory{

    @Override
    Product create() {
        return new ProductA();
    }
}

class FactoryB extends  Factory{

    @Override
    Product create() {
        return new ProductB();
    }
}