package pattern.delegate.simple;

public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工A，擅长加密，执行" + command);
    }
}
