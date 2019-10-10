import javax.crypto.spec.PSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

//反射的常用方法
public class BasePro {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        AA a = new AA();
        //创建字节码文件
        Class c1 = Class.forName("AA");
        //类加载器
        ClassLoader c = c1.getClassLoader();
        System.out.println(c);

        //获取字节码文件的成员变量
        System.out.println("获取类的公共成员变量：");
        Field[] f = c1.getFields();
        for (Field jg:f) {
            System.out.println(jg);
        }
        System.out.println();
        System.out.println("获取类的所有成员变量：");
        Field[] f2 = c1.getDeclaredFields();
        for (Field jg:f2) {
            System.out.println(jg);
        }
        System.out.println();
        //获取类的构造方法
        System.out.println("获取类的公共构造方法");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor jg:constructors) {
            System.out.println(jg);
        }
        System.out.println();
        System.out.println("获取类的所有构造方法");
        Constructor[] constructors2 = c1.getDeclaredConstructors();
        for (Constructor jg:constructors2) {
            System.out.println(jg);
        }
        System.out.println();
        //获取类的方法
        System.out.println("获取类以及类的父类的所有公共方法");
        Method[] method = c1.getMethods();
        for (Method jg:method) {
            System.out.println(jg);
        }
        System.out.println();
        System.out.println("获取类自己的所有方法");
        Method[] method2 = c1.getDeclaredMethods();
        for (Method jg:method2) {
            System.out.println(jg);
        }

        System.out.println("---------------");

        //反射类的父类
        Class c2 = Class.forName("AA1");
        System.out.println(c2.getSuperclass());

        Method method1 = c2.getMethod("show3");
        //反射方法的修饰符
        System.out.println(method1.getModifiers());
        //反射方法的名字
        System.out.println(method1.getName());
        //反射方法的参数类型
        System.out.println(Arrays.toString(method1.getParameterTypes()));

        System.out.println("----------------");

        //反射类的接口
        System.out.println(Arrays.toString(c2.getInterfaces()));
        System.out.println("----------------");
        //反射属性值的类型
        System.out.println(c2.getTypeName());
    }
}

class AA {
    //成员变量
    public String name;
    private int id;
    static private long birthday = 20000927;

    //构造方法
    public AA(String name,int id) {
        this.name = name;
        this.id = id;
    }
    private AA(long birthday) {
        System.out.println(birthday);
    }
    public AA() {

    }

    //成员方法
    public static void show() {
        System.out.println(birthday);
    }
    public void show3() {
        System.out.println("公共非静态方法");
    }
    private void show2() {
        System.out.println(name+"  "+id);
    }
}

//AA的子类
class AA1 extends AA implements Runnable {
    String name;
    int age;
    boolean sex;
    @Override
    public void run() {

    }

}