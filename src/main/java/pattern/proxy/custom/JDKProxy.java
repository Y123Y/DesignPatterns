package pattern.proxy.custom;

import java.lang.reflect.Method;

public class JDKProxy implements MyInvocationHandler {
    private Person person;

    public Object getInstance(Person person) throws Exception{
        this.person = person;
        Class<?> clazz = person.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始");
        method.invoke(person, args);
        System.out.println("代理结束");
        return null;
    }
}
