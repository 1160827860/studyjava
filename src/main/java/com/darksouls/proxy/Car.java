package com.darksouls.proxy;

import java.util.Random;

public class Car implements Moveable {

    public void move() {

        try {
            long starttime = System.currentTimeMillis();
            Thread.sleep(new Random().nextInt(1000));
            long endtime =  System.currentTimeMillis();
            System.out.println("汽车运行时间" + (endtime - starttime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
