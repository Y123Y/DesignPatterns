package pattern.singleton.hungry;

public class HungrySingleton {
    private static final HungrySingleton hungrysingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrysingleton;
    }
}
