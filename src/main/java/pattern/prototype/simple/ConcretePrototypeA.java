package pattern.prototype.simple;

import java.util.List;

public class ConcretePrototypeA implements Prototype {
    private Integer age;
    private String name;
    private List hobbies;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "ConcretePrototypeA{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    @Override
    public Prototype clone() {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(this.age);
        concretePrototype.setHobbies(this.hobbies);
        concretePrototype.setName(this.name);
        return concretePrototype;
    }
}
