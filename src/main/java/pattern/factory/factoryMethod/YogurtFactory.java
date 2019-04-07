package pattern.factory.factoryMethod;

import pattern.factory.Milk;
import pattern.factory.Yogurt;

public class YogurtFactory implements MilkFactory {
    @Override
    public Milk createMilk() {
        return new Yogurt();
    }
}
