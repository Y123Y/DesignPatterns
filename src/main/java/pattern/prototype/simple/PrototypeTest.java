package pattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();

        concretePrototype.setName("ABC");
        concretePrototype.setAge(20);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("game");
        hobbies.add("music");
        concretePrototype.setHobbies(hobbies);

        ConcretePrototypeA copy = (ConcretePrototypeA) Client.startClone(concretePrototype);
        System.out.println(copy);
        System.out.println(concretePrototype.getHobbies() == copy.getHobbies());
    }
}
