package basics.designpatterns.factoryPattern;

public class calculate {
    public static void main(String[] args) {
        try {
            int n2;
            int n1 = n2 = 10;
            int choice = 1;
            operationFactoryImpl operationFactory = new operationFactoryImpl();
            Operation operation = operationFactory.getInstance(choice);
            int result = operation.calculate(n1,n2);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
