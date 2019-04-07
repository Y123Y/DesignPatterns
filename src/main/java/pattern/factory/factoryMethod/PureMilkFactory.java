package pattern.factory.factoryMethod;

import pattern.factory.Milk;
import pattern.factory.PureMilk;

public class PureMilkFactory implements MilkFactory {
    @Override
    public Milk createMilk() {
        return new PureMilk();
    }
}
