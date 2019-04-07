package pattern.singleton.lazy;

import java.io.Serializable;

public class LazyInnerClassSingleton implements Serializable {
    private LazyInnerClassSingleton(){
        if (LazyHolder.LAZY != null){
            throw new RuntimeException("不允许构建多个实例");
        }
    }

    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    private Object readResolve(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
