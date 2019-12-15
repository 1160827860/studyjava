package com.darksouls.proxy.staticproxy;

import com.imooc.mode.proxy.Car;

import java.util.Date;

/**
 * 使用继承来实现静态代理
 */
public class Car1 extends Car {
    @Override
    public void move(){
        System.out.println("汽车启动了" + new Date());
        super.move();
        System.out.println("汽车结束启动了" + new Date());
    }

}
