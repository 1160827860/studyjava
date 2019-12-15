package com.darksouls.proxy.cglib;

public class Test {
    @org.junit.jupiter.api.Test
    public void test1(){
        CglibProxy proxy = new CglibProxy();
        Train t = (Train) proxy.getProxy(Train.class);
        t.train();
    }

}
