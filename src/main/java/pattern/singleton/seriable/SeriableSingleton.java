package pattern.singleton.seriable;

import java.io.Serializable;

public class SeriableSingleton implements Serializable {
    public static final SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton(){}

    public static SeriableSingleton getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
