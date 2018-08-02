package com.wanda.advancedlight.model;

/**
 * 单例模式
 * Created by PC on 2018/8/2.
 */

public class Singleton {

    /**
     * 饿汉模式
     *
     * 这种方式加载时就完成了初始化，所以类加载比较慢，但是获取对象的速度快，这种方式基于类加载机制，
     * 避免了多线程的同步问题，咋类加载的时候就完成了实例化，没有达到懒加载的效果。
     * 如果从始至终未使用这个实例，则会造成内存的浪费。
     */

//    private static Singleton instance = new Singleton();
//    private Singleton(){}
//    public static Singleton getInstance(){
//        return instance;
//    }



    /**
     * 懒汉模式（线程不安全）
     *
     * 懒汉模式声明了一个静态对象，在用户第一次调用时初始化。这虽然节约了资源，但第一次加载时需要初始化，反应稍慢一些，
     * 而且在多线程中不能正常工作。
     */
//    private static Singleton instance;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        if (instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }


    /**
     *懒汉模式（线程安全）
     *
     * 这种写法能在多线程中很好的工作，但是每次调用getInstance方法是都需要进行同步。
     * 这会造成不必要的同步开销，而且大部分时候我们是用不到同步的，所以不建议用这样模式。
     *
     */
//    private static Singleton instance;
//    private Singleton(){};
//    private static synchronized Singleton getInstance(){
//        if (instance == null){
//            instance = new Singleton();
//
//        }
//        return instance;
//    }


    /**
     * 双重检查模式（DCL）
     *
     * 这种写法在getSingleton方法中进行了两次判空，第一次是为了不必要的同步，第二次是在Singleton等于null的情况下
     * 才创建的实例，
     */


//    private volatile static Singleton singleton;
//
//    private Singleton(){}
//
//    public static Singleton getSingleton(){
//        if (singleton == null){
//            synchronized (Singleton.class){
//                if (singleton == null){
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }

    /**
     * 静态内部类单例模式
     *
     * 第一次加载Singleton类时并不会初始化sInstance,只有第一次调用getInstance方法时虚拟机加载SingletonHolder并初始化sInstance
     * 这样不仅能确保线程安全，也能保证Singleton类的唯一性，所以推荐使用静态内部类单利模式。
     */
    private Singleton(){}
    public static Singleton getInstance(){
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder{
        private static final Singleton sInstance = new Singleton();
    }

}
