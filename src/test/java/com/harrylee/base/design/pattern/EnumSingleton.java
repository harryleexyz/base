package com.harrylee.base.design.pattern;

/**
 * @author harrylee
 */
public class EnumSingleton {
    private EnumSingleton() {
    }

    /**
     * 因为 JVM 设计枚举的时候就把枚举设计成单例的了，保证 JVM 中只有一个枚举类元素的唯一实例
     * 这里只是用了枚举的特性
     * 其中 枚举 自动被 static final 修饰
     * 其中 枚举构造函数 自动被 private 修饰
     */
    public enum Singleton {
        INSTANCE;
        private EnumSingleton singleton;

        /**
         * JVM会保证此方法绝对只调用一次
         */
        Singleton() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }
    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}
