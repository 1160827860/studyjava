package com.darksouls.proxy.diyproxy;

import com.imooc.mode.proxy.Car;
import com.imooc.mode.proxy.Moveable;

public class Test {
    @org.junit.jupiter.api.Test
    public void test1() throws Exception {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Moveable m = (Moveable)MyProxy.newProxyInstance(Moveable.class,h);
        m.move();
    }
    
}
