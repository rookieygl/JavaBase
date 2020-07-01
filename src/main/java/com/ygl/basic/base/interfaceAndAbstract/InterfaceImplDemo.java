package com.ygl.basic.base.interfaceAndAbstract;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/1 23:13
 * @DESC: rookie stronger
 **/
public class InterfaceImplDemo implements InterfaceDemo {

    public static void main(String[] args) {
        InterfaceDemo interfaceDemo = new InterfaceImplDemo();
        interfaceDemo.play();
        System.out.println(InterfaceDemo.getString());
    }

    @Override
    public void play() {
        System.out.println("实现方法");
        run();
    }

}
