package com.ygl.basic.base.interfaceAndAbstract;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/1 22:56
 * @DESC: rookie stronger
 * <p>
 * jdk1.8后的默认方法
 * <p>
 * 接口默认方法，便于接口的扩展
 * <p>
 * 实现类不用实现默认方法，但是可以直接调用该默认方法
 * <p>
 * <p>
 * 1．默认方法使用 default 关键字，一个接口中可以有多个默认方法。
 * 2．接口中既可以定义抽象方法，又可以定义默认方法，默认方法不是抽象方法。
 * 3．子类实现接口的时候，可以直接调用接口中的默认方法，即继承了接口中的默认方法。
 * 4．接口中同时还可以定义静态方法，静态方法通过接口名调用。
 **/
public interface InterfaceDemo {
    //抽象接口方法
    void play();

    //静态方法直接通过接口名调用
    static String getString() {
        return "s";
    }

    //默认方法
    default void run() {
        System.out.println("猫跑");
    }
}
