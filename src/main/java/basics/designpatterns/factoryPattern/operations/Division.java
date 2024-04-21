package basics.designpatterns.factoryPattern.operations;

import basics.designpatterns.factoryPattern.Operation;

public class Division implements Operation {
    @Override
    public int calculate(int n1, int n2){
        if(n2 == 0)
            throw new ArithmeticException("can't divide by zero");
        return n1/n2;
    }
}
