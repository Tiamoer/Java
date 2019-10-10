import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

//自定义注解
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD, ElementType.PARAMETER})
@interface ZJ {
    String name() default "自定义注解";
}

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Test t = new Test();
        t.f1();
        t.f2();
        t.f3();
        t.f4();
    }
    //反射接口及父类
    public void f1() throws ClassNotFoundException {
        System.out.println("反射接口及父类");
        Class c = Class.forName("Test2");
        System.out.println(c.getSuperclass());
        System.out.println(Arrays.toString(c.getInterfaces()));
        System.out.println();
    }
    //反射方法以及方法的修饰符、方法名，返回值，参数类型，异常信息
    public void f2() throws ClassNotFoundException {
        System.out.println("反射方法以及方法的修饰符、方法名，返回值，参数类型");
        Class c = Class.forName("Test1");
        Method[] m = c.getDeclaredMethods();
        for (Method jg:m) {
            System.out.println(jg.toString());
        }

        Method m1 = m[0];
        System.out.println(Arrays.toString(m1.getParameterTypes()));
        System.out.println(m1.getModifiers());
        System.out.println(m1.getName());
        System.out.println(m1.getReturnType());
        System.out.println(Arrays.toString(m1.getExceptionTypes()));
        System.out.println();
    }
    //反射类的所有构造方法以及属性
    public void f3() throws ClassNotFoundException {
        System.out.println("反射类的所有构造方法以及属性");
        Class c = Class.forName("Test1");
        Field[] fields = c.getDeclaredFields();
        for (Field jg:fields) {
            System.out.println(jg);
        }
        Constructor[] constructors = c.getDeclaredConstructors();
        System.out.println("构造方法！");
        for (Constructor jg:constructors) {
            System.out.println(jg);
        }
        System.out.println();
    }
    //反射注解
    public void f4() throws ClassNotFoundException {
        System.out.println("反射注解");
        Class c = Class.forName("Test2");
        System.out.println(c.getAnnotation(ZJ.class));
        System.out.println(Arrays.toString(c.getAnnotationsByType(ZJ.class)));
    }
}

//反射类1
class Test1 {
    public String name;
    private int age;

    //构造方法
    public Test1(String name) {
        this.name = name;
    }

    //普通方法
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public String toString(int id) throws Exception {
        return "Hello!"+id;
    }
}
//反射类2
@ZJ
class Test2 extends Test1 implements JK {
    String address;
    private long id;
    public Test2(String name) {
        super(name);
    }
}
//接口
interface JK {

}