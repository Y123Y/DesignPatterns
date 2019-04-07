package pattern.strategy.promotion;

public class GroupbuyStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("拼团促销，满20人成团");
    }
}
