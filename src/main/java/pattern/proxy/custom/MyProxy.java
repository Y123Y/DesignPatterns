package pattern.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {
    public static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h){
        //1.动态生成源代码文件
        String src = generateSrc(interfaces);
        try {
            //2.java文件输出磁盘
            String filePath = MyProxy.class.getResource(".").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.close();

            //3.把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //4.编译生成的.class文件加载到JVM
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();
            //5.返回字节码重组后的新代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package custom;" + ln);
        sb.append("import java.lang.reflect.Method;");
        sb.append("public final class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("MyInvocationHandler h;" + ln);
        sb.append("public $Proxy0(MyInvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        for (Method m : interfaces[0].getMethods()){
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + ln);
            sb.append("try {" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{});" + ln);
            sb.append("this.h.invoke(this, m, null);" + ln);
            sb.append("}catch(Throwable e){" + ln);
            sb.append("e.printStackTrace();" + ln);
            sb.append("}" + ln);
            sb.append("}" + ln);
        }

        sb.append("}" + ln);

        return sb.toString();
    }
}
