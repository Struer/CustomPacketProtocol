package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        short a = 1;
        short b= 1;
        Invoker invoker = InvokerHolder.getInvoker(a, b);
        Object invoke = invoker.invoke(new String[]{"qwe", "qwe"});
        System.out.println(invoke);
    }

}
