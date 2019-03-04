package com.harrylee.base.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author harrylee
 */
public class DynamicAgent {
    /**
     * 实现InvocationHandler接口，并且可以初始化被代理类的对象
     */
    static class DynamicAgentHandler implements InvocationHandler {
        private Object proxy;

        public DynamicAgentHandler(Object proxy) {
            this.proxy = proxy;
        }

        /**
         * 自定义invoke方法
         *
         * @param proxy
         * @param method
         * @param args
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>>>before invoking");
            //真正调用方法的地方
            Object ret = method.invoke(this.proxy, args);
            System.out.println(">>>>after invoking");
            return ret;
        }
    }

    /**
     * 返回一个被修改过的对象
     *
     * @param interfaceClazz
     * @param proxy
     * @return
     */
    public static Object agent(Class interfaceClazz, Object proxy) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz},
                new DynamicAgentHandler(proxy));
    }

    // public static void main(String[] args) throws Exception {
    //     //注意一定要返回接口，不能返回实现类否则会报错
    //     Fruit fruit = (Fruit) DynamicAgent.agent(Fruit.class, new Apple());
    //     fruit.show();
    // }
}
