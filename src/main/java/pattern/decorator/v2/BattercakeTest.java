package pattern.decorator.v2;

public class BattercakeTest {
    public static void main(String[] args) {
        Battercake battercake = new BaseBattercake();

        battercake = new EggDecorator(battercake);

        battercake = new SausageDecorator(battercake);

        battercake = new SausageDecorator(battercake);

        System.out.println(battercake.getMsg() + ", 总价为：" + battercake.getPrice());
    }
}
