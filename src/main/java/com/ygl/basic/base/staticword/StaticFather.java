package com.ygl.basic.base.staticword;

/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/6/12 14:07
 * @Desc:
 */
class StaticSon extends StaticFather {
//父类静态代码块——>子类静态代码块——>父类代码块——>父类构造方法——>子类代码块——>子类构造方法

    //静态代码块
    static {
        System.out.println("son load static block ...");
    }

    //普通代码块
    {
        System.out.println("son load common block ...");
    }

    public StaticSon() {
        System.out.println("son load constructor  ...");
    }

    public void sonFunction(){
		System.out.println("son exec function  ...");
	}

    //静态内部类
    static class StaticInner {
        static {
            System.out.println("son load inner static block class...");
        }

        static void staticInnerMethod() {
            System.out.println("son load static inner method...");
        }
    }

}

public class StaticFather {
    //父类静态代码块——>子类静态代码块——>父类代码块——>父类构造方法——>子类代码块——>子类构造方法

    //静态代码块
    static {
        System.out.println("father load static block ...");
    }

    //普通代码块
    {
        System.out.println("father load common block ...");
    }


    public StaticFather() {
        System.out.println("father load constructor  ...");
    }


	public void sonFunction(){
	}

    /**
     * 当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时,类才会被加载。
	 *
     * 静态内部类时也是一样，当方法被调用才被初始化，并不会随着外部类的初始化而执行
	 *
	 * java中静态类只有一种，那就是静态内部类，顶级类不能用static 修饰
     *
     * @param args
     */
    public static void main(String[] args) {
        StaticFather outer = new StaticSon();  //按顺序执行类的初始化属性 方法只在被调用的时候执行
		//调用静态内部类方法，初始化静态内部类
        StaticSon.StaticInner.staticInnerMethod();  //调用内部类的静态方法
		outer.sonFunction();
    }
}
