package basics.designpatterns.factoryPattern;

import basics.designpatterns.factoryPattern.operations.Addition;
import basics.designpatterns.factoryPattern.operations.Subtration;
import basics.designpatterns.factoryPattern.operations.InvalidOperation;

public class operationFactoryImpl implements operationFacrory{
    @Override
    public Operation getInstance(int type) throws InvalidOperation {
        switch (type){
            case 1 : return new Addition();
            case 2 : return new Subtration();
            default: throw new InvalidOperation("Invalid choice");
        }
    }
}
