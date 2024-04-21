package basics.designpatterns.singleton;

public class CheckSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance(5);
        System.out.println(singleton.getValue());
        Singleton singleton1 = Singleton.getInstance(4);
        System.out.println(singleton1.getValue());

    }
}
