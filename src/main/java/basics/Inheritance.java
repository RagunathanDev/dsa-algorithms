package basics;

public class Inheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Base baseDerived = new Derived();
        Derived derived = new Derived();
        base.start();
        baseDerived.start();
        derived.start();
        derived.start();
    }
}

class Base {
    public void start() {
        System.out.println("Base");
    }
}

class Derived extends Base {

    public void start() {
        System.out.println("Derived");

    }
    public void next(){
        System.out.println("next Derived");
    }
}