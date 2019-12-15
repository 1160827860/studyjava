package com.darksouls.proxy.diyproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class TimeHandler implements InvocationHandler {
    private Object target;

    public TimeHandler(Object target){
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        try {

            System.out.println("汽车开始行驶");
            long starttime = System.currentTimeMillis();
            m.invoke(target);
            long endtime =  System.currentTimeMillis();
//            System.out.println("汽车运行时间" + (endtime - starttime));
            System.out.println("汽车结束启动了" + new Date());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
