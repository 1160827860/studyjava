package com.darksouls.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    /**
     * 拦截所有目标类的调用
     * @param o 目标方法的实例
     * @param method 目标方法的反射对象
     * @param objects 方法的参数
     * @param methodProxy 代理类的实例
     * @return 对象
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("日志开始");
        methodProxy.invokeSuper(o,objects);
        System.out.println("日志结束");
        return null;
    }
}
