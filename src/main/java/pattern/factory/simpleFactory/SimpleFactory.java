package pattern.factory.simpleFactory;

import pattern.factory.Milk;
import pattern.factory.PureMilk;
import pattern.factory.Yogurt;

public class SimpleFactory {
    public Milk createMilk(String name){
        if ("纯牛奶".equals(name)){
            return new PureMilk();
        }else if ("酸奶".equals(name)){
            return new Yogurt();
        }else{
            return null;
        }
    }
}
