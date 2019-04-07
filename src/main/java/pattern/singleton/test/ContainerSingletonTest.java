package pattern.singleton.test;

import pattern.singleton.register.ContainerSingleton;

public class ContainerSingletonTest {
    public static void main(String[] args) {
        try {
            ConcurrentExecutor.execute(() -> {
                Object obj = ContainerSingleton.getBean("pattern.singleton.test.Test");
                System.out.println(System.currentTimeMillis() + ":" + obj);
            }, 10, 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
