package pattern.factory.abstractFactory;

public class YiliMilkFactory implements MilkFactory {
    @Override
    public PureMilk createPureMilk() {
        return new YiliPureMilk();
    }

    @Override
    public Yogurt createYogurt() {
        return new YiliYogurt();
    }
}
