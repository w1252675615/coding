/*
    1.自由序列化 2.只有一个实例，不怕反射 3.线程安全
 */

public enum EnumSingleton {
    INSTANCE;
    public void doSomething{

    }
}

public class other {
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSomething(); //实现单例中的doSomething方法
    }
}