package com.ygl.basic.base.params;

public class Params {
    private static int intStatic = 222;

    public static void main(String[] args) {
        method(intStatic);
        System.out.println(intStatic);
        method();
        System.out.println(intStatic);
    }

    public static void method(int parms) {
        parms = 777;
        intStatic = 888;
    }

    public static void method() {
        intStatic=888;
    }
}
