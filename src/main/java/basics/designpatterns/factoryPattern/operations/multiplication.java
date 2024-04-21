package basics.designpatterns.factoryPattern.operations;

import basics.designpatterns.factoryPattern.Operation;

public class multiplication implements Operation {
    @Override
    public int calculate(int n1,int n2){
        return n1 * n2;
    }
}
