package com.wilson.java.genericity;

import javax.xml.ws.Service;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericsGetTypeInterfaceDemo {
    public static void main(String[] args) {
        Type[] genericInterfaces = ServiceImp.class.getGenericInterfaces();

        //判断是否可以转换成ParamterizedType
        if (genericInterfaces.getClass().isAssignableFrom(ParameterizedType[].class)){
            for (Type genericInterface:genericInterfaces ){
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type type= actualTypeArguments[0];
                if (type instanceof Class){
                    Class clazz= (Class) type;
                    System.out.println(clazz);
                }

            }

        }


    }
}


interface ServiceA<T> {

}

interface ServiceB<T> {

}

class ServiceImp implements ServiceA<EntryA>,ServiceB<EntryB>{


}


class EntryA {

}

class EntryB {

}