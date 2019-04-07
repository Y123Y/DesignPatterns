package pattern.factory.abstractFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        MilkFactory factory = new MengniuFactory();
        factory.createPureMilk().name();
        factory.createYogurt().name();
    }
}
