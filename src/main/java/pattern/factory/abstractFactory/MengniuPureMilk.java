package pattern.factory.abstractFactory;

public class MengniuPureMilk implements PureMilk {
    @Override
    public void name() {
        System.out.println("蒙牛纯牛奶");
    }
}
