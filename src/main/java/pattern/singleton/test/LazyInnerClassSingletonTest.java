package pattern.singleton.test;

import pattern.singleton.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        try {
//            Class<?> clazz = LazyInnerClassSingleton.class;
//            Constructor c = clazz.getDeclaredConstructor(null);
//            c.setAccessible(true);
//
//            Object o1 = c.newInstance();
            Object o2 = LazyInnerClassSingleton.getInstance();

            System.out.println(o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}