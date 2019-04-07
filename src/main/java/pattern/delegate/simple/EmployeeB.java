package pattern.delegate.simple;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，擅长架构，执行" + command);
    }
}
