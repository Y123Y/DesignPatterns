package pattern.factory.abstractFactory;


public interface MilkFactory {
    PureMilk createPureMilk();
    Yogurt createYogurt();
}
