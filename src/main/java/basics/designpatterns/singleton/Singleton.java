package basics.designpatterns.singleton;

public class Singleton {
    private Singleton() {
    }

    private int value;

    private Singleton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private volatile static Singleton singletonObj = null;

    public static Singleton getInstance(int value) {
        if (singletonObj == null) {
            synchronized (Singleton.class) {
                if (singletonObj == null)
                    singletonObj = new Singleton(value);
            }
        }
        return singletonObj;
    }

}
