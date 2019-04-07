package pattern.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<String, PromotionStrategy>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON.name(), new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK.name(), new CashBackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY.name(), new GroupbuyStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();

    private PromotionStrategyFactory(){}

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        PromotionStrategy strategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return strategy == null ? NON_PROMOTION : strategy;
    }

    enum PromotionKey{
        COUPON, CASHBACK, GROUPBUY;
    }
}
