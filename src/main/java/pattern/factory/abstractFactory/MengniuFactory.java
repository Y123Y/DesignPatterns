package pattern.factory.abstractFactory;

public class MengniuFactory implements MilkFactory {
    @Override
    public PureMilk createPureMilk() {
        return new MengniuPureMilk();
    }

    @Override
    public Yogurt createYogurt() {
        return new MengniuYogurt();
    }
}
