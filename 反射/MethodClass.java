import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射调用方法
public class MethodClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //创建字节码文件
        Class c = Class.forName("DD");
        //反射指定方法
        Method m = c.getMethod("f1",String.class);
        //创建参数数组
        String[] name = {"张三","李四","王五"};
        //循环调用方法
        for (String jg:name) {
            //使用invoke()调用方法
            m.invoke(c.newInstance(),jg); //c.newInstance()返回DD类的对象
        }
        System.out.println("-------------------");
        //调用某个私有的方法
        Method[] m1 = c.getDeclaredMethods();
        for (Method jg:m1) {
            System.out.println(jg);
        }
        Method m2 = m1[4];
        m2.setAccessible(true);
        m2.invoke(c.newInstance());

    }
}

class DD {
    public void f1(String name) {
        System.out.println(name);
    }
    public void f2(String name,int age) {
        System.out.println(name+"    "+age);
    }
    public void f3() {
        System.out.println("无参数");
    }
    public String f4() {
        return "AAA";
    }
    private void f5() {
        System.out.println("私有的");
    }
}

