package offer.singleton;/*
    使用静态内部类加载，Lazy loading，线程安全。
 */

public class EagerSingleton2 {
    private EagerSingleton2() {}
    private static class SingletonHolder {
        private static final EagerSingleton2 instance = new EagerSingleton2();
    }
    public static EagerSingleton2 getInstance(){
        return SingletonHolder.instance;
    }
}