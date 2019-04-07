package pattern.factory;

public class Yogurt implements Milk {
    @Override
    public String getType() {
        return "酸奶";
    }
}
