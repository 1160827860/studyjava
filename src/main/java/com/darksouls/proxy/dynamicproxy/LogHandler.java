package com.darksouls.proxy.dynamicproxy;


import com.imooc.mode.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogHandler implements InvocationHandler {
    private Object target;

    public LogHandler(Moveable car) {
        target = car;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("日志启动了" + new Date());
        method.invoke(target);
        System.out.println("日志结束" + new Date());
        return null;
    }
}
