package pattern.proxy.custom;

public class CustomProxyTest {
    public static void main(String[] args) {
        try {
            Person tn = (Person) new JDKProxy().getInstance(new TianNv());
            System.out.println(tn.getClass());
            tn.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
