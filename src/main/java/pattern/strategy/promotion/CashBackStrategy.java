package pattern.strategy.promotion;

public class CashBackStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("返现促销，返回金额");
    }
}
