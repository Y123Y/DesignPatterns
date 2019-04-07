package pattern.proxy.staticproxy.proxy;


import pattern.proxy.custom.MyClassLoader;
import pattern.proxy.custom.MyInvocationHandler;
import pattern.proxy.custom.MyProxy;
import pattern.proxy.custom.RouteProxy;
import pattern.proxy.staticproxy.IOrderService;
import pattern.proxy.staticproxy.Order;
import pattern.proxy.staticproxy.db.DynamicDataSourceEntity;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Y on 2019/3/15.
 */
public class OrderServiceDynamicProxy implements MyInvocationHandler {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private Object proxyObj;

    public Object getInstance(Object target){
        this.proxyObj = target;
        Class<?> clazz = target.getClass();
        return RouteProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object res = method.invoke(proxyObj, args);
        after();
        return res;
    }

    private void before(Object target) {
        try {
            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            int dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
            DynamicDataSourceEntity.set(dbRouter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void after(){
        DynamicDataSourceEntity.restore();
    }
}
