package com.harrylee.base.aop.cglib;

import com.harrylee.base.aop.jdk.Apple;
import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author harrylee
 */
public class CGlibAgent implements MethodInterceptor {

    private Object proxy;

    /**
     * 生成代理对象
     *
     * @param proxy
     * @return
     */
    public Object getInstance(Object proxy) {
        this.proxy = proxy;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.proxy.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }


    /**
     * 回掉
     *
     * @param obj
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println(">>>>before invoking");
        //真正调用
        Object ret = proxy.invokeSuper(obj, args);
        System.out.println(">>>>after invoking");
        return ret;
    }

    // public static void main(String[] args) {
    //     CGlibAgent cGlibAgent = new CGlibAgent();
    //     Apple apple = (Apple) cGlibAgent.getInstance(new Apple());
    //     apple.show();
    // }
}
