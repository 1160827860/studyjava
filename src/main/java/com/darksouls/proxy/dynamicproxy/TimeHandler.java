package com.darksouls.proxy.dynamicproxy;

import com.imooc.mode.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class TimeHandler implements InvocationHandler {
    private Object target;

    public TimeHandler(Moveable car) {
        target = car;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("汽车启动了" + new Date());
        method.invoke(target);
        System.out.println("汽车结束启动了" + new Date());
        return null;
    }

}
