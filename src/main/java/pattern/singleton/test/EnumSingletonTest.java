package pattern.singleton.test;

import pattern.singleton.register.EnumSingleton;

import java.lang.reflect.Constructor;

public class EnumSingletonTest {
//    public static void main(String[] args) {
//        EnumSingleton s1 = null;
//        EnumSingleton s2 = EnumSingleton.getInstance();
//        s2.setData(SeriableSingleton.getInstance());
//
//        FileOutputStream fos = null;
//        try{
//            fos = new FileOutputStream("EnumSingleton.obj");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(s2);
//            oos.flush();
//            oos.close();
//
//            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            s1 = (EnumSingleton) ois.readObject();
//            ois.close();
//
//            System.out.println(s1.getData());
//            System.out.println(s2.getData());
//            System.out.println(s1.getData() == s2.getData());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            EnumSingleton es = (EnumSingleton) c.newInstance("asd", 123);
            System.out.println(es);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
