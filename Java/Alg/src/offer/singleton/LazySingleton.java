package offer.singleton;/*
    加线程锁的懒汉模式，可以lazy loading，锁占用额外资源，效率很低。
 */

public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){};

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}