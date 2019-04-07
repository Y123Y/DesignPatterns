package pattern.singleton.threadlocal;

public class ThreadLocalSingleton {
    private ThreadLocalSingleton(){}

    private static final ThreadLocal<ThreadLocalSingleton> threaLocal =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    public static ThreadLocalSingleton getInstance(){
        return threaLocal.get();
    }
}
