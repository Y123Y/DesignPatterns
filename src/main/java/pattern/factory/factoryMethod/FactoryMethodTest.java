package pattern.factory.factoryMethod;

import pattern.factory.Milk;

public class FactoryMethodTest {
    public static void main(String[] args) {
        MilkFactory factory = new YogurtFactory();
        Milk milk = factory.createMilk();
        System.out.println(milk.getType());
    }
}
