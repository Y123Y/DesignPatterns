package pattern.delegate.simple;

public class delegateTest {
    public static void main(String[] args) {
        new Boss().command("加密", new Leader());
    }
}
