package pattern.singleton.test;

import pattern.singleton.threadlocal.ThreadLocalSingleton;

public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start();
        t2.start();

        System.out.println("END");
    }
}
