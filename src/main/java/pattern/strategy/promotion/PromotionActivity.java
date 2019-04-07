package pattern.strategy.promotion;

public class PromotionActivity {
    private PromotionStrategy strategy;

    public PromotionActivity(PromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.doPromotion();
    }
}
