package pattern.strategy.promotion;

import org.apache.commons.lang3.StringUtils;

public class PromotionActivityTest {
//    public static void main(String[] args) {
//        PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
//        PromotionActivity activity1111 = new PromotionActivity(new CashBackStrategy());
//
//        activity618.execute();
//        activity1111.execute();
//    }

//    public static void main(String[] args) {
//        PromotionActivity activity;
//        String promotionKey = "COUPON";
//
//        if (StringUtils.equals(promotionKey, "COUPON")) {
//            activity = new PromotionActivity(new CouponStrategy());
//        } else if (StringUtils.equals(promotionKey, "CASHBACK")) {
//            activity = new PromotionActivity(new CashBackStrategy());
//        }else {
//            activity = new PromotionActivity(new EmptyStrategy());
//        }
//
//        activity.execute();
//    }

    public static void main(String[] args) {
        String promotionKey = "GROUPBUY";
        PromotionActivity activity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        activity.execute();
    }
}
