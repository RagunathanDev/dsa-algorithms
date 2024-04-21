package basics.designpatterns.factoryPattern;

import basics.designpatterns.factoryPattern.operations.InvalidOperation;

public interface operationFacrory {
    Operation getInstance(int type) throws InvalidOperation;
}
