package pattern.strategy.pay;

public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1", "201903161451", 439);
        MsgResult result = order.pay(PayStrategy.UNION_PAY);
        System.out.println(result);
    }
}
