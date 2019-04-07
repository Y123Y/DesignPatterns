package pattern.singleton.lazy;

public class LazyDoubleCheckSingleton {
    private static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton(){}

    //双重检查锁
    public static LazyDoubleCheckSingleton getInstance(){
        if (lazy == null) {
            synchronized(LazyDoubleCheckSingleton.class) {
                if (lazy == null) {
                    lazy = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazy;
    }

}
