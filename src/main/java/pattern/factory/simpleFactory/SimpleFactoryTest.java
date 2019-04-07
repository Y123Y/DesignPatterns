package pattern.factory.simpleFactory;

import pattern.factory.Milk;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();

        Milk milk = factory.createMilk("酸奶");

        System.out.println(milk.getType());
    }
}
