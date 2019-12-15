package com.darksouls.proxy.staticproxy;

import com.imooc.mode.proxy.Car;
import com.imooc.mode.proxy.Moveable;
import com.imooc.mode.proxy.dynamicproxy.LogHandler;
import com.imooc.mode.proxy.dynamicproxy.TimeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

    @org.junit.jupiter.api.Test
    public void test2() {
        Car1 car1 = new Car1();
        car1.move();
    }
    @org.junit.jupiter.api.Test
    public void test1 (){
        Car2 car2 = new Car2(new Car());
        car2.move();
    }

    /**
     * 对动态代理进行测试
     */
    @org.junit.jupiter.api.Test
    public void test3(){
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class cls = car.getClass();
        InvocationHandler l = new LogHandler(car);
        /**
         * loader是类加载器
         * interfaces 实现接口
         * h InvocationHandler
         */
        Moveable v = (Moveable)Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),h);
         v.move();
    }
    /**
     * 动态代理对两种方法的叠加、
     * 第一种方法
     */
    @org.junit.jupiter.api.Test
    public void test4(){
        /**
         * 使用第一种方法进行功能的叠加
         */
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class cls = car.getClass();
        /**
         * loader是类加载器
         * interfaces 实现接口
         * h InvocationHandler
         */
        Moveable v = (Moveable)Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),h);
        InvocationHandler l = new LogHandler(v);
        Moveable v1 = (Moveable)Proxy.newProxyInstance(v.getClass().getClassLoader(),v.getClass().getInterfaces(),l);
        v1.move();
    }
    /**
     * 动态代理模式的第二种方法
     */
    @org.junit.jupiter.api.Test
    public void test5(){


    }






}
