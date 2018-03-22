package offer.singleton;/*
       饿汉模式，不能做到lazy loading。
 */


public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){};

    public static EagerSingleton getInstance() {
        return instance;
    }
}